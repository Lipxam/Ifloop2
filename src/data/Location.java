package data;

import java.util.ArrayList;
import java.util.List;

//this must be immutable
public class Location implements java.io.Serializable
{	
	private int x, y;
	
	public Location(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public List<Location> getAdjacentLocs()
	{
		List<Location> result = new ArrayList<Location>();
		for(int x1 = x - 1; x1 <= x + 1; x1++)
		{
			for(int y1 = y - 1; y <= y + 1; y++)
				if(x1 != x && y1 != y)
					result.add(new Location(x1, y1));
		}
		return result;
	}
	
	public Direction directionTowards(Location other)
	{
		throw new UnsupportedOperationException();
	}
	
	public Location move(int d)
	{
		Location r = new Location(x, y);
		switch(d)
		{
			case Direction.DOWN: r.y++; break;
			case Direction.UP: r.y--; break;
			case Direction.LEFT: r.x--; break;
			case Direction.RIGHT: r.x++; break;
		}
		return r;
	}
	
	public boolean equals(Object obj)
	{
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if(x != other.x)
			return false;
		if(y != other.y)
			return false;
		return true;
	}

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	@Override
	public String toString()
	{
		return "Location [x=" + x + ", y=" + y + "]";
	}

	public boolean outOfBounds()
	{
		// TODO Auto-generated method stub
		return false;
	}
}