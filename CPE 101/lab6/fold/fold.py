import math
from point import *

def sum(input_list):
    sum = 0
    for x in input_list:
        sum = x + sum
    return sum

def index_of_smallest(input_list):
    min_index = 0

    if input_list != []:
        for x in range(len(input_list)):
            if input_list[x] < input_list[min_index]:
                min_index = x
        return min_index
    else:
        return -1


def nearest_origin(point_list):
    nearest_index = 0

    if point_list != []:
        for i in range(len(point_list)):
            new_dist = math.sqrt((point_list[i].x - 0)**2 + (point_list[i].y - 0)**2)
            nearest_dist = math.sqrt((point_list[nearest_index].x - 0)**2 + (point_list[nearest_index].y - 0)**2)
            if new_dist < nearest_dist:
                nearest_index = i
        return nearest_index
    else:
        return -1 
        
    
    
    
