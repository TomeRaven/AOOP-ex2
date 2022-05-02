package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import animals.Animal;
import food.Meat;
import mobility.Point;
import plants.Plant;

/**
 * 
 * @author tomer handali 206751489
 * this class is intended to represent a draw panel for the exercise objects
 */
public class ZooPanel extends JPanel{
	
	
	private ArrayList<Animal> arr = new ArrayList<Animal>(); // animal array
	private Plant plant = null; // plant object
	private Meat meat=null; // meat object
	private Color color = null; // color of panel
	public BufferedImage img = null; // background image of panel

	
	 @Override
     protected void paintComponent(Graphics g) { //method to draw all the images
        super.paintComponent(g);
        
        if(this.img!=null) // adding an image to the background or a background color
        	g.drawImage(img,0,0,getWidth(),getHeight(), this);
        else
        	g.setColor(this.color);
        
        
        for(int i=0;i<arr.size();++i) //drawing the animals in the array
        	arr.get(i).drawObject(g);
        
        if(this.plant!=null) //drawing a plant
        	plant.drawObject(g);
        
        if(this.meat!=null) // drawing meat
        	meat.drawObject(g);
       
        	
     }
	 
	 /**
	  * This method will check each time an animal moves if they can eat an object that is near them
	  */
	 public void manageZoo()
	 {
	 
		 
		 int index; // index of currently checked animal
		 
		 for(index=0;index<arr.size();++index) { // going through the entire array
			 
			 Animal animal=arr.get(index);
			 
			 if (animal.isChange()) // if theres a change in animal coordinates
			 {
				 animal.resetChange(); // resetting to no change so loop wont repeat this for no reason
				 
				 //checking if plant can be eaten
				 if(plant != null && animal.calcDistance(plant.getLocation())<=animal.getEatDistance() && animal.eat(plant))
				 {
					 animal.eatInc();
					 plant=null;
				 }
				 //checking if meat can be eaten
				 if(meat!=null && animal.calcDistance(meat.getLocation())<=animal.getEatDistance() && animal.eat(meat))
				 {
					 animal.eatInc();
					 meat=null;
				 }
				 //checking if other close animals can be eaten
				 for(int j=0;j<arr.size();++j)
				 {
					 Animal other=arr.get(j);
					 
					 if(index!=j && animal.getWeight()>other.getWeight()*2 && animal.calcDistance(other.getLocation())<other.getSize() && animal.eat(other))
					 {
						 animal.eatInc();
						 arr.remove(j); //removing eaten animal from array
						 --j;
						 if(j<index) // fixing the indexes because of object removal from array
							 --index;
						 
						 
					 }
				 }
				 
			 }
		 
		 }
	 
		 this.repaint(); //repainting panel
	 }
	 
	 
	 
	 @Override
     public Dimension getPreferredSize() {
         return new Dimension(200, 200);
     }
	 public void setcol(Color c)
	 {
			 
		 this.color=c;
		 
	 }
	 
	 public void setimg(String s) //loading and setting an image background
	 {
		 BufferedImage i = null;
		 try { i = ImageIO.read(new File(s)); }
		 catch (IOException e) { System.out.println("Cannot load image"); }
		 
		 this.img=i;
		  
		 
		 
		 
	 }
	 
	 public void removeimg() //removing an image
	 {
		 
		 this.img=null;
		 
	 }
	 
	 /**
	  * 
	  * @param a The animal that will be added to the array
	  */
	 public void addAnimal(Animal a)
	 {
		 
		 arr.add(a);
		 
	 }
	 
	 public void removeAll()
	 {
		 arr.removeAll(arr);
		 this.plant=null;
		 this.meat=null;
	 }
	 
	 /**
	  * This method initializes the meat data member and replaces any plant object if there was any on the screen beforehand 
	  * @param m The meat object that will be added to the screen
	  */
	 public void addMeat(Meat m) 
	 {
		 this.meat=m;
		 this.plant=null;
	 
	 }
	 
	 /**
	  * This method initializes the plant data member and replaces any meat object if there was any on the screen beforehand 
	  * @param p The plant object that will be added to the screen
	  */
	 public void addPlant(Plant p)
	 {
		 this.plant=p;
		 this.meat=null;
		 
	 }
	 
	 
	 
	 
	 public int getarrsize() {return arr.size();} //getting array size
	 
	 public ArrayList<Animal> getarr() {return this.arr;} //getting array

}
