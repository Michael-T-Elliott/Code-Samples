/**
 * This defines a Rectangle object that implements the interface "Shape"
 *
 * @author Michael Elliott
 * @version Project 02
 * @version CPE102-10
 * @version Spring 2015
 */

import java.awt.*;
import java.util.*;

public class Rectangle implements Shape
{
	private double width;
	private double height;
	private Point position;
	private Color color;
	private boolean filled;

	public Rectangle(double width, double height, Point position, Color color, boolean filled)
	{
		this.width = width;
		this.height = height;
		this.position = position;
		this.color = color;
		this.filled = filled;
	}

	public double getArea()
	{
		return (width * height);
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

	public double getWidth()
	{
		return width;
	}

	public void setWidth(double width)
	{
		this.width = width;

	}

	public double getHeight()
	{
		return height;
	}

	public void setHeight(double height)
	{
		this.height = height;
	}

	public Point getPosition()
	{
		return position;
	}

	public boolean equals(Rectangle other)
	{
		boolean equal = false;
		boolean type = false;
		Rectangle r = new Rectangle(width, height, position, color, filled);

		if (other instanceof Rectangle)
		type = true;

		if (type == true && r.width == other.width && r.height == other.height && r.position.x == other.position.x && r.position.y == other.position.y && r.color == other.color && r.filled == other.filled)
		{
			equal = true;
		}

		return equal;
	}
}