package graphics;

import java.awt.*;
import java.awt.image.BufferStrategy;
import control.Level;
import data.Grid;

public class G
{
	Level level = new Level();
	ImageManager imageManager = new ImageManager();
	
	Window window;
	
	public G(Level l)
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
		
		while(true)
		{
			Graphics g = strat.getDrawGraphics();
			if(!strat.contentsLost())
			{
				try
				{
					
					g.fillRect((int) (Math.random() * (bounds.width + 100)) - 100,
					(int) (Math.random() * (bounds.height + 100)) - 100, (int) (Math.random() * 100),
					(int) (Math.random() * 100));
					
					Thread.sleep(10);
				}
				
				catch(InterruptedException ex)
				{}
			}
		}
		
		strat.show();
		g.dispose();
		
		window.setVisible(false);
		window.setVisible(true);
	}
	
	private void drawLevel(Graphics g)
	{
		Grid gr = level.getGrid();
		imageManager.loadImages(gr);
		
		// TODO draw background
		// TODO draw materiels
		// TODO draw machines
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
		new G(null);
	}
}
