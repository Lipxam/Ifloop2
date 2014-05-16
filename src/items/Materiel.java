package items;

import java.util.ArrayList;
import java.util.List;
import data.Direction;

public abstract class Materiel extends Item implements Moveable
{
	List<Class<? extends Machine>> passesThrough = new ArrayList<Class<? extends Machine>>();
	
	//where this came from
	Machine parent;
	Direction moveDirection;
	
	public Materiel(Direction d)
	{
		moveDirection = d;
		
		addPassesThrough("Wire");
	}
	
	public void addPassesThrough(String string)
	{
		try
		{
			passesThrough.add((Class<? extends Machine>)Class.forName(string));
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean passesThrough(Machine m)
	{
		for(Class<? extends Machine> c: passesThrough)
		{
			if(true)//m is of type/subtype c
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
		//just changes the location of the materiel
		loc.move(moveDirection);
	}
}
