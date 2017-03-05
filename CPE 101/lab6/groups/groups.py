def groups_of_3(input_list):
    new_list = []
    while len(input_list) > 3:
        new_list.append([input_list[0], input_list[1], input_list[2]])
        input_list = input_list[3:]
        
    new_list.append(input_list)
    return new_list
