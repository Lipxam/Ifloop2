package data;

import items.*;
import java.util.*;

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

	public List<Item> getItems()
	{
		return grid.getItems();
	}

	public void addItem(Item i)
	{
		grid.addItem(i);
	}

	public void removeItem(Item i)
	{
		grid.removeItem(i);
	}

	public List<Item> getItemsAtLoc(Location loc)
	{
		return grid.getItemsAtLoc(loc);
	}

	public List<Materiel> getMateriels()
	{
		return grid.getMateriels();
	}

	public List<Machine> getMachines()
	{
		return grid.getMachines();
	}

	public Iterator<Item> iterator()
	{
		return grid.iterator();
	}

	public List<Machine> getMachinesAtLoc(Location loc)
	{
		return grid.getMachinesAtLoc(loc);
	}
	
	
}