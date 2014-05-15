package data;

import java.util.List;

public class Location
{	
	int x, y;
	
	public Location(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public List<Location> getAdjacentLocs()
	{
		return null;
	}
	
	public void move(Direction d)
	{
		switch(d.direction)
		{
			case Direction.DOWN: y--; break;
			case Direction.UP: y++; break;
			case Direction.LEFT: x--; break;
			case Direction.RIGHT: x++; break;
		}
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
}
