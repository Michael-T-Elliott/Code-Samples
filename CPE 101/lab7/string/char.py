
def is_lower_101(char):
    if ord(char) > 64 and ord(char) < 91:
        return False
    if ord(char) > 96 and ord(char) <123:
        return True

def char_rot_13(char):
    if ord(char) > 64 and ord(char) < 78:
        return chr(ord(char)+ 13)

    elif ord(char) > 77 and ord(char) < 91:
        return chr(ord(char)-13)

    elif ord(char) > 96 and ord(char) < 110:
        return chr(ord(char)+13)

    elif ord(char) > 109 and ord(char) < 123:
        return chr(ord(char)-13)