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

