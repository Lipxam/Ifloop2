package machines;
import items.Item;
import items.Machine;
import items.Materiel;

import java.util.ArrayList;
import java.util.List;


public class LaserIn extends Machine
{
	public LaserIn()
	{
		addInputType("Laser");
		addOutputType("Electricty");
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
	public void step()
	{
		// TODO Auto-generated method stub

	}
}
