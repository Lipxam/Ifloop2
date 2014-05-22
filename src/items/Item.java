package items;

import java.awt.Graphics;
import java.awt.Rectangle;
import data.Location;


public abstract class Item 
{
	int width, height;
	protected Location loc;
	
	public Item(Location l)
	{
		loc = l;
	}

	public abstract void step();
	
	public abstract void draw(Graphics g, Rectangle bounds);

	public Location getLocation()
	{
		return loc;
	}
}
