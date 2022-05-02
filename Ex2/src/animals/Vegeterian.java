package animals;

import graphics.ZooPanel;
import mobility.Point;

/**
 *   This class is meant to be a parent to animals with chew methods so makesound can be properly implemented

 * @author tomer handali 206751489
 *
 */
public abstract class Vegeterian extends Animal{
	
	
	public Vegeterian(String s,Point p,int size,int Hspeed,int Vspeed,String color, ZooPanel pan )
	{
		super(s,p,size,Hspeed,Vspeed,color,pan);
		
	}
	
	public Vegeterian(String s, Point p)
	{
		super(s,p);
	}

	public void makeSound()
	{
		chew();
		
	}
	
	public abstract void chew();
}
