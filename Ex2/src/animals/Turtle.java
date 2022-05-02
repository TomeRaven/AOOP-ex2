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
public class Turtle extends Vegeterian{
	
	private int age=-1;
	
	public final static int defAge=1;
	public final static int minAge=0;
	public final static int maxAge=500;
	
	public static final double def_weight = 1;
	public static final Point def_location = new Point(80,0);
	

	
	public Turtle(int size, String color,int Hspeed,int Vspeed,ZooPanel pan)
	{
		super("Turtle",def_location,size,Hspeed,Vspeed,color,pan);
		
		this.setDiet(new Herbivore());
		this.setWeight(size*0.5);
		
		
	}
	
	public Turtle(String s)
	{
		this(s,def_location);

	}
	
	public Turtle(String s, Point p)
	{
		this(s,p,def_weight);

	}
	public Turtle(String s, Point p, double w)
	{
		this(s,p,w,defAge);
	}
	public Turtle(String s, Point p, double w, int a)
	{
		super(s,p);
		

		this.setWeight(w);
		this.setAge(a);
		this.setDiet(new Herbivore());
	}
	
	public void chew()
	{
	}
	
	public EFoodType getFoodtype()
	{
		
		return EFoodType.MEAT;
		
	}
	
	public boolean setAge(int a)
	{
		boolean x=true;
		
		if(a<minAge||a>maxAge)
			x= false;
		else
			this.age=a;
		
		
		if(this.age==-1) // constructor call -> if a isnt valid, age must be initialized with default value
		{
			x=true;
			this.age=defAge;
			

		}
		return x;
		
	}
	
	public int getAge() {
		
		
		return this.age;
		
	}
	
	public String toString()
	{
		return  "[ Turtle]: "+this.getAnimalName();
	}
	
	public String getPath() {
		switch(this.getColor())
		{
		case "Natural":
			return "assignment2_pictures//trt_n_1.png";
		case "Red":
			return "assignment2_pictures//trt_r_1.png";
		case "Blue":
			return "assignment2_pictures//trt_b_1.png";
		
		default:
			return null;
		}
		
	}

}
