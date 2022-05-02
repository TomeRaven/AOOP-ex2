package animals;

import graphics.ZooPanel;
import mobility.Point;
/**
 * This class is meant to be a parent to animals with roar methods so makesound can be properly implemented
 * @author tomer handali 206751489 
 *
 */
public abstract class Predator extends Animal {

	public Predator(String s,Point p,int size,int Hspeed,int Vspeed,String color, ZooPanel pan )
	{
		super(s,p,size,Hspeed,Vspeed,color,pan);
		
	}
	
	public Predator(String s, Point p) {
		super(s, p);
		
	}
	
	public void makeSound()
	{
		roar();
		
	}
	
	public abstract void roar();

}
