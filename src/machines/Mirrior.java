package machines;

import items.Item;
import items.Machine;
import items.Materiel;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Mirrior extends Machine
{
	List<Materiel> result = new ArrayList<Materiel>();
	
	public Mirrior()
	{
		addInputType("Light");
		addOutputType("Light");
	}
	public List<Materiel> step(List<Item> inputs)
	{
		List<Materiel> result = new ArrayList<Materiel>();
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
		return result;
	}
	@Override
	public void step()
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void draw(Graphics g)
	{
		// TODO Auto-generated method stub
		
	}
}
