package materiel;

import java.awt.Graphics;
import java.awt.Rectangle;
import data.*;

public class Water extends Materiel
{
	public Water(Location loc)
	{
		super(loc, new Direction(Direction.DOWN));
	}

	public void draw(Graphics g, Rectangle bounds)
	{
		Rectangle rect = mapGridtoPixels(bounds, loc.getX(), loc.getY());
		g.drawImage(imgs.get(0), rect.x, rect.y, rect.width, rect.height, null);
	}
}
