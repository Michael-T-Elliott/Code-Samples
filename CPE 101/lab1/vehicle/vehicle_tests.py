import unittest
import vehicle

class VehicleTests(unittest.TestCase):
    def test_my_vehicle(self):
        my_vehicle = vehicle.Vehicle(2, 3.1, 0, False)
        self.assertEqual(my_vehicle.wheels, 2)
        self.assertAlmostEqual(my_vehicle.fuel, 3.1)
        self.assertEqual(my_vehicle.doors, 0)
        self.assertFalse(my_vehicle.roof)
   
      # Add code here.



# Run the unit tests.
if __name__ == '__main__':
   unittest.main()

