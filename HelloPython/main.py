print("Hello pyton")
print('''line1
line2
line3''')
print(r'\\\t\\')
print(10//3)
print(ord('A'))
print(chr(25991))
x = b'ABC'
print('Hello, %s' % 'world')
print('Hi, %s you have $%d.' % ('Michale', 100000))
print('%2d-%02d' % (3,1))
print('%.2f' % 3.1415926)
print('Age: %s. Gender: %s' % (25, True))
print('growth rate: %d %%' % 7)
s = 'Python-中文'
print(s)
b = s.encode('utf-8')
print(b)
print(b.decode('utf-8'))
classmethod = ['Michael', 'Bob', 'Tracy']
print(classmethod)
print(len(classmethod))
print(classmethod[0])
print(classmethod[-1])
classmethod.insert(1, 'Jack')
print(classmethod)
print(classmethod.pop())
print(classmethod)
print(classmethod.pop(1))
print(classmethod)
classmethod[1] = 'Sarah'
print(classmethod)

L = ['Apple', 123, True]
print(L)
s = ['python', 'java',['asp','php'],'scheme']
print(len(s))

L = []
print(len(L))


classmethod = ('Michael', 'Bob', 'Tracy')

print(classmethod)
t = (1)
print(t)

t = (1,)
print(t)

# 定义的不是tuple，是1这个数！这是因为括号()既可以表示tuple，又可以表示数学公式中的小括号，这就产生了歧义，因此，Python规定，这种情况下，按小括号进行计算，计算结果自然是1。
t = ('a','b', ['A','B'])
t[2][1] = 'X'
t[2][1] = 'Y'
print(t)

L = [
    ['Apple','Google', 'Microsoft'],
    ['Java', 'Python','Ruby','PHP',
     ['Adam','Bart','Lisa']]
]

print(L[0][0])


age = 20
if age >= 18:
    print('your age is', age)
    print('adult')
else:
    print('your age is', age)
    print('teenager')


age = 3
if age >= 18:
    print('adult')
elif age >= 6:
    print('teenager')
else:
    print('kid')


age = 20
if age >= 6:
    print('teenager')
elif age >= 18:
    print('adult')
else:
    print('kid')

# 只要x是非零数值、非空字符串、非空list等，就判断为True，否则为False
if x:
    print('True')


s = input('birth: ')
birth = int(s)
if birth < 2000:
    print('00前')
else:
    print('00后')

# 注意:
# input()返回的是字符串
# 必须通过int()将字符串转换为整数
# 才能用于数值比较:

age = int(input('Input your age: '))
if age >= 18:
    print('adult')
elif age >= 6:
    print('teenager')
else:
    print('kid')


names = ['Michael', 'Bob', 'Tracy']
for name in names:
    print(name)


sum = 0
for x in [1,2,3,4,5,6,7,8,9,10]:
    sum = sum + x

print(sum)


print(list(range(5)))

sum = 0
for x in range(101):
    sum = sum + x
print(sum)

sum = 0
n = 99
while n > 0:
    sum = sum + n
    n = n - 2
print(sum)


for i in ['Bart','Lisa', 'Adam']:
    print('Hello, %s!' % i)


# while 1:
    # print(9)


names = ['Michel','Bob','Tracy']
scores = [95,75,85]

d = {'Michael': 95, 'Bob': 75}
print('Thomas' in d)

print(d.get('Thomas'))
print(d.get('Thomas',-1))

print(d.pop('Bob'))

key = [1,2,3]
# d[key] = 'a list'
# print(d)

s = set([1,2,3])
print(s)

s1 = set([1,2,3])
s2 = set([2,3,4])

print(s1 & s2)
print(s1 | s2)


t = [1]
print(set(t))

a = ['c','b','a']
a.sort()
print(a)

a = 'abc'
b = a.replace('a','A')
print(b)

print(a)


d = {
    'Michael': 95,
    'Bob': 75,
    'Tracy': 85
}
print('d[\'Michael\'] =', d['Michael'])
print('d[\'Bob\'] =', d['Bob'])
print('d[\'Tracy\'] =', d['Tracy'])
print('d.get(\'Thomas\', -1) =', d.get('Thomas', -1))


# def fib(n):
#         a, b = 0,1
#         while a < n:
#             print(a, end=' ')
#             a, b = b, a + b
#         print()
# fib(1000)
# abs('a')
print(int('123'))
print(int(12.34))
print(str(1.23))

print(str(100))
print(bool(1))
print(bool(''))
a = abs
print(a(-1))
print('max(1,2,3) =',max(1,2,3))
# print('sum([1, 2, 3]) =', sum([1, 2, 3]))
# print('min(1,2,3) =',min(1,2,3))
# print('sum([1,2,3]) =',sum([1 ,2 ,3]))

# print(abs('a'))
# print(abs(100))
# print(abs(-20))

# print(abs(1,2))



def my_abs(x):
    if not isinstance(x, (int, float)):
        raise  TypeError('bad operand type')
    if x >= 0:
        return x
    else:
        return -x

# my_abs(1,2)
print(my_abs(5))

def nop():
    pass

if age >= 18:
    pass

key = [1,2,3]
# d[key] = 'a list'

# 并允许后续代码引用math包里的sin、cos等函数

import math
def move(x,y, step, angle=0):
    nx = x + step * math.cos(angle)
    ny = y - step * math.sin(angle)
    return nx, ny

x, y = move(100, 100, 60, math.pi / 6)
print(x,y)
r = move(100,100,60, math.pi/ 6)
print(r)

def power(x):
    return x * x

print(power(5))
print(power(15))

def power(x, n):
    s = 1
    while n > 0:
        n = n - 1
        s = s * x
    return s

print(power(5,2))
print(power(5,3))


def power(x, n=2):
    s = 1
    while n > 0:
        n = n - 1
        s = s * x
    return s

print(power(5))
print(power(5,2))

def enroll(name, gender):
    print('name:',name)
    print('gender:',gender)


# enroll('Sarah','F')

def enroll(name, gender, age=6, city='Beijing'):
    print('name:',name)
    print('gender:',gender)
    print('age:',age)
    print('city:',city)

print(enroll('Sarah','F'))
# print(enroll('Bob','M',7))
# print(enroll('Adam','M',city='Tianjin'))

# 所以，定义默认参数要牢记一点：默认参数必须指向不变对象！
def add_end(L=[]):
    L.append('END')
    return L

print(add_end())
print(add_end())
print(add_end())

def add_end(L=None):
    if L is None:
        L = []
        L.append('END')
        return L