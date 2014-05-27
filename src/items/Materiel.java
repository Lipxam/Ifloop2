package items;

import java.util.ArrayList;
import java.util.List;
import data.Direction;
import data.Location;

public abstract class Materiel extends Item implements Moveable
{
	int steps = 0;
	
	List<Class<? extends Machine>> passesThrough = new ArrayList<Class<? extends Machine>>();
	
	// where this came from
	Machine parent;
	Direction moveDirection;
	
	public Materiel(Location loc)
	{
		this(loc, new Direction(-1));
	}
	
	public Materiel(Location l, Direction d)
	{
		super(l);
		addPassesThrough("Wire");
		moveDirection = d;

	}
	
	public void addPassesThrough(String string)
	{
		if(!string.contains("."))
		{
			if(string.equals("Machine"))
				string = "items." + string;
			else
				string = "machines." + string;
		}
		
		try
		{
			passesThrough.add((Class<? extends Machine>) Class.forName(string));
		}
		catch(ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean passesThrough(Machine m)
	{
		for(Class<? extends Machine> c: passesThrough)
		{
			if(true)
				// m is of type/subtype c
				return true;
		}
		return passesThrough.contains(m.getClass());
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
