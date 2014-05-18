package control;

import graphics.G;
import java.awt.Window;

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
		
		
		//main loop
		while(true)
		{
			//get input
			//step program
			//redraw
		}
	}
}
