package control;

public class Control
{	
	Level currentLevel;
	
	public void loadLevel(int n)
	{
		//TODO load n from dat file
		//currentLevel = *loaded level*
	}
	
	public void nextLevel()
	{
		loadLevel(getLevelNum() + 1);
	}
	
	public void reload()
	{
		loadLevel(getLevelNum());
	}

	public int getLevelNum()
	{
		return currentLevel.getNum();
	}
}
