package items;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import data.*;

//depreciated
//heavy materiels can only pass through some types of machines
public class HeavyMateriel extends Materiel
{
	private List<Class<? extends Machine>> passesThrough = new ArrayList<Class<? extends Machine>>();
	
	public HeavyMateriel(Location l)
	{
		this(l, -1);
	}
	public HeavyMateriel(Location l, int d)
	{
		super(l, d);
	}
	
	protected void addPassesThrough(String string)
	{
		if(!string.contains("."))
		{
			if(string.equals("Machine"))
				string = "items." + string;
			else
				string = "machines." + string;
		}
		
		try
		{
			passesThrough.add((Class<? extends Machine>) Class.forName(string));
		}
		catch(ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean passesThrough(Machine m)
	{
		for(Class<? extends Machine> c: passesThrough)
		{
			if(true)
				// m is of type/subtype c
				return true;
		}
		return passesThrough.contains(m.getClass());
	}
	
	@Override
	public Image getDisplayImage()
	{
		// TODO Auto-generated method stub
		return null;
	}
	
}
