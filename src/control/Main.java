package control;

import graphics.G;
import java.awt.Window;
import machines.*;
import data.Level;
import data.Location;

public class Main
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

	Control control;
	G graphics;
	Window window;
	
	public Main()
	{
		graphics = new G();
		control = new Control(graphics);
		window = graphics.getWindow();
		
		control.setLevel(level0());
		
		//main loop
		while(true)
		{
			//get input
			//step program
			//redraw
		}
	}
	
	public Level level0()
	{
		Level level = new Level(0);
		level.addItem(new Looper(new Location(3, 4)));
		level.addItem(new Wire(new Location(3, 3)));
		level.addItem(new Wire(new Location(3, 2)));
		level.addItem(new Wire(new Location(3, 1)));
		level.addItem(new Lightbulb(new Location(3, 1)));
		
		return level;
	}
}
