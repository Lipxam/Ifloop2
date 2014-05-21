package control;

import items.*;
import java.util.List;
import java.util.ListIterator;
import data.*;
import graphics.G;

public class Control
{	
	Level currentLevel;
	ElectricityControl eControl;
	G graphics;
	
	public Control(G g)
	{
		eControl = new ElectricityControl(currentLevel);
		graphics = g;
	}

	public void loadLevel(int n)
	{
		//TODO load n from dat file
		//currentLevel = *loaded level*
	}
	
	public void nextLevel()
	{
		loadLevel(getLevelNum() + 1);
	}
	
	public void reload()
	{
		loadLevel(getLevelNum());
	}

	public int getLevelNum()
	{
		return currentLevel.getNum();
	}
	
	public void step()
	{
		eControl.step();
		
		Grid grid = currentLevel.getGrid();
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
