package com.hotbitmapgg.ohmybilibili.api;

import com.hotbitmapgg.ohmybilibili.network.ApiHelper;
import com.hotbitmapgg.ohmybilibili.model.BasicMessage;
import com.hotbitmapgg.ohmybilibili.model.HomeBanner;

import java.util.ArrayList;
import java.util.List;

public class BannerApi
{

    public static BasicMessage<ArrayList<HomeBanner>> getBanner()
    {

        String url = ApiHelper.getSlideshowUrl();
        BasicMessage<HomeBannerResult> result = ApiHelper.getSimpleUrlResult(url, HomeBannerResult.class);
        BasicMessage<ArrayList<HomeBanner>> msg = new BasicMessage<>();
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

    private class HomeBannerResult
    {

        public int result;

        public List<HomeBanner> list;
    }
}
