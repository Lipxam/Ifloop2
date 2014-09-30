package machines;

import items.*;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import data.*;

public class LaserOut extends Machine implements Powered
{
	boolean active; 
	boolean setActive;
	
	public LaserOut(Location loc)
	{
		super(loc);
		addInputType("materiel.Electricity");
		addOutputType("materiel.Laser");
		orientation.direction = Direction.RIGHT;
	}
	public List<Materiel> step(List<Item> inputsObs)
	{
		List<Materiel> result = new ArrayList<Materiel>();
		setActive(false);
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
						Constructor c = o.getDeclaredConstructor(Class.forName("data.Location"), Class.forName("data.Direction"));
						result.add((Materiel)(c.newInstance(this.loc, this.orientation)));
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		}
		return result;
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
	}
	
	
}
