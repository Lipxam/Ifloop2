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
		int count = 0;
		for(Materiel m: level.getMateriels())
		{
			if(m instanceof Electricity)
			{
				count++;
				System.out.println(m.getLocation());
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
					//System.out.println("Removed Electricity at " + e.getLocation());
				}
			}
		}
	}
}
