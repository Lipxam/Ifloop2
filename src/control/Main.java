package control;

import graphics.G;
import java.awt.Window;

public class Main
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

	LevelControl control;
	G graphics;
	Window window;
	
	public Main()
	{
		control = new LevelControl();
		graphics = new G(control);
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
