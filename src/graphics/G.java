package graphics;

import items.Machine;
import items.Materiel;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import machines.Wire;
import data.Level;

public class G
{
	Level level;
	ImageManager imageManager = new ImageManager();
	
	JFrame window;
	Rectangle bounds;
	
	public G()
	{
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice device = env.getDefaultScreenDevice(); // gives access to whatever the graphics device is
		GraphicsConfiguration gc = device.getDefaultConfiguration();
		
		window = new JFrame();
		window.setIgnoreRepaint(true);
		window.setUndecorated(true);
		device.setFullScreenWindow(window);
		device.setDisplayMode(device.getDisplayMode());
		
		bounds = window.getBounds();
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
		imageManager.loadImages(level);
	}
	
	private void drawLevel(Graphics g)
	{
		
		// TODO draw background
		
		//draw wires
		for(Machine i: level.getMachines())
		{
			if(i instanceof Wire)
				i.draw(g, bounds);
		}
		
		//draw materiels
		for(Materiel i: level.getMateriels())
		{
			i.draw(g, bounds);
		}
		
		//draw machines
		for(Machine i: level.getMachines())
		{
			if(!(i instanceof Wire))
				i.draw(g, bounds);
		}
	}
	
	public Window getWindow()
	{
		return window;
	}
	
	public void setWindow(JFrame window)
	{
		this.window = window;
	}
	
	public static void main(String...args)
	{
		new G();
	}
}
