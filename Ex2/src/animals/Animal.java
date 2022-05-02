package animals;
import graphics.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import diet.*;
import food.*;
import mobility.*;
/**
 * 
 * @author tomer handali 206751489
 *
 */
public abstract class Animal extends Mobile implements IEdible,IDrawable,IAnimalBehavior{
	
	private String name;
	private double weight=0;
	private IDiet diet;
	
	private final int EAT_DISTANCE = 10;
	private int size;
	private String col;
	private int horSpeed;
	private int verSpeed;
	private boolean coordChanged;
	private Thread thread;
	private int x_dir=1;
	private int y_dir=1;
	private int eatCount;
	private ZooPanel pan;
	private BufferedImage img1, img2;
	
	
	public Animal(String s,Point p,int size,int Hspeed,int Vspeed,String color, ZooPanel pan)
	{
		
		super(p);
		this.name=s;
		this.size=size;
		this.horSpeed=Hspeed;
		this.verSpeed=Vspeed;
		this.col=color;
		this.coordChanged=false;
		this.eatCount=0;
		this.pan=pan;
		
	}
	
	public Animal(String s, Point p)
	{
		super(p);
		setName(s);
		
	}
	
	
	private boolean setName(String s) {
		this.name=s;
		return true;
	}
	
	
	public double getWeight() {
		
		
		return this.weight;
		
	}
	
	public String getAnimalName() {
		
		//MessageUtility.logGetter(this.name, "getName", this.name);
		
		return this.name;
		
	}
	
	public boolean setWeight(double w) 
	{
		boolean x=true;
		
		if(w<0)
			x=false;
		else
			this.weight=w;
		
		
		
		return x;
	}
	
	protected boolean setDiet(IDiet d)
	{
		this.diet=d;
		
		return true;
		
	}
	
	public abstract EFoodType getFoodtype();
	
	public abstract void makeSound();
	
	public boolean eat(IEdible other)
	{
		boolean x=true;
		double wadd=diet.eat(this, other);
		
		if(wadd==0)
			x = false;
		else
		{
			this.setWeight(this.weight+wadd);
			makeSound();
		}
		
		
		return x;
	}
	
	public double move(Point p)
	{
		double d=super.move(p);
		
		double w=this.getWeight();
		
		this.setWeight(w-(d*w*0.00025));
		
		this.coordChanged=true;
		
		boolean x= (d==0?false:true);
		
		
		return d;
	}
	
	
	public int getEatDistance() {return this.EAT_DISTANCE;}
	
	@Override
	public String getColor()
	{
		
		return col;
	}
	
	@Override
	public int getEatCount() {
		// TODO Auto-generated method stub
		return eatCount;
	}
	
	@Override
	public void eatInc() {
		eatCount++;
		
	}
	
	public int getSize() {return this.size;}
	
	public boolean getChanges () {return this.coordChanged;}
	public void setChanges (boolean state) {this.coordChanged=state;}
	
	public int getHspeed() {return this.horSpeed;}
	public int getVspeed() {return this.verSpeed;}
	
	public void loadImages(String nm) {
		
		BufferedImage img = null;
		
		try { img = ImageIO.read(new File(nm)); }
		 catch (IOException e) { System.out.println("Cannot load image"); }
		
		if(x_dir==1)
			img1=img;
		else
			img2=img;
	}
	
	public abstract String getPath();
	
	public boolean isChange() {return this.coordChanged;}
	
	public void resetChange() {this.coordChanged=false;}
	
	public void drawObject (Graphics g)
	{
	 
	 if(x_dir==1) // animal goes to the right side
		 g.drawImage(img1, this.getLocation().getx()/*-size/2*/, Point.max_y- this.getLocation().gety() -size/2, size/2, size, pan);
	 else // animal goes to the left side
		 g.drawImage(img2, this.getLocation().getx(), this.getLocation().gety() -size/10, size/2, size, pan);
	}
	
	
	
}
