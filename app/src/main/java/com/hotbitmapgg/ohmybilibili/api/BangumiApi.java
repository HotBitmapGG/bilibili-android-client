package com.hotbitmapgg.ohmybilibili.api;

import com.hotbitmapgg.ohmybilibili.model.bangumi.Bangumi;
import com.hotbitmapgg.ohmybilibili.model.base.BasicMessage;
import com.hotbitmapgg.ohmybilibili.network.ApiHelper;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 番剧查询Api
 *
 * @HotBitmapGG
 */
public class BangumiApi
{

    public static final int BTYPE_ALL = -1, BTYPE_2D = 2, BTYPE_RETINA = 3;

    public static final int WD_ALL = -1, WD_SUN = 0, WD_MON = 1, WD_TUE = 2, WD_WED = 3, WD_THU = 4, WD_FRI = 5, WD_SAT = 6;

    public static BasicMessage<ArrayList<Bangumi>> getBangumi(int btype, int weekday)
    {

        String url = ApiHelper.getBangumiUrl(btype, weekday);
        LogUtil.lsw(url);
        BasicMessage<BangumiResult> result = ApiHelper.getSimpleUrlResult(url, BangumiResult.class);
        BasicMessage<ArrayList<Bangumi>> msg = new BasicMessage<>();
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

    private class BangumiResult
    {

        public int results;

        public List<Bangumi> list;
    }
}
