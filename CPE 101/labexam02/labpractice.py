


class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = x

class Circle:
    def __init__(self, point, radius):
        self.point = point
        self.radus = radius

def circles_overlap(circle1, circle2):
    distance = math.sqrt(((circle1.Point.x - circle2.point.x)**2) + ((circle1.Point.y - circle2.Point.y)**2))
    sum_of_radii = circle1.radius + circle2.radius
    if distance > sum_of_radii:
        return -1
    else if ((distance + 0.00001) = sum_of_radii):
        return 0
    else:
        return 1

def named_circles(circle_list1, circle_list2):
    overlap_circles = []
    for i in range(len(circle_list1)):
        overlap = circles_overlap(circle_list1[i], circle_list2[i])
        if (overlap == -1) or (overlap == 0):
            overlap_circles.append((circle_list1[i], circle_list2[i]))
    return overlap_circles
            
        
            
    
        
