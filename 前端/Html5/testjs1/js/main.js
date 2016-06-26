
var ps = $('p');
ps.length;

var a = $('.red');
var a = $('.red.green');

var email = $('[name=email]');

var icon = $('[name^=icon]');
var names =$('[name$=with]');


var icons = $('[class^="icon-"]');

var eamilInput = $('input[name=email]');

var tr = $('tr.red');

$('p,div');
$('p.red,p.green');


alert($('ul.lang li.lang-javascript'));
$('div.testing li.lang-javascript');

$('ul.lang li');


//子选择器$('parent>child')类似层级选择器，但是限定了层级关系必须是父子关系，就是<child>节点必须是<parent>节点的直属子节点。还是以上面的例子：
$('form[name=upload] input');
$('ul.lang>li.lang-javascript');
$('div.testing>li.lang-javascript');

$('ul.lang li');
$('ul.lang li:first-child');
$('ul.lang li:last-child');
//// 选出第N个元素，N从1开始
$('ul.lang li:nth-child(2)');
//选出序号为偶数的元素
$('ul.lang li:nth-child(even)');
//选出序号为奇数的元素
$('ul.lang li:nth-child(odd)');



var ul = $('ul.lang');
var dy = ul.find('.dy');
var swf = ul.find('#swift');
var hsk = ul.find('[name=haskell]');

var swf = $('#swift');
var parent = swf.parent();
var a = swf.parent('div.red');

swift.next();
swift.next('[name=haskell]');

swift.prev();
swift.prev('.js');

var langs = $('ul.lang li');
var a = langs.filters('.dy');
langs.filters(function () {
    //要特别注意函数内部的this被绑定为DOM对象，不是jQuery对象：
   return this.innerHTML.indexOf('S') === 0;
});

var langs = $('ul.lang li');
var arr = langs.map(function () {
   return this.innerHTML;
}).get();

var js = langs.first();
var js1 = $('ul.lang li:first-child');
var haskell = langs.last();
var haskell1 = $('ul.lang li:last-child');
var sub = langs.slice(2,4);







