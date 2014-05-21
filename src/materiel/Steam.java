package materiel;

import items.Materiel;
import java.awt.Graphics;
import data.Direction;
import data.Location;

public class Steam extends Materiel
{
	public Steam(Location loc)
	{
		super(loc, new Direction(Direction.UP));
	}

	@Override
	public void draw(Graphics g)
	{
		// TODO Auto-generated method stub
		
	}
}
