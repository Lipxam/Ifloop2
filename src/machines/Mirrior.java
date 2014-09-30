package machines;

import items.*;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import data.*;

public class Mirrior extends Machine
{
	List<Materiel> result = new ArrayList<Materiel>();
	
	public Mirrior(Location loc)
	{
		super(loc);
		addInputType("Light");
		addOutputType("Light");
	}
	public List<Materiel> step(List<Item> inputs)
	{
		List<Materiel> result = new ArrayList<Materiel>();
		for(Class<? extends Materiel> o: requiredOutputs)
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
	public void draw(Graphics g, Rectangle bounds)
	{
		// TODO Auto-generated method stub
		
	}
}
