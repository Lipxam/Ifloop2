package graphics;

import items.*;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;
import data.*;

public class ImageManager
{
	HashMap<Class<? extends Item>, List<Image>> map;
	
	public ImageManager()
	{
		map = new HashMap<Class<? extends Item>, List<Image>>();
	}
	
	public void loadImages(Class<? extends Item> type)
	{
		if(map.containsKey(type))
			return;
		//TODO load all the images associated with this class into the map
		List<Image> imgList = new ArrayList<Image>();
		
		
		for(File f: new File("img").listFiles())
		{
			//this file is of type type
			if(f.getPath().substring(f.getPath().lastIndexOf('/')).contains(type.getSimpleName().toLowerCase()))
			{
				System.out.println("loaded "+type.getSimpleName().toLowerCase());
				try
				{
					imgList.add(ImageIO.read(f));
				}
				catch(IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		map.put(type, imgList);
	}
	
	private List<File> listAllFiles(File dir)
	{ 
		//needs to test if machine and load it's outputs if it is
		List<File> result = new ArrayList<File>();
		if(dir.isDirectory())
		{
			for(File f: dir.listFiles())
			{
				if(f.isFile())
					result.add(f);
				else if(f.isDirectory())
					result.addAll(listAllFiles(f));
			}
		}
		
		return result;
	}
	
	public void loadImages(Level l)
	{
		for(Item i: l.getItems())
		{
			loadImages(i.getClass());
			if(i instanceof Machine)
			{
				Machine m = (Machine)i;
				for(Class<? extends Item> p: m.requiredOutputs)
				{
					loadImages(p);
				}
			}
		}
		for(Item i: l.getToolbar())
		{
			loadImages(i.getClass());
		}
	}
	
	public List<Image> getImages(Class<? extends Item> class1)
	{
		return map.get(class1);
	}
}
