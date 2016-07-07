//
//  CoffeeFlavor.h
//  iOS设计模式 - 享元
//
//  Created by 张德荣 on 16/7/7.
//  Copyright © 2016年 zdrjson. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface CoffeeFlavor : NSObject
/**
 咖啡的味道
 */
@property (nonatomic, strong) NSString *flavor;
@end
