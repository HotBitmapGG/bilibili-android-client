package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.model.base.BasicMessage;
import com.hotbitmapgg.ohmybilibili.model.video.VideoSrc;
import com.hotbitmapgg.ohmybilibili.model.video.VideoViewInfo;
import com.hotbitmapgg.ohmybilibili.network.ApiHelper;

/**
 * Created by hcc on 16/8/4 21:18
 * 100332338@qq.com
 * <p/>
 * 视频详情查询API
 */
public class VideoApi
{

    public static BasicMessage<VideoViewInfo> getVideoViewInfo(int av, int page, boolean needReadFav)
    {

        String url = ApiHelper.getVideoInfoUrl(av, page, needReadFav);
        return ApiHelper.getSimpleUrlResult(url, VideoViewInfo.class);
    }

    public static BasicMessage<VideoSrc> getVideoSrc(int av)
    {

        String url = ApiHelper.getHTML5Url(String.valueOf(av));
        return ApiHelper.getSimpleUrlResult(url, VideoSrc.class);
    }
}
