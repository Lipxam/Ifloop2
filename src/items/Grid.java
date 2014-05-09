package items;

import java.util.*;

public class Grid implements Iterable<Item>
{
	private List<Item> items;
	
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

	public Iterator<Item> iterator()
	{
		return items.iterator();
	}
}