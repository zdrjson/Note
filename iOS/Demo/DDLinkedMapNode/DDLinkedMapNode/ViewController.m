//
//  ViewController.m
//  DDLinkedMapNode
//
//  Created by 张德荣 on 16/6/7.
//  Copyright © 2016年 zdrjson. All rights reserved.
//

#import "ViewController.h"
#import <CoreFoundation/CoreFoundation.h>
#import <pthread.h>
static inline dispatch_queue_t DDMemoryCacheReleaseQueue() {
    return dispatch_get_global_queue(DISPATCH_QUEUE_PRIORITY_LOW, 0);
}
/**
 A node in linked map.
 Typically, you should not use this class directly.
 */
@interface _DDLinkedMapNode : NSObject {
    @package
    __unsafe_unretained _DDLinkedMapNode *_prev; // retained by dic
    __unsafe_unretained _DDLinkedMapNode *_next; // retained by dic
    id _key;
    id _value;
    NSUInteger _cost;
    NSTimeInterval _time;
}
@end

@implementation _DDLinkedMapNode
@end


@interface _DDLinkedMap : NSObject {
    @package
    CFMutableDictionaryRef _dic; // do not set object directly
    NSUInteger _totalCost;
    NSUInteger _totalCount;
    _DDLinkedMapNode *_head; // MRU, do not change it directly
    _DDLinkedMapNode *_tail; // LRU, do not change it directly
    BOOL _releaseOnMainThread;
    BOOL _releaseAsynchronously;
}
/**
 Insert a node at head and update the total cost.
 Node and node.key should not be nil.
 */
- (void)insertNodeAtHead:(_DDLinkedMapNode *)node;
/**
 Bring a inner node to headr.
 Node should already inside the dic.
 */
- (void)bringNodeToHead:(_DDLinkedMapNode *)node;
/**
 Remove a inner node and update the total cost.
 Node shouls already inside the dic.
 */
- (void)removeNode:(_DDLinkedMapNode *)node;
/**
 Remove tail node if exist
 */
- (_DDLinkedMapNode *)removeTailNode;
/**
 Remove all node in background queue.
 */
- (void)removeAll;
@end

@implementation _DDLinkedMap

- (instancetype)init
{
    self = [super init];
    if (self) {
        _dic = CFDictionaryCreateMutable(CFAllocatorGetDefault(), 0, &kCFTypeDictionaryKeyCallBacks, &kCFTypeDictionaryValueCallBacks);
        _releaseOnMainThread = NO;
        _releaseAsynchronously = YES;
    }
    return self;
}
- (void)dealloc {
    CFRelease(_dic);
}
- (void)insertNodeAtHead:(_DDLinkedMapNode *)node {
    CFDictionarySetValue(_dic, (__bridge const void *)(node->_key), (__bridge const void *)(node));
    _totalCost += node->_cost;
    _totalCount++;
    if (_head) {
        node->_next = _head;
        _head->_prev = node;
        _head = node;
    } else {
        _head = _tail = node;
    }
}

- (void)bringNodeToHead:(_DDLinkedMapNode *)node {
    if (_head == node)  return;
    
    if (_tail == node) {
        _tail = node->_prev;
        _tail->_next = nil;
    } else {
        node->_next->_prev = node->_prev;
        node->_prev->_next = node->_next;
    }
    node->_next = _head;
    node->_prev = nil;
    _head->_prev = node;
    _head = node;
}
- (void)removeNode:(_DDLinkedMapNode *)node {
    CFDictionaryRemoveValue(_dic, (__bridge const void *)(node->_key));
    _totalCost -= node->_cost;
    _totalCount--;
    if (node->_next) node->_next->_prev = node->_prev;
    if (node->_prev) node->_prev->_next = node->_next;
    if (_head == node) _head = node->_next;
    if (_tail == node) _tail = node->_prev;
}
- (_DDLinkedMapNode *)removeTailNode {
    if (!_tail)  return nil;
    _DDLinkedMapNode *tail = _tail;
    CFDictionaryRemoveValue(_dic, (__bridge const void *)(_tail->_key));
    _totalCost -= _tail->_cost;
    _totalCount--;
    if (_head == _tail) {
        _head = _tail = nil;
    } else {
        _tail = _tail->_prev;
        _tail->_next = nil;
    }
    return tail;
}
- (void)removeAll {
    _totalCost = 0;
    _totalCount = 0;
    _head = nil;
    _tail = nil;
    if (CFDictionaryGetCount(_dic) > 0) {
        CFMutableDictionaryRef holder = _dic;
        _dic = CFDictionaryCreateMutable(CFAllocatorGetDefault(), 0, &kCFTypeDictionaryKeyCallBacks, &kCFTypeDictionaryValueCallBacks);
        
        if (_releaseAsynchronously) {
            dispatch_queue_t queue = _releaseOnMainThread ? dispatch_get_main_queue() :
            DDMemoryCacheReleaseQueue();
            dispatch_async(queue, ^{
                CFRelease(holder);  // hold an release in specified queue
            });
        } else if (_releaseOnMainThread && !pthread_main_np()) {
            dispatch_async(dispatch_get_main_queue(), ^{
                CFRelease(holder); // hold and release in specified queue
            });
        } else {
            CFRelease(holder);
        }
    }
}


@end

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view, typically from a nib.
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

@end
