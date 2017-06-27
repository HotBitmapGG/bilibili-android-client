package com.hotbitmapgg.bilibili.entity.video;

import java.util.ArrayList;

/**
 * Created by hcc on 16/8/22 20:48
 * 100332338@qq.com
 * <p/>
 * 视频评论
 * <p/>
 * ###### ver1 返回
 * <p/>
 * | 返回值字段       | 字段类型   | 字段说明                                  |
 * | ----------- | ------ | ------------------------------------- |
 * | mid         | int    | 会员ID                                  |
 * | lv          | int    | 楼层                                    |
 * | fbid        | int    | 评论ID                                  |
 * | msg         | string | 评论信息                                  |
 * | ad_check    | int    | 状态 (0: 正常 1: UP主隐藏 2: 管理员删除 3: 因举报删除) |
 * | face        | string | 发布人头像                                 |
 * | rank        | int    | 发布人显示标识                               |
 * | nick        | string | 发布人暱称                                 |
 * | totalResult | int    | 总评论数                                  |
 * | pages       | int    | 总页数                                   |
 * <p/>
 * ###### ver 2/3 返回
 * <p/>
 * | 返回值字段    | 字段类型    | 字段说明 |
 * | -------- | ------- | ---- |
 * | results  | int     | 总评论数 |
 * | page     | int     | 当前页数 |
 * | pages    | int     | 总页数  |
 * | isAdmin  | int     | 未知   |
 * | needCode | boolean | 未知   |
 * | owner    | int     | 未知   |
 * | hotList  | list    | 热评列表 |
 * | list     | list    | 评论表  |
 * <p/>
 * ###### hotlist/list内容
 * <p/>
 * | 返回值字段       | 字段类型   | 字段说明                                  |
 * | ----------- | ------ | ------------------------------------- |
 * | mid         | int    | 会员ID                                  |
 * | lv          | int    | 楼层                                    |
 * | fbid        | int    | 评论ID                                  |
 * | msg         | string | 评论信息                                  |
 * | ad_check    | int    | 状态 (0: 正常 1: UP主隐藏 2: 管理员删除 3: 因举报删除) |
 * | face        | string | 发布人头像                                 |
 * | rank        | int    | 发布人显示标识                               |
 * | nick        | string | 发布人暱称                                 |
 * | totalResult | int    | 总评论数                                  |
 * | pages       | int    | 总页数                                   |
 * | good        | int    | 点赞数?                                  |
 * | isgood      | int    | 是否已点赞?                                |
 * | device      | 未知     | 未知                                    |
 * | create      | int    | 创建评论的UNIX时间                           |
 * | create_at   | String | 创建评论的可读时间(2016-01-20 15:52)           |
 * | reply_count | int    | 回复数量                                  |
 * | level_info  | list   | 用户的等级信息?                              |
 * | sex         | String | 用户的性别                                 |
 * | reply       | list   | 对此评论的回复(仅限list)                       |
 * <p/>
 * ###### level_info
 * <p/>
 * | 返回值字段         | 字段类型 | 字段说明      |
 * | ------------- | ---- | --------- |
 * | current_level | int  | 用户当前等级    |
 * | current_min   | int  | 当前等级最低经验值 |
 * | current_exp   | int  | 用户当前经验值   |
 * | next_exp      | int  | 下一等级所需经验值 |
 * <p/>
 * ###### reply
 * <p/>
 * | 返回值字段       | 字段类型   | 字段说明                                  |
 * | ----------- | ------ | ------------------------------------- |
 * | mid         | int    | 会员ID                                  |
 * | lv          | int    | 楼层                                    |
 * | fbid        | int    | 评论ID                                  |
 * | msg         | string | 评论信息                                  |
 * | ad_check    | int    | 状态 (0: 正常 1: UP主隐藏 2: 管理员删除 3: 因举报删除) |
 * | face        | string | 发布人头像                                 |
 * | rank        | int    | 发布人显示标识                               |
 * | nick        | string | 发布人暱称                                 |
 * | totalResult | int    | 总评论数                                  |
 * | pages       | int    | 总页数                                   |
 * | good        | int    | 点赞数?                                  |
 * | isgood      | int    | 是否已点赞?                                |
 * | device      | 未知     | 未知                                    |
 * | create      | int    | 创建评论的UNIX时间                           |
 * | create_at   | String | 创建评论的可读时间(2016-01-20 15:52)           |
 * | reply_count | int    | 回复数量                                  |
 * | level_info  | list   | 用户的等级信息?                              |
 * | sex         | String | 用户的性别                                 |
 */
public class VideoCommentInfo {
    public int owner;
    public int pages;
    public boolean needCode;
    public int isAdmin;
    public int results;
    public ArrayList<HotList> hotList;
    public ArrayList<List> list;
    public int page;

    public class HotList {
        public String face;
        public int mid;
        public String sex;
        public int isgood;
        public int adCheck;
        public String nick;
        public String create_at;
        public int rank;
        public int good;
        public LevelInfo level_info;
        public int lv;
        public String fbid;
        public int reply_count;
        public String msg;
        public int create;
        public String device;
    }

    public class List {
        public String face;
        public int mid;
        public String sex;
        public int isgood;
        public int adCheck;
        public String nick;
        public String create_at;
        public int rank;
        public int good;
        public LevelInfo level_info;
        public int lv;
        public String fbid;
        public int reply_count;
        public String msg;
        public int create;
        public String device;
    }

    public class LevelInfo {
        public int current_level;
    }
}
