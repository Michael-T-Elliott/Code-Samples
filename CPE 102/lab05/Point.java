/**
 * This is an interface, used in CartesianPoint and PolarPoint classes for PointTester
 *
 * @author Michael Elliott
 * @version Project 01
 * @version CPE102-10 (replace the X with your section number)
 * @version Spring 2015
 */


public interface Point
{
	double xCoordinate();
	double yCoordinate();
	double radius();
	double angle();
	double distanceFrom(Point other);
	Point rotate90();
}