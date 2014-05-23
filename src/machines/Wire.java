package machines;

import items.*;
import java.awt.*;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import data.Direction;
import data.Location;

public class Wire extends Machine implements Powered
{
	List<Materiel> result = new ArrayList<Materiel>();
	boolean active;
	boolean setActive;
	
	public Wire(Location loc)
	{
		super(loc);
		addInputType("materiel.Electricity");
		addOutputType("materiel.Electricity");
	}
	
	public List<Materiel> step(List<Item> inputs)
	{
		for(Item a: inputs)
		{
			for(Class<? extends Materiel> b: inputs1)
			{
				if(b.isInstance(a))
				{
					setActive(true);
				}
			}
		}
		for(Class<? extends Materiel> o: outputs)
		{
			try
			{
				for(Class<? extends Materiel> a: outputs)
				{
					Constructor c = a.getDeclaredConstructor(Class.forName("data.Location"),
					Class.forName("data.Direction"));
					for(int i = 0; i < inputs.size(); i++)
						result.add((Materiel) (c.newInstance(loc, ((Materiel) inputs.get(i)).getDirection())));
					
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
		g.drawImage(imgs.get(0), rect.x, rect.y, rect.width, rect.height, null);
	}
}
