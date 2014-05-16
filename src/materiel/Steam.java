package materiel;

import data.Direction;
import items.Materiel;

public class Steam extends Materiel
{
	public Steam()
	{
		super(new Direction(Direction.UP));
	}
}
