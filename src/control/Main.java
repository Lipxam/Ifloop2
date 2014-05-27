package control;

import graphics.G;

import java.awt.Window;

import machines.LaserOut;
import machines.Looper;
import machines.Wire;
import materiel.Water;
import data.Level;
import data.Location;

public class Main
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new Main();
	}
	
	Control control;
	G graphics;
	Window window;
	
	public Main()
	{
		
		// main loop
		try
		{
			graphics = new G();
			control = new Control(graphics);
			window = graphics.getWindow();
			
			control.setLevel(level0());
			while(true)
			{
				// get input
				// step program
				control.step();
				// redraw
				
				Thread.sleep(500);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			System.exit(0);
		}
	}
	
	public Level level0()
	{
		Level level = new Level(0);
		level.addItem(new Looper(new Location(6, 14)));
		level.addItem(new Wire(new Location(6, 13)));
		//level.addItem(new Wire(new Location(6, 12)));
		//level.addItem(new Wire(new Location(6, 11)));
		level.addItem(new LaserOut(new Location(6, 11)));
	//	level.addItem(new Water(new Location(5, 1)));
		
		return level;
	}
}
