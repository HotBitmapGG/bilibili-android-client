package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.base.BasicMessage;
import com.hotbitmapgg.ohmybilibili.entity.video.VideoComment;
import com.hotbitmapgg.ohmybilibili.network.ApiHelper;

/**
 * Created by hcc on 16/8/4 21:18
 * 100332338@qq.com
 * <p/>
 * 视频评论查询API
 */
public class VideoCommentApi
{

    public static BasicMessage<VideoComment> getVideoCommentList(int aid, int page, int pagesize, int ver)
    {

        String url = ApiHelper.getVideoComment(aid, page, pagesize, ver);
        BasicMessage<VideoComment> msg = ApiHelper.getSimpleUrlResult(url, VideoComment.class);
        if (msg.getCode() == BasicMessage.CODE_SUCCEED)
        {
            return msg;
        }

        return null;
    }
}
