/**
 * This defines a Shape interface.
 *
 * @author Michael Elliott
 * @version Project 02
 * @version CPE102-10
 * @version Spring 2015
 */

import java.awt.*;
import java.util.*;

public interface Shape
{
	/**
	*Gets area of Shape.
	*@return Area of shape is returned as a double.
	 */
	double getArea();

	/**
	*Gets color of Shape.
	*@return color of shape is returned as a Color object.
	 */
	Color getColor();

	/**
	*Sets color of Shape.
	*@param color The color parameter is a Color object and sets the color of the shape to param color.
	 */
	void setColor(Color color);

	/**
	*Gets filled of Shape.
	*@return boolean filled of shape is returned.
	 */
	boolean getFilled();

	/**
	*Sets filled of Shape.
	*@param filled The filled parameter is a boolean and sets the filled boolean of the shape to param filled.
	 */
	void setFilled(boolean filled);

	/**
	*Moves a shape by the specified point.
	*@param point The point parameter is a Point object and moves the shape by its x and y values.
	 */
	void move(Point point);
}