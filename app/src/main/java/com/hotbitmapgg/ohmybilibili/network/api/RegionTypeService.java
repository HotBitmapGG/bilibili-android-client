package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.region.RegionTypesInfo;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by hcc on 2016/10/11 18:18
 * 100332338@qq.com
 * <p>
 * 获取分区数据
 * <p>
 * http://app.bilibili.com/x/v2/region?access_key=f5bd4e793b82fba5aaf5b91fb549910a
 * &actionKey=appkey&appkey=27eb53fc9058f8c3&build=3470&device=phone
 * &mobi_app=iphone&platform=ios&sign=c76b9aa1fbcefcbd9d08b862c050d16e&ts=1469603650
 */

public interface RegionTypeService
{

    @GET("x/v2/region?access_key=f5bd4e793b82fba5aaf5b91fb549910a&actionKey=appkey&appkey=27eb53fc9058f8c3&build=3470&device=phone&mobi_app=iphone&platform=ios&sign=c76b9aa1fbcefcbd9d08b862c050d16e&ts=1469603650")
    Observable<RegionTypesInfo> getPartitionTypes();
}
