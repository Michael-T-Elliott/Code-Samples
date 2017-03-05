/**
 * This defines a WorkSpace object to contain given shapes in
 *
 * @author Michael Elliott
 * @version Project 02
 * @version CPE102-10
 * @version Spring 2015
 */

import java.awt.*;
import java.util.*;

public class WorkSpace
{
	private ArrayList<Shape> ws = new ArrayList<Shape>();

	public WorkSpace()
	{

	}

	public void add(Shape shape)
	{
		ws.add(shape);
	}

	public Shape remove(int index)
	{
		if (index > ws.size())
			return null;

		Shape reference = ws.get(index);
		ws.remove(index); 
		return reference;
	}

	public Shape get(int index)
	{
		Shape reference = ws.get(index);
		return reference;
	}

	public int size()
	{
		int size = ws.size();
		return size;
	}

	public ArrayList<Rectangle> getRectangles()
	{
		ArrayList<Rectangle> rect = new ArrayList<Rectangle>();

		for (int i = 0; i < ws.size(); i++)
		{
			if (ws.get(i) instanceof Rectangle)
			{	
				Rectangle r = (Rectangle)ws.get(i);
				rect.add(r);
			}
		}
		return rect;
	}

	public ArrayList<Circle> getCircles()
	{
		ArrayList<Circle> circ = new ArrayList<Circle>();

		for (int i = 0; i < ws.size(); i++)
		{
			if (ws.get(i) instanceof Circle)
			{	
				Circle c = (Circle)ws.get(i);
				circ.add(c);
			}
		}
		return circ;
	}

	public ArrayList<Triangle> getTriangles()
	{
		ArrayList<Triangle> tri = new ArrayList<Triangle>();

		for (int i = 0; i < ws.size(); i++)
		{
			if (ws.get(i) instanceof Triangle)
			{	
				Triangle t = (Triangle)ws.get(i);
				tri.add(t);
			}
		}
		return tri;
	}

	public ArrayList<ConvexPolygon> getConvexPolygons()
	{
		ArrayList<ConvexPolygon> conv = new ArrayList<ConvexPolygon>();

		for (int i = 0; i < ws.size(); i++)
		{
			if (ws.get(i) instanceof ConvexPolygon)
			{	
				ConvexPolygon cp = (ConvexPolygon)ws.get(i);
				conv.add(cp);
			}
		}
		return conv;
	}

	public ArrayList<Shape> getShapesByColor(Color color)
	{
		ArrayList<Shape> col = new ArrayList<Shape>();

		for (int i = 0; i < ws.size(); i++)
		{
			if (ws.get(i).getColor() == color)
			{	
				col.add(ws.get(i));
			}
		}
		return col;
	}

	public double getAreaOfAllShapes()
	{
		double sum = 0;
		for (int i = 0; i < ws.size(); i++)
		{
			sum += ws.get(i).getArea();
		}
		return sum;
	}
}