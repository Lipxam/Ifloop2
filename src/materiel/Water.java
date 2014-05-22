package materiel;

import items.Materiel;
import java.awt.Graphics;
import java.awt.Rectangle;
import data.Direction;
import data.Location;

public class Water extends Materiel
{
	public Water(Location loc)
	{
		super(loc, new Direction(Direction.DOWN));
	}

	public void draw(Graphics g, Rectangle bounds)
	{
		// TODO Auto-generated method stub
		
	}
}
