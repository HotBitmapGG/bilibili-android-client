package com.hotbitmapgg.ohmybilibili.module.home;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.HomeMoreLayoutAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.config.Secret;
import com.hotbitmapgg.ohmybilibili.entity.partition.PartitionMoreTitle;
import com.hotbitmapgg.ohmybilibili.entity.partition.PartitionMoreType;
import com.hotbitmapgg.ohmybilibili.module.partition.PartitionMoreActivity;
import com.hotbitmapgg.ohmybilibili.utils.ToastUtil;
import com.hotbitmapgg.ohmybilibili.widget.ExpandableHeightGridView;

import java.util.List;

import butterknife.Bind;

/**
 * Created by hcc on 16/8/4 21:18
 * 100332338@qq.com
 * <p/>
 * 首页分区界面
 */
public class HomeMoreFragment extends RxLazyFragment
{

    @Bind(R.id.more_layout)
    ExpandableHeightGridView mMoreLayout;

    public static HomeMoreFragment newInstance()
    {

        return new HomeMoreFragment();
    }

    @Override
    public
    @LayoutRes
    int getLayoutResId()
    {

        return R.layout.fragment_home_more;
    }

    @Override
    public void finishCreateView(Bundle state)
    {

        HomeMoreLayoutAdapter mAdapter = new HomeMoreLayoutAdapter(getActivity());
        mMoreLayout.setAdapter(mAdapter);
        mMoreLayout.setExpanded(true);
        mMoreLayout.setOnItemClickListener(new OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {

                switch (position)
                {
                    case 0:
                        PartitionMoreTitle mBangumi = new PartitionMoreTitle();
                        List<PartitionMoreType> mBangumiTitles = mBangumi.titles;
                        mBangumiTitles.add(new PartitionMoreType("完结动画", 32));
                        mBangumiTitles.add(new PartitionMoreType("连载动画", 33));
                        mBangumiTitles.add(new PartitionMoreType("国产", 110));
                        mBangumiTitles.add(new PartitionMoreType("日剧", 111));
                        mBangumiTitles.add(new PartitionMoreType("美剧", 112));
                        mBangumiTitles.add(new PartitionMoreType("其他", 113));

                        if (TextUtils.isEmpty(Secret.APP_KEY))
                        {
                            ToastUtil.ShortToast("AppKey为空");
                        } else
                        {
                            launchTypeDetailsActivity(mBangumi, "番剧");
                        }

                        break;

                    case 1:
                        PartitionMoreTitle mAnimation = new PartitionMoreTitle();
                        List<PartitionMoreType> mAnimationTitles = mAnimation.titles;
                        mAnimationTitles.add(new PartitionMoreType("MAD·AMV", 24));
                        mAnimationTitles.add(new PartitionMoreType("MMD·3D", 25));
                        mAnimationTitles.add(new PartitionMoreType("综合", 27));
                        mAnimationTitles.add(new PartitionMoreType("原创·配音", 47));
                        mAnimationTitles.add(new PartitionMoreType("原创动画", 48));
                        mAnimationTitles.add(new PartitionMoreType("配音动画", 49));
                        mAnimationTitles.add(new PartitionMoreType("手书", 50));
                        mAnimationTitles.add(new PartitionMoreType("资讯", 51));
                        mAnimationTitles.add(new PartitionMoreType("杂谈", 52));
                        mAnimationTitles.add(new PartitionMoreType("其他", 53));

                        if (TextUtils.isEmpty(Secret.APP_KEY))
                        {
                            ToastUtil.ShortToast("AppKey为空");
                        } else
                        {
                            launchTypeDetailsActivity(mAnimation, "动画");
                        }

                        break;

                    case 2:
                        PartitionMoreTitle mMuise = new PartitionMoreTitle();
                        List<PartitionMoreType> mMuiseTitles = mMuise.titles;
                        mMuiseTitles.add(new PartitionMoreType("音乐视频", 28));
                        mMuiseTitles.add(new PartitionMoreType("三次元音乐", 29));
                        mMuiseTitles.add(new PartitionMoreType("VOCALOID·UTAU", 30));
                        mMuiseTitles.add(new PartitionMoreType("翻唱", 31));
                        mMuiseTitles.add(new PartitionMoreType("演奏", 59));
                        mMuiseTitles.add(new PartitionMoreType("音乐选集", 130));
                        mMuiseTitles.add(new PartitionMoreType("OP/ED/OST", 54));
                        mMuiseTitles.add(new PartitionMoreType("Vocaloid", 56));
                        mMuiseTitles.add(new PartitionMoreType("UTAU相关", 57));
                        mMuiseTitles.add(new PartitionMoreType("中文曲", 58));
                        mMuiseTitles.add(new PartitionMoreType("其他", 55));

                        if (TextUtils.isEmpty(Secret.APP_KEY))
                        {
                            ToastUtil.ShortToast("AppKey为空");
                        } else
                        {
                            launchTypeDetailsActivity(mMuise, "音乐");
                        }


                        break;

                    case 3:
                        PartitionMoreTitle mDence = new PartitionMoreTitle();
                        List<PartitionMoreType> mDenceTitles = mDence.titles;
                        mDenceTitles.add(new PartitionMoreType("舞蹈", 20));
                        mDenceTitles.add(new PartitionMoreType("音乐舞蹈", 132));
                        mDenceTitles.add(new PartitionMoreType("综艺", 133));
                        mDenceTitles.add(new PartitionMoreType("其他", 134));

                        if (TextUtils.isEmpty(Secret.APP_KEY))
                        {
                            ToastUtil.ShortToast("AppKey为空");
                        } else
                        {
                            launchTypeDetailsActivity(mDence, "舞蹈");
                        }

                        break;

                    case 4:
                        PartitionMoreTitle mGame = new PartitionMoreTitle();
                        List<PartitionMoreType> mGameTitles = mGame.titles;
                        mGameTitles.add(new PartitionMoreType("游戏视频", 17));
                        mGameTitles.add(new PartitionMoreType("游戏攻略·解说", 18));
                        mGameTitles.add(new PartitionMoreType("Mugen", 19));
                        mGameTitles.add(new PartitionMoreType("电子竞技", 60));
                        mGameTitles.add(new PartitionMoreType("单机游戏", 64));
                        mGameTitles.add(new PartitionMoreType("网络游戏", 65));
                        mGameTitles.add(new PartitionMoreType("家用·掌机", 66));
                        mGameTitles.add(new PartitionMoreType("赛事", 68));
                        mGameTitles.add(new PartitionMoreType("解说", 69));
                        mGameTitles.add(new PartitionMoreType("其他1", 67));
                        mGameTitles.add(new PartitionMoreType("其他2", 63));
                        mGameTitles.add(new PartitionMoreType("其他3", 70));
                        mGameTitles.add(new PartitionMoreType("GMV", 121));
                        mGameTitles.add(new PartitionMoreType("预告·演示", 61));

                        if (TextUtils.isEmpty(Secret.APP_KEY))
                        {
                            ToastUtil.ShortToast("AppKey为空");
                        } else
                        {
                            launchTypeDetailsActivity(mGame, "游戏");
                        }

                        break;

                    case 5:
                        PartitionMoreTitle mScience = new PartitionMoreTitle();
                        List<PartitionMoreType> mScienceTitles = mScience.titles;
                        mScienceTitles.add(new PartitionMoreType("纪录片", 37));
                        mScienceTitles.add(new PartitionMoreType("全球科技", 39));
                        mScienceTitles.add(new PartitionMoreType("野生技术协会", 122));
                        mScienceTitles.add(new PartitionMoreType("趣味科普", 124));
                        mScienceTitles.add(new PartitionMoreType("数码科技", 95));
                        mScienceTitles.add(new PartitionMoreType("军事科技", 96));
                        mScienceTitles.add(new PartitionMoreType("手机评测", 97));
                        mScienceTitles.add(new PartitionMoreType("技术宅", 40));
                        mScienceTitles.add(new PartitionMoreType("教程演示", 105));
                        mScienceTitles.add(new PartitionMoreType("手办模型", 123));
                        mScienceTitles.add(new PartitionMoreType("演讲", 103));
                        mScienceTitles.add(new PartitionMoreType("公开课", 104));
                        mScienceTitles.add(new PartitionMoreType("科技人文", 107));
                        mScienceTitles.add(new PartitionMoreType("趣味短片", 108));
                        mScienceTitles.add(new PartitionMoreType("其他", 98));

                        if (TextUtils.isEmpty(Secret.APP_KEY))
                        {
                            ToastUtil.ShortToast("AppKey为空");
                        } else
                        {
                            launchTypeDetailsActivity(mScience, "科技");
                        }

                        break;

                    case 6:
                        PartitionMoreTitle mRecreation = new PartitionMoreTitle();
                        List<PartitionMoreType> mRecreationTitles = mRecreation.titles;
                        mRecreationTitles.add(new PartitionMoreType("生活娱乐", 21));
                        mRecreationTitles.add(new PartitionMoreType("综艺", 71));
                        mRecreationTitles.add(new PartitionMoreType("动物圈", 75));
                        mRecreationTitles.add(new PartitionMoreType("喵星人", 77));
                        mRecreationTitles.add(new PartitionMoreType("汪星人", 78));
                        mRecreationTitles.add(new PartitionMoreType("美食", 76));
                        mRecreationTitles.add(new PartitionMoreType("美食视频", 80));
                        mRecreationTitles.add(new PartitionMoreType("制作教程", 81));
                        mRecreationTitles.add(new PartitionMoreType("Korea相关", 131));
                        mRecreationTitles.add(new PartitionMoreType("其他", 79));

                        if (TextUtils.isEmpty(Secret.APP_KEY))
                        {
                            ToastUtil.ShortToast("AppKey为空");
                        } else
                        {
                            launchTypeDetailsActivity(mRecreation, "娱乐");
                        }

                        break;

                    case 7:
                        PartitionMoreTitle mKichiku = new PartitionMoreTitle();
                        List<PartitionMoreType> mKichikuTitles = mKichiku.titles;
                        mKichikuTitles.add(new PartitionMoreType("三次元鬼畜", 22));
                        mKichikuTitles.add(new PartitionMoreType("二次元鬼畜", 26));
                        mKichikuTitles.add(new PartitionMoreType("人力VOCALOID", 126));
                        mKichikuTitles.add(new PartitionMoreType("教程演示", 127));

                        if (TextUtils.isEmpty(Secret.APP_KEY))
                        {
                            ToastUtil.ShortToast("AppKey为空");
                        } else
                        {
                            launchTypeDetailsActivity(mKichiku, "鬼畜");
                        }

                        break;

                    case 8:
                        PartitionMoreTitle mMovei = new PartitionMoreTitle();
                        List<PartitionMoreType> mMoveiTitles = mMovei.titles;
                        mMoveiTitles.add(new PartitionMoreType("预告·花絮", 82));
                        mMoveiTitles.add(new PartitionMoreType("电影", 83));
                        mMoveiTitles.add(new PartitionMoreType("微电影·短片", 85));
                        mMoveiTitles.add(new PartitionMoreType("国产", 87));
                        mMoveiTitles.add(new PartitionMoreType("日剧", 88));
                        mMoveiTitles.add(new PartitionMoreType("美剧", 89));
                        mMoveiTitles.add(new PartitionMoreType("特摄", 91));
                        mMoveiTitles.add(new PartitionMoreType("布袋戏", 92));
                        mMoveiTitles.add(new PartitionMoreType("其他", 90));

                        if (TextUtils.isEmpty(Secret.APP_KEY))
                        {
                            ToastUtil.ShortToast("AppKey为空");
                        } else
                        {
                            launchTypeDetailsActivity(mMovei, "电影");
                        }


                        break;

                    case 9:
                        PartitionMoreTitle mTv = new PartitionMoreTitle();
                        List<PartitionMoreType> mTvTitles = mTv.titles;
                        mTvTitles.add(new PartitionMoreType("完结剧集", 34));
                        mTvTitles.add(new PartitionMoreType("连载剧集", 15));
                        mTvTitles.add(new PartitionMoreType("特摄·布袋", 86));
                        mTvTitles.add(new PartitionMoreType("预告·花絮", 128));
                        mTvTitles.add(new PartitionMoreType("BBC纪录片", 99));
                        mTvTitles.add(new PartitionMoreType("探索频道", 100));
                        mTvTitles.add(new PartitionMoreType("国家地理", 101));
                        mTvTitles.add(new PartitionMoreType("NHK", 102));
                        mTvTitles.add(new PartitionMoreType("其他", 125));

                        if (TextUtils.isEmpty(Secret.APP_KEY))
                        {
                            ToastUtil.ShortToast("AppKey为空");
                        } else
                        {
                            launchTypeDetailsActivity(mTv, "电视剧");
                        }

                        break;

                    default:
                        break;
                }
            }
        });
    }

    /**
     * 根据分区类型进入界面
     *
     * @param mTitle
     * @param typeTitle
     */
    protected void launchTypeDetailsActivity(PartitionMoreTitle mTitle, String typeTitle)
    {

        PartitionMoreActivity.launch(getActivity(), mTitle, typeTitle);
    }
}
