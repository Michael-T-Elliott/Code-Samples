from char import *

def str_rot_13(string):
    a = ''
    for i in range(len(string)):
        a = a + char_rot_13(string[i])
    return a

def str_translate_101(string, x, y):
    a = ''
    for i in range(len(string)):
        if string[i] == x:
            a = a + y
        else:
            a = a + string[i]
    return a
