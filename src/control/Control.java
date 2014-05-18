package control;

import graphics.G;

public class Control
{	
	Level currentLevel;
	G graphics;
	
	public Control(G g)
	{
		graphics = g;
	}

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
