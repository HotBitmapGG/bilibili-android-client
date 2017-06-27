package com.hotbitmapgg.bilibili.media;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by hcc on 16/9/14 21:37
 * 100332338@qq.com
 */
@SuppressLint({"DrawAllocation", "AppCompatCustomView"})
public class OutlineTextView extends TextView {
    private TextPaint mTextPaint;
    private TextPaint mTextPaintOutline;
    private String mText = "";
    private float mBorderSize;
    private int mBorderColor;
    private int mColor;
    private float mSpacingMult = 1.0f;
    private float mSpacingAdd = 0;
    private boolean mIncludePad = true;

    public OutlineTextView(Context context) {
        super(context);
        initPaint();
    }

    public OutlineTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public OutlineTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initPaint();
    }

    private void initPaint() {
        mTextPaint = new TextPaint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextSize(getTextSize());
        mTextPaint.setColor(mColor);
        mTextPaint.setStyle(Paint.Style.FILL);
        mTextPaint.setTypeface(getTypeface());
        mTextPaintOutline = new TextPaint();
        mTextPaintOutline.setAntiAlias(true);
        mTextPaintOutline.setTextSize(getTextSize());
        mTextPaintOutline.setColor(mBorderColor);
        mTextPaintOutline.setStyle(Paint.Style.STROKE);
        mTextPaintOutline.setTypeface(getTypeface());
        mTextPaintOutline.setStrokeWidth(mBorderSize);
    }


    public void setText(String text) {
        super.setText(text);
        mText = text;
        requestLayout();
        invalidate();
    }

    public void setTextSize(float size) {
        super.setTextSize(size);
        requestLayout();
        invalidate();
        initPaint();
    }

    public void setTextColor(int color) {
        super.setTextColor(color);
        mColor = color;
        invalidate();
        initPaint();
    }

    public void setShadowLayer(float radius, float dx, float dy, int color) {
        super.setShadowLayer(radius, dx, dy, color);
        mBorderSize = radius;
        mBorderColor = color;
        requestLayout();
        invalidate();
        initPaint();
    }

    public void setTypeface(Typeface tf, int style) {
        super.setTypeface(tf, style);
        requestLayout();
        invalidate();
        initPaint();
    }


    public void setTypeface(Typeface tf) {
        super.setTypeface(tf);
        requestLayout();
        invalidate();
        initPaint();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        Layout layout = new StaticLayout(getText(), mTextPaintOutline,
                getWidth(), Layout.Alignment.ALIGN_CENTER, mSpacingMult,
                mSpacingAdd, mIncludePad);
        layout.draw(canvas);
        layout = new StaticLayout(getText(), mTextPaint, getWidth(),
                Layout.Alignment.ALIGN_CENTER, mSpacingMult, mSpacingAdd,
                mIncludePad);
        layout.draw(canvas);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Layout layout = new StaticLayout(getText(), mTextPaintOutline,
                measureWidth(widthMeasureSpec), Layout.Alignment.ALIGN_CENTER,
                mSpacingMult, mSpacingAdd, mIncludePad);
        int ex = (int) (mBorderSize * 2 + 1);
        setMeasuredDimension(measureWidth(widthMeasureSpec) + ex,
                measureHeight(heightMeasureSpec) * layout.getLineCount() + ex);
    }


    private int measureWidth(int measureSpec) {
        int result;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = (int) mTextPaintOutline.measureText(mText)
                    + getPaddingLeft() + getPaddingRight();
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;
    }


    private int measureHeight(int measureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        int mAscent = (int) mTextPaintOutline.ascent();
        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = (int) (-mAscent + mTextPaintOutline.descent())
                    + getPaddingTop() + getPaddingBottom();
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;
    }
}