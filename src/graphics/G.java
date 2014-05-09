package graphics;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class G
{
	public G()
	{
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice device = env.getDefaultScreenDevice(); // gives access to whatever the graphics device is
		GraphicsConfiguration gc = device.getDefaultConfiguration();
		
		Window window = new Window(null, gc);
		window.setIgnoreRepaint(true);
		device.setFullScreenWindow(window);
		
		Rectangle bounds = window.getBounds();
		window.createBufferStrategy(2);
		BufferStrategy strat = window.getBufferStrategy();
		
		Graphics g = strat.getDrawGraphics();
		if(!strat.contentsLost())
		{
			// drawing in here
			g.setColor(Color.RED);
			g.fillRect(0, 0, bounds.width, bounds.height);
			
			strat.show();
			g.dispose();
		}
		
		window.setVisible(false);
		window.setVisible(true);
	}
}
