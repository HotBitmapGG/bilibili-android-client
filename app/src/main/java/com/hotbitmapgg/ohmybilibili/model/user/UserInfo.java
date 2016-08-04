package com.hotbitmapgg.ohmybilibili.model.user;

import java.util.List;

public class UserInfo
{

    public int mid; // 用户ID

    public String name; // 用户名

    public String uname; // 查询 UID 返回的用户名

    public String userid; // 查询 UID 返回的真实用户名

    public boolean approve; // 是否为认证用户

    public String sex; // 性别

    public int rank; // 用户等级数

    public String face; // 用户头像

    public String DisplayRank; // 用户等级数显示

    public int regtime; // 注册时间

    public String birthday; // 出生日期

    public String place; // 居住地

    public String description; // 用户描述/认证信息

    public int article; // 投稿数

    public List<Integer> attentions; // 已关注的用户ID

    public int fans; // 粉丝数

    public int friend; // 朋友数

    public int attention; // 关注数

    public String sign; // 签名

    public int code;

    public static final int CODE_NOT_EXIST = -626;
}
