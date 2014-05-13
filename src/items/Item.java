package items;

import data.Location;


public abstract class Item 
{
	int width, height;
	Location loc;
	
	public abstract void step();

	public Location getLocation()
	{
		return loc;
	}
}
