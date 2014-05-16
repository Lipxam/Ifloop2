package graphics;

import java.awt.*;
import java.awt.image.BufferStrategy;
import control.LevelControl;
import data.Grid;

public class G
{
	LevelControl level = new LevelControl();
	ImageManager imageManager = new ImageManager();
	
	Window window;
	
	public G(LevelControl l)
	{
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice device = env.getDefaultScreenDevice(); // gives access to whatever the graphics device is
		GraphicsConfiguration gc = device.getDefaultConfiguration();
		
		level = l;
		
		window = new Window(null, gc);
		window.setIgnoreRepaint(true);
		device.setFullScreenWindow(window);
		
		Rectangle bounds = window.getBounds();
		window.createBufferStrategy(2);
		BufferStrategy strat = window.getBufferStrategy();
		
		Graphics g = strat.getDrawGraphics();
		if(!strat.contentsLost())
		{
			try
			{
				while(true)
				{	
					g.fillRect((int)(Math.random() * bounds.width), (int)(Math.random() * bounds.height), (int)(Math.random() * 10), (int)(Math.random() * 10));
					
					Thread.sleep(10);
				}
			}
			catch(InterruptedException ex)
			{}
			 
			strat.show();
			g.dispose();
		}
		
		window.setVisible(false);
		window.setVisible(true);
	}
	
	private void drawLevel(Graphics g)
	{
		Grid gr = level.getGrid();
		imageManager.loadImages(gr);
		
		//TODO draw background
		//TODO draw materiels
		//TODO draw machines
	}
	
	public Window getWindow()
	{
		return window;
	}

	public void setWindow(Window window)
	{
		this.window = window;
	}
	
	public static void main(String...args)
	{
		new G();
	}
}
