word = input('Is Palindrom?: ').replace(' ', '')
print(True if word == word[::-1] else False)