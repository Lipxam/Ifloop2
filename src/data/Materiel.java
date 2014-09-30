package data;


//materiels can not normally pass through any type of machine
public abstract class Materiel extends Item implements Moveable
{
	int steps = 0;
	
	// where this came from
	Machine parent;
	
	int moveDirection;
	
	public Materiel(Location loc)
	{
		this(loc, -1);
	}
	
	public Materiel(Location l, int d)
	{
		super(l);
		moveDirection = d;
	}

	public boolean passesThrough(Machine m)
	{
		return false;
	}
	
	//pretty much just a shortcut
	public boolean inMotion()
	{
		return getMoveDirection() == -1;
	}
	
	public int getMoveDirection()
	{
		return moveDirection;
	}
	
	public void step()
	{
		steps++;
		
		// just changes the location of the materiel
		loc = loc.move(moveDirection);
	}

	@Override
	public String toString()
	{
		return getClass().getName() + " [parent=" + parent + ", moveDirection=" + moveDirection + ", loc=" + loc + "]";
	}
}
