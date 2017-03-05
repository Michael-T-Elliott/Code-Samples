import math

def square_all(numb_list):
    return [x**2 for x in numb_list]

def add_n_all(numb_list, n):
    new_list = []
    for x in numb_list:
        new_list.append(x + n)
    return new_list

def distance_all(pt_list):
    return [math.sqrt((point.x**2) + (point.y**2)) for point in pt_list] 
