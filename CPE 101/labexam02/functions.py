from data import *
import math

def distance(point1, point2):
    return math.sqrt(((point1.x - point2.x)**2) + ((point1.y - point2.y)**2))

def check_circle(circle, point):
    dist = distance(circle.center, point)
    if dist < circle.radius: #if in circle
        return -1
    if ((dist + 0.00001) == circle.radius) or ((dist - 0.00001) == circle.radius) or (dist == circle.radius): #if on circle
        return 0
    else:
        return 1

def in_or_out(circle_list, point):
    new_list = []
    for i in range(len(circle_list)):
        point_loc = check_circle(circle_list[i], point)
        if (point_loc == 1): #if in or on circle
            new_list.append(circle_list[i])
    return new_list

def list_multiply(num_list1, num_list2):
    new_list = []
    for i in range(len(num_list1)):
        product = num_list1[i]*num_list2[i]
        new_list.append(num_list1[i]*num_list2[i])
    return new_list
    
