package com.hotbitmapgg.bilibili.widget.dialog;

import com.hotbitmapgg.bilibili.utils.ThemeHelper;
import com.hotbitmapgg.ohmybilibili.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by hcc on 16/9/16 13:14
 * 100332338@qq.com
 * <p/>
 * 主题切换选择对话框
 */
public class CardPickerDialog extends DialogFragment implements View.OnClickListener {

  public static final String TAG = "CardPickerDialog";

  ImageView[] mCards = new ImageView[8];

  Button mConfirm;

  Button mCancel;

  private int mCurrentTheme;

  private ClickListener mClickListener;


  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setStyle(DialogFragment.STYLE_NO_TITLE, R.style.AppTheme_AppCompat_Dialog_Alert);
    mCurrentTheme = ThemeHelper.getTheme(getActivity());
  }


  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater,
                           @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

    return inflater.inflate(R.layout.dialog_theme_picker, container, false);
  }


  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

    super.onViewCreated(view, savedInstanceState);
    mCancel = (Button) view.findViewById(android.R.id.button2);
    mConfirm = (Button) view.findViewById(android.R.id.button1);
    mCards[0] = (ImageView) view.findViewById(R.id.theme_pink);
    mCards[1] = (ImageView) view.findViewById(R.id.theme_purple);
    mCards[2] = (ImageView) view.findViewById(R.id.theme_blue);
    mCards[3] = (ImageView) view.findViewById(R.id.theme_green);
    mCards[4] = (ImageView) view.findViewById(R.id.theme_green_light);
    mCards[5] = (ImageView) view.findViewById(R.id.theme_yellow);
    mCards[6] = (ImageView) view.findViewById(R.id.theme_orange);
    mCards[7] = (ImageView) view.findViewById(R.id.theme_red);
    setImageButtons(mCurrentTheme);
    for (ImageView card : mCards) {
      card.setOnClickListener(this);
    }
    mCancel.setOnClickListener(this);
    mConfirm.setOnClickListener(this);
  }


  @Override
  public void onClick(View v) {

    switch (v.getId()) {
      case android.R.id.button1:
        if (mClickListener != null) {
          mClickListener.onConfirm(mCurrentTheme);
        }
      case android.R.id.button2:
        dismiss();
        break;
      case R.id.theme_pink:
        mCurrentTheme = ThemeHelper.CRAD_SAKURA;
        setImageButtons(mCurrentTheme);
        break;
      case R.id.theme_purple:
        mCurrentTheme = ThemeHelper.CARD_HOPE;
        setImageButtons(mCurrentTheme);
        break;
      case R.id.theme_blue:
        mCurrentTheme = ThemeHelper.CARD_STORM;
        setImageButtons(mCurrentTheme);
        break;
      case R.id.theme_green:
        mCurrentTheme = ThemeHelper.CARD_WOOD;
        setImageButtons(mCurrentTheme);
        break;
      case R.id.theme_green_light:
        mCurrentTheme = ThemeHelper.CARD_LIGHT;
        setImageButtons(mCurrentTheme);
        break;
      case R.id.theme_yellow:
        mCurrentTheme = ThemeHelper.CARD_THUNDER;
        setImageButtons(mCurrentTheme);
        break;
      case R.id.theme_orange:
        mCurrentTheme = ThemeHelper.CARD_SAND;
        setImageButtons(mCurrentTheme);
        break;
      case R.id.theme_red:
        mCurrentTheme = ThemeHelper.CARD_FIREY;
        setImageButtons(mCurrentTheme);
        break;
      default:
        break;
    }
  }


  private void setImageButtons(int currentTheme) {

    mCards[0].setSelected(currentTheme == ThemeHelper.CRAD_SAKURA);
    mCards[1].setSelected(currentTheme == ThemeHelper.CARD_HOPE);
    mCards[2].setSelected(currentTheme == ThemeHelper.CARD_STORM);
    mCards[3].setSelected(currentTheme == ThemeHelper.CARD_WOOD);
    mCards[4].setSelected(currentTheme == ThemeHelper.CARD_LIGHT);
    mCards[5].setSelected(currentTheme == ThemeHelper.CARD_THUNDER);
    mCards[6].setSelected(currentTheme == ThemeHelper.CARD_SAND);
    mCards[7].setSelected(currentTheme == ThemeHelper.CARD_FIREY);
  }


  public void setClickListener(ClickListener clickListener) {

    mClickListener = clickListener;
  }


  public interface ClickListener {

    void onConfirm(int currentTheme);
  }
}
