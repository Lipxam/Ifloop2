package materiel;

import items.Materiel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import data.Direction;
import data.Location;

public class Laser extends Materiel
{
	public Laser(Location l, Direction d)
	{
		super(l, d);
	}

	public void draw(Graphics g, Rectangle bounds)
	{
		Rectangle rect = mapGridtoPixels(bounds, loc.getX(), loc.getY());
		g.setColor(Color.BLACK);
		g.fillRect(rect.x + 5, rect.y + 5, rect.width - 10, rect.height - 10);
	}
}
