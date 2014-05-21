package materiel;

import items.Materiel;
import java.awt.Graphics;
import data.Direction;
import data.Location;

public class Electricity extends Materiel
{
	public Electricity(Direction d, Location l)
	{
		super(d, l);
		
		//passes through everything
		addPassesThrough("Machine");
	}

	@Override
	public void draw(Graphics g)
	{
		// TODO Auto-generated method stub
		
	}
}
