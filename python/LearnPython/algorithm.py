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



