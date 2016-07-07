//
//  Menu.m
//  iOS设计模式 - 享元
//
//  Created by 张德荣 on 16/7/7.
//  Copyright © 2016年 zdrjson. All rights reserved.
//

#import "Menu.h"

@interface Menu ()
@property (nonatomic, strong) NSMutableDictionary <NSString *, CoffeeFlavor *> *flavors;
@end

@implementation Menu
- (instancetype)init
{
    self = [super init];
    if (self) {
        self.flavors = [NSMutableDictionary dictionary];
    }
    return self;
}

- (CoffeeFlavor *)lookupWithFlavor:(NSString *)flavor {
    NSParameterAssert(flavor);
    
    if ([self.flavors objectForKey:flavor] == nil) {
        CoffeeFlavor *coffeeFlavor = [[CoffeeFlavor alloc] init];
        coffeeFlavor.flavor = flavor;
        self.flavors[flavor] = coffeeFlavor;
    }
    return [self.flavors objectForKey:flavor];
}
@end
