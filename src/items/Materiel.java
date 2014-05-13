package items;

import data.Direction;

public abstract class Materiel extends Item implements Moveable
{
	//where this came from
	Machine parent;
	
	Direction moveDirection;
	
	public Materiel(Direction d)
	{
		moveDirection = d;
	}
	
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
