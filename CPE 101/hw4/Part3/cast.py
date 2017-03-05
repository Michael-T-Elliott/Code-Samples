from collisions import *
from data import *

def convert_to_int(number):
    num = int(number*255)
    if num > 255:
        return 255
    else:
        return num

def ambient(ambient_light, finish, color):
    r = color.r * finish * ambient_light.r
    g = color.g * finish * ambient_light.g
    b = color.b * finish * ambient_light.b
    return Color(r, g, b)

def diffuse(ambient_color


def cast_ray(ray, sphere_list, ambient_light):
    intersection_points = find_intersection_points(sphere_list, ray)
    min_value = 1000000000000000000

    if find_intersection_points(sphere_list, ray) != []:

        for i in range(len(intersection_points)):

            difference = difference_point(ray.pt, intersection_points[i][1]) 
            distance = length_vector(difference) 

            if distance < min_value:
                min_index = i 
                min_value = distance

        r = intersection_points[min_index][0].color.r
        g = intersection_points[min_index][0].color.g
        b = intersection_points[min_index][0].color.b

        color = Color(r, g, b)

        finish = intersection_points[min_index][0].finish

        return ambient(ambient_light, finish, color)
    else:
        return Color(1, 1, 1)


def cast_all_rays(min_x, max_x, min_y, max_y, width, height, eye_point, sphere_list, ambient_light):
    
    dx = (max_x - min_x)/float(width)  #pixel width
    dy = (max_y - min_y)/float(height) #pixel height

    for y in range(height):
        for x in range(width):
            pixel_point = Point(dx * x + min_x, max_y - y * dy, 0) #may need tinkering
            
            ray_direction = normalize_vector(vector_from_to(eye_point, pixel_point))
            
            my_ray = Ray(eye_point, ray_direction)
            
            color = cast_ray(my_ray, sphere_list, ambient_light)
            print convert_to_int(color.r), convert_to_int(color.g), convert_to_int(color.b)
            
            
            
            
            
            


