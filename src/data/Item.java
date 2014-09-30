package data;

import java.awt.*;
import java.io.Serializable;


public abstract class Item implements Serializable
{
	public java.util.List<Image> imgs;
	
	protected Grid grid;
	
	protected Location loc;
	
	public Item(Location l)
	{
		loc = l;
	}
	
	//items responsible for adding and removing from grid
	public void addToGrid(Grid g)
	{
		if(grid != null)
			removeFromGrid();
		
		grid = g;
		grid.addItem(this);
	}
	
	public void removeFromGrid()
	{
		grid.removeItem(this);
		grid = null;
	}

	public abstract void step();
	
	public void draw(Graphics g, Rectangle bounds)
	{
		Rectangle rect = mapGridtoPixels(bounds, loc.getX(), loc.getY());
		g.drawImage(getDisplayImage(), rect.x, rect.y, rect.width, rect.height, null);
	}

	public abstract Image getDisplayImage();
	
	public Image getDefaultDisplayImage()
	{
		if(imgs == null)
			throw new RuntimeException("imgs is null");
		else if(imgs.isEmpty())
			throw new RuntimeException("imgs is empty");
		
		return imgs.get(0);
	}

	public Location getLocation()
	{
		return loc;
	}
	
	public Rectangle mapGridtoPixels(Rectangle bounds, int gridX, int gridY)
	{
		int x = bounds.width / grid.getNumCols() * (gridX + 1);
		int y = bounds.height / grid.getNumRows() * (gridY + 1);
		
		return new Rectangle(x, y, 40, 40);
	}

	@Override
	public String toString()
	{
		return getClass().getName() + " [loc=" + loc + "]";
	}
}
