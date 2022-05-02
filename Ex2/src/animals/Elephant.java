package animals;

import food.EFoodType;
import graphics.ZooPanel;
import diet.*;
import mobility.*;
/**
 * 
 * @author tomer handali 206751489
 *
 */
public class Elephant extends Vegeterian{
	private double trunkLength=0;
	
	public final static double minTrunkLength=0.5;
	public final static double maxTrunkLength=3;
	public final static double defTrunkLength=1.0;
	
	public static final double def_weight = 500;
	public static final Point def_location = new Point(50,90);

	
	public Elephant(int size, String color,int Hspeed,int Vspeed, ZooPanel pan)
	{
		super("Elephant",def_location,size,Hspeed,Vspeed,color,pan);
		
		this.setDiet(new Herbivore());
		this.setWeight(size*1.0);
		
		
	}
	
	public Elephant(String s)
	{
		this(s,def_location);
		

	}
	
	public Elephant(String s, Point p)
	{
		this(s,p,def_weight);		

	}
	public Elephant(String s, Point p, double w)
	{
		this(s,p,w,defTrunkLength);
	}
	
	public Elephant(String s, Point p, double w, double t)
	{
		super(s,p);
		
		
		this.setWeight(w);
		this.setTrunkLength(t);
		this.setDiet(new Herbivore());
		
	}
	
	public void chew()
	{
	}
	
	public EFoodType getFoodtype()
	{
		
		return EFoodType.MEAT;
		
	}
	
	public boolean setTrunkLength(double t)
	{
		boolean x=true;
		
		if(t<minTrunkLength||t>maxTrunkLength)
			x = false;
		else
		 this.trunkLength=t;
		
		
		if(this.trunkLength==0&&x==false) // constructor call -> must be initialized with default value
		{
			this.trunkLength=defTrunkLength;
			x=true;
		}
		
		return x;
		
	}
	
	public double getTrunkLength() {
		
		
		return this.trunkLength;
		
	}
	
	public String toString()
	{
		return  "[ Elephant]: "+this.getAnimalName();
	}

	@Override
	public String getPath() {
		switch(this.getColor())
		{
		case "Natural":
			return "assignment2_pictures//elf_n_1.png";
		case "Red":
			return "assignment2_pictures//elf_r_1.png";
		case "Blue":
			return "assignment2_pictures//elf_b_1.png";
		
		default:
			return null;
		}
		
	}
}
