package control;

import items.Machine;
import items.Materiel;
import java.util.List;
import machines.Wire;
import materiel.Electricity;
import data.Level;
import data.Location;

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
				
				for(Location loc: e.getLocation().getAdjacentLocs())
				{
					List<Machine> machines = level.getMachinesAtLoc(loc);
					for(Machine mac: machines)
					{
						if(mac instanceof Wire)
						{
							level.addItem(new Electricity(e.getLocation().directionTowards(loc), loc));
						}
					}
				}
			}
		}
	}
}
