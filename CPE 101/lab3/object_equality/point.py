# Name: Michael Elliott
# Instructor: Dr. John Campbell
# Section: 17

import utility 

class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def __eq__(self, other):
        return (utility.epsilon_equal(self.x, other.x)) and (utility.epsilon_equal(self.y, other.y))

        

