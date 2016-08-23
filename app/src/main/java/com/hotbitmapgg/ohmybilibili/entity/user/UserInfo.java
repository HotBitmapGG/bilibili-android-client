package com.hotbitmapgg.ohmybilibili.entity.user;

import java.util.List;

/**
 * Created by hcc on 16/8/22 20:48
 * 100332338@qq.com
 * <p/>
 * 用户详情数据
 */
public class UserInfo
{

    public static final int CODE_NOT_EXIST = -626;

    // 用户ID
    public int mid;

    // 用户名
    public String name;

    // 查询 UID 返回的用户名
    public String uname;

    // 查询 UID 返回的真实用户名
    public String userid;

    // 是否为认证用户
    public boolean approve;

    // 性别
    public String sex;

    // 用户等级数
    public int rank;

    // 用户头像
    public String face;

    // 用户等级数显示
    public String DisplayRank;

    // 注册时间
    public int regtime;

    // 出生日期
    public String birthday;

    // 居住地
    public String place;

    // 用户描述 认证信息
    public String description;

    // 投稿数
    public int article;

    // 已关注的用户ID
    public List<Integer> attentions;

    // 粉丝数
    public int fans;

    // 朋友数
    public int friend;

    // 关注数
    public int attention;

    // 签名
    public String sign;

    public int code;
}
