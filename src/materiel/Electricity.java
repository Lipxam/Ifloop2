package materiel;

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
}
