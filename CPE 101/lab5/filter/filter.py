import math

def are_positive(numb_list):
    return [x for x in numb_list if x > 0]

def are_greater_than(numb_list, n):
    return [x for x in numb_list if x > n]

def are_in_first_quadrant(pt_list): 
    new_list = []
    for point in pt_list:
        if point.x > 0 and point.y > 0:
            new_list.append(point)
    return new_list
        
