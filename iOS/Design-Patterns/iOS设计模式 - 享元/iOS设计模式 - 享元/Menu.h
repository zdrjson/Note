//
//  Menu.h
//  iOS设计模式 - 享元
//
//  Created by 张德荣 on 16/7/7.
//  Copyright © 2016年 zdrjson. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "CoffeeFlavor.h"

@interface Menu : NSObject
/**
 获取指定味道的咖啡(如果没有则创建)
 
 @param flavor 味道
 
 @return 指定味道的咖啡
 */
- (CoffeeFlavor *)lookupWithFlavor:(NSString *)flavor;
@end
