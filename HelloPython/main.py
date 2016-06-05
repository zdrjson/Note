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

# 定义的不是tuple，是1这个数！这是因为括号()既可以表示tuple，又可以表示数学公式中的小括号，这就产生了歧义，因此，Python规定，这种情况下，按小括号进行计算，计算结果自然是1。