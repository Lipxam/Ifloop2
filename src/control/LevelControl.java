package control;

import items.*;

public class LevelControl
{	
	Grid grid = new Grid();

	public void step()
	{
		for(Item i: grid.getItems())
		{
			i.step();
			
			if(i instanceof Materiel)
			{
				Materiel mat = (Materiel)i;
				
				//TODO remove materiel if applicable
			}
			else if(i instanceof Machine)
			{
				//TODO gather all materiels in i's location
				//TODO step i with inputs
				//TODO get outputs
			}
		}
	}
}
