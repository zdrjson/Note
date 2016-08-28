//
//  Person.m
//  block链式编程
//
//  Created by 张德荣 on 16/6/3.
//  Copyright © 2016年 zdrjson. All rights reserved.
//

#import "Person.h"

@implementation Person
- (Person *(^)())run{
    return ^id(){
        return self;
    };
}
- (Person *(^)())sleep{
    return ^id(){
        return self;
    };
}
- (Person *)a
{
    return self;
}
- (Person *)b;
{
    return self;
}
- (Person *(^)())go:(Person * (^)(Person *p))pp {
    NSLog(@"%@",pp);
      return ^id(){
        return self;
    };
}


@end
