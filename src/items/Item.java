package items;

import java.awt.*;
import data.Location;


public abstract class Item 
{
	public java.util.List<Image> imgs;
	
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
	
	//there are 20 rows and 15 columns
	public static Rectangle mapGridtoPixels(Rectangle bounds, int row, int col)
	{
		int x = bounds.width / col;
		int y = bounds.height / row;
		
		return new Rectangle(x, y, 40, 40);
	}
}
