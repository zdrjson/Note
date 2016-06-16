//
//  Person.h
//  block链式编程
//
//  Created by 张德荣 on 16/6/3.
//  Copyright © 2016年 zdrjson. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface Person : NSObject
- (Person *(^)())run;
- (Person *(^)())sleep;
- (Person *)a;
- (Person *)b;
@end
