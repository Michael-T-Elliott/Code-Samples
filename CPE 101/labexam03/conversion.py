from math import *
import math
from utility import *

class Point:
    def __init__(self, rect, polar):
        self.rect = rect
        self.polar = polar

    def __eq__(self, other):
        return (self.rect, other.rect) and (self.polar, other.polar)

def convert(x, y):
    r = sqrt(x**2 + y**2)
    angle = atan2(y, x)
    if angle < 0:
        angle = 2*math.pi + angle
    polar = (r, angle)
    rect = (x, y)
    point = Point(rect, polar)
    return point

def convert_list(point_list):
    new_list = []
    for i in range(len(point_list)):
        x = point_list[i].rect[0]
        y = point_list[i].rect[1]
        new_list.append(convert(x,y))

def read_points(filename):
    in_file = open(filename, 'r')
    for line in in_file:
        int(line)

def write_point(filename, point_list):
    in_file = open(filename, 'w')
    for line in in_file:
        write('x y r angle \n')

