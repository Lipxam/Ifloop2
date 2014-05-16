package materiel;

import java.awt.Graphics;

import items.Materiel;
import data.Direction;

public class Electricity extends Materiel
{
	public Electricity(Direction d)
	{
		super(d);
		
		//passes through everything
		addPassesThrough("Machine");
	}

	@Override
	public void draw(Graphics g)
	{
		// TODO Auto-generated method stub
		
	}
}
