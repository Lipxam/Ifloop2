package materiel;

import items.Materiel;
import java.awt.Graphics;
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

	@Override
	public void draw(Graphics g)
	{
		// TODO Auto-generated method stub
		
	}
}
