package control;

import items.Item;
import items.Materiel;
import java.util.List;

public class LevelControl
{	
	List<Item> items;
	
	public void step()
	{
		for(Item i: items)
		{
			i.step();
			
			if(i instanceof Materiel)
			{
				Materiel mat = (Materiel)i;
				
				//TODO move materiel if applicable
			}
		}
	}
}
