package items;

import java.util.ArrayList;
import java.util.List;

public abstract class Machine extends Item
{
	// TODO make input/output
	
	//list of accpeted inputs and outputs
	List<Class<? extends Materiel>> inputs, outputs;
	
	Direction orientation;
	
	public Machine()
	{
		inputs = new ArrayList<Class<? extends Materiel>>();
		outputs = new ArrayList<Class<? extends Materiel>>();
	}
	
	public abstract List<Materiel> step(List<Item> inputs);
}
