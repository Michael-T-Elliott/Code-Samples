/**
 * This defines a Circle object that implements the interface "Shape"
 *
 * @author Michael Elliott
 * @version Project 02
 * @version CPE102-10
 * @version Spring 2015
 */

import java.awt.*;
import java.util.*;

public class Circle implements Shape
{
	private double radius;
	private Point position;
	private Color color;
	private boolean filled;

	public Circle(double radius, Point position, Color color, boolean filled)
	{
		this.radius = radius;
		this.position = position;
		this.color = color;
		this.filled = filled;
	}

	public double getArea()
	{
		return (Math.PI * radius * radius);
	}

	public Color getColor()
	{
		return color;
	}

	public void setColor(Color color)
	{
		this.color = color;
	}

	public boolean getFilled()
	{
		return filled;
	}

	public void setFilled(boolean filled)
	{
		this.filled = filled;
	}

	public void move(Point point)
	{
		position.x += point.x;
		position.y += point.y;
	}

	public double getRadius()
	{
		return radius;
	}

	public void setRadius(double radius)
	{
		this.radius = radius;
	}

	public Point getPosition()
	{
		return position;
	}

	public boolean equals(Circle other)
	{
		boolean type = false;
		boolean equal = false;
		Circle c = new Circle(radius, position, color, filled);

		if (other instanceof Circle)
			type = true;

		if (type == true && c.radius == other.radius && c.position.x == other.position.x && c.position.y == other.position.y && c.color == other.color && c.filled == other.filled)
		{
			equal = true;
		}

		return equal;
	}
}
