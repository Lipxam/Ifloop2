package items;

import java.awt.*;
import data.Location;


public abstract class Item 
{
	public java.util.List<Image> imgs;
	
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
	
	//there are 20 rows and 15 columns
	public static Rectangle mapGridtoPixels(Rectangle bounds, int row, int col)
	{
		int x = bounds.width / (col + 1);
		int y = bounds.height / (row + 1);
		
		return new Rectangle(x, y, 40, 40);
	}

	@Override
	public String toString()
	{
		return getClass().getName() + " [loc=" + loc + "]";
	}
}
