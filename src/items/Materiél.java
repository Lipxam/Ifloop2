package items;

public class Materi�l extends Item implements Moveable
{
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
