package items;

import java.util.ArrayList;
import java.util.List;
import data.Direction;

public abstract class Machine extends Item
{
	// TODO make input/output
	
<<<<<<< HEAD
	//list of accpeted inputs and outputs
	protected List<Class<? extends Materiel>> inputs, outputs;
	
	Direction orientation;
=======
		//list of accpeted inputs and outputs
		protected List<Class<? extends Materiel>> inputs, outputs;
		
		Direction orientation;
>>>>>>> FETCH_HEAD
	
	public Machine()
	{
		setInputs(new ArrayList<Class<? extends Materiel>>());
		outputs = new ArrayList<Class<? extends Materiel>>();
	}
	
	public abstract List<Materiel> step(List<Item> inputs);

	public List<Class<? extends Materiel>> getInputs()
	{
		return inputs;
	}

	public void setInputs(List<Class<? extends Materiel>> inputs)
	{
		this.inputs = inputs;
	}
}
