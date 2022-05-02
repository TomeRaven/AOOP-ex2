package graphics;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import food.Meat;
import plants.Cabbage;
import plants.Lettuce;
import plants.Plant;

/**
 * 
 * @author tomer handali 206751489
 * this class is intended to present a dialog window to feed animals using plant or meat objects
 */ 
public class FoodDialog extends JDialog implements ActionListener {

	private Meat meat; // meat object to feed meat eaters
	private Plant plant; // plant object to feed vegetarian animals
	private JButton cabbage; // cabbage button 
	private JButton lettuce; // lettuce button
	private JButton meatb; // meat button
	
	private ZooPanel panel; // draw panel
	/**
	 * 
	 * @param window this is the Jframe of the project
	 * @param pan this is the panel used to draw the objects
	 */
	public FoodDialog(Frame window,ZooPanel pan)
	{
		super(window,"Food for animals",true);
		
		this.panel=pan;
		
		JPanel decision=new JPanel(); // horizontal box layout panel to present options
	    decision.setLayout(new BoxLayout(decision,BoxLayout.LINE_AXIS));
	       
	    lettuce=new JButton("Lettuce");  //creating the lettuce button, adding action listener and adding to decision panel
	    lettuce.addActionListener(this);
	    decision.add(lettuce);
	       
        decision.add(Box.createRigidArea(new Dimension(50,10))); //spacing between components

		cabbage=new JButton("Cabbage"); //creating the cabbage button, adding action listener and adding to decision panel
		cabbage.addActionListener(this);
		decision.add(cabbage);
		
        decision.add(Box.createRigidArea(new Dimension(50,10))); //spacing between components

		meatb=new JButton("Meat"); //creating the meat button, adding action listener and adding to decision panel
		meatb.addActionListener(this);
		decision.add(meatb);
		
		
		this.add(decision); //adding panel to dialog
        
        this.pack();    
        this.setVisible(true);
	        
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand()=="Lettuce")
		{
			plant = new Lettuce(panel); //creating the lettuce object, loading its image and adding to panel
			plant.loadImages(plant.getpath());
			panel.addPlant(plant);
			
		}
		if(e.getActionCommand()=="Cabbage")
		{
			plant=new Cabbage(panel); //creating the cabbage object, loading its image and adding to panel
			plant.loadImages(plant.getpath());
			panel.addPlant(plant);
			
		}
		if(e.getActionCommand()=="Meat")
		{
			meat=new Meat(panel); //creating the meat object, loading its image and adding to panel
			meat.loadImages(meat.getPath());
			panel.addMeat(meat);
			
		}
		this.setVisible(false);
		
	}

}
