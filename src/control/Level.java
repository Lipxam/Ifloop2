package control;

import items.*;
import java.util.*;
import data.Grid;
import data.Location;

public class Level
{
	private Grid grid = new Grid();
	List<Machine> toolbar = new ArrayList<Machine>();
	
	private int levelNum;
	
	public Level(int n)
	{
		levelNum = n;
	}
	
	public void setNum(int n)
	{
		levelNum = n;
	}
	
	public int getNum()
	{
		return levelNum;
	}
	
	public Grid getGrid()
	{
		return grid;
	}
	
	public List<Machine> getToolbar()
	{
		return toolbar;
	}
	
	public void step()
	{
		for(Machine i: grid.getMachines())
		{
			// gather all materiels in i's location
			List<Item> items = grid.getItemsAtLoc(i.getLocation());
			ListIterator<Item> iterator = items.listIterator();
			while(iterator.hasNext())
			{
				if(!(iterator.next() instanceof Materiel))
					iterator.remove();
			}
			
			Machine mac = (Machine) i;
			List<Materiel> outputs = mac.step(items);
			
			// release outputs into world
			for(Materiel m: outputs)
			{
				grid.addItem(m);
			}
		}
		
		for(Materiel i: grid.getMateriels())
		{
			Location loc = i.getLocation();
			// TODO remove materiel if applicable
			for(Machine x: grid.getMachinesAtLoc(loc))
			{
				if(!i.passesThrough(x))
				{
					grid.removeItem(i);
					break;
				}
			}
			
		}
	}
}