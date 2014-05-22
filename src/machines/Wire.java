package machines;

import items.*;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import data.Location;

public class Wire extends Machine implements Powered
{
	List<Materiel> result = new ArrayList<Materiel>();
	boolean active; 
	boolean setActive;
	
	public Wire(Location loc)
	{
		super(loc);
		addInputType("Electricity");
		addOutputType("Electricty");
	}
	public List<Materiel> step(List<Item> inputs)
	{
		for(Item a: inputs)
		{
			for(Class<? extends Materiel> b : inputs1)
			{
				if(b.isInstance(a))
				{
					setActive(true);
				}
			}
		}		for(Class<? extends Materiel> o: outputs)
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
	public void setActive(boolean a)
	{
		active = a;
	}
	@Override
	public boolean isActive()
	{
		// TODO Auto-generated method stub
		return active;
		
	}
<<<<<<< HEAD
=======
	@Override
>>>>>>> FETCH_HEAD
	public void draw(Graphics g, Rectangle bounds)
	{
		Rectangle rect = mapGridtoPixels(bounds, loc.getX(), loc.getY());
		g.drawImage(imgs.get(0), rect.x, rect.y, rect.width, rect.height, null);
	}
}
