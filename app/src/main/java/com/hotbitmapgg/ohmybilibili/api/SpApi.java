package com.hotbitmapgg.ohmybilibili.api;

import com.hotbitmapgg.ohmybilibili.network.ApiHelper;
import com.hotbitmapgg.ohmybilibili.model.base.BasicMessage;
import com.hotbitmapgg.ohmybilibili.model.video.Sp;

import java.util.ArrayList;
import java.util.List;

/**
 * 专题视频查询Api
 *
 * @HotBitmapGG
 */
public class SpApi
{

    public static BasicMessage<Sp> getSpInfo(int spid, String title)
    {

        String url = ApiHelper.getSpUrl(spid, title);
        return ApiHelper.getSimpleUrlResult(url, Sp.class);
    }

    public static BasicMessage<ArrayList<Sp.Item>> getSpItem(int spid, int season_id, int bangumi)
    {

        String url = ApiHelper.getSpItemUrl(spid, season_id, bangumi);
        BasicMessage<SpItemResult> result = ApiHelper.getSimpleUrlResult(url, SpItemResult.class);
        BasicMessage<ArrayList<Sp.Item>> msg = new BasicMessage<>();
        if (result.getCode() == BasicMessage.CODE_SUCCEED)
        {
            msg.setObject(new ArrayList<>(result.getObject().list));
            msg.setCode(BasicMessage.CODE_SUCCEED);
        } else
        {
            msg.setCode(BasicMessage.CODE_ERROR);
        }
        return msg;
    }

    private static class SpItemResult
    {

        public int result;

        public List<Sp.Item> list;
    }
}
