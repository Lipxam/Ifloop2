package machines;

import java.util.ArrayList;
import java.util.List;

import items.Item;
import items.Machine;
import items.Materiel;

public class LaserOut extends Machine
{
	public LaserOut()
	{
		addInputType("Electricity");
		addOutputType("Laser");
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
}
