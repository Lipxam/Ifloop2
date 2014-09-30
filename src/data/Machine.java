package data;

import java.util.ArrayList;
import java.util.List;

public abstract class Machine extends Item
{
	//a class representing a possible output for this machine
	//and the inputs required to generate that output
	static class OutputRequirement
	{
		Class<? extends Materiel> output;
		List<Class<? extends Materiel>> requiredInputs;
		
		public OutputRequirement(Class<? extends Materiel> o)
		{
			output = o;
		}
		
		public void addRequiredInput(Class<? extends Materiel> i)
		{
			if(requiredInputs.contains(i))
				throw new RuntimeException("List Already Contains " + i.getSimpleName());
			
			requiredInputs.add(i);
		}
	}
	 

	public List<OutputRequirement> outputs;
	
	//one of the four defined constants in Direction class
	protected int orientation;
	
	boolean userPlaceable = false;
	
	public Machine(Location loc)
	{
		super(loc);
		outputs = new ArrayList<OutputRequirement>();
	}
	
	public void step()
	{}
	
	public abstract List<Materiel> step(List<Item> inputs);
	
	public void addOutputRequirement(OutputRequirement r)
	{
		outputs.add(r);
	}
	
	public void addOutputRequirement(Class<? extends Materiel> output, Class<? extends Materiel>...inputs)
	{
		OutputRequirement r = new OutputRequirement(output);
		
		for(Class<? extends Materiel> c: inputs)
			r.addRequiredInput(c);
	}
}
