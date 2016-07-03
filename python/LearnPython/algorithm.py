from collections import Iterable, Iterator
print(isinstance([],Iterable))
print(isinstance({},Iterable))
print(isinstance('abc',Iterable))
print(isinstance((x for x in range(10)),Iterable))
print(isinstance(100,Iterable))

print(isinstance((x for x in range(10)), Iterator))
print(isinstance([],Iterator))

print(isinstance({},Iterator))
print(isinstance('abc',Iterator))


print(isinstance(iter([]), Iterator))


print(isinstance(iter('abc'), Iterator))

it = iter([1,2,3,4,5])
while True:
    try:
        x = next(it)
        print(x)
    except StopIteration:
        print('stop')
        break

def add(x, y, f):
    return f(x) + f(y)

print(add(-5,6,abs))

def removeElement(self, A, elem):
    ret = 0
    for item in A:
        if item != elem:
            A[ret] = item
            ret += 1

    return ret

L = [x * x for x in range(10)]
print(L);
g = (x * x for x in range(10))
print(g)
for n in g:
    print(n)


def f(x):
    return x * x
r = map(f, [1,2,3,4,5,6,7,8,9])
print(r)
print(list(r))


print(list(map(str,[1,2,3,4,5,6,7,8,9])))

from  functools import reduce
def add(x,y):
    return x + y
print(reduce(add,[1,3,5,7,9]))

def fn(x,y):
    return x * 10 + y

print(reduce(fn,[1,3,5,7,9]))



def char2num(s):
    return {'0':0,'1':1,'2':2,'3':3,'4':4,'5':5,'6':6,'7':7,'8':8,'9':9}[s]


print(reduce(fn, map(char2num, '13579')))


def str2int(s):
    def fn(x, y):
        return x * 10 + y
    def char2num(s):
        return {'0':0,'1':1,'2':2,'3':3,'4':4,'5':5,'6':6,'7':7,'8':8,'9':9}[s]
    return reduce(fn, map(char2num,s))

def char2num(s):
    return {'0':0,'1':1,'2':2,'3':3,'4':4,'5':5,'6':6,'7':7,'8':8,'9':9}[s]
def str2int(s):
    return reduce(lambda x, y: x * 10 + y, map(char2num, s))

def is_odd(n):
    return n % 2 == 1

print(list(filter(is_odd, [1,2,4,5,6,9,10,15])))


def not_empty(s):
    return s and s.strip()
print(list(filter(not_empty,['A','','B',None,'C','   '])))

def _odd_iter():
    n = 1
    while True:
        n = n + 2
        # print('xxx')
        yield n

# 定义刷选函数
def _not_divisible(n):
    return lambda  x : x % n > 0

def primes():
    yield 2
    it = _odd_iter()  # 初始序列
    print(it)
    while True:
        n = next(it)  # 返回序列的第一个数
        yield n
        it = filter(_not_divisible(n),it) # 构成新序列

# 打印1000以内的素数
# for n in primes():
#     if n < 1000:
#         print('')
#     else:
#         break

# 这里，最难理解的就是generator和函数的执行流程不一样。函数是顺序执行，遇到return语句或者最后一行函数语句就返回。而变成generator的函数，在每次调用next()的时候执行，遇到yield语句返回，再次执行时从上次返回的yield语句处继续执行。

print(sorted([36,5,-12,9,-21]))

print(sorted([36,5,-12,9,-21],key=abs))

print(sorted(['bob','about','Zoo','Credit']))



print(sorted(['bob','about','Zoo','Credit'],key=str.lower))
print(sorted(['bob','about','Zoo','Credit'],key=str.lower,reverse=True))


def calc_sum(*args):
    ax = 0
    for n in args:
        ax = ax + n
    return ax


def lazy_sum(*args):
    def sum():
        ax = 0
        for n in args:
            ax = ax + n
        return ax
    return sum


f = lazy_sum(1,3,5,7,9)
print(f)

print(f())

def count():
    fs = []
    for i in range(1,4):
        def f():
            return i * i
        fs.append(f)
    return fs
f1, f2, f3 = count()
print(f1())
print(f2())
print(f3())


def count():
    def f(j):
        # return  lambda : j * j
        def g():
            return j*j
        return g

    fs = []
    for i in range(1, 4):
        fs.append(f(i)) #f(i)立刻被执行,因此i的当前值被传入f()
    return fs

f1, f2, f3 = count()
print(f1(),f2(),f3())



print(list(map(lambda x: x * x,[1,2,3,4,5,6,7,7,8,9])))




def f(x):
    return x * x

f = lambda x : x * x

print(f)
print(f(5))


def build(x, y):
    return lambda: x * x + y * y



def now():
    print('2015-3-25')

f = now

print(f())

print(now.__name__)
print(f.__name__)

def log(func):
    def wrapper(*args, **kw):
        print('call %s():' % func.__name__)
        return func(*args, **kw)
    return wrapper


@log
def now():
    print('2015-3-125')
now()


def log(text):
    def decorator(func):
        def wrapper(*args,**kw):
            print('%s %s():'% (text, func.__name__))
            return func(*args, **kw)
        return wrapper
    return decorator

@log('execute')
def now():
    print('2015-3-25')
now()

import functools
#不需要编写wrapper.__name__ = func.__name__这样的代码，Python内置的functools.wraps就是干这个事的，所以，一个完整的decorator的写法如下：
def log(func):
    @functools.wraps(func)
    def wrapper(*args,**kw):
        print('call %s():' % func.__name__)
        return func(*args, **kw)
    return wrapper

def log(text):
    def decorator(func):
        @functools.wraps(func)
        def wrapper(*args, **kw):
            print('%s %s()' %(text, func.__name__))
            return func(*args, **kw)
        return wrapper
    return decorator


print(int('12345', base=8))
print(int('12345', 16))

def int2(x, base=2):
    return int(x, base)

print(int2('1000000'))
print(int2('1010101'))


import functools
int2 = functools.partial(int, base=2)
print(int2('1000000'))
print(int2('1010101'))

print(int2('1000000', base=10))


int2 = functools.partial(int, base=2)
int2('10010')
# 相当于
kw = {'base':2}
int('10010',**kw)

max2 = functools.partial(max, 10)

max2(5,6,7)
# 相当于
args = (10,5,6,7)
max(*args)








