package com.hotbitmapgg.ohmybilibili.api;

import com.hotbitmapgg.ohmybilibili.network.ApiHelper;
import com.hotbitmapgg.ohmybilibili.model.BasicMessage;
import com.hotbitmapgg.ohmybilibili.model.VideoSrc;
import com.hotbitmapgg.ohmybilibili.model.VideoViewInfo;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;

/**
 * 视频详情查询Api
 *
 * @HotBitmapGG
 */
public class VideoApi
{

    public static BasicMessage<VideoViewInfo> getVideoViewInfo(int av, int page, boolean needReadFav)
    {

        String url = ApiHelper.getVideoInfoUrl(av, page, needReadFav);
        LogUtil.lsw(url);
        return ApiHelper.getSimpleUrlResult(url, VideoViewInfo.class);
    }

    public static BasicMessage<VideoSrc> getVideoSrc(int av)
    {

        String url = ApiHelper.getHTML5Url(String.valueOf(av));
        LogUtil.lsw(url);
        return ApiHelper.getSimpleUrlResult(url, VideoSrc.class);
    }
}
