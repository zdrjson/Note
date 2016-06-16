//
//  Animal.h
//  NSProxyDemo
//
//  Created by 张德荣 on 16/5/20.
//  Copyright © 2016年 JsonZhang. All rights reserved.
//

#import <Foundation/Foundation.h>

@protocol Animal <NSObject>

- (NSString *)name;

- (NSString *)type;

- (void)call;

- (void)run;
@end
