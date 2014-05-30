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
		g.drawImage(imgs.get(0), rect.x, rect.y, rect.width, rect.height, null);
	}
}
