# coding=utf-8
scroe = 20

if scroe>=80:
    print("很好")
elif scroe>=60:
    print("及格")
elif scroe>=30:
    print("不及格")
else:
    print("很差")


def add_end(L=None):
    if L is None:
        L = []
        L.append('END')
        return L


print(add_end())
print(add_end())

def calc(numbers):
    sum = 0
    for n in numbers:
        sum = sum + n * n
    return sum


print(calc([1,2,3]))
print(calc([1,3,5,7]))


def calc(*numbers):
    sum = 0
    for n in numbers:
        sum = sum + n * n
    return sum

print(calc(1,2))
print(calc())

nums = [1,2,3]
print(calc(nums[0],nums[1],nums[2]))
# *nums表示把nums这个list的所有元素作为可变参数传进去。这种写法相当有用，而且很常见。
print(calc(*nums))

def person1(name, age, **kw):
    print('name:',name,'age:',age, 'other:',kw)

person1('Michael',30)

person1('Bob',35,city='Beijing')
person1('Adam',45,gender='M', job='Engineer')


extra = {'city':'Beijing','job':'Engineer'}
person1('Jack',24,**extra)


def person(name, age, **kw):
    if 'city' in kw:
        pass
    if 'job' in kw:
        pass

    print('name:',name,'age:',age,'other:',kw)



def f1(a, b, c=0, *args, **kw):
    print('a=',a, 'b=',b, 'c=',c, 'args = ',args,'kw = ',kw)


def f2(a, b, c=0, *,d, **kw):
        print('a=', a, 'b=',b, 'c =',c,'d =',d,'kw = ',kw)


print(f1(1,2))

print(f1(1,2,c=3))

print(f1(1,2,3,'a','b'))

print(f1(1,2,3, 'a', 'b', x=99))

print(f2(1,2, d=99, ext=None))

args = (1,2,3,4)

kw = {'d':99,'x':'#'}

print(f1(*args, **kw))

args = (1, 2, 3)
kw = {'d': 88, 'x': '#'}
print(f2(*args, **kw))





