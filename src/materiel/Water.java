package materiel;

import items.Materiel;
import data.Direction;

public class Water extends Materiel
{
	public Water()
	{
		super(new Direction(Direction.DOWN));
	}
}
