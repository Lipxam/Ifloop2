package data;

import java.io.Serializable;
import java.util.*;

public class Grid implements Iterable<Item>, Serializable
{
	//accessed only by same package
	List<Item> items;
	
	int cols = 15, rows = 20;
	
	public Grid()
	{
		items = new ArrayList<Item>();
	}
	
	public List<Item> getItems()
	{
		return items;
	}
	
	public void addItem(Item i)
	{
		items.add(i);
	}
	
	public void removeItem(Item i)
	{
		items.remove(i);
	}
	
	public List<Item> getItemsAtLoc(Location loc)
	{
		List<Item> result = new ArrayList<Item>();
		for(Item i: items) 
		{
			if(i.getLocation().equals(loc))
				result.add(i);
		}
		return result;
	}
	
	public List<Materiel> getMateriels()
	{
		List<Materiel> result = new ArrayList<Materiel>();
		for(Item i: this)
		{
			if(i instanceof Materiel)
				result.add((Materiel)i);
		}
		
		return result;
	}

	public List<Machine> getMachines()
	{
		List<Machine> result = new ArrayList<Machine>();
		for(Item i: this)
		{
			if(i instanceof Machine)
				result.add((Machine)i);
		}
		
		return result;
	}
	
	public Iterator<Item> iterator()
	{
		return items.iterator();
	}

	public List<Machine> getMachinesAtLoc(Location loc)
	{
		List<Machine> result = new ArrayList<Machine>();
		for(Item i: this)
		{
			if(i instanceof Machine && i.getLocation().equals(loc))
				result.add((Machine)i);
		}
		
		return result;
	}

	public int getNumCols()
	{
		return cols;
	}

	public int getNumRows()
	{
		return rows;
	}
	
}