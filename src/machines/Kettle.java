package machines;

import items.*;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import materiel.Water;
import data.*;

public class Kettle extends Machine implements Powered
{
	Direction a = new Direction(1);
	Direction b = new Direction(2);
	Direction c = new Direction(3);
	Direction d = new Direction(4);
	boolean active;
	
	public Kettle(Location loc)
	{
		super(loc);
		addInputType("materiel.Electricity");
		addOutputType("materiel.Steam");
	}
	
	public List<Materiel> step(List<Item> inputsObs)
	{
		List<Materiel> result = new ArrayList<Materiel>();
		for(Item a: inputsObs)
		{
			for(Class<? extends Materiel> b: requiredInputs)
			{
				if(b.isInstance(a))
				{
					setActive(true);
				}
			}
		}
		if(isActive() == true)
		{
			for(Class<? extends Materiel> o: requiredOutputs)
			{
				try
				{
						Constructor c = o.getDeclaredConstructor(Class.forName("data.Location"));
						result.add((Materiel)(c.newInstance(this.loc)));
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
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
