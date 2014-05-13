package items;

import Interfaces.Moveable;

public abstract class Materiel extends Item implements Moveable
{
	//where this came from
	Machine parent;
	
	Direction moveDirection;
	
	public boolean inMotion()
	{
		return moveDirection != null;
	}

	@Override
	public Direction getDirection()
	{
		return moveDirection;
	}
}
