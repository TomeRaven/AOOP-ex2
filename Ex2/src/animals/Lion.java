package animals;
import java.util.Random;
import diet.*;
import food.EFoodType;
import graphics.ZooPanel;
import mobility.*;

/**
 * 
 * @author tomer handali 206751489
 *
 */
public class Lion extends Predator{
	
	private int scarCount;
	
	public static final int defScars=0;
	
	public static final double def_weight = 408.2;
	public static final Point def_location = new Point(20,0);
	
	public Lion(int size, String color,int Hspeed,int Vspeed,ZooPanel pan)
	{
		super("Lion",def_location,size,Hspeed,Vspeed,color,pan);
		
		this.setDiet(new Carnivore());
		this.setWeight(size*0.8);
		
		
	}
	
	public Lion(String s)
	{
		this(s,def_location);
		
	}
	
	public Lion(String s, Point p)
	{
		this(s,p,def_weight);

	}
	public Lion(String s, Point p,double w)
	{
		this(s,p,w,defScars);
		
	}
	public Lion(String s, Point p, double w, int scars)
	{
		super(s,p);
		

		this.setWeight(w);
		this.setScars(scars);
		this.setDiet(new Carnivore());
	}
	
	
	public void roar()
	{
		addScar();
	}
	
	public EFoodType getFoodtype()
	{
		
		return EFoodType.NOTFOOD;
		
	}
	
	public void addScar()
	{
		Random rand = new Random();
		int guess = rand.nextInt(2);
		if (guess==1)
			setScars(this.scarCount+1);
			
	}
	
	private boolean setScars(int s)
	{
		
		return true;
	}
	
	public int getScars() {
		
		
		return this.scarCount;
		
	}
	
	public String toString()
	{
		return "[ Lion]: "+this.getAnimalName();
	}

	public String getPath() {
		switch(this.getColor())
		{
		case "Natural":
			return "assignment2_pictures//lio_n_1.png";
		case "Red":
			return "assignment2_pictures//lio_r_1.png";
		case "Blue":
			return "assignment2_pictures//lio_b_1.png";
		
		default:
			return null;
		}
		
	}
}
