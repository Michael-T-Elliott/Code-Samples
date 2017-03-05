from sys import *

def main():
    print 'This program may take several minutes. Please wait.'
    image_output()

def command_line_argument():
    try:
        input_file = open(argv[1], 'r')
        return input_file
    except: 
        print "usage: file.py file.ppm"
        exit()

def groups_of_3(input_list):
    new_list = []
    while len(input_list) > 3:
        new_list.append([input_list[0], input_list[1], input_list[2]])
        input_list = input_list[3:]
        
    new_list.append(input_list)
    return new_list    	

def c_mult(number):
    num = int(number) * 10
    if (num) > 255:
        return 255
    else:
        return num

def image_reading(input_file, output_file):
    file = input_file.read()
    file_array = file.split()

    pixels = groups_of_3(file_array)
    for p in pixels:
        color = str(c_mult(p[0]))
        output_file.write(color + " " + color + " " + color + "\n")
        #set g and b pixel values to r and multiply by 10
    return pixels

def image_output():
    input_file = command_line_argument()

    P3 = input_file.readline()
    width_height = input_file.readline()
    color_range = input_file.readline()

    output_file = open('hidden.ppm', 'w')

    output_file.write(P3) 
    output_file.write(width_height)
    output_file.write(color_range)

    image_reading(input_file, output_file)


if __name__ == '__main__':
    main()

    