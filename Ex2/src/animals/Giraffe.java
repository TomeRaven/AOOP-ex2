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
public class Giraffe extends Vegeterian{
	
	private double neckLength=0;
	
	public final static double minNeckLength=1.0;
	public final static double maxNeckLength=2.5;
	public final static double defNeckLength=1.5;
	public static final double def_weight = 450;
	public static final Point def_location = new Point(50,0);
	
	
	public Giraffe(int size, String color,int Hspeed,int Vspeed, ZooPanel pan)
	{
		super("Giraffe",def_location,size,Hspeed,Vspeed,color,pan);
		
		this.setDiet(new Herbivore());
		this.setWeight(size*2.2);
		
		
	}
	
	public Giraffe(String s)
	{
		this(s,def_location);

	}
	
	public Giraffe(String s, Point p)
	{
		this(s,p,def_weight);

	}
	
	public Giraffe(String s, Point p, double w)
	{
		this(s,p,w,defNeckLength);
	}
	
	public Giraffe(String s, Point p, double w, double n)
	{
		super(s,p);
		

		this.setWeight(w);
		
		this.setNeckLength(n);
		
		this.setDiet(new Herbivore());
		
	}
	
	public void chew()
	{
	}
	
	public EFoodType getFoodtype()
	{
		
		return EFoodType.MEAT;
		
	}
	
	public boolean setNeckLength(double t)
	{
		boolean x=true;
		
		if(t<minNeckLength||t>maxNeckLength)
			x = false;
		else
			this.neckLength=t;
		
		
		if(this.neckLength==0&&x==false) // constructor call -> must be initialized with default value
		{
			this.neckLength=defNeckLength;
			x=true;

		}
		
		return x;
		
	}
	
	public double getNeckLength() {
		
		
		return this.neckLength;
		
	}
	
	public String toString()
	{
		return  "[ Giraffe]: "+this.getAnimalName();
	}
	
	public String getPath() {
		switch(this.getColor())
		{
		case "Natural":
			return "assignment2_pictures//grf_n_1.png";
		case "Red":
			return "assignment2_pictures//grf_r_1.png";
		case "Blue":
			return "assignment2_pictures//grf_b_1.png";
		
		default:
			return null;
		}
		
	}

}
