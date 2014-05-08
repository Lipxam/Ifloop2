package items;

public class Materiél extends Item implements Moveable
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
