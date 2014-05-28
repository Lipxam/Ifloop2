package control;

import items.Machine;
import items.Materiel;
import machines.Wire;
import materiel.Electricity;
import data.Level;

public class ElectricityControl
{	
	Level level;
	
	public ElectricityControl(Level l)
	{
		level = l;
	}
	
	public void step()
	{
		for(Materiel m: level.getMateriels())
		{
			if(m instanceof Electricity)
			{
				Electricity e = (Electricity)m;
				
				boolean remove = true;
				for(Machine mac: level.getMachinesAtLoc(e.getLocation()))
				{
					if(mac instanceof Wire)
						remove = false;
				}
				
				if(remove)
				{
					level.removeItem(e);
				}
			}
		}
	}
}
