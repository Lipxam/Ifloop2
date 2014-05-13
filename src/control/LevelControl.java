package control;

import items.*;
import java.util.List;
import java.util.ListIterator;
import data.Grid;
import data.Location;

public class LevelControl
{	
	Grid grid = new Grid();

	public void step()
	{
		for(Item i: grid.getItems())
		{
			Location loc = i.getLocation();
			if(i instanceof Machine)
			{
				//TODO gather all materiels in i's location
				List<Item> items = grid.getItemsAtLoc(loc);
				ListIterator<Item> iterator = items.listIterator();
				while(iterator.hasNext())
				{
					if(!(iterator.next() instanceof Materiel))
						iterator.remove();
				}
				
				Machine mac = (Machine)i;
				List<Materiel> outputs = mac.step(items);
				
				//release outputs into world
				for(Materiel m: outputs)
				{
					grid.addItem(m);
				}
			}
			else if(i instanceof Materiel)
			{
				Materiel mat = (Materiel)i;
				
				//TODO remove materiel if applicable
				for(Item x: grid.getItemsAtLoc(loc))
				{
					if(x instanceof Machine)
						grid.removeItem(mat);
				}
			}
		}
	}
}
//FIX THIS SHIT