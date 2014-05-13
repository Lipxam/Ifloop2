package machines;

import items.Item;
import items.Machine;
import items.Materiel;

import java.util.List;

public class Kettle extends Machine
{
	public Kettle()
	{
		inputs.add(Class.forName("Water"));
	}
	public List<Class<? extends Materiel>> step(List<Item> inputs)
	{
		return outputs;
	}
}
