# Note 

![What is your main focus for toady](mainFocus.png)


# * [the career of a programmer](http://coolshell.cn/articles/17583.html#comments)

> **我花费了大量的时间阅读和学习各种开源的代码、研究其中的实现原理、尝试自己实现相关技术、尝试在工作中使用，这使得我在 iOS 开发技术上进步很快。 —— YY**

> **每天都有很多事情要做，但是事情永远做不完，所以必须有明确优先级，明确一个目标，给定一段时间,坚持看看效果如何。**




## **Algorithm**
* [Direct insertion sort](http://www.henishuo.com/insert-sort/)
* [张不坏的博客](http://zhangbuhuai.com/2015/06/28/Array-and-Algorithm/)
* [git二分法查找命令的使用](http://blog.csdn.net/maybe_windleave/article/details/8532092)
* [LeetCode_Swift](https://github.com/soapyigu/LeetCode_Swift)
* [swift算法](http://www.jianshu.com/users/8d5b91490ca5/latest_articles)
* [Learn-Algorithms](https://github.com/nonstriater/Learn-Algorithms)
* [Solutions to LeetCode by Swift](https://github.com/soapyigu/LeetCode_Swift)
* [时间复杂度和空间复杂度](https://www.zybuluo.com/Sakura-W/note/384646)
* [Swift 算法实战之路：二叉树](http://www.jianshu.com/p/28f6b0b85ec1)

## **System design**
[System-design-interview-for-IT-companies](https://github.com/checkcheckzz/system-design-interview)

## Animaton
### TransitionAnimation
* [VCTransitionsLibrary](https://github.com/ColinEberhardt/VCTransitionsLibrary)
* [RZTransitions](https://github.com/Raizlabs/RZTransitions)
* [HYBControllerTransitions](https://github.com/CoderJackyHuang/HYBControllerTransitions)
* [KYMagicMove](https://github.com/KittenYang/KYMagicMove)
* [ViewControllersTransition](https://github.com/YouXianMing/ViewControllersTransition)
* [iOS-ViewController-Transition-Demo](https://github.com/seedante/iOS-ViewController-Transition-Demo.git)
* [ZFDragableModalTransition(淘宝进入购买详情转场动画)](https://github.com/zoonooz/ZFDragableModalTransition)

### CollectionAnimation
* [popping](https://github.com/schneiderandre/popping)
* [The Animation Collection_YouXianMing](https://github.com/YouXianMing/Animations)

### facebookPopMenuAnimation
* [DXPopover](https://github.com/xiekw2010/DXPopover)
* [CMPopTipView](https://github.com/chrismiles/CMPopTipView)
* [NirKxMenu](https://github.com/zpz1237/NirKxMenu)

### TinderSwipeAnimation
* [MDCSwipeToChoose](https://github.com/modocache/MDCSwipeToChoose)
* [TinderSimpleSwipeCards](https://github.com/cwRichardKim/TinderSimpleSwipeCards)
* [ZLSwipeableView](https://github.com/zhxnlai/ZLSwipeableView)
* [Koloda](https://github.com/Yalantis/Koloda)
* [HotGirls](https://github.com/zangqilong198812/HotGirls)

### GestureAnimation
* [DraggableYoutubeFloatingVideo](https://github.com/vizllx/DraggableYoutubeFloatingVideo)


## Video
### AVFoundation
* [iOS使用AVFoundation实现二维码扫描](http://strivingboy.github.io/blog/2014/11/08/scan-qrcode/)  
* [AVFoundation Tutorial](https://www.raywenderlich.com/30200/avfoundation-tutorial-adding-overlays-and-animations-to-videos)
* [AVFoundation Take photo](http://www.jianshu.com/p/6dd23699f92f)
* [liveVideoIntroductionBiaoGeBlog](http://www.henishuo.com/ios-live-confused/)
* [book](http://item.jd.com/11742630.html)

* [Bilibili / ijkplayer baseed on FFmpeg with MediaCodec,Video Toolbox support](https://github.com/Bilibili/ijkplayer)

* [AVFoundation 视频流处理](https://github.com/100mango/zen/blob/master/iOS学习：AVFoundation%20视频流处理/iOS学习：AVFoundation%20视频流处理%20.md)

* [SCRecorder iOS camera engine with Vine-like tap to record, animatable filters, slow motion, segments editing](https://github.com/rFlex/SCRecorder.git)

* [ffmpeg principle](https://segmentfault.com/a/1190000000502967)

* [Cache media file while play media using AVPlayer](https://github.com/vitoziv/VIMediaCache)

* [AVFoundation编程指南1-使用 Assets](https://segmentfault.com/a/1190000004049416)

* [AVFoundation编程指南2-用AVPlayer播放视频](https://segmentfault.com/a/1190000004054258)
* [AVFoundation相关类的分析](http://www.fanliugen.com/?p=423)
* [iOS 视频剪切、旋转，视频添加音频、添加水印，视频导出](http://ios.jobbole.com/85309/)
* [iOS 三种录制视频方式](http://ios.jobbole.com/85069/)
* [CMTime简单介绍](http://www.jianshu.com/p/f110bf6e0471)
* [AVFoundation(一):基础知识](http://www.jianshu.com/p/485e946f80b4)
* [AVFoundation(二)：核心AVAsset](http://www.jianshu.com/p/9805be76ee68)
* [iOS音视频实现边下载边播放](http://sky-weihao.github.io/2015/10/06/Video-streaming-and-caching-in-iOS/)
* [CTVideoPlayerView](https://github.com/casatwy/CTVideoPlayerView)
* [Eleven Player is a simple powerful video player.use ffmpeg](https://github.com/coderyi/Eleven)

```
CMTimeMake和CMTimeMakeWithSeconds 详解 
CMTimeMake(a,b)    a当前第几帧, b每秒钟多少帧.当前播放时间a/b
CMTimeMakeWithSeconds(a,b)    a当前时间,b每秒钟多少帧.
CMTimeMake
CMTime CMTimeMake (
   int64_t value,
   int32_t timescale
);
CMTimeMake顧名思義就是用來建立CMTime用的,
但是千萬別誤會他是拿來用在一般時間用的,
CMTime可是專門用來表示影片時間用的類別,
他的用法為: CMTimeMake(time, timeScale)
time指的就是時間(不是秒),
而時間要換算成秒就要看第二個參數timeScale了.
timeScale指的是1秒需要由幾個frame構成(可以視為fps),
因此真正要表達的時間就會是 time / timeScale 才會是秒.
簡單的舉個例子
CMTimeMake(60, 30);
CMTimeMake(30, 15);
```



### muke
 * [segmentfault iOS share](http://www.imooc.com/learn/599)
 * [beijing swift conference](http://www.imooc.com/learn/600)

### Download
* [MJDownload](https://github.com/CoderMJLee/MJDownload.git)
* [ZFPlayer](https://github.com/renzifeng/ZFPlayer.git)
* [TCBlobDownload](https://github.com/thibaultCha/TCBlobDownload.git)

```
Features
     后台下载文件
	1	Download files in background threads
	   代理或者blocks风格
	2	Blocks or delegate style
	   暂停 重新开始一个下载
	3	Pause and resume a download
	   设置最大并发下载数
	4	Set a maximum number of concurrent downloads
	   自定义下载路径
	5	Custom download path
	   下载速度与剩余时间
	6	Download speed and remaining time
	   取消下载
	7	Download cancellation
	    下载依赖 
	8	Download dependencies
	
	•	If a download has been stopped and the local file has not been deleted, when you will restart the download to the same local path, the download will start where it has stopped using the HTTP Range header (14.35).
	•	You can also set dependencies in your downloads using the addDependentDownload: method from TCBlobDownloader.
```

[MZDownloadManager(swfit now)](https://github.com/mzeeshanid/MZDownloadManager)

```
This download manager uses the iOS 7 NSURLSession api to download files.
     能在后台下载大的文件
	•	Can download large files if app is in background.
	   能在后台下载文件
	•	Can download files if app is in background.
	   能在同一时间下载多个文件
	•	Can download multiple files at a time.
	   重新开始下载已经打断的下载任务
	•	It can resume interrupted downloads.
	   用户能够暂停下载
	•	User can also pause the download.
	   如果任何错误发生了，用户能够重新下载
	•	User can retry any download if any error occurred during download.
```


* [Download-Manager](https://github.com/oarrabi/Download-Manager)

```
What it provides
	•	Easy to integrate and use iOS download manager.
	•	Easily download file with the very robust AFNetworking library.
	•	Deal only with NSURL, you will never have to keep strong or weak references of the Download managers.
	•	Download files in sequential and parallel order.
	•	Make sure each file (NSURL) is being downloaded only once.
	•	Have multiple listener/delegates on a single download operation.
	•	Download operation unique by URL, never download a URL twice.
	•	Cache the downloaded file in Memory and on Disk using EGOCache.
	•	Easily add and remove listeners to observe the download operations.
	•	Singleton classes for fast access and minimum memory overhead.
	•	Ensure that the UI Thread is never blocked.
	•	Delegate or Block event callbacks.
	•	All of the above in two lines of code.

```
 **downloadManager should do**
 
```
 1. 后台下载
 2. 多任务下载
 3. 暂停
 4. 多任务暂停
 5. 全部暂停
 6. delete
 7. 多任务delete
 8. 全部delete
 9. 返回下载状态（1：没有下载 2：下载中 3：下载成功 4：下载失败：5：其他）
 10. 检测某个任务是否正在下载
 11. 查看已经下载文件存放位置（readonly）
 12. 查看已经下载文件大小（readonly）
 13. 查看已经下载文件名（readonly）
 14. 查看已经下载文件类型（readonly）
 15. 查看已经下载成功的时间（readonly）
 13. 下载中文件的进度
 14. 设置下载任务的优先级
 15. 设置断点续传
 16. 检测已经下载的文件是否完整
 17. 查看文件开始下载的时间(readonly)
 18. 检测已经下载的文件
 19. 检测全部已经下载文件的大小
 20. 设置下载超时时间
 21. 设置cdnurl
 22. 查看正在下载的文件数量
 23. 删除过期的文件
 24. 设置删除过期的文件的算法
 25. 查询正在下载的任务
 26. 查询某个下载任务的进度 
```



### LiveVideo
* [LiveVideoCoreSDK](https://github.com/runner365/LiveVideoCoreSDK)
* [SmarterStreaming](https://github.com/daniulive/SmarterStreaming)
* [主流跨平台媒体库ffmpeg，live555，MobileVLCKit简介](https://segmentfault.com/a/1190000002953107)
* [MiaowShow iOS视频直播项目](https://github.com/SunLiner/MiaowShow)
* [520Linkee](https://github.com/GrayJIAXU/520Linkee)
* [RTMPCHybridEngine-IOS](https://github.com/AnyRTC/RTMPCHybridEngine-IOS)

## Audio
* [MPVolumeView_iOS program modification system volume](https://segmentfault.com/a/1190000002401961)

## Image

### Gif 
* [FLAnimatedImage](https://github.com/Flipboard/FLAnimatedImage)
* [sever return 304](http://weibo.com/1247589445/DwgHFs2cF?type=repost)
* [关于UIImage的内存问题与解决方案](https://github.com/Magic-Unique/HXImage/blob/master/description.md)


## View
* [scrollView To Top](http://www.jianshu.com/p/68632cbd6263)
* [why SDWebImageDecoder](http://www.jianshu.com/p/135e17c7d10f)
* [Y_KLine](https://github.com/yate1996/Y_KLine)
* [StockKLine](https://github.com/mengmanzbh/StockKLine)
* [YYStock](https://github.com/yate1996/YYStock)
* [高仿支付宝解锁](https://github.com/CharlinFeng/CoreLock)
* [VTMagic is a page container library for iOS](https://github.com/tianzhuo112/VTMagic)

### 占位视图
* [DZNEmptyDataSet](https://github.com/dzenbot/DZNEmptyDataSet)
* [CYLTableViewPlaceHolder](https://github.com/ChenYilong/CYLTableViewPlaceHolder)

### MessageKit
* [Atlas-iOS](https://github.com/layerhq/Atlas-iOS)


### Button
* [图片与文字不定Btn](https://github.com/lianchengjiang/LCUIKit)



## CALayer
* [CALayer and subLayer](http://my.oschina.net/u/2340880/blog/536048)
* [CATextLayer](https://github.com/joeshang/CATextLayerTest)
* [CAGradientLayer](https://zsisme.gitbooks.io/ios-/content/chapter6/cagradientLayer.html)

```
普通CALayer在被初始化时是需要给一个frame值的,这个frame值一般都与给定view的bounds值一致,它本
身是有形状的,而且是矩形.
CAShapeLayer在初始化时也需要给一个frame值,但是,它本身没有形状,它的形状来源于你给定的一个path,

然后它去取CGPath值,它与CALayer有着很大的区别
CAShapeLayer有着几点很重要:
1. 它依附于一个给定的path,必须给与path,而且,即使path不完整也会自动首尾相接
2. strokeStart以及strokeEnd代表着在这个path中所占用的百分比
```



## Model
* [YYModel basic knowledge](http://www.jianshu.com/p/198af7042b2d)
* [YYModel 源码历险记](http://www.jianshu.com/users/aa41dad549af/latest_articles)
* [YYModel Part](http://xiongzenghuidegithub.github.io/blog/archives/)

## Cache
* [FMDB](https://github.com/ccgus/fmdb)
* [realm](https://github.com/realm/realm-cocoa)
* [MagicalRecord](https://github.com/magicalpanda/MagicalRecord)
* [VIMediaCache](https://github.com/vitoziv/VIMediaCache)
* [NSURLCache 网络请求缓存指南](http://www.cocoachina.com/ios/20160701/16895.html)

## Text
* [CoreText_xiongzenghu](http://xiongzenghuidegithub.github.io/blog/2016/04/26/coretext-part-3/)
* [CoreText_zoomfeng](http://www.zoomfeng.com/blog/coretextshi-yong-jiao-cheng-%5B%3F%5D.html)
* [TTTAttributedLabel](https://github.com/TTTAttributedLabel/TTTAttributedLabel)
* [UILabel replacement with fine-grain appear/disappear animation](https://github.com/overboming/ZCAnimatedLabel)
* [TYAttrubutedLabel](https://github.com/12207480/TYAttributedLabel)
* [YYText 是如何绘制的](https://github.com/lzwjava/OpenSourceNotes)






## AutoLayout
* [Autolayout standard style of writing](http://reviewcode.cn/article.html?reviewId=14)
* [Masonry 源码解析](https://github.com/Draveness/iOS-Source-Code-Analyze/blob/master/Masonry/iOS%20源代码分析%20---%20Masonry.md)
* [HandyAutoLayout](https://github.com/casatwy/HandyAutoLayout)
* [SDAutoLayout](https://github.com/gsdios/SDAutoLayout)
* [Masonry](https://github.com/SnapKit/Masonry)
* [FDStackView —— Downward Compatible UIStackView](http://blog.wtlucky.com)

## CADisplayLink
* [CADisplayLink](http://www.jianshu.com/p/c35a81c3b9eb)

## Architecture
* [OUT OF OOP-inheritance](http://casatwy.com/tiao-chu-mian-xiang-dui-xiang-si-xiang-yi-ji-cheng.html)
* [IOP](http://casatwy.com/tiao-chu-mian-xiang-dui-xiang-si-xiang-er-duo-tai.html)
* [OUT OF OOP-package](http://casatwy.com/tiao-chu-mian-xiang-dui-xiang-si-xiang-san-feng-zhuang.html)
* [know or understand](http://casatwy.com/zen-yao-mian-shi-jia-gou-shi.html)
* [路由跳转的思考](http://awhisper.github.io/2016/06/12/路由跳转的思考/)
* [CDD](http://mrpeak.cn/blog/cdd/)
* [天猫架构解耦之路 by gaosboy（高嘉峻)](http://weibo.com/1708947107/DBQxn64gC?type=repost#_rnd1467178225666)
* [新浪微博iOS客户端架构与优化之路](http://mp.weixin.qq.com/s?__biz=MzA3ODg4MDk0Ng==&mid=2651112273&idx=1&sn=893a66a04e541a99b7bc4d7cf227e2f7#rd)
* [滴滴出行iOS客户端架构演进之路](http://mp.weixin.qq.com/s?__biz=MzA3ODg4MDk0Ng==&mid=402854111&idx=1&sn=5876e615fabd6d921285d904e16670fb#rd)
* [面向切面编程之 Aspects 源码解析及应用](http://wereadteam.github.io/2016/06/30/Aspects/)
* [解耦神器 —— 统跳协议和Rewrite引擎_Gaosboy](http://pingguohe.net/2015/11/24/Navigator-and-Rewrite.html?from=timeline&isappinstalled=0)
* [不要写死！天猫App的动态化配置中心实践](http://mp.weixin.qq.com/s?plg_nld=1&plg_uin=1&mid=402842876&idx=1&plg_nld=1&scene=23&plg_auth=1&__biz=MzA3ODg4MDk0Ng%3D%3D&plg_dev=1&srcid=0714QNbdzbzuS1Ulam0tklNi&plg_usr=1&plg_vkey=1&sn=e15d596c95bf7d1ed579cfd7e410696a#rd)
* [从无到有：微信后台系统的演进之路](http://geek.csdn.net/news/detail/51045)
* [万亿级调用系统：微信序列号生成器架构设计及演变](http://mp.weixin.qq.com/s?__biz=MjM5MDE0Mjc4MA==&mid=503509249&idx=1&sn=44fbaff1e0fc0b5e8a8f8ad9585086f0#rd)
* [天下武功出少林，天下架构出MVC](/Architecture/天下武功出少林，天下架构出MVC.jpg
)
* [大型网站技术架构（1）](https://segmentfault.com/a/1190000007390358?utm_source=weekly&utm_medium=email&utm_campaign=email_weekly)
* [大型网站技术架构（2）：架构要素和高性能架构](https://segmentfault.com/a/1190000007409203)
* [年度盘点（三） | 2016 年十大架构师必读好文](http://weibo.com/ttarticle/p/show?id=2309404060110799426234)
* [对象间交互模式](https://casatwy.com/communication_patterns.html)

### FRP
* [RAC](https://github.com/ReactiveCocoaChina/ReactiveCocoaChineseResources)

## Memory leaks
* [MLeaksFinder](https://github.com/Zepo/MLeaksFinder)
* [FBRetainCycleDetector](https://github.com/facebook/FBRetainCycleDetector)

## Runloop
* [RunLoopWorkDistribution](https://github.com/diwu/RunLoopWorkDistribution)
* [PerformanceMonitor](https://github.com/suifengqjn/PerformanceMonitor)
* [RunLoop学习笔记](http://www.starming.com/index.php?v=index&view=74)
* [深入理解RunLoop](http://blog.ibireme.com/2015/05/18/runloop/)
* [sunny runloop实战](http://blog.sunnyxx.com/2015/05/17/cell-height-calculation/)
* [NSRunLoop、参与多线程之间的通信](http://xiongzenghuidegithub.github.io/blog/2015/08/21/nsrunloop,-can-yu-duo-xian-cheng-zhi-jian-de-tong-xin/)
* [iOS实时卡顿监控](http://ios.jobbole.com/83742/)

## Runtime
* [翻译-为什么objc_msgSend必须用汇编实现](http://tutuge.me/2016/06/19/translation-why-objcmsgsend-must-be-written-in-assembly/)
* [Objective-C 消息发送与转发机制原理](http://yulingtianxia.com/blog/2016/06/15/Objective-C-Message-Sending-and-Forwarding/)
* [Calling Conventions](http://slides.com/sunnyxx/calling-conventions-in-cocoa#/)
* [如何动态调用 C 函数](http://mp.weixin.qq.com/s?__biz=MzIzNTQ2MDg2Ng==&mid=2247483687&idx=1&sn=94d3ce224e5e25f2e1ae8a6046efb472#rd)

## SQ
* [GYDataCenter](https://github.com/Zepo/GYDataCenter)
* [CTPersistance](https://github.com/casatwy/CTPersistance)
* [FMDB](https://github.com/ccgus/fmdb)
* [realm之于iOS](http://mp.weixin.qq.com/s?__biz=MzI5MjEzNzA1MA==&mid=2650264208&idx=1&sn=edfeb6ec6d14bddeb3c3ac3367045456&chksm=f40683a5c3710ab3adce18244f5c02bbf3e2b3b156162e90b8c4ecf9a58fcf9f50987706db3e#wechat_redirect)
* [当磁盘空间爆满后，MySQL会发生什么事呢？又应该怎么应对？](http://imysql.com/2015/09/23/mysql-faq-what-will-happen-when-disk-full.shtml?f=http://blogread.cn/)
* [误删 300G，GitLab 官方对删库事故的事后分析](http://blog.jobbole.com/110171/)

## Socket
* [微信、陌陌等著名IM软件设计架构详解](http://blog.csdn.net/justinjing0612/article/details/38322353)

## Cocoapods
* [ERROR: While executing gem ... (Errno::EPERM) Operation not permitted - /usr/bin/pod](http://stackoverflow.com/questions/30812777/cannot-install-cocoa-pods-after-uninstalling-results-in-error/30851030#30851030)
* [Operation not permitted - /usr/bin/fuzzy_match](http://blog.csdn.net/sinat_29998157/article/details/50070687)
* [While executing gem ... (TypeError) no implicit conversion of nil into String](http://stackoverflow.com/questions/25844937/how-to-install-cocoa-pods-in-terminal)
* [When using cocoapods, what is the best way to change the PRODUCT_NAME?](http://stackoverflow.com/questions/31120403/when-using-cocoapods-what-is-the-best-way-to-change-the-product-name)
* [理解Cocoapods](https://segmentfault.com/a/1190000005041357)
* [CocoaPods安装出现SSL verification error](http://www.jianshu.com/p/17043faee2e6)

## SomeGuysBlog
* [WeiXinRead](http://wereadteam.github.io)
* [sunnyxx](http://blog.sunnyxx.com)
* [FMDB_description](http://blog.csdn.net/yixiangboy/article/details/51274186)
* [integration ijkplayer](http://www.jianshu.com/p/1f06b27b3ac0)
* [daiming](http://www.jianshu.com/users/9a4903d7e3d1/latest_articles)
* [Draveness](http://draveness.me/)
* [chuange](http://adad184.com)
* [tutuge](http://tutuge.me)
* [casa](http://casatwy.com)
* [leichunfeng](http://blog.leichunfeng.com)
* [YY](http://blog.ibireme.com)
* [YY github ios list](http://github.ibireme.com/github/list/ios/)
* [onev](https://onevcat.com)
* [youxianming](http://www.cnblogs.com/YouXianMing/)
* [JohnLui](https://lvwenhan.com)
* [mz](http://makezl.github.io)
* [margtin](http://www.martinrgb.com)
* [zhuo](http://www.jianshu.com/users/88a056103c02/latest_articles)
* [tangqiao](http://blog.devtang.com)
* [mrpeak](http://mrpeak.cn)
* [yang](http://kittenyang.com)
* [yanzu](http://www.jianshu.com/users/b82d2721ba07/latest_articles)
* [beige](http://www.henishuo.com)
* [nanfengzi](http://southpeak.github.io)
* [xiongzenghuidegithu](http://xiongzenghuidegithub.github.io)
* [lexrus](http://lexrus.com)
* [xiaobenlang](http://jiangliancheng.gitcafe.io)
* [xia](http://blog.txx.im/?from=inf&wvr=5&loc=infblog)
* [zixun](http://zixun.github.io)
* [zengxianhua](http://zengxianhua.com)
* [kissGod](http://www.jianshu.com/users/8d704c0faf00/latest_articles)
* [bang](http://blog.cnbang.net/archives/)
* [TomatoRead](https://github.com/everettjf/TomatoRead)
* [玉令天下的博客](http://yulingtianxia.com/blog/2016/06/15/Objective-C-Message-Sending-and-Forwarding/)
* [bestswifter](https://bestswifter.com)
* [百度Hi团队 iOS 技术周报](https://github.com/BaiduHiDeviOS/iOS-Tech-Weekly)
* [iOS-Source-Code-Analyze](https://github.com/Draveness/iOS-Source-Code-Analyze)
* [Ghost博客搭建 - 追随猫神之路](http://402v.com/ghostbo-ke-da-jian-xi-lie-zhui-sui-mao-shen-zhi-lu/)
* [MartinRGB](http://www.martinrgb.com)
* [阮一峰的网络日志](http://www.ruanyifeng.com/blog/)
* [iPic](http://toolinbox.net)
* [手机天猫技术大赏](http://pingguohe.net/tmalltech/)
* [XcodeMen](http://www.jianshu.com/users/d509cc369c78/latest_articles)
* [Keynotes of lzwjava at github](https://github.com/lzwjava/Keynotes)
* [isaced](http://www.isaced.com/sort/6)
* [酷 壳 – COOLSHELL](http://coolshell.cn)
* [王垠](http://www.yinwang.org/)
* [iOS开发常用三方库、插件、知名博客等等](https://github.com/Tim9Liu9/TimLiu-iOS)
* [多年iOS开发经验总结(一)](多年iOS开发经验总结(一))

## Git
* [Git Flow](http://www.jianshu.com/p/fa83b6858d52)
* [如何解决GitHub commit次数过多.git文件过大的问题?](https://www.zhihu.com/question/29769130)
* [if you change your password or username on GitHub](https://help.github.com/articles/updating-credentials-from-the-osx-keychain/)
* [git 原理](http://gold.xitu.io/entry/575e223a165abd005559294f)

```
git Alias
autoPush() {
    git add -A
    git commit -m $1
    git push
}
alias g=autoPush
```

### Gitpages
* [southpeak.github.io](http://southpeak.github.io)
  
  
## Crash
* [objc_retain](http://www.bkjia.com/IOSjc/898404.html)
* [NSTimer](http://blog.csdn.net/enuola/article/details/8099461)

```
You must send this message from the thread on which the timer was installed. If
you send this message from another thread, the input source associated with the
timer may not be removed from its run loop, which could prevent the thread from
exiting properly.
NSTimer 在哪个线程创建就要在哪个线程停止，否则会导致资源不能被正确的释放。看起来各种坑还不少。
```

## Efficiency 
* [Mac_MrPeak](http://mrpeak.cn/blog/mac-efficiency/)


## Vim
* [vim搜索命令](http://blog.csdn.net/luomoweilan/article/details/6260179)
* [VIM——帮助和配置](http://macshuo.com/?p=769)
* [VIM——为效率而生](http://macshuo.com/?p=755)
* [VIM——缘起](http://macshuo.com/?p=748)
* [简明 Vim 练级攻略](http://coolshell.cn/articles/5426.html)
* [Vim常用命令_标哥](http://www.huangyibiao.com/vim-xcode/)
* [Vim 用户的大脑形态](http://blog.jobbole.com/104276/)
* [Vim - 适合自己的，才是最好的](http://geekplux.com/2015/06/06/vim-those-fit-yourself-are-the-best.html)
* [Vim入门基础](http://www.jianshu.com/p/bcbe916f97e1)


## Tool
* [Phabricator](http://phabricator.org/)
* [oh-my-zsh](https://github.com/robbyrussell/oh-my-zsh)
* [Homebrew](http://brew.sh/)
* [fastlane(`The easiest way to automate building and releasing your iOS and Android apps`)打包Tool](https://github.com/fastlane/fastlane)
* [fir-cli command-line interface](https://github.com/FIRHQ/fir-cli)
* [Charles抓包心得](http://itangqi.me/2016/05/30/tips-for-using-charles/#more)
* [Surge原理](http://gold.xitu.io/entry/562eef4900b0acaac036ac11)
* [WWDC 410 Visual Debugging With Xcode](https://mp.weixin.qq.com/s?__biz=MzIwMTYzMzcwOQ==&mid=2650948410&idx=1&sn=c48375a832b8769a0f43a293a3f09fe3&scene=0&key=f8ab7b995657050bada4064a262d2959647e1b5f90d16dc6aacd29bbb714ed1c9ab7d221648976431d558244cd7f7f4c&ascene=0&uin=NDU1NzA2MTk1&devicetype=iMac+MacBookPro12%2C1+OSX+OSX+10.11.5+build(15F34)&version=11020201&pass_ticket=H4NFpA%2FV2mGlXbz6iuyTOJnJk06Bxbxc4ZX3kEuhqXJbEyQiJG8zuAWpLkapt%2F31)
* [Surge config](https://github.com/lhie1/Surge)
* [AppleDNS](https://github.com/gongjianhui/AppleDNS)
* [alfred workflow 李大锤同学](http://weibo.com/lizexipablo?profile_ftype=1&is_all=1&is_search=1&key_word=alfred#_0)
* [鼠须管](https://github.com/rime/squirrel)
* [Mac  开发者  怕雾霾和没vim  设计师](http://liqi.io/zhangbin/)
* [Mac  Swift  同用书垫电脑  开发者](http://liqi.io/wangling/)
* [hosts](https://github.com/racaljk/hosts)
* [hacker-scripts](https://github.com/NARKOZ/hacker-scripts)


```
homebrew-cask,官网传送, 是一套建立在homebrew基础上的Mac软件安装命令行工具。与brew的区别就
是，后者侧重于软件套件和软件环境的配置安装，而前者是mac平台软件
```

```
brew 是从下载源码解压然后 ./configure && make install ，同时会包含相关依存库。并自动配置好
各种环境变量，而且易于卸载。 
这个对程序员来说简直是福音，简单的指令，就能快速安装和升级本地的各种开发环境。
而 brew cask 是 已经编译好了的应用包 （.dmg/.pkg），仅仅是下载解压，放在统一的目录中（/opt/
homebrew-cask/Caskroom），省掉了自己去下载、解压、拖拽（安装）等蛋疼步骤，同样，卸载相当容易与
干净。这个对一般用户来说会比较方便，包含很多在 AppStore 里没有的常用软件。
```


## Tutorial
* [objc](http://objccn.io)
* [Safari for OS X 你不可不知的 10 个快捷键](http://sspai.com/30902)
* [Markdown](https://github.com/younghz/Markdown)
* [TimLiu-iOS](https://github.com/Tim9Liu9/TimLiu-iOS)
* [链式编程1](http://www.jianshu.com/p/87ef6720a096)
* [链式编程2](http://xiongzenghuidegithub.github.io/blog/2015/12/04/blockmo-ni-lian-shi-yu-fa/)
* [一些 iOS / Web 开发相关的翻译或原创博客文章](https://github.com/nixzhu/dev-blog)
* [YY整理- ( ゜- ゜)つロ Github-iOS备忘](http://github.ibireme.com/github/list/ios/)


## 设计模式
* [youxianming](http://www.cnblogs.com/YouXianMing/tag/软件设计原则/)
* [leichunfeng](https://github.com/leichunfeng/DesignPatterns-Objective-C)



## Foundation
* roundf 将浮点值四舍五入为最接近的整数
* `pow() 函数用来求 x 的 y 次幂（次方），其原型为：
    double pow(double x, double y);`
* `usleep函数能把进程挂起一段时间， 单位是微秒（千分之一毫秒）`


## NetWorking
* [RTNetworking](https://github.com/casatwy/RTNetworking)

1. 以什么方式将数据交付给业务层？这个问题的回答是这样：
   尽可能通过Delegate的回调方式交付数据，这样可以避免不必要的跨层访问。当出现跨层访问的需求时（比如信号类型切换），通过Notification的方式交付数据。正常情况下应该是避免使用Block的。

2. 使用reformer这个对象用于封装数据转化的逻辑，这个对象是一个独立对象，事实上，它是作为Adaptor(适配器)模式

3. 对于业务层而言，由Controller根据View和APIManager之间的关系，选择合适的reformer将View可以直接使用的数据（甚至reformer可以用来直接生成view）转化好之后交付给View。对于网络层而言，只需要保持住原始数据即可，不需要主动转化成数据原型。然后数据采用NSDictionary加Const字符串key来表征，避免了使用对象来表征带来的迁移困难，同时不失去可读性。

* [iOS中的 NSURLProtocol](http://www.jianshu.com/p/0244e431fb3c)



## Optimization
* [可以试试弃用 UILabel，使用 UIView，通过绘制一张圆角+文字的图片作为其 layer 的 contents。](http://reviewcode.cn/article.html?reviewId=7)
* [YYModel 性能优化的几个 Tip：](http://blog.ibireme.com/2015/10/23/ios_model_framework_benchmark/)
* [HXImage,UIImage 的内存优化](https://github.com/Magic-Unique/HXImage/blob/master/description.md) [微博addational](http://weibo.com/2180203585/DtI4UvP8w?type=comment#_rnd1468979516204)
* [优化 App 的启动时间](http://yulingtianxia.com/blog/2016/10/30/Optimizing-App-Startup-Time/)
* [基于clang插件的一种iOS包大小瘦身方案](https://mp.weixin.qq.com/s?__biz=MzA3ODg4MDk0Ng==&mid=2651112856&idx=1&sn=b2c74c62a10b4c9a4e7538d1ad7eb739)
* [如何将 iOS 项目的编译速度提高5倍](https://zhuanlan.zhihu.com/p/27584726)


## Device
* [getUUID](http://www.henishuo.com/uuid-udid/)

## Xcode 
* [iOS应用程序打包](http://www.jianshu.com/p/bd953c3e389f)
* [使用fastlane gym/xctool编写ipa打包脚本](http://www.jianshu.com/p/54ab07f2e63b)

## Http Code description

```
HTTP状态码介绍

HTTP 301 Moved Permanently 被请求的资源已永久移动到新位置，并且将来任何对此资源的引用都应该使用本响应返回的若干个URI之一。如果可能，拥有链接编辑功能的客户端应当自动把请求的地址修改为从服务器反馈回来的地址。除非额外指定，否则这个响应也是可缓存的。

HTTP 302 Found 请求的资源现在临时从不同的URI响应请求。由于这样的重定向是临时的，客户端应当继续向原有地址发送以后的请求。只有在Cache-Control或Expires中进行了指定的情况下，这个响应才是可缓存的。

HTTP 400    – 请求无效
HTTP 401.1 – 未授权：登录失败
HTTP 401.2 – 未授权：服务器配置问题导致登录失败
HTTP 401.3 – ACL 禁止访问资源
HTTP 401.4 – 未授权：授权被筛选器拒绝
HTTP 401.5 – 未授权：ISAPI 或 CGI 授权失败

HTTP 403      – 禁止访问
HTTP 403      – 对 Internet 服务管理器 的访问仅限于 Localhost
HTTP 403.1 禁止访问：禁止可执行访问
HTTP 403.2   – 禁止访问：禁止读访问
HTTP 403.3   – 禁止访问：禁止写访问
HTTP 403.4   – 禁止访问：要求 SSL
HTTP 403.5   – 禁止访问：要求 SSL 128
HTTP 403.6   – 禁止访问：IP 地址被拒绝
HTTP 403.7   – 禁止访问：要求客户证书
HTTP 403.8   – 禁止访问：禁止站点访问
HTTP 403.9   – 禁止访问：连接的用户过多
HTTP 403.10 – 禁止访问：配置无效
HTTP 403.11 – 禁止访问：密码更改
HTTP 403.12 – 禁止访问：映射器拒绝访问
HTTP 403.13 – 禁止访问：客户证书已被吊销
HTTP 403.15 – 禁止访问：客户访问许可过多
HTTP 403.16 – 禁止访问：客户证书不可信或者无效
HTTP 403.17 – 禁止访问：客户证书已经到期或者尚未生效 HTTP 404.1 -

无法找到 Web 站点
HTTP 404 – 无法找到文件
HTTP 405 – 资源被禁止
HTTP 406 – 无法接受
HTTP 407 – 要求代理身份验证
HTTP 410 – 永远不可用
HTTP 412 – 先决条件失败
HTTP 414 – 请求 – URI 太长

HTTP 500        – 内部服务器错误
HTTP 500.100 – 内部服务器错误 – ASP 错误
HTTP 500-11 服务器关闭
HTTP 500-12 应用程序重新启动
HTTP 500-13  – 服务器太忙
HTTP 500-14  – 应用程序无效
HTTP 500-15  – 不允许请求 global.asa
Error 501       – 未实现
HTTP 502       – 网关错误
```


# 小知识

```
isKindOfClass来确定一个对象是否是一个类的成员，或者是派生自该类的成员
isMemberOfClass只能确定一个对象是否是当前类的成员
```

```
删除Xcode多余描述文件
~/Library/MobileDevice/Provisioning Profiles
```

```
快速入门写接口 Node.js
rnr,flask,express
```

```
用telnet命令来测试服务器
```



```
端口

端口的作用：通过端口来区分出同一电脑内不同应用或者进程，从而实现一条物理网线(通过分组交换技术-比如
internet)同时链接多个程序 Port_(computer_networking)

端口号是一个 16位的 uint, 所以其范围为 1 to 65535 (对TCP来说, port 0 被保留，不能被使用. 对
于UDP来说, source端的端口号是可选的， 为0时表示无端口).

app.listen(3000)，进程就被打标，电脑接收到的3000端口的网络消息就会被发送给我们启动的这个进程
```


JavaScript引擎的工作方式是，先解析代码，获取所有被声明的变量，然后再一行一行地运行。这造成的结果，就是所有的变量的声明语句，**都会被提升到代码的头部**，这就叫做变量提升（hoisting）。

**JavaScript 
如果数组的键名是添加超出范围的数值，该键名会自动转为字符串。
for...in不仅会遍历数组所有的数字键，还会遍历非数字键。
数组的某个位置是空位，与某个位置是undefined，是不一样的。如果是空位，使用数组的forEach方法、for...in结构、以及Object.keys方法进行遍历，空位都会被跳过。
空位就是数组没有这个元素，所以不会被遍历到，而undefined则表示数组有这个元素，值是undefined，所以遍历不会跳过。**

注意，对于var命令来说，局部变量只能在函数内部声明，在其他区块中声明，一律都是全局变量**

**shell来批量删除：svn status | grep ! | awk '{print $2}' | xargs svn delete**


* [批量svn delete](http://hushicai.com/2014/02/28/pi-liang-svn-delete.html)
* [纯IPv6环境App适配的坑](http://mrpeak.cn/blog/ipv6/)
* [前端技能汇总](https://github.com/JacksonTian/fks)
* [JSPatch实现原理详解](http://blog.cnbang.net/tech/2808/)
* [浅谈浏览器http的缓存机制](http://web.jobbole.com/86970/)
* [TCP/IP简介](http://www.liaoxuefeng.com/wiki/0014316089557264a6b348958f449949df42a6d3a2e542c000/0014320037768360d53e4e935ca4a1f96eed1c896ad1217000)
* [what is ABI?](http://www.jianshu.com/p/66a76df0db95?utm_campaign=maleskine&utm_content=note&utm_medium=writer_share&utm_source=weibo)
* [301/ 302 description](https://www.nowcoder.com/questionTerminal/b196fb6e27704b1b89253da3d49bc80f?orderByHotValue=0&done=0&pos=11&mutiTagIds=157)
* [Linux 的文件权限与目录配置](http://beyondvincent.com/2016/10/07/2016-10-07-linux-file-permissions-and-directory-configuration/#more)
* [怎么学习golang？以及如何学习一门新的语言](https://www.zhihu.com/people/astaxie/answers)
* [Linux 的文件与目录管理 含查看文件内容](http://beyondvincent.com/2016/10/10/2016-10-10-linux-file-and-directory-manager/)
* [WEB请求处理流程](http://www.jianshu.com/p/558455228c43)
* [什么是开发 App 的正确步骤?](http://www.jianshu.com/p/4ef3d3737661)


架构书籍：大型网站技术架构
mac 下运行 xx.js 文件可以通过 terminal run  "$ node xx.js"
ERROR Deployer not found: git ---> npm install hexo-deployer-git --save
By default, you will be promted to check for upgrades every few weeks. If you would like oh-my-zsh to automatically upgrade itself without prompting you, set the following in your ~/.zshrc:

***
在Python中定义函数，可以用必选参数、默认参数、可变参数、关键字参数和命名关键字参数，这5种参数都可以组合使用。但是请注意，参数定义的顺序必须是：必选参数、默认参数、可变参数、命名关键字参数和关键字参数。
返回闭包时牢记的一点就是：返回函数不要引用任何循环变量，或者后续会发生变化的变量。
能用type()判断的基本类型也可以用isinstance()判断：
***


# CSS

```
W3C对于ID和CLASS的设定是ID具有唯一性，class具有普遍性。所以说我们用他们俩的时候就要按照这个特性
来使用。id 是不能重复的，class 却是可以重复使用，通过id可以找到页面上唯一的一个标签，而class呢
可以多个标签使用同一种样式提供了可能
```
* [Sass中文网](http://www.sass.hk/guide/)			
			
# HTML
* [HTML5a标签的 target 属性](http://www.w3school.com.cn/html5/att_a_target.asp)

# JS
* [详解js跨域问题](https://segmentfault.com/a/1190000000718840)
* [关于javascript跨域及JSONP的原理与应用](https://segmentfault.com/a/1190000002438126)
* [跨域资源共享 CORS 详解](http://www.ruanyifeng.com/blog/2016/04/cors.html)
* [js标准对象](http://www.liaoxuefeng.com/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/00143449957099176f55ba07b764c3daa522217d0e42643000)
* [Node.js 包教不包会](https://github.com/alsotang/node-lessons)
* [lihei_jquery](http://blog.csdn.net/lihei12345/article/category/2393611)
* [Blog_Platform](https://github.com/TryGhost/Ghost)
* [js单线程模型](http://javascript.ruanyifeng.com/advanced/single-thread.html)
* [ANGULARJS实现单页面应用的原理-路由(ROUTE)](http://www.cnblogs.com/iCafe/p/5732159.html)
* [JavaScript运行原理解析](https://www.kancloud.cn/digest/liao-js/149467)
* [JS重塑学习](https://www.kancloud.cn/digest/liao-js/149473)

## Vue.js
* [vue.js 60分钟快速入门](http://www.cnblogs.com/keepfool/p/5625583.html)
* [vue勾三股四](http://jiongks.name/)
* [Vue.js作者尢雨溪：Vue 2.0——渐进式前端解决方案](http://mp.weixin.qq.com/s?__biz=MjM5MDE0Mjc4MA==&mid=2650994529&idx=1&sn=953bf1d92cc2a7b278d0761d3e433803&chksm=bdbf0f328ac886245652735e4dfa1b39b1357b9f36ccf1b337714ac81810f8441d189ce89615&scene=0#wechat_redirect)
* [vue2.0实战DICK-BooM-tutorial](https://github.com/MeCKodo/vue-tutorial)
* [进阶 Vue 2.0](https://segmentfault.com/a/1190000007638646)
* [vue.js中文api](https://cn.vuejs.org/v2/api/#Vue-set)
* [vue-router description](http://router.vuejs.org/zh-cn/essentials/getting-started.html)
* [Vue documents](https://github.com/zhaohaodang/vue-WeChat/wiki)
* ### [Vue实例](https://cn.vuejs.org/v2/guide/instance.html#生命周期图示)
* [Vue源码学习](http://hcysun.me/2017/03/03/Vue%E6%BA%90%E7%A0%81%E5%AD%A6%E4%B9%A0/)



## Node.js
* [淘宝 NPM 镜像](https://npm.taobao.org)
* [Node.js的Event Loop](http://www.ruanyifeng.com/blog/2014/10/event-loop.html)
* [一起学 Node.js](https://github.com/nswbmw/N-blog)


## this
* [JavaScript 之 this 详解](http://www.jeffjade.com/2015/08/03/2015-08-03-javascript-this/?hmsr=toutiao.io&utm_medium=toutiao.io&utm_source=toutiao.io)
* [Javascript的this用法](http://www.ruanyifeng.com/blog/2010/04/using_this_keyword_in_javascript.html)
* [JavaScript中的this关键字](http://blogread.cn/it/article/7315?f=wb)

## js与Native交互
* [CTJSBridge](https://github.com/casatwy/CTJSBridge)
* [WebViewJavascriptBridge](https://github.com/marcuswestin/WebViewJavascriptBridge)
* [JSPatch](https://github.com/bang590/JSPatch)



# 前端
* [前端工程师手册](https://leohxj.gitbooks.io/front-end-database/content/preference/browser-rendering-performance.html)
* [iOS客户端开发与Web前端开发](http://blog.cnbang.net/tech/1813/)
* [钉钉H5如何性能优化](https://github.com/dingtalkFE/blog/issues/1)
* [QQ空间面向移动时代Hybrid架构设计](http://mp.weixin.qq.com/s?__biz=MjM5MDE0Mjc4MA==&mid=2650993637&idx=1&sn=8a2673272575abbef4b0f6dbc25e0186)
* [15年双11手淘前端技术巡演 - H5性能最佳实践](https://github.com/amfe/article/issues/21)
* [构建单页Web应用](https://github.com/xufei/blog/issues/5)
* [全栈工程师培训材料ruanyifeng](https://github.com/ruanyf/jstraining)
* [前端面试题整理汇总](http://web.jobbole.com/88177/)
* [什么是服务端渲染](https://segmentfault.com/q/1010000004293653)
* [服务器端渲染和客户端渲染有什么区别?](https://mp.weixin.qq.com/s?__biz=MzA5Nzc4OTA1Mw==&mid=2659599236&idx=1&sn=e8ed7de4c63f24cbd02dc6fd42ef8789&key=3fa25093d92ebc15fdc2dbf821311ba4005747edbc6b6203a91e8e685be3052b7034ce29c8a288f56159ca7f506112a1be182bf24b76a8588637c534f259bbfb6b9e4589455c364297af04644b39dc88&ascene=0&uin=MjkxMjg4Nzk4Mg%3D%3D&devicetype=iMac+MacBookPro13%2C3+OSX+OSX+10.12.4+build(16E195)&version=12020610&nettype=WIFI&fontScale=100&pass_ticket=ZOkHWsVN15NpM5f47IdypX3P9y265kbkaMOX7QSowcBdkFBmjxS4kxz%2B%2FAEfxCaa)

### IDE
* [brackets](https://github.com/adobe/brackets)
* [atom](https://github.com/atom/atom)

# Python
> Python程序是大小写敏感的
* [Beautiful Soup](https://www.crummy.com/software/BeautifulSoup/bs4/doc.zh/index.html)
* [scrapy](https://github.com/scrapy/scrapy)
* [urllib3](https://github.com/shazow/urllib3)
* [requests](https://github.com/kennethreitz/requests)
* [youtube-dl](https://github.com/rg3/youtube-dl)
* [you-get](https://github.com/soimort/you-get)
* [Python的所有内置函数](https://docs.python.org/3/library/functions.html)
* [AppleDNS](https://github.com/gongjianhui/AppleDNS)
* [Python os模块参考手册](http://kuanghy.github.io/2015/08/02/python-os)
* [Python并发编程之协程/异步IO](http://python.jobbole.com/87202/)
* [python web 入坑指南](http://python-web-guide.readthedocs.io/zh/latest/)

# DNS 
[DNS 原理入门](http://www.ruanyifeng.com/blog/2016/06/dns.html)

# Shell
* [Shell 编程初探](http://draveness.me/shell-bian-cheng-chu-tan/)
* [入门bash Shell脚本](http://blog.wtlucky.com/blog/2013/05/02/start-write-shell/)
* [Shell脚本编程总结及速查手册](http://blog.jobbole.com/103790/)
* [Shell脚本编程30分钟入门](https://github.com/qinjx/30min_guides/blob/master/shell.md)
* [两个月精通 Shell 脚本](http://wiki.jikexueyuan.com/project/learn-shell/)

# VPN
* [clowwindy](https://github.com/clowwindy?tab=repositories)
* [Potatso](https://github.com/shadowsocks/Potatso)
* [VPNOn](https://github.com/lexrus/VPNOn)
* [FireUpYourVPN](https://github.com/johnlui/FireUpYourVPN)
* [Potatso使用说明](https://manual.potatso.com)

# GitHubStars
* [TinyPNG4Mac 图片压缩MacApp](https://github.com/kyleduo/TinyPNG4Mac)

* [WeChat 实现类似微信朋友圈或者QQ空间，评论回复，九宫格布局。处理键盘弹出后定位到当前点击的被评论人处。另：滑动时候FPS在57-60之间，纵享丝滑！](https://github.com/zhengwenming/WeChat)

* [知乎日报web版---vue](https://github.com/yatessss/zhihudaily-vue)

* [一个 iOS 上的弹幕渲染库](https://github.com/unash/BarrageRenderer)

# Crash soluation 
* [GYBootingProtection](https://github.com/liuslevis/GYBootingProtection)

# JAVA
* [Java 基本语法](http://wiki.jikexueyuan.com/project/java/basic-syntax.html)
 
# Product
* [不要在功能上竞争](http://www.ruanyifeng.com/blog/2011/07/dont_compete_on_features.html)
 
# 常用命令行

```
du -sh * 查看文件大小
git commit -am ''
```
	
```
copy所以文件，包括隐藏文件
cp -r /opt/usr/20070723/.  /backup/latest/
这里不能用*,一定要用.
```

# Cross-Platform
* [ionic](https://ionicframework.com/)
* [React](https://github.com/facebook/react)
* [weex](http://alibaba.github.io/weex/cn/doc/get-started.html)

# Job
* [How could you work for facebook especially for Chinese](http://cenalulu.github.io/mysql/how-i-become-a-facebook-dba/)

# Security
* [从 MONGODB “赎金事件” 看安全问题](http://coolshell.cn/articles/17607.html)


# Go
* [A guy from Apple](https://www.zhihu.com/lives/800688114623463424)
* [beego 文档](https://beego.me/docs/intro/)
* [a book for go](https://github.com/mikespook/Learning-Go-zh-cn)

# Business model
* [the profit model of tencent](http://www.51a.la/keji/8850.html)


# Coding for Money
* [FinancialSupportForOpenSource](https://github.com/wizicer/FinancialSupportForOpenSource#%E5%B9%BF%E5%91%8A)
* [How to make more than $1mn+/yr as a software engineer?](https://news.ycombinator.com/item?id=13613911)

# SEO 
* [SEO 网站优化的步骤和技巧有哪些?](https://www.zhihu.com/question/19808905)

# Interview
* [iOS](https://github.com/ChenYilong/iOSInterviewQuestions/blob/master/01%E3%80%8A%E6%8B%9B%E8%81%98%E4%B8%80%E4%B8%AA%E9%9D%A0%E8%B0%B1%E7%9A%84iOS%E3%80%8B%E9%9D%A2%E8%AF%95%E9%A2%98%E5%8F%82%E8%80%83%E7%AD%94%E6%A1%88/%E3%80%8A%E6%8B%9B%E8%81%98%E4%B8%80%E4%B8%AA%E9%9D%A0%E8%B0%B1%E7%9A%84iOS%E3%80%8B%E9%9D%A2%E8%AF%95%E9%A2%98%E5%8F%82%E8%80%83%E7%AD%94%E6%A1%88%EF%BC%88%E4%B8%8A%EF%BC%89.md#%E4%BC%98%E5%8C%96%E9%83%A8%E5%88%86)
* [快速找出一个数组中的两个数字，让这两个数字之和等于一个给定的值](http://blog.csdn.net/mimi9919/article/details/51335337)
* [爬虫访问中，如何解决网站限制IP的问题？](https://www.zhihu.com/question/20392627)

