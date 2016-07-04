#!/usr/bin/env python3
# -*- coding: utf-8 -*-

' a test module '

__author__ = 'Michael Liao'

import sys

def test():
    args = sys.argv
    if len(args)==1:
            print('Hello, world!')
    elif len(args)==2:
        print('Hello, %s!' % args[1])
    else:
        print('Too many arguments!')

if __name__=='__main__':
    test()

from PIL import Image
# im = Image.open('test.png')
# print(im.format, im.size, im.mode)
# print(im.thumbnail((200, 100)))
# print(im.save('thum.jpg', 'JEPG'))


from flask import Flask
app = Flask(__name__)

@app.route("/")
def hello():
    return "Hello World!"

if __name__ == "__main__":
    app.run()















def _private_1(name):
    return 'Hello, %s' % name


def _private_2(name):
    return 'Hi, %s' % name

def greeting(name):
    if len(name) > 3:
        return  _private_1(name)
    else:
        return _private_2(name)

print(greeting('xxxx'))

