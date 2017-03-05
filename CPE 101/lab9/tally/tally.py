from sys import *

def main(argv):
    file_name = argv[1]
    try:
        file_object = open(file_name, "r")
    except:
        print "Error. Failed to Open File."
        exit()

    column = int(argv[2])

    print get_column_sum(file_object, column)

def float_default(string, line_number):
    try:
        return float(string)
    except:
        print "line" + " " + str(line_number) + " " + "not a number"
        return 0

def get_column_val(string, column, line_number):
    if column < len(string.split()):
        values = string.split()
        return float_default(values[column], line_number)
    else:
        print "line" + " " + str(line_number) + " " + "out of range"
        return 0

def get_column_sum(file_object, column):
    sum = 0
    line_number = 0
    for line in file_object:
        line_number += 1
        sum += get_column_val(line, column, line_number)
        
    return sum

if __name__ == "__main__":
    main(argv)
    




