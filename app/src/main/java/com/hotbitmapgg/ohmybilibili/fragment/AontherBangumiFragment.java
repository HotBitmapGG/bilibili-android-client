package com.hotbitmapgg.ohmybilibili.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.adapter.BangumiTimeLineRecycleAdapter;
import com.hotbitmapgg.ohmybilibili.api.BangumiApi;
import com.hotbitmapgg.ohmybilibili.model.Bangumi;
import com.hotbitmapgg.ohmybilibili.model.BasicMessage;
import com.hotbitmapgg.ohmybilibili.network.AbsAsyncTask;
import com.hotbitmapgg.ohmybilibili.ui.SpecialDetailsActivity;
import com.hotbitmapgg.ohmybilibili.widget.CircleProgressView;

import java.util.ArrayList;

/**
 * Created by hcc on 16/3/26.
 * 二次元新番
 */
public class AontherBangumiFragment extends LazyFragment
{

    private RecyclerView mRecyclerView;

    private ArrayList<Bangumi> mBangumis = new ArrayList<>();

    private CircleProgressView mCircleProgressView;

    private BangumiTimeLineRecycleAdapter mAdapter;

    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_aonther_bangumi;
    }

    @Override
    public void finishCreateView(Bundle state)
    {

        mRecyclerView = $(R.id.two_recycle);
        mCircleProgressView = $(R.id.two_circle_progress);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));

        startGetTwoBangumiTask();
    }

    private void startGetTwoBangumiTask()
    {

        mCircleProgressView.setVisibility(View.VISIBLE);
        mCircleProgressView.spin();
        new GetTwoBangumiTaskAbs().execute();
    }

    private void finishGetTask()
    {

        mAdapter = new BangumiTimeLineRecycleAdapter(mRecyclerView, mBangumis);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new AbsRecyclerViewAdapter.OnItemClickListener()
        {

            @Override
            public void onItemClick(int position, AbsRecyclerViewAdapter.ClickableViewHolder holder)
            {

                Bangumi mBangumi = mAdapter.getItem(position);
                String spid = mBangumi.spid;
                String title = mBangumi.title;
                int season_id = mBangumi.season_id;

                Intent mIntent = new Intent(getActivity(), SpecialDetailsActivity.class);
                mIntent.putExtra("spid", spid);
                mIntent.putExtra("title", title);
                mIntent.putExtra("season_id", season_id);
                startActivity(mIntent);
            }
        });

        mCircleProgressView.setVisibility(View.GONE);
        mCircleProgressView.stopSpinning();
    }


    private class GetTwoBangumiTaskAbs extends AbsAsyncTask<Void,Void,BasicMessage<ArrayList<Bangumi>>>
    {

        @Override
        protected BasicMessage<ArrayList<Bangumi>> doInBackground(Void... params)
        {

            return BangumiApi.getBangumi(BangumiApi.BTYPE_2D);
        }

        @Override
        protected void onPostExecute(BasicMessage<ArrayList<Bangumi>> msg)
        {

            if (msg != null && msg.getCode() == BasicMessage.CODE_SUCCEED)
            {

                ArrayList<Bangumi> bangumiList = msg.getObject();
                if (bangumiList != null && bangumiList.size() > 0)
                {
                    mBangumis.clear();
                    mBangumis.addAll(bangumiList);
                }

                finishGetTask();
            }
        }
    }
}
