package animals;

import food.*;
import graphics.ZooPanel;
import diet.*;
import mobility.*;

/**
 * 
 * @author tomer handali 206751489
 *
 */
public class Bear extends Predator {
	private String furColor=null;
	
	public final static String[] furs = {"GRAY","BLACK","WHITE"};
	public final static String defFur=new String("GRAY");
	public static final double def_weight = 308.2;
	public static final Point def_location = new Point(100,5);
	
	
	public Bear(int size, String color,int Hspeed,int Vspeed, ZooPanel pan)
	{
		super("Bear",def_location,size,Hspeed,Vspeed,color,pan);
		
		this.setDiet(new Omnivore());
		this.setWeight(size*1.5);
		
		
	}
	
	public Bear(String s)
	{
		this(s,def_location);
		
	}
	
	
	public Bear(String s, Point p)
	{
		this(s,p,def_weight);
		
	}
	public Bear(String s, Point p, double w)
	{
		this(s,p,w,defFur);
	}
	
	public Bear(String s, Point p, double w, String f)
	{
		super(s,p);
		
		
		this.setFurColor(f);
		this.setWeight(w);
		this.setDiet(new Omnivore());
		
	}
	
	
	public void roar()
	{
	}
	
	public EFoodType getFoodtype()
	{
		
		return EFoodType.MEAT;
		
	}
	
	public boolean setFurColor(String f)
	{
		boolean x=false;
		
		for(int i=0;i<furs.length;++i)
			if(furs[i]==f) 
			{
				this.furColor=f;
				x = true;
				break;
			}
			
		
		if(this.furColor==null&&x==false) // constructor call -> must be initialized with default value
		{
			this.furColor=defFur;
			x=true;
		}

		return x;
		
	}
	
	public String getFurColor() {
		
		
		return this.furColor;
		
	}
	
	public String toString()
	{
		return  "[ Bear]: "+this.getAnimalName();
	}



	@Override
	public String getPath() {
		switch(this.getColor())
		{
		case "Natural":
			return "assignment2_pictures//bea_n_1.png";
		case "Red":
			return "assignment2_pictures//bea_r_1.png";
		case "Blue":
			return "assignment2_pictures//bea_b_1.png";
		
		default:
			return null;
		}
		
		
	}

}
