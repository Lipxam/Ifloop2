package data;

import java.io.*;
import machines.Looper;

public class LevelCreator
{
	public static void main(String...args)
	{
		Level l = new Level(0);
		l.addItem(new Looper(new Location(6, 7)));
		
		LevelCreator creator = new LevelCreator(new File("level_data/level0.dat"));
		System.out.println(creator.level);
	}
	
	Level level;
	String levelDir = "level_data";
	
	public LevelCreator(int number)
	{
		this(new Level(number));
	}
	
	public LevelCreator(Level original)
	{
		level = original;
	}
	
	public LevelCreator(File original)
	{
		level = loadLevel(original);
	}
	
	public Level loadLevel(File file)
	{
		Level result = null;
		try
		{
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
			result = (Level)(input.readObject());
			
			input.close();
		}
		catch(FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public void save()
	{
		String ending = "";
		String path = levelDir + "/level" + level.getNum();
		
		int n = 1;
		while(new File(path + ending).exists())
		{
			ending = "_" + n;
		}
		
		File saveFile = new File(path + ending + ".dat");
		
		try
		{
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(saveFile));
			synchronized(level)
			{
				output.writeObject(level);
			}
			output.close();
		}
		catch(FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Level getLevel()
	{
		return level;
	}
}
