package data;

import java.awt.Image;
import java.util.List;

public class Wire extends Machine implements Powered
{
	boolean active;
	boolean setActive;
	
	public Wire(Location loc)
	{
		super(loc);
	}
	
	public void step()
	{
		// TODO Auto-generated method stub
		
	}
	
	public void setActive(boolean a)
	{
		active = a;
	}
	
	public boolean isActive()
	{
		// TODO Auto-generated method stub
		return active;
		
	}

	@Override
	public Image getDisplayImage()
	{
		return getDefaultDisplayImage();
	}

	@Override
	public List<Materiel> step(List<Item> inputs)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
