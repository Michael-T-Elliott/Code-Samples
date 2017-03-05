/**
 * This defines a ConvexPolygon object that implements the interface "Shape"
 *
 * @author Michael Elliott
 * @version Project 02
 * @version CPE102-10
 * @version Spring 2015
 */


import java.awt.*;
import java.util.*;

public class ConvexPolygon implements Shape
{
	private Point[] vertices;
	private Color color;
	private boolean filled;

	public ConvexPolygon(Point[] vertices, Color color, boolean filled)
	{
		this.vertices = vertices;
		this.color = color;
		this.filled = filled;
	}

	public Point getVertex(int index)
	{
		return vertices[index];
	}

	public void setVertex(int index, Point point)
	{
		vertices[index] = point;
	}

	public double getArea()
	{
		double area = 0;
		int index = vertices.length;

		for (int i = 0; i < index; i++)
		{
			Point p1 = vertices[i];
			Point p2 = null;

			if (i+1 < index)
			{
			p2 = vertices[i+1];
			}
			else
			{
			p2 = vertices[0];
			}

			area += 0.5 * (p1.x*p2.y - p1.y*p2.x);
		}
		return area;
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
		int index = vertices.length;
		for (int i = 0; i < index; i++)
		{
			vertices[i].x += point.x;
			vertices[i].y += point.y;
		}

	}

	public boolean equals(ConvexPolygon other)
	{
		boolean equal = false;
		boolean type = false;
		boolean vertexMatch = false;
		ConvexPolygon c = new ConvexPolygon(vertices, color, filled);

		if (other instanceof ConvexPolygon)
		{
			if (c.vertices[0].x == other.vertices[0].x && c.vertices[0].y == other.vertices[0].y && c.vertices[1].x == other.vertices[1].x && c.vertices[1].y == other.vertices[1].y && c.color == other.color && c.filled == other.filled)
			{
				equal = true;
			}
		}	

		return equal;
	}
}