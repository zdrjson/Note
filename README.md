# DDNote

## Animaton
### TransitionAnimation
* [VCTransitionsLibrary](https://github.com/ColinEberhardt/VCTransitionsLibrary)
* [RZTransitions](https://github.com/Raizlabs/RZTransitions)
* [HYBControllerTransitions](https://github.com/CoderJackyHuang/HYBControllerTransitions)
* [KYMagicMove](https://github.com/KittenYang/KYMagicMove)
* [ViewControllersTransition](https://github.com/YouXianMing/ViewControllersTransition)
* [iOS-ViewController-Transition-Demo](https://github.com/seedante/iOS-ViewController-Transition-Demo.git)

### CollectionAnimation
* [popping](https://github.com/schneiderandre/popping)

### facebookPopMenuAnimation
* [DXPopover](https://github.com/xiekw2010/DXPopover)
* [CMPopTipView](https://github.com/chrismiles/CMPopTipView)
* [NirKxMenu](https://github.com/zpz1237/NirKxMenu)

###TinderSwipeAnimation
* [MDCSwipeToChoose](https://github.com/modocache/MDCSwipeToChoose)
* [TinderSimpleSwipeCards](https://github.com/cwRichardKim/TinderSimpleSwipeCards)
* [ZLSwipeableView](https://github.com/zhxnlai/ZLSwipeableView)
* [Koloda](https://github.com/Yalantis/Koloda)


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
	   用户能够下载
	•	User can retry any download if any error occurred during download.
```






### LiveVideo
* [LiveVideoCoreSDK](https://github.com/runner365/LiveVideoCoreSDK)
* [SmarterStreaming](https://github.com/daniulive/SmarterStreaming)

##Audio
* [MPVolumeView_iOS program modification system volume](https://segmentfault.com/a/1190000002401961)

## Image
### Gif 
[FLAnimatedImage](https://github.com/Flipboard/FLAnimatedImage)
[sever return 304](http://weibo.com/1247589445/DwgHFs2cF?type=repost)

## View
* [scrollView To Top](http://www.jianshu.com/p/68632cbd6263)
* [why SDWebImageDecoder](http://www.jianshu.com/p/135e17c7d10f)
* [Y_KLine](https://github.com/yate1996/Y_KLine)

## CALayer
* [CALayer and subLayer](http://my.oschina.net/u/2340880/blog/536048)
* [CATextLayer](https://github.com/joeshang/CATextLayerTest)

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

## Cache
* [FMDB](https://github.com/ccgus/fmdb)
* [realm](https://github.com/realm/realm-cocoa)
* [MagicalRecord](https://github.com/magicalpanda/MagicalRecord)

## Text
* [CoreText_xiongzenghu](http://xiongzenghuidegithub.github.io/blog/2016/04/26/coretext-part-3/)
* [CoreText_zoomfeng](http://www.zoomfeng.com/blog/coretextshi-yong-jiao-cheng-%5B%3F%5D.html)
* [TTTAttributedLabel](https://github.com/TTTAttributedLabel/TTTAttributedLabel)
* [UILabel replacement with fine-grain appear/disappear animation](https://github.com/overboming/ZCAnimatedLabel)
* [TYAttrubutedLabel](https://github.com/12207480/TYAttributedLabel)


## AutoLayout
* [Autolayout standard style of writing](http://reviewcode.cn/article.html?reviewId=14)

## CADisplayLink
* [CADisplayLink](http://www.jianshu.com/p/c35a81c3b9eb)

## Architecture
* [OUT OF OOP-inheritance](http://casatwy.com/tiao-chu-mian-xiang-dui-xiang-si-xiang-yi-ji-cheng.html)
* [IOP](http://casatwy.com/tiao-chu-mian-xiang-dui-xiang-si-xiang-er-duo-tai.html)
* [OUT OF OOP-package](http://casatwy.com/tiao-chu-mian-xiang-dui-xiang-si-xiang-san-feng-zhuang.html)
* [know or understand](http://casatwy.com/zen-yao-mian-shi-jia-gou-shi.html)

### FRP
* [RAC](https://github.com/ReactiveCocoaChina/ReactiveCocoaChineseResources)


## Memory leaks
* [MLeaksFinder](https://github.com/Zepo/MLeaksFinder)
* [FBRetainCycleDetector](https://github.com/facebook/FBRetainCycleDetector)

##Cocoapods
* [ERROR: While executing gem ... (Errno::EPERM) Operation not permitted - /usr/bin/pod](http://stackoverflow.com/questions/30812777/cannot-install-cocoa-pods-after-uninstalling-results-in-error/30851030#30851030)
* [Operation not permitted - /usr/bin/fuzzy_match](http://blog.csdn.net/sinat_29998157/article/details/50070687)
* [While executing gem ... (TypeError) no implicit conversion of nil into String](http://stackoverflow.com/questions/25844937/how-to-install-cocoa-pods-in-terminal)

##SomeGuysBlog
* [WeiXinRead](http://wereadteam.github.io)
* [sunnyxx](http://blog.sunnyxx.com)
* [FMDB_description](http://blog.csdn.net/yixiangboy/article/details/51274186)
* [integration ijkplayer](http://www.jianshu.com/p/1f06b27b3ac0)
* [daiming](http://www.jianshu.com/users/9a4903d7e3d1/latest_articles)

## Git
* [Git Flow](http://www.jianshu.com/p/fa83b6858d52)
* [如何解决GitHub commit次数过多.git文件过大的问题?](https://www.zhihu.com/question/29769130)
* [if you change your password or username on GitHub](https://help.github.com/articles/updating-credentials-from-the-osx-keychain/)

### gitpages
* [southpeak.github.io](http://southpeak.github.io)
  
  
## Crash
* [objc_retain] (http://www.bkjia.com/IOSjc/898404.html)
* [NSTimer]

```
You must send this message from the thread on which the timer was installed. If
you send this message from another thread, the input source associated with the
timer may not be removed from its run loop, which could prevent the thread from
exiting properly.
NSTimer 在哪个线程创建就要在哪个线程停止，否则会导致资源不能被正确的释放。看起来各种坑还不少。

```
 
## Algorithm
* [Direct insertion sort](http://www.henishuo.com/insert-sort/)

## Efficiency 
* [Mac_MrPeak](http://mrpeak.cn/blog/mac-efficiency/)

## Tool
* [Phabricator](http://phabricator.org/)
* [oh-my-zsh](https://github.com/robbyrussell/oh-my-zsh)
* [Homebrew](http://brew.sh/)

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


* [hosts](https://github.com/racaljk/hosts)
* [hacker-scripts](https://github.com/NARKOZ/hacker-scripts)

## Tutorial
* [objc](http://objccn.io)
* [Safari for OS X 你不可不知的 10 个快捷键](http://sspai.com/30902)
* [Markdown](https://github.com/younghz/Markdown)

##Foundation
* roundf 将浮点值四舍五入为最接近的整数

## NetWorking
* [RTNetworking](https://github.com/casatwy/RTNetworking)

1. 以什么方式将数据交付给业务层？这个问题的回答是这样：
   尽可能通过Delegate的回调方式交付数据，这样可以避免不必要的跨层访问。当出现跨层访问的需求时（比如信号类型切换），通过Notification的方式交付数据。正常情况下应该是避免使用Block的。

2. 使用reformer这个对象用于封装数据转化的逻辑，这个对象是一个独立对象，事实上，它是作为Adaptor(适配器)模式

3. 对于业务层而言，由Controller根据View和APIManager之间的关系，选择合适的reformer将View可以直接使用的数据（甚至reformer可以用来直接生成view）转化好之后交付给View。对于网络层而言，只需要保持住原始数据即可，不需要主动转化成数据原型。然后数据采用NSDictionary加Const字符串key来表征，避免了使用对象来表征带来的迁移困难，同时不失去可读性。




#CSS

```
W3C对于ID和CLASS的设定是ID具有唯一性，class具有普遍性。所以说我们用他们俩的时候就要按照这个特性
来使用。id 是不能重复的，class 却是可以重复使用，通过id可以找到页面上唯一的一个标签，而class呢
可以多个标签使用同一种样式提供了可能
```												



