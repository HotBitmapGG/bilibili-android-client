# An Unofficial Bilibili Android Client

[![Wercker](https://img.shields.io/badge/Android%20Client-bilibili-brightgreen.svg)](https://github.com/HotBitmapGG/bilibili) [![Issue Stats](https://img.shields.io/issuestats/i/github/strongloop/express.svg?maxAge=2592000)]()  [![TeamCity CodeBetter](https://img.shields.io/teamcity/codebetter/bt428.svg?maxAge=2592000)]() [![Crates.io](https://img.shields.io/crates/l/rustc-serialize.svg?maxAge=2592000)]()

![](https://github.com/HotBitmapGG/OhMyBiliBili/blob/OhMyBiliBili/art/bg2.png?raw=true)

## Features

* 首页六大模块，推荐，番剧，直播，关注，分区，发现的实现。

* 视频详情界面，视频评论，使用ijkplayer完成的视频播放，烈焰弹幕库实现的弹幕功能。

* 番剧模块的实现，包括专题详情界面，番剧详情界面，番剧放送表，番剧索引，新番连载，分季新番，追番。

* 使用ijkplayer实现的直播视频的播放，直播的弹幕没有实现，暂时还抓不到弹幕的数据，后期会完善。

* 游戏中心，话题中心，活动中心，原创排行榜，全区排行榜，离线缓存，周边商城，大会员界面的实现。

* 全站搜索的实现，搜索功能跟官方一致，支持综合，番剧，up主，影视，专题搜索。

* 直播详情界面的实现，目前只简单的完成了直播基本功能，还在完善中。

* 用户详情界面的实现。

* 分区详情的实现，包括推荐，各分区详情界面。

* 仿B站登录的小彩蛋。(登录只是假登录，随意输入帐号密码即可)


## Screenshots

<a href="art/00.png"><img src="art/00.png" width="30%"/></a> <a href="art/01.png"><img src="art/01.png" width="30%"/></a> <a href="art/02.png"><img src="art/02.png" width="30%"/></a>

<a href="art/03.png"><img src="art/03.png" width="30%"/></a> <a href="art/04.png"><img src="art/04.png" width="30%"/></a> <a href="art/05.png"><img src="art/05.png" width="30%"/></a>

<a href="art/06.png"><img src="art/06.png" width="30%"/></a> <a href="art/07.png"><img src="art/07.png" width="30%"/></a> <a href="art/003.png"><img src="art/003.png" width="30%"/></a>

<a href="art/004.png"><img src="art/004.png" width="30%"/></a> <a href="art/08.png"><img src="art/08.png" width="30%"/></a> <a href="art/09.png"><img src="art/09.png" width="30%"/></a>

<a href="art/10.png"><img src="art/10.png" width="30%"/></a> <a href="art/11.png"><img src="art/11.png" width="30%"/></a> <a href="art/12.png"><img src="art/12.png" width="30%"/></a>

<a href="art/13.png"><img src="art/13.png" width="30%"/></a> <a href="art/005.png"><img src="art/005.png" width="30%"/></a> <a href="art/006.png"><img src="art/006.png" width="30%"/></a>

<a href="art/007.png"><img src="art/007.png" width="30%"/></a> <a href="art/14.png"><img src="art/14.png" width="30%"/></a> <a href="art/15.png"><img src="art/15.png" width="30%"/></a>

<a href="art/16.png"><img src="art/16.png" width="30%"/></a> <a href="art/17.png"><img src="art/17.png" width="30%"/></a> <a href="art/18.png"><img src="art/18.png" width="30%"/></a>

<a href="art/19.png"><img src="art/19.png" width="30%"/></a> <a href="art/20.png"><img src="art/20.png" width="30%"/></a> <a href="art/21.png"><img src="art/21.png" width="30%"/></a>

<a href="art/22.png"><img src="art/22.png" width="30%"/></a> <a href="art/23.png"><img src="art/23.png" width="30%"/></a> <a href="art/24.png"><img src="art/24.png" width="30%"/></a>

<a href="art/25.png"><img src="art/25.png" width="30%"/></a> <a href="art/26.png"><img src="art/26.png" width="30%"/></a> <a href="art/27.png"><img src="art/27.png" width="30%"/></a>

<a href="art/28.png"><img src="art/28.png" width="30%"/></a> <a href="art/29.png"><img src="art/29.png" width="30%"/></a> <a href="art/30.png"><img src="art/30.png" width="30%"/></a>

<a href="art/31.png"><img src="art/31.png" width="30%"/></a> <a href="art/32.png"><img src="art/32.png" width="30%"/></a> <a href="art/33.png"><img src="art/33.png" width="30%"/></a>

<a href="art/34.png"><img src="art/34.png" width="30%"/></a> <a href="art/35.png"><img src="art/35.png" width="30%"/></a> <a href="art/36.png"><img src="art/36.png" width="30%"/></a>

<a href="art/38.png"><img src="art/38.png" width="30%"/></a> <a href="art/39.png"><img src="art/39.png" width="30%"/></a> <a href="art/40.png"><img src="art/40.png" width="30%"/></a>

<a href="art/41.png"><img src="art/41.png" width="30%"/></a> <a href="art/42.png"><img src="art/42.png" width="30%"/></a>  <a href="art/43.png"><img src="art/43.png" width="30%"/></a>

![](https://github.com/HotBitmapGG/bilibili/blob/master-x/art/001.png?raw=true)

![](https://github.com/HotBitmapGG/bilibili/blob/master-x/art/002.png?raw=true)


## Compilation

因升级至Android Studio2.2，项目已使用新的编译器Jack，如果你不是AS2.2以上版本，遇到编译报错，
请参考[issues#15](https://github.com/HotBitmapGG/bilibili-android-client/issues/15)


## UpdateLog

版本详细更新日志查看:[更新日志](https://github.com/HotBitmapGG/bilibili-android-client/blob/master-x/UpdateLog.md)


## API

现用接口都已不需要Appkey，大部分接口是使用iOS客户端抓包获取的接口，后期会抽时间整理成详细的接口文档放出来。



## Instructions

 * 如果你有任何意见，bug，问题都可以给我提Issuse，我会第一时间关注并解决.

 * Apk暂时不提供下载,因为还有一些界面功能没有做完,等全部完善后会上传到fir.im。

 * 后期会抽时间使用MVP来重构该项目,让整体架构更清晰。


## Statement

该项目仅供交流学习使用，如果该项目有侵犯B站版权问题，或被告知需停止共享与使用，本人会及时删除此页面与整个项目。


## Thanks to the open source project

* [RxJava](https://github.com/ReactiveX/RxJava)
* [RxAndroid](https://github.com/ReactiveX/RxAndroid)
* [RxBinding](https://github.com/JakeWharton/RxBinding)
* [RxLifecycle](https://github.com/trello/RxLifecycle)
* [RxCache](https://github.com/VictorAlbertos/RxCache)
* [okhttp](https://github.com/square/okhttp)
* [retrofit](https://github.com/square/retrofit)
* [ijkplayer](https://github.com/Bilibili/ijkplayer)
* [DanmakuFlameMaster](https://github.com/Bilibili/DanmakuFlameMaster)
* [butterknife](https://github.com/JakeWharton/butterknife)
* [glide](https://github.com/bumptech/glide)
* [MaterialSearchView](https://github.com/MiguelCatalan/MaterialSearchView)
* [FlycoTabLayout](https://github.com/H07000223/FlycoTabLayout)
* [MagicaSakura](https://github.com/Bilibili/MagicaSakura)
* [FlowLayout](https://github.com/hongyangAndroid/FlowLayout)



## About me

[![Wercker](https://img.shields.io/badge/weibo-HotBitmapGG-blue.svg)](http://weibo.com/3223089177/profile?topnav=1&wvr=6&is_all=1)

An android developer in Wuhan.

If you want to make friends with me, You can focus on my weibo.


## License

 Copyright 2016 HotBitmapGG

 Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.





