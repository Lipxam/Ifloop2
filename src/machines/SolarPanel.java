package machines;

import items.*;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import data.*;

public class SolarPanel extends Machine implements Powered
{
	List<Materiel> result = new ArrayList<Materiel>();
	boolean active; 
	boolean setActive;
	
	public SolarPanel(Location loc)
	{
		super(loc);
		addInputType("Light");
		addOutputType("Electricity");
	}
	public List<Materiel> step(List<Item> inputs)
	{
		for(Item a: inputs)
		{
			for(Class<? extends Materiel> b : requiredInputs)
			{
				if(b.isInstance(a))
				{
					setActive(true);
				}
			}
		}		for(Class<? extends Materiel> o: requiredOutputs)
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
	public void draw(Graphics g, Rectangle bounds)
	{
		// TODO Auto-generated method stub
		
	}
}
