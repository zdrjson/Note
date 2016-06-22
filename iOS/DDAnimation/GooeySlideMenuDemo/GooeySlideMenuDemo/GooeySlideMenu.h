//
//  GooeySlideMenu.h
//  GooeySlideMenuDemo
//
//  Created by 张德荣 on 16/6/22.
//  Copyright © 2016年 zdrjson. All rights reserved.
//

#import <UIKit/UIKit.h>
typedef void(^MenuButtonClickedBlock)(NSInteger index, NSString *title, NSInteger titleCounts);

@interface GooeySlideMenu : UIView
/**
 Convenient init method
 
 @param titles Your menu options
 
 @return object
 */
- (instancetype)initWithTitles:(NSArray *)titles;
/**
 Custom init method
 
 @param titles    list title array
 @param height    <#height description#>
 @param menuColor <#menuColor description#>
 @param style     <#style description#>
 
 @return object
 */
- (instancetype)initWithTitles:(NSArray *)titles buttonHeight:(CGFloat)height MenuColor:(UIColor *)menuColor withBackBlurStyle:(UIBlurEffectStyle)style;
/**
 Method to trigger the animation
 */
- (void)trigger;
/**
 The block of menu buttons clicked
 */
@property (nonatomic, copy) MenuButtonClickedBlock menuClickBlock;
@end
