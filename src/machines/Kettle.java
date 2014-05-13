package machines;

import items.Item;
import items.Machine;
import items.Materiel;

import java.util.ArrayList;
import java.util.List;

public class Kettle extends Machine
{
	public Kettle()
	{
		try
		{
			inputs.add((Class<? extends Materiel>)Class.forName("Electricity"));
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try
		{
			outputs.add((Class<? extends Materiel>)Class.forName("Steam"));
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
}
