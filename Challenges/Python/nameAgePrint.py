from datetime import date

def getNameAndTurn100 ():
    name = input('Please enter your Name: ')
    age = input('Please enter your Age: ')
    
    while age.isdigit() != True:
        age = input('Please enter your real Age: ')
    
    age = int(age)
    
    year = date.today().year - age + 100
    
    print('Your name is %s, you will turn 100 in %i' % (name, year))
    
    
getNameAndTurn100()