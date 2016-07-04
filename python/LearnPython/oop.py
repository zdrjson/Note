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

bart = Student('Bart Simpson', 59)
print(bart.name)

print(bart.score)


