package graphics;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import control.Level;
import data.Grid;

public class G
{
	Level level;
	ImageManager imageManager = new ImageManager();
	
	Window window;
	
	public G()
	{
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice device = env.getDefaultScreenDevice(); // gives access to whatever the graphics device is
		GraphicsConfiguration gc = device.getDefaultConfiguration();
		
		window = new Window(null, gc);
		window.setIgnoreRepaint(true);
		device.setFullScreenWindow(window);
		
		Rectangle bounds = window.getBounds();
		window.createBufferStrategy(2);
		
		BufferStrategy strat = window.getBufferStrategy();
		Graphics g = strat.getDrawGraphics();
		
		try
		{
			Image splashpng = ImageIO.read(new File("img/splash_text.png"));
			int imgW = (int) (640 * 1.8), imgH = (int) (400 * 2);
			
			g.setColor(Color.WHITE);
			g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
			g.setColor(Color.BLACK);
			for(int i = 0; i < 200; i++)
			{
				if(!strat.contentsLost())
				{
					int rectWidth = (int) (Math.random() * 50) + 20, rectHeight = (int) (Math.random() * 50) + 20;
					Color c = new Color((int) (Math.random() * 256), (int) (Math.random() * 256),
					(int) (Math.random() * 256));
					for(int j = 0; j < i / 25; j++)
					{
						c = c.darker();
						rectWidth += 20;
						rectHeight += 20;
					}
					g.setColor(c);
					
					for(int j = 0; j < 3; j++)
						g.fillRect((int) (Math.random() * (bounds.width + 100)) - 100,
						(int) (Math.random() * (bounds.height + 100)) - 100, rectWidth, rectHeight);
					
					g.drawImage(splashpng, bounds.width / 2 - imgW / 2, bounds.height / 2 - imgH / 2, imgW + 20, imgH,
					null);
					
					Thread.sleep(10);
				}
			}
			for(int i = 0; i < 100; i++)
			{
				g = strat.getDrawGraphics();

				g.setColor(new Color(0, 0, 0, i));
				g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
				g.drawImage(splashpng, bounds.width / 2 - imgW / 2, bounds.height / 2 - imgH / 2, imgW + 20, imgH,
				null);
				strat.show();
				g.dispose();
			}
			
			strat.show();
			g.dispose();
		}
		catch(IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(InterruptedException ex)
		{}
		
		while(true)
		{
			g = strat.getDrawGraphics();
			if(!strat.contentsLost())
			{
				try
				{
					
					strat.show();
					g.dispose();
					
					Thread.sleep(10);
				}
				
				catch(InterruptedException ex)
				{}
			}
		}
	}
	
	public void setLevel(Level l)
	{
		level = l;
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
		new G();
	}
}
