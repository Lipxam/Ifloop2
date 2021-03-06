package machines;

import items.*;

import java.awt.*;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import data.*;

public class Looper extends Machine implements Powered
{
	boolean active;
	boolean setActive;
	
	public Looper(Location loc)
	{
		super(loc);
		addInputType("materiel.Electricity");
		addOutputType("materiel.Electricity");
		setActive(true);
	}
	
	public List<Materiel> step(List<Item> inputsObs)
	{
		List<Materiel> result = new ArrayList<Materiel>();
		if(isActive())
		{
			for(Class<? extends Materiel> o: requiredOutputs)
			{
				try
				{
						Constructor c = o.getDeclaredConstructor(Class.forName("data.Location"), Class.forName("data.Direction"));
						result.add((Materiel)(c.newInstance(this.loc, new Direction(Direction.UP))));
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
		Rectangle rect = mapGridtoPixels(bounds, loc.getX(), loc.getY());
		g.drawImage(imgs.get(0), rect.x, rect.y, rect.width, rect.height, null);
		//g.setColor(Color.BLACK);
		//g.fillRect(rect.x, rect.y, rect.width, rect.height);
	}
}
