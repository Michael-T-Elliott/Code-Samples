/**
 * This defines a Triangle object that implements the interface "Shape"
 *
 * @author Michael Elliott
 * @version Project 02
 * @version CPE102-10
 * @version Spring 2015
 */

import java.awt.*;
import java.util.*;

public class Triangle implements Shape
{
	private Point a;
	private Point b;
	private Point c;
	private Color color;
	private boolean filled;

	public Triangle(Point a, Point b, Point c, Color color, boolean filled)
	{
		this.a = a;
		this.b = b;
		this.c = c;
		this.color = color;
		this.filled = filled;
	}

	public double getArea()
	{
		double sideA = Math.sqrt( ((b.x-c.x)*(b.x-c.x)) + ((b.y-c.y)*(b.y-c.y)) );
		double sideC = Math.sqrt( ((a.x-b.x)*(a.x-b.x)) + ((a.y-b.y)*(a.y-b.y)) );
		double sideB = Math.sqrt( ((c.x-a.x)*(c.x-a.x)) + ((c.y-a.y)*(c.y-a.y)) );
		double s = (sideA+sideB+sideC)/2;
		return Math.sqrt(s*(s-sideA)*(s-sideB)*(s-sideC));
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
		a.x += point.x;
		a.y += point.y;
		b.x += point.x;
		b.y += point.y;
		c.x += point.x;
		c.y += point.y;
	}

	public Point getVertexA()
	{
		return a;
	}

	public void setVertexA(Point point)
	{
		a = point;
	}

	public Point getVertexB()
	{
		return b;
	}

	public void setVertexB(Point point)
	{
		b = point;
	}

	public Point getVertexC()
	{
		return c;
	}

	public void setVertexC(Point point)
	{
		c = point;
	}

	public boolean equals(Triangle other)
	{
		boolean equal = false;
		boolean type = false;
		Triangle t = new Triangle(a, b, c, color, filled);

		if (other instanceof Triangle)
			type = true;

		if (type == true && t.a.x == other.a.x && t.a.y == other.a.y && t.b.x == other.b.x && t.b.y == other.b.y && t.c.x == other.c.x && t.c.y == other.c.y && t.filled == other.filled)
		{
			equal = true;
		}

		return equal;
	}
}