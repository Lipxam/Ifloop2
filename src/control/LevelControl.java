package control;

import items.*;
import java.util.*;
import data.Grid;
import data.Location;

public class LevelControl
{
	private Grid grid = new Grid();
	List<Machine> toolbar = new ArrayList<Machine>();
	
	private int levelNum;
	
	public LevelControl(int n)
	{
		levelNum = n;
	}
	
	public LevelControl()
	{
		this(0);
	}
	
	public void setLevel(int n)
	{
		levelNum = n;
		grid = loadLevel(n);
	}
	
	public void nextLevel()
	{
		setLevel(levelNum + 1);
	}
	
	public Grid getGrid()
	{
		return grid;
	}
	
	public Grid loadLevel(int num)
	{
		// TODO load the starting grid from a dat file
		return null;
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