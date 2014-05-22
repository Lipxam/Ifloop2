package materiel;

import items.Materiel;
import java.awt.*;
import data.Direction;
import data.Location;

public class Electricity extends Materiel
{
	public Electricity(Location l, Direction d)
	{
		super(l, d);
		
		//passes through everything
		addPassesThrough("Machine");
	}

	public void draw(Graphics g, Rectangle bounds)
	{
		// TODO Auto-generated method stub
		Rectangle rect = mapGridtoPixels(bounds, loc.getX(), loc.getY());
		g.drawImage(img, rect.x, rect.y, rect.width, rect.height, null);
	}
}
