class Student(object):
    def __init__(self, name, score):
        self.name = name
        self.score = score

    def print_score(self):
        print('%s: %s' %(self.name, self.score))


bart = Student('Bart Simpson', 59)
lisa = Student('Lisa Simpson', 87)
bart.print_score()
lisa.print_score()

class Student(object):
    pass
bart = Student()

bart.name = 'Bart Simpson'
print(bart.name)



class Student(object):
    def __init__(self, name, score):
        self.name = name;
        self.score = score

    def print_score(self):
        print('%s: %s' % (self.name, self.score))

    def get_grade(self):
        if self.score >= 90:
            return 'A'
        elif self.score >= 60:
            return 'B'
        else:
            return 'C'


bart = Student('Bart Simpson', 59)
print(bart.name)

print(bart.score)

bart.print_score()


print(bart.get_grade())




class Student(object):
    def __init__(self, name, score):
        self.__name = name
        self.__score = score

    def print_score(self):
        print('%s: %s' % (self.__name, self.__score))

    def get_name(self):
        return self.__name

    def get_score(self):
        return self.__score

    def set_socre(self, score):
        if 0 <= score <= 100:
            self.__score = score
        else:
            raise  ValueError('bad score')


bart = Student('Bart Simpson', 98)

print(bart._Student__name)


class Animal(object):
    def run(self):
        print('Animal is running...')


class Dog(Animal):
    pass

class Cat(Animal):
    pass

dog = Dog()
dog.run()

cat = Cat()
cat.run()

class Dog(Animal):
    def run(self):
        print('Dog is running...')

    def eat(self):
        print('Eating meat...')


class Dog(Animal):
    def run(self):
        print('Dog is running...')

class Cat(Animal):
    def run(self):
        print('Cat is running...')

a = list()
b = Animal()
c = Dog()

print(isinstance(a, list))

print(isinstance(b, Animal))

print(isinstance(c, Dog))


def run_twice(animal):
    






