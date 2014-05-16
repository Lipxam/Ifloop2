package items;

import java.awt.Graphics;
import data.Location;


public abstract class Item 
{
	int width, height;
	protected Location loc;
	
	public abstract void step();
	
	public abstract void draw(Graphics g);

	public Location getLocation()
	{
		return loc;
	}
}
