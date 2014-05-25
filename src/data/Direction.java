package data;

public class Direction
{
	public static final int LEFT = 0;
	public static final int RIGHT = 1;
	public static final int UP = 2;
	public static final int DOWN = 3;
	int direction;
	public Direction(int d)
	{
		d = direction;
	}
	@Override
	public String toString()
	{
		String s = "";
		switch(direction)
		{
			case LEFT: s += "LEFT"; break;
			case RIGHT: s += "RIGHT"; break;
			case UP: s += "UP"; break;
			case DOWN: s += "DOWN"; break;
			
		}
		
		return "Direction " + s;
	}
}
