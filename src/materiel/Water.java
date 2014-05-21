package materiel;

import items.Materiel;
import java.awt.Graphics;
import data.Direction;
import data.Location;

public class Water extends Materiel
{
	public Water(Location loc)
	{
		super(loc, new Direction(Direction.DOWN));
	}

	@Override
	public void draw(Graphics g)
	{
		// TODO Auto-generated method stub
		
	}
}
