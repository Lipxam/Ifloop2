package machines;

import java.util.ArrayList;
import java.util.List;

import items.Item;
import items.Machine;
import items.Materiel;

public class Wire extends Machine
{
	public Wire()
	{
		addInputType("Electricity");
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
	@Override
	public void step()
	{
		// TODO Auto-generated method stub
		
	}
}
