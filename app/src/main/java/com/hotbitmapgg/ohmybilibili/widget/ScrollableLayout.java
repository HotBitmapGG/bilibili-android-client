package com.hotbitmapgg.ohmybilibili.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;

import com.hotbitmapgg.ohmybilibili.R;


/**
 * <p>
 * This is the main {@link android.view.ViewGroup} for implementing Scrollable.
 * It has the same as {@link FrameLayout#onMeasure(int, int)}
 * measure logic, but has it's own
 * {@link #onLayout(boolean, int, int, int, int)} logic.
 * </p>
 * <p>
 * Note, that this ViewGroup will layout it's children as if it were an ordinary
 * {@link android.widget.LinearLayout} with orientation set to
 * {@link android.widget.LinearLayout#VERTICAL}. No paddings or margins will
 * affect the layout position of children,
 * 
 * although margins will certainly affect measurements.
 * </p>
 * <p>
 * The best usage would be to include two {@link View} views. The
 * first one would represent the <code>header</code> logic and the second would
 * be scrollable container. Note, that we should make use of
 * {@link android.view.ViewGroup.LayoutParams#MATCH_PARENT} as the height
 * attribute for scrollable container. Because it directly affects the
 * scrollable behavior. If you wish to create a <code>sticky</code> effect for
 * one of the views in <code>header</code> ViewGroup, you could specify
 * <code>layout_marginTop</code> attribute for your scrollable layout, which
 * represents the height of your sticky element.
 * </p>
 * <p>
 * The logic behind scenes is simple. We should be able to encapsulate
 * scrollable logic in a way (in a <code>tabs</code> case), that saves us from
 * adding header placeholders and footers (so that scrollY does not change when
 * different tab is selected) to every {@link android.widget.ScrollView},
 * {@link android.widget.AbsListView} etc. So, instead of modifying scrolling
 * behavior of each scrollable View, we are creating our own ViewGroup that
 * handles it for us.
 * </p>
 * <p>
 * Follow these steps to create your own Scrollable layout:
 * </p>
 * 
 * <b>Simple case</b>
 * 
 * <pre>
 * {@code
 *     <ru.noties.scrollable.ScrollableLayout
 *          android:layout_width="match_parent"
 *          android:layout_height="match_parent"
 *          app:scrollable_maxScroll="@dimen/header_height"> <!-- (!) -->
 * 
 *          <View
 *              android:layout_width="match_parent"
 *              android:layout_height="@dimen/header_height" /> <!-- (!) -- >
 * 
 *          <ListView
 *              android:layout_width="match_parent"
 *              android:layout_height="match_parent" />
 * 
 *     </ru.noties.scrollable.ScrollableLayout>
 * }
 * </pre>
 * 
 * <b>Sticky case</b> (of cause it's just an xml step, you also should implement
 * translation logic in OnScrollChangeListener
 * {@link #setOnScrollChangedListener(OnScrollChangedListener)})
 * 
 * <pre>
 *     {@code
 *     <ru.noties.scrollable.ScrollableLayout
 *          android:layout_width="match_parent"
 *          android:layout_height="match_parent"
 *          app:scrollable_maxScroll="@dimen/header_height">
 * 
 *          <LinearLayout
 *              android:layout_width="match_parent"
 *              android:layout_height="wrap_content">
 * 
 *              <View
 *                  android:layout_width="match_parent"
 *                  android:layout_height="@dimen/header_height" />
 * 
 *              <View
 *                  android:layout_width="match_parent"
 *                  android:layout_height="@dimen/sticky_height" /> <!-- (!) -->
 * 
 *          </LinearLayout>
 * 
 *          <ListView
 *              android:layout_width="match_parent"
 *              android:layout_height="match_parent"
 *              android:layout_marginTop="@dimen/sticky_height" /> <!-- (!) -->
 *     }
 * </pre>
 * 
 * Created by Dimitry Ivanov (mail@dimitryivanov.ru) on 28.03.2015.
 */
@SuppressLint("NewApi")
public class ScrollableLayout extends FrameLayout
{

	private static final long DEFAULT_IDLE_CLOSE_UP_ANIMATION = 200L;
	private static final int DEFAULT_CONSIDER_IDLE_MILLIS = 100;

	private ScrollableScroller mScroller;
	private GestureDetector mScrollDetector;
	private GestureDetector mFlingDetector;

	private CanScrollVerticallyDelegate mCanScrollVerticallyDelegate;
	private OnScrollChangedListener mOnScrollChangedListener;

	private int mMaxScrollY;

	private boolean mIsScrolling;
	private boolean mIsFlinging;

	private MotionEventHook mMotionEventHook;

	private CloseUpAlgorithm mCloseUpAlgorithm;
	private ObjectAnimator mCloseUpAnimator;

	private boolean mSelfUpdateScroll;
	private boolean mSelfUpdateFling;

	private boolean mIsTouchOngoing;

	private CloseUpIdleAnimationTime mCloseUpIdleAnimationTime;
	private CloseUpAnimatorConfigurator mCloseAnimatorConfigurator;

	private View mDraggableView;
	private boolean mIsDraggingDraggable;
	private final Rect mDraggableRect;
	{
		mDraggableRect = new Rect();
	}

	private long mConsiderIdleMillis;

	public ScrollableLayout(Context context)
	{
		super(context);
		init(context, null);
	}

	public ScrollableLayout(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		init(context, attrs);
	}

	public ScrollableLayout(Context context, AttributeSet attrs, int defStyleAttr)
	{
		super(context, attrs, defStyleAttr);
		init(context, attrs);
	}

	private void init(Context context, AttributeSet attributeSet)
	{

		final TypedArray array = context.obtainStyledAttributes(attributeSet, R.styleable.ScrollableLayout);
		try
		{

			final boolean flyWheel = array.getBoolean(R.styleable.ScrollableLayout_scrollable_scrollerFlywheel, false);
			mScroller = initScroller(context, null, flyWheel);

			final float friction = array.getFloat(R.styleable.ScrollableLayout_scrollable_friction, Float.NaN);
			if (friction == friction)
			{
				setFriction(friction);
			}

			mMaxScrollY = array.getDimensionPixelSize(R.styleable.ScrollableLayout_scrollable_maxScroll, 0);

			final long considerIdleMillis = array.getInteger(R.styleable.ScrollableLayout_scrollable_considerIdleMillis, DEFAULT_CONSIDER_IDLE_MILLIS);
			setConsiderIdleMillis(considerIdleMillis);

			final boolean useDefaultCloseUp = array.getBoolean(R.styleable.ScrollableLayout_scrollable_defaultCloseUp, false);
			if (useDefaultCloseUp)
			{
				setCloseUpAlgorithm(new DefaultCloseUpAlgorithm());
			}

			final int closeUpAnimationMillis = array.getInteger(R.styleable.ScrollableLayout_scrollable_closeUpAnimationMillis, -1);
			if (closeUpAnimationMillis != -1)
			{
				setCloseUpIdleAnimationTime(new SimpleCloseUpIdleAnimationTime(closeUpAnimationMillis));
			}

			final int interpolatorResId = array.getResourceId(R.styleable.ScrollableLayout_scrollable_closeUpAnimatorInterpolator, 0);
			if (interpolatorResId != 0)
			{
				final Interpolator interpolator = AnimationUtils.loadInterpolator(context, interpolatorResId);
				setCloseAnimatorConfigurator(new InterpolatorCloseUpAnimatorConfigurator(interpolator));
			}

		} finally
		{
			array.recycle();
		}

		setVerticalScrollBarEnabled(true);

		mScrollDetector = new GestureDetector(context, new ScrollGestureListener());
		mFlingDetector = new GestureDetector(context, new FlingGestureListener(context));

		mMotionEventHook = new MotionEventHook(new MotionEventHookCallback()
		{
			@Override
			public void apply(MotionEvent event)
			{
				ScrollableLayout.super.dispatchTouchEvent(event);
			}
		});
	}

	/**
	 * Override this method if you wish to create own
	 * {@link android.widget.Scroller}
	 * 
	 * @param context
	 *            {@link Context}
	 * @param interpolator
	 *            {@link Interpolator}, the default
	 *            implementation passes <code>null</code>
	 * @param flywheel
	 *            {@link android.widget.Scroller#Scroller(Context, Interpolator, boolean)}
	 * @return new instance of {@link android.widget.Scroller} must not bu null
	 */
	protected ScrollableScroller initScroller(Context context, Interpolator interpolator, boolean flywheel)
	{
		return new ScrollableScroller(context, interpolator, flywheel);
	}

	/**
	 * Sets friction for current {@link android.widget.Scroller}
	 * 
	 * @see android.widget.Scroller#setFriction(float)
	 * @param friction
	 *            to be applied
	 */
	public void setFriction(float friction)
	{
		mScroller.setFriction(friction);
	}

	/**
	 * @see ru.noties.scrollable.CanScrollVerticallyDelegate
	 * @param delegate
	 *            which will be invoked when scroll state of scrollable children
	 *            is needed
	 */
	public void setCanScrollVerticallyDelegate(CanScrollVerticallyDelegate delegate)
	{
		this.mCanScrollVerticallyDelegate = delegate;
	}

	/**
	 * Also can be set via xml attribute <code>scrollable_maxScroll</code>
	 * 
	 * @param maxY
	 *            the max scroll y available for this View.
	 * @see #getMaxScrollY()
	 */
	public void setMaxScrollY(int maxY)
	{
		this.mMaxScrollY = maxY;
	}

	/**
	 * @return value which represents the max scroll distance to
	 *         <code>this</code> View (aka <code>header</code> height)
	 * @see #setMaxScrollY(int)
	 */
	public int getMaxScrollY()
	{
		return mMaxScrollY;
	}

	/**
	 * Note that this value might be set with xml definition (
	 * 
	 * <pre>
	 * {@code app:scrollable_considerIdleMillis="100"}
	 * </pre>
	 * 
	 * )
	 * 
	 * @param millis
	 *            millis after which current scroll state would be considered
	 *            idle and thus firing close up logic if set
	 * @see #getConsiderIdleMillis()
	 * @see #DEFAULT_CONSIDER_IDLE_MILLIS
	 */
	public void setConsiderIdleMillis(long millis)
	{
		mConsiderIdleMillis = millis;
	}

	/**
	 * @return current value of millis after which scroll state would be
	 *         considered idle
	 * @see #setConsiderIdleMillis(long)
	 */
	public long getConsiderIdleMillis()
	{
		return mConsiderIdleMillis;
	}

	/**
	 * Pass an {@link ru.noties.scrollable.OnScrollChangedListener} if you wish
	 * to get notifications when scroll state of <code>this</code> View has
	 * changed. It\'s helpful for implementing own logic which depends on scroll
	 * state (e.g. parallax, alpha, etc)
	 * 
	 * @param listener
	 *            to be invoked when
	 *            {@link #onScrollChanged(int, int, int, int)} has been called.
	 *            Might be <code>null</code> if you don\'t want to receive
	 *            scroll notifications anymore
	 */
	public void setOnScrollChangedListener(OnScrollChangedListener listener)
	{
		this.mOnScrollChangedListener = listener;
	}

	/**
	 * @see View#onScrollChanged(int, int, int, int)
	 * @see ru.noties.scrollable.OnScrollChangedListener#onScrollChanged(int,
	 *      int, int)
	 * @see CloseUpAlgorithm
	 */
	@Override
	public void onScrollChanged(int l, int t, int oldL, int oldT)
	{

		final boolean changed = t != oldT;

		if (changed && mOnScrollChangedListener != null)
		{
			mOnScrollChangedListener.onScrollChanged(t, oldT, mMaxScrollY);
		}

		if (mCloseUpAlgorithm != null)
		{
			removeCallbacks(mIdleRunnable);
			if (!mSelfUpdateScroll && changed && !mIsTouchOngoing)
			{
				postDelayed(mIdleRunnable, mConsiderIdleMillis);
			}
		}
	}

	protected void setSelfUpdateScroll(boolean value)
	{
		mSelfUpdateScroll = value;
	}

	protected boolean isSelfUpdateScroll()
	{
		return mSelfUpdateScroll;
	}

	/**
	 * Note that {@link DefaultCloseUpAlgorithm} might be set with xml
	 * definition (
	 * 
	 * <pre>
	 * {@code app:scrollable_defaultCloseUp="true"}
	 * </pre>
	 * 
	 * )
	 * 
	 * @param closeUpAlgorithm
	 *            {@link CloseUpAlgorithm} implementation, might be null
	 * @see CloseUpAlgorithm
	 * @see DefaultCloseUpAlgorithm
	 */
	public void setCloseUpAlgorithm(CloseUpAlgorithm closeUpAlgorithm)
	{
		this.mCloseUpAlgorithm = closeUpAlgorithm;
	}

	/**
	 * Note that {@link SimpleCloseUpIdleAnimationTime} might be set with xml
	 * definition (
	 * 
	 * <pre>
	 * {@code app:scrollable_closeUpAnimationMillis="200"}
	 * </pre>
	 * 
	 * )
	 * 
	 * @param closeUpIdleAnimationTime
	 *            {@link CloseUpIdleAnimationTime} implementation, might be null
	 * @see CloseUpIdleAnimationTime
	 * @see SimpleCloseUpIdleAnimationTime
	 * @see #DEFAULT_IDLE_CLOSE_UP_ANIMATION
	 */
	public void setCloseUpIdleAnimationTime(CloseUpIdleAnimationTime closeUpIdleAnimationTime)
	{
		this.mCloseUpIdleAnimationTime = closeUpIdleAnimationTime;
	}

	/**
	 * @param configurator
	 *            {@link CloseUpAnimatorConfigurator} implementation to process
	 *            current close up {@link ObjectAnimator},
	 *            might be null
	 * @see CloseUpAnimatorConfigurator
	 * @see ObjectAnimator
	 */
	public void setCloseAnimatorConfigurator(CloseUpAnimatorConfigurator configurator)
	{
		this.mCloseAnimatorConfigurator = configurator;
	}

	/**
	 * @see View#scrollTo(int, int)
	 * @see #setCanScrollVerticallyDelegate(CanScrollVerticallyDelegate)
	 * @see #setMaxScrollY(int)
	 */
	@Override
	public void scrollTo(int x, int y)
	{

		final int newY = getNewY(y);

		if (newY < 0)
		{
			return;
		}

		super.scrollTo(0, newY);
	}

	protected int getNewY(int y)
	{

		final int currentY = getScrollY();

		if (currentY == y)
		{
			return -1;
		}

		final int direction = y - currentY;
		final boolean isScrollingBottomTop = direction < 0;

		if (mCanScrollVerticallyDelegate != null)
		{

			if (isScrollingBottomTop)
			{

				// if not dragging draggable then return, else do not return
				if (!mIsDraggingDraggable && !mSelfUpdateScroll && mCanScrollVerticallyDelegate.canScrollVertically(direction))
				{
					return -1;
				}
			}
			else
			{

				// else check if we are at max scroll
				if (currentY == mMaxScrollY && !mCanScrollVerticallyDelegate.canScrollVertically(direction))
				{
					return -1;
				}
			}
		}

		if (y < 0)
		{
			y = 0;
		}
		else if (y > mMaxScrollY)
		{
			y = mMaxScrollY;
		}

		return y;
	}

	/**
	 * Sets View which should be included in receiving scroll gestures. Maybe be
	 * null
	 * 
	 * @param view
	 *            you wish to include in scrolling gestures (aka tabs)
	 */
	public void setDraggableView(View view)
	{
		mDraggableView = view;
	}

	@Override
	public boolean dispatchTouchEvent(@SuppressWarnings("NullableProblems") MotionEvent event)
	{

		final int action = event.getActionMasked();
		if (action == MotionEvent.ACTION_DOWN)
		{

			mIsTouchOngoing = true;
			mScroller.abortAnimation();

			if (mDraggableView != null && mDraggableView.getGlobalVisibleRect(mDraggableRect))
			{
				final int x = (int) (event.getRawX() + .5F);
				final int y = (int) (event.getRawY() + .5F);
				mIsDraggingDraggable = mDraggableRect.contains(x, y);
			}
			else
			{
				mIsDraggingDraggable = false;
			}
		}
		else if (action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_CANCEL)
		{

			mIsTouchOngoing = false;

			if (mCloseUpAlgorithm != null)
			{
				removeCallbacks(mIdleRunnable);
				postDelayed(mIdleRunnable, mConsiderIdleMillis);
			}
		}

		final boolean isPrevScrolling = mIsScrolling;
		final boolean isPrevFlinging = mIsFlinging;

		mIsFlinging = mFlingDetector.onTouchEvent(event);
		mIsScrolling = mScrollDetector.onTouchEvent(event);

		removeCallbacks(mScrollRunnable);
		post(mScrollRunnable);

		final boolean isIntercepted = mIsScrolling || mIsFlinging;
		final boolean isPrevIntercepted = isPrevScrolling || isPrevFlinging;

		final boolean shouldRedirectDownTouch = action == MotionEvent.ACTION_MOVE && (!isIntercepted && isPrevIntercepted) && getScrollY() == mMaxScrollY;

		if (isIntercepted || isPrevIntercepted)
		{

			mMotionEventHook.hook(event, MotionEvent.ACTION_CANCEL);

			if (!isPrevIntercepted)
			{
				return true;
			}
		}

		if (shouldRedirectDownTouch)
		{
			mMotionEventHook.hook(event, MotionEvent.ACTION_DOWN);
		}

		super.dispatchTouchEvent(event);
		return true;
	}

	private void cancelIdleAnimationIfRunning(boolean removeCallbacks)
	{

		if (removeCallbacks)
		{
			removeCallbacks(mIdleRunnable);
		}

		if (mCloseUpAnimator != null && mCloseUpAnimator.isRunning())
		{
			mCloseUpAnimator.cancel();
		}
	}

	@Override
	public void computeScroll()
	{
		if (mScroller.computeScrollOffset())
		{
			final int oldY = getScrollY();
			final int nowY = mScroller.getCurrY();
			scrollTo(0, nowY);
			if (oldY != nowY)
			{
				onScrollChanged(0, getScrollY(), 0, oldY);
			}
			postInvalidate();
		}
	}

	@Override
	protected int computeVerticalScrollRange()
	{
		return mMaxScrollY;
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right, int bottom)
	{
		// int childTop = top;
		int childTop = 0;
		for (int i = 0; i < getChildCount(); i++)
		{
			final View view = getChildAt(i);
			view.layout(left, childTop, right, childTop + view.getMeasuredHeight());
			childTop += view.getMeasuredHeight();
		}
	}

	private final Runnable mScrollRunnable = new Runnable()
	{
		@Override
		public void run()
		{

			final boolean isContinue = mScroller.computeScrollOffset();
			mSelfUpdateFling = isContinue;

			if (isContinue)
			{

				final int y = mScroller.getCurrY();
				final int nowY = getScrollY();
				final int diff = y - nowY;

				if (diff != 0)
				{
					scrollBy(0, diff);
				}

				post(this);
			}
		}
	};

	@SuppressLint("NewApi")
	private final Runnable mIdleRunnable = new Runnable()
	{
		@Override
		public void run()
		{

			cancelIdleAnimationIfRunning(false);

			if (mSelfUpdateScroll || mSelfUpdateFling)
			{
				return;
			}

			final int nowY = getScrollY();

			if (nowY == 0 || nowY == mMaxScrollY)
			{
				return;
			}

			final int endY = mCloseUpAlgorithm.getIdleFinalY(ScrollableLayout.this, nowY, mMaxScrollY);

			if (nowY == endY)
			{
				return;
			}

			mCloseUpAnimator = ObjectAnimator.ofInt(ScrollableLayout.this, mCloseUpAnimationProperty, nowY, endY);

			final long duration = mCloseUpIdleAnimationTime != null ? mCloseUpIdleAnimationTime.compute(ScrollableLayout.this, nowY, endY, mMaxScrollY) : DEFAULT_IDLE_CLOSE_UP_ANIMATION;

			mCloseUpAnimator.setDuration(duration);
			mCloseUpAnimator.addListener(new AnimatorListenerAdapter()
			{

				@Override
				public void onAnimationStart(Animator animation)
				{
					mSelfUpdateScroll = true;
				}

				@Override
				public void onAnimationEnd(Animator animation)
				{
					mSelfUpdateScroll = false;
				}

				@Override
				public void onAnimationCancel(Animator animation)
				{
					mSelfUpdateScroll = false;
				}
			});

			if (mCloseAnimatorConfigurator != null)
			{
				mCloseAnimatorConfigurator.configure(mCloseUpAnimator);
			}

			mCloseUpAnimator.start();
		}
	};

	private class ScrollGestureListener extends GestureListenerAdapter
	{

		private final int mTouchSlop;
		{
			final ViewConfiguration vc = ViewConfiguration.get(getContext());
			mTouchSlop = vc.getScaledTouchSlop();
		}

		@SuppressWarnings("NullableProblems")
		@Override
		public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY)
		{

			final float absX = Math.abs(distanceX);

			if (absX > Math.abs(distanceY) || absX > mTouchSlop)
			{
				return false;
			}

			final int now = getScrollY();
			scrollBy(0, (int) (distanceY + .5F));

			return now != getScrollY();
		}
	}

	private class FlingGestureListener extends GestureListenerAdapter
	{

		private static final int MIN_FLING_DISTANCE_DIP = 12;

		private final int mMinFlingDistance;
		private final float mMinVelocity;

		FlingGestureListener(Context context)
		{
			this.mMinFlingDistance = DipUtils.dipToPx(context, MIN_FLING_DISTANCE_DIP);

			final ViewConfiguration configuration = ViewConfiguration.get(context);
			this.mMinVelocity = configuration.getScaledMinimumFlingVelocity();
		}

		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY)
		{

			if (Math.abs(velocityY) < mMinVelocity)
			{
				return false;
			}

			if (Math.abs(velocityX) > Math.abs(velocityY))
			{
				return false;
			}

			final int nowY = getScrollY();
			if (nowY < 0 || nowY > mMaxScrollY)
			{
				return false;
			}

			mScroller.fling(0, nowY, 0, -(int) (velocityY + .5F), 0, 0, 0, mMaxScrollY);

			if (mScroller.computeScrollOffset())
			{

				final int suggestedY = mScroller.getFinalY();

				if (Math.abs(nowY - suggestedY) < mMinFlingDistance)
				{
					mScroller.abortAnimation();
					return false;
				}

				final int finalY;
				if (suggestedY == nowY || mCloseUpAlgorithm == null)
				{
					finalY = suggestedY;
				}
				else
				{
					finalY = mCloseUpAlgorithm.getFlingFinalY(ScrollableLayout.this, suggestedY - nowY < 0, nowY, suggestedY, mMaxScrollY);
					mScroller.setFinalY(finalY);
				}

				final int newY = getNewY(finalY);

				return !(finalY == nowY || newY < 0);
			}

			return false;
		}
	}

	private static class MotionEventHook
	{

		final MotionEventHookCallback callback;

		MotionEventHook(MotionEventHookCallback callback)
		{
			this.callback = callback;
		}

		void hook(MotionEvent event, int action)
		{
			final int historyAction = event.getAction();
			event.setAction(action);
			callback.apply(event);
			event.setAction(historyAction);
		}
	}

	@SuppressLint("NewApi")
	private interface MotionEventHookCallback
	{
		void apply(MotionEvent event);
	}

	private final Property<ScrollableLayout, Integer> mCloseUpAnimationProperty = new Property<ScrollableLayout, Integer>(Integer.class, "scrollY")
	{

		@SuppressLint("NewApi")
		@Override
		public Integer get(ScrollableLayout object)
		{
			return object.getScrollY();
		}

		@Override
		public void set(final ScrollableLayout layout, final Integer value)
		{
			layout.setScrollY(value);
		}
	};

	@Override
	public Parcelable onSaveInstanceState()
	{
		final Parcelable superState = super.onSaveInstanceState();
		final ScrollableLayoutSavedState savedState = new ScrollableLayoutSavedState(superState);

		savedState.scrollY = getScrollY();

		return savedState;
	}

	@SuppressLint("NewApi")
	@Override
	public void onRestoreInstanceState(Parcelable state)
	{

		if (!(state instanceof ScrollableLayoutSavedState))
		{
			super.onRestoreInstanceState(state);
			return;
		}

		final ScrollableLayoutSavedState in = (ScrollableLayoutSavedState) state;
		super.onRestoreInstanceState(in.getSuperState());

		setScrollY(in.scrollY);
	}

	private static class ScrollableLayoutSavedState extends BaseSavedState
	{

		int scrollY;

		public ScrollableLayoutSavedState(Parcel source)
		{
			super(source);

			scrollY = source.readInt();
		}

		public ScrollableLayoutSavedState(Parcelable superState)
		{
			super(superState);
		}

		@Override
		public void writeToParcel(Parcel out, int flags)
		{
			super.writeToParcel(out, flags);

			out.writeInt(scrollY);
		}

		public static final Creator<ScrollableLayoutSavedState> CREATOR = new Creator<ScrollableLayoutSavedState>()
		{

			@Override
			public ScrollableLayoutSavedState createFromParcel(Parcel in)
			{
				return new ScrollableLayoutSavedState(in);
			}

			@Override
			public ScrollableLayoutSavedState[] newArray(int size)
			{
				return new ScrollableLayoutSavedState[size];
			}
		};
	}
}
