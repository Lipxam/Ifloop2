package items;

import java.util.ArrayList;
import java.util.List;
import data.Direction;

public abstract class Machine extends Item
{
	// TODO make input/output
	// list of accpeted inputs and outputs
	protected List<Class<? extends Materiel>> inputs, outputs;
	
	Direction orientation;
	
	public Machine()
	{
		inputs = new ArrayList<Class<? extends Materiel>>();
		outputs = new ArrayList<Class<? extends Materiel>>();
	}
	
	public void step()
	{}
	
	public abstract List<Materiel> step(List<Item> inputs);
	
	public void addInputType(String type)
	{
		try
		{
			inputs.add((Class<? extends Materiel>)Class.forName(type));
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addOutputType(String type)
	{
		try
		{
			outputs.add((Class<? extends Materiel>)Class.forName(type));
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
