package machines;

import items.*;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import materiel.Water;
import data.Direction;
import data.Location;

public class Kettle extends Machine implements Powered
{
	Direction a = new Direction(1);
	Direction b = new Direction(2);
	Direction c = new Direction(3);
	Direction d = new Direction(4);
	boolean active;
	boolean setactive;
	List<Materiel> result = new ArrayList<Materiel>();
	
	public Kettle(Location loc)
	{
		super(loc);
		addInputType("Electricity");
		addOutputType("Steam");
	}
	public List<Materiel> step(List<Item> inputsObs)
	{	
		for(Item a: inputsObs)
		{
			for(Class<? extends Materiel> b : inputs1)
			{
				if(b.isInstance(a))
				{
					setActive(true);
				}
			}
		}
		if(isActive() == true)
		{
			for(Class<? extends Materiel> o: outputs)
			{
				try
				{
					for(Class<? extends Materiel> a : outputs)
					{
					Constructor c = a.getDeclaredConstructor(Class.forName("Direction), Class.forName("Location))
					result.add((Materiel) conc.newInstance(this.loc));
					
				} catch (InstantiationException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	@Override
	public void setActive(boolean a)
	{
		active = a;
	}
	@Override
	public boolean isActive()
	{
		return active;
	}
	public void draw(Graphics g, Rectangle bounds)
	{
		// TODO Auto-generated method stub
		
	}
}
