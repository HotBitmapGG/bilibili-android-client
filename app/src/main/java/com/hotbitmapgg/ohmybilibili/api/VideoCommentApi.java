package com.hotbitmapgg.ohmybilibili.api;

import com.hotbitmapgg.ohmybilibili.model.base.BasicMessage;
import com.hotbitmapgg.ohmybilibili.model.video.VideoComment;
import com.hotbitmapgg.ohmybilibili.network.ApiHelper;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;

/**
 * 视频评论查询Api
 *
 * @HotBitmapGG
 */
public class VideoCommentApi
{

    public static BasicMessage<VideoComment> getVideoCommentList(int aid, int page, int pagesize, int ver)
    {

        String url = ApiHelper.getVideoComment(aid, page, pagesize, ver);
        LogUtil.lsw(url);
        BasicMessage<VideoComment> msg = ApiHelper.getSimpleUrlResult(url, VideoComment.class);
        if (msg.getCode() == BasicMessage.CODE_SUCCEED)
        {
            return msg;
        }

        return null;
    }
}
