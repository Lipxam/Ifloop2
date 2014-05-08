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
			
			//duplicate materiels
			if(i instanceof Materiel)
			{
				Materiel mat = (Materiel)i;
				
				items.add(mat.stepChild());
			}
		}
	}
}
