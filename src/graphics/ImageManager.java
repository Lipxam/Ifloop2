package graphics;

import items.Item;
import java.awt.Image;
import java.util.HashMap;
import java.util.List;
import data.Grid;
import data.Level;

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
		List<Image> imgList = map.get(type);
	}
	
	public void loadImages(Level l)
	{
		for(Item i: l.getItems())
		{
			loadImages(i.getClass());
		}
		for(Item i: l.getToolbar())
		{
			loadImages(i.getClass());
		}
	}
	
	public List<Image> getImages(Class<? extends Item> type)
	{
		return map.get(type);
	}
}
