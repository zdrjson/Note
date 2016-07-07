//
//  CoffeeShop.h
//  iOS设计模式 - 享元
//
//  Created by 张德荣 on 16/7/7.
//  Copyright © 2016年 zdrjson. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface CoffeeShop : NSObject
/**
 接受订单
 
 @param flavor 咖啡味道
 @param table  桌子
 */
- (void)takeOrder:(NSString *)flavor table:(int)table;
/**
 开始服务
 */
- (void)serve;
@end
