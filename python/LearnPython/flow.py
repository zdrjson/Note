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












