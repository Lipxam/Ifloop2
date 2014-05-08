package control;

import items.Item;
import java.util.List;

public class LevelControl
{	
	List<Item> items;
	
	public void step()
	{
		for(Item i: items)
			i.step();
	}
}
