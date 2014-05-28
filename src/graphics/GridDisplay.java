package graphics;

import items.Machine;
import items.Materiel;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.image.BufferStrategy;

import machines.Wire;
import data.Grid;

public class GridDisplay extends EventListener
{
	private Grid grid;
	private Window window;
	private Rectangle bounds;
	
	public GridDisplay(Grid g, Window w)
	{
		window = w;
		grid = g;
		
	}
	
	
	
	public void draw(Graphics g, Rectangle bounds)
	{
		// draw wires
		g.setColor(Color.BLUE);
		g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);
		g.setColor(Color.BLACK);
		for(int i = 0; i < 15; i++)
		{
			g.drawRect(i*50, 0, 10, bounds.height);
		}
		for(int z = 0; z < 15; z++)
		{
			g.drawRect(0, z*50, bounds.width, 10);
		}
		
		
		
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
		