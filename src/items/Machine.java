package items;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import data.Direction;
import data.Location;

public abstract class Machine extends Item
{
	// TODO make input/output
	// list of accpeted inputs and outputs
	protected List<Class<? extends Materiel>> inputs1, outputs;
	
	protected Direction orientation = new Direction(0);
	
	boolean userPlaceable = false;
	
	public Machine(Location loc)
	{
		super(loc);
		inputs1 = new ArrayList<Class<? extends Materiel>>();
		outputs = new ArrayList<Class<? extends Materiel>>();
	}
	
	public void step()
	{}
	
	public abstract List<Materiel> step(List<Item> inputs);
	
	public void addInputType(String type)
	{
		try
		{
			
			inputs1.add((Class<? extends Materiel>) Class.forName(type));
		}
		catch(ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addOutputType(String type)
	{
		try
		{
			outputs.add((Class<? extends Materiel>) Class.forName(type));
		}
		catch(ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
