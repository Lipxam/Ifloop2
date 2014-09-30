package data;


public interface Moveable
{
	boolean inMotion();
	
	//returns one of the 4 defined constants in Direciton: UP, DOWN, LEFT, RIGHT or -1 is not in motion
	int getMoveDirection();
}
