package materiel;

import items.Materiel;
import java.awt.Graphics;
import java.awt.Rectangle;
import data.Direction;
import data.Location;

public class Steam extends Materiel
{
	public Steam(Location loc)
	{
		super(loc, new Direction(Direction.UP));
	}

	public void draw(Graphics g, Rectangle bounds)
	{
		// TODO Auto-generated method stub
		
	}
}
