#!/bin/bash

svn up /Users/json/Desktop/shouZunApp

rm -rf /Users/json/Desktop/ios/wwwcp

cp -rf /Users/json/Desktop/ios/www /Users/json/Desktop/ios/wwwcp

rm -rf /Users/json/Desktop/ios/www

cp -rf /Users/json/Desktop/shouZunApp/platforms/ios/www /Users/json/Desktop/ios

