//
//  FBPopMenu.h
//  FaceBookPopMenu
//
//  Created by 张德荣 on 16/6/23.
//  Copyright © 2016年 zdrjson. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface FBPopMenu : UIView
+ (void)showTitleArr:(NSArray *)titleArr selected:(void(^)(NSInteger selectIndex))selectedCallBack;
+ (void)dismiss;
@end
