package machines;

import items.*;
import java.awt.*;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import data.Direction;
import data.Location;

public class Looper extends Machine implements Powered
{
	boolean active;
	boolean setActive;
	
	public Looper(Location loc)
	{
		super(loc);
		addInputType("materiel.Electricity");
		addOutputType("materiel.Electricity");
	}
	
	public List<Materiel> step(List<Item> inputs)
	{
		setActive(true);
		
		List<Materiel> result = new ArrayList<Materiel>();
		for(Class<? extends Materiel> o: outputs)
		{
			try
			{
				for(Class<? extends Materiel> a: outputs)
				{
					Constructor c = a.getDeclaredConstructor(Class.forName("data.Location"), Class.forName("data.Direction"));
					result.add((Materiel)(c.newInstance(new Location(loc.getX(), loc.getY() - 1), new Direction(Direction.UP))));
				}
				
			}
			catch(Exception e)
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
		Rectangle rect = mapGridtoPixels(bounds, loc.getX(), loc.getY());
		//g.drawImage(imgs.get(0), rect.x, rect.y, rect.width, rect.height, null);
		g.setColor(Color.BLACK);
		g.fillRect(rect.x, rect.y, rect.width, rect.height);
	}
}
