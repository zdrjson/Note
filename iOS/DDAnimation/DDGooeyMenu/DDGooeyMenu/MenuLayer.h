//
//  MenuLayer.h
//  DDGooeyMenu
//
//  Created by 张德荣 on 16/6/13.
//  Copyright © 2016年 zdrjson. All rights reserved.
//

#import <QuartzCore/QuartzCore.h>
typedef enum : NSUInteger {
    STATE1,
    STATE2,
    STATE3,
}STATE;

@interface MenuLayer : CALayer
@property (nonatomic, assign) BOOL showDebug;
@property (nonatomic, assign) STATE animState;
@property (nonatomic, assign) CGFloat xAxisPercent;
@end
