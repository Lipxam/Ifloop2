package graphics;

import items.Machine;
import items.Materiel;
import java.awt.Graphics;
import java.awt.Rectangle;
import machines.Wire;
import data.Grid;

public class GridDisplay
{
	private Grid grid;
	private Window window;
	
	public GridDisplay(Grid g)
	{
		grid = g;
	}
	
	public void draw(Graphics g, Rectangle bounds)
	{
		// draw wires
		for(Machine i: grid.getMachines())
		{
			if(i instanceof Wire)
				i.draw(g, bounds);
		}
		
		// draw materiels
		for(Materiel i: grid.getMateriels())
		{
			i.draw(g, bounds);
		}
		
		// draw machines
		for(Machine i: grid.getMachines())
		{
			if(!(i instanceof Wire))
				i.draw(g, bounds);
		}
		
	}

	public Grid getGrid()
	{
		return grid;
	}

	public void setGrid(Grid grid)
	{
		this.grid = grid;
	}
}
