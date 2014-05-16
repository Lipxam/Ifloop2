package machines;

import items.Item;
import items.Machine;
import items.Materiel;
import items.Powered;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Kettle extends Machine implements Powered
{
	boolean active;
	boolean setactive;
	List<Materiel> result = new ArrayList<Materiel>();
	
	public Kettle()
	{
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
					result.add(o.newInstance());
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
	@Override
	public void draw(Graphics g)
	{
		// TODO Auto-generated method stub
		
	}
}
