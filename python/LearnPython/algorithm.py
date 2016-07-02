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







