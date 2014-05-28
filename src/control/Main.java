package control;

import graphics.G;
import items.Machine;
import items.Powered;
import java.awt.Window;
import machines.*;
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
			int i = 0;
			while(true)
			{
				if(i >= 6)
				{
					for(Machine m: control.currentLevel.getMachines())
						if(m instanceof Looper)
							((Powered)m).setActive(false);
				}
				
				// get input
				// step program
				control.step();
				i++;
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
<<<<<<< HEAD
		level.addItem(new Wire(new Location(6, 7)));
		level.addItem(new Wire(new Location(6, 13)));
		level.addItem(new Wire(new Location(6, 12)));
		level.addItem(new LaserOut(new Location(6, 12)));
		level.addItem(new LaserOut(new Location(6, 6)));
=======
		level.addItem(new Wire(new Location(6, 13)));
		level.addItem(new Wire(new Location(6, 12)));
		level.addItem(new Wire(new Location(6, 11)));
		level.addItem(new LaserOut(new Location(6, 11)));
		level.addItem(new LaserOut(new Location(6, 9)));
>>>>>>> FETCH_HEAD
	//	level.addItem(new Water(new Location(5, 1)));
		
		return level;
	}
}
