from collisions import *
from data import *
from vector_math import *

def convert_to_int(number):
    num = int(number*255)
    if num > 255:
        return 255
    else:
        return num

def ambient_func(ambient_light, ambient, color):
    r = color.r * ambient * ambient_light.r
    g = color.g * ambient * ambient_light.g
    b = color.b * ambient * ambient_light.b
    return Color(r, g, b)

def diffuse_func(diffuse, ambient_color, N, ldir, light, sphere):
    diffuse_value_r = dot_vector(N, ldir) * light.color.r * sphere.color.r * diffuse
    diffuse_value_g = dot_vector(N, ldir) * light.color.g * sphere.color.g * diffuse
    diffuse_value_b = dot_vector(N, ldir) * light.color.b * sphere.color.b * diffuse
    r = diffuse_value_r + ambient_color.r
    g = diffuse_value_g + ambient_color.g
    b = diffuse_value_b + ambient_color.b
    return Color(r, g, b)

def cast_ray_from_intersection(ray, sphere_list):
    intersection_points = find_intersection_points(sphere_list, ray)
    return len(intersection_points) > 0

def relection_vec(ldir, LdotN, N):
     return normalize_vector(difference_vector(ldir, scale_vector(N, (2*LdotN))))

def spec_intense(light, sphere, specular_intensity):
    spec_power = specular_intensity**(1.0/sphere.finish.roughness)
    if specular_intensity > 0:
        spec_contribution_r = light.color.r * sphere.finish.specular * (spec_power)
        spec_contribution_g = light.color.g * sphere.finish.specular * (spec_power)
        spec_contribution_b = light.color.b * sphere.finish.specular * (spec_power)
        return Color(spec_contribution_r, spec_contribution_g, spec_contribution_b)
    else:
        return Color(0, 0, 0)  

def cast_ray(ray, sphere_list, ambient_light, light, eye_point):
    intersection_points = find_intersection_points(sphere_list, ray)
    min_value = 1000000000000000000

    if find_intersection_points(sphere_list, ray) != []:

        for i in range(len(intersection_points)):

            difference = difference_point(ray.pt, intersection_points[i][1]) 
            distance = length_vector(difference) 

            if distance < min_value:
                min_index = i 
                min_value = distance

        N = sphere_normal_at_point(intersection_points[min_index][0],
                                               intersection_points[min_index][1])
        sphere = intersection_points[min_index][0]
        short_norm_vector = scale_vector(N, 0.01)
        pe = translate_point(intersection_points[min_index][1], short_norm_vector)
        ldir = normalize_vector(vector_from_to(pe, light.pt))
        LdotN = dot_vector(N, ldir)

        r = intersection_points[min_index][0].color.r
        g = intersection_points[min_index][0].color.g
        b = intersection_points[min_index][0].color.b
        color = Color(r, g, b)

        ambient = intersection_points[min_index][0].finish.ambient
        diffuse = intersection_points[min_index][0].finish.diffuse
        ambient_color = ambient_func(ambient_light, ambient, color)
        diffuse_color = diffuse_func(diffuse, ambient_color, N, ldir, light, sphere)

        reflection_vector = relection_vec(ldir, LdotN, N)
        vdir = normalize_vector(vector_from_to(eye_point, pe))
        specular_intensity = dot_vector(reflection_vector, vdir)
        spec_contribution = spec_intense(light, sphere, specular_intensity)
        
        new_ray = Ray(pe,ldir) 
         
        if not cast_ray_from_intersection(new_ray, sphere_list) and dot_vector(N, ldir) > 0:
            return Color(diffuse_color.r + spec_contribution.r, diffuse_color.g + spec_contribution.g, diffuse_color.b + spec_contribution.b)

        return Color(ambient_color.r, ambient_color.g, ambient_color.b)
    else:
        return Color(1, 1, 1)


def cast_all_rays(min_x, max_x, min_y, max_y, width, height, eye_point, 
                  sphere_list, ambient_light, light):
    
    dx = (max_x - min_x)/float(width)  #pixel width
    dy = (max_y - min_y)/float(height) #pixel height

    for y in range(height):
        for x in range(width):
            pixel_point = Point(dx * x + min_x, max_y - y * dy, 0)
            
            ray_direction = normalize_vector(vector_from_to(eye_point, pixel_point))
            
            my_ray = Ray(eye_point, ray_direction)
            
            color = cast_ray(my_ray, sphere_list, ambient_light, light, eye_point)
            print convert_to_int(color.r),\
                  convert_to_int(color.g),\
                  convert_to_int(color.b)
            
            
            
            
            
            


