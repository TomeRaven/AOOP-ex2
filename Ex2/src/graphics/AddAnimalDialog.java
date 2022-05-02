package graphics;

import java.awt.Dimension;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import animals.*;

/**
 * 
 * @author tomer handali 206751489
 * This class is intended to create a dialog so the user can easily create an animal
 */
public class AddAnimalDialog extends JDialog {
	
	private final String[] animals = {"Elephant","Lion","Giraffe","Turtle","Bear"}; //names of animal types
	private final String[] colors= {"Natural","Red","Blue"}; // names of colors for animals
	private final JComboBox<String> comboAnimal; // options of animal types
	private final JComboBox<String> comboColor; //options of animal colors
	
	private static final int minsize=50; // minimum size of animal
	private static final int maxsize=300; // maximum size of animal
	private static final int minspeed=1; // minimum speed of animal (Horizontal and vertical)
	private static final int maxspeed=10; // maximum speed of animal (Horizontal and vertical)
	
	private String animalType; //object to receive animal type selection
	private String animalCol; //object to receive animal color selection
	private JTextField animalsize; //object to receive animal size selection
	private JTextField animalHspeed; //object to receive animal horizontal speed selection
	private JTextField animalVspeed; //object to receive animal vertical speed selection
	
	private Animal createdAnimal; //object to receive the created animal 
	private int result = -1; //object used to remember whether the user created an animal or cancelled
	
	/**
	 * 
	 * @param window this is the Jframe of the project
	 * @param pan this is the panel used to draw the objects
	 */
	public AddAnimalDialog(Frame window, ZooPanel pan)
	{
		
		super(window,"Add Animal",true);
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS)); // vertical box layout layout for components
		
        this.add(new JLabel("Set the animal type:"));// the label to request animal type
        this.add(comboAnimal=new JComboBox<String>(this.animals)); // adding combobox for selection
        
        this.add(Box.createRigidArea(new Dimension(10,10))); //spacing between components
		
        this.add(new JLabel("Set animal size (in pixels, must be between "+minsize+" - "+maxsize+" ):")); // label to request animal size
        animalsize=new JTextField(); // receiving text for animal size
        this.add(animalsize); // adding the textbox
        
        this.add(Box.createRigidArea(new Dimension(10,10)));//spacing between components
        
        this.add(new JLabel("Set animal horizontal speed (must be between "+minspeed+" - "+maxspeed+" ):"));//label to request horizontal speed
        animalHspeed=new JTextField(); // receiving text for animal H speed
        this.add(animalHspeed); //adding the textbox

        this.add(Box.createRigidArea(new Dimension(10,10)));//spacing between components

        this.add(new JLabel("Set animal vertical speed (must be between "+minspeed+" - "+maxspeed+" ):")); // label to request vertical speed
        animalVspeed=new JTextField(); //receiving text for animal V speed
        this.add(animalVspeed); //adding the textbox
        
        this.add(Box.createRigidArea(new Dimension(10,10)));//spacing between components
        
        this.add(new JLabel("Set the animal color:"));// the label to request animal color
        this.add(comboColor=new JComboBox<String>(colors)); //adding combobox for selection
        
        this.add(Box.createRigidArea(new Dimension(10,10)));//spacing between components
        
        JPanel decision=new JPanel(); //panel used for buttons to decide- add an animal or cancel 
        decision.setLayout(new BoxLayout(decision,BoxLayout.LINE_AXIS)); // horizontal box layout for decision panel

        
		JButton cancel = new JButton("Cancel"); //button used to cancel
		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
                result = JOptionPane.CANCEL_OPTION; 

				setVisible(false);
			}
		});
		decision.add(cancel); //adding button to panel
		
		decision.add(Box.createHorizontalGlue());//spacing between components
		
		JButton addA=new JButton("Add Animal"); //button used to add animal
		addA.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String textnum; // object to receive text from Jtextfield objects
				int sizenum; // object to receive size number
				int hspeednum; // object to receive horizontal speed number
				int vspeednum; // object to receive vertical speed number
				
				animalType=comboAnimal.getItemAt(comboAnimal.getSelectedIndex()); // receving animal type string

				animalCol=comboColor.getItemAt(comboColor.getSelectedIndex()); // receiving animal color string

				
				textnum = animalsize.getText(); // receiving animal size text
				
				// parsing the text to integer - if user did not enter an integer number error message will show up 
				try {
					 sizenum = Integer.parseInt(textnum); 
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Animal size must be integer number only","Invalid input!",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if(sizenum < minsize || sizenum > maxsize) //checking size validity
				{
					JOptionPane.showMessageDialog(null, "Animal size range "+minsize+"-"+maxsize+" only","Invalid input!",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				textnum = animalHspeed.getText(); // receiving animal h speed text
				
				// parsing the text to integer - if user did not enter an integer number error message will show up 
				try {
					 hspeednum = Integer.parseInt(textnum);
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Animal horizontal speed is integer number only","Invalid input!",JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(hspeednum < minspeed || hspeednum > maxspeed) //checking speed validity
				{
					JOptionPane.showMessageDialog(null, "Animal horizontal speed range "+minspeed+"-"+maxspeed+" only","Invalid input!",JOptionPane.ERROR_MESSAGE);
					return;
				}

				textnum = animalVspeed.getText(); // receiving animal v speed text
				
				// parsing the text to integer - if user did not enter an integer number error message will show up 
				try {
					 vspeednum = Integer.parseInt(textnum);
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Animal vertical speed is integer number only","Invalid input!",JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(vspeednum < minspeed || vspeednum > maxspeed) //checking speed validity
				{
					JOptionPane.showMessageDialog(null, "Animal vertical speed range "+minspeed+"-"+maxspeed+" only","Invalid input!",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				switch(animalType) // creating the animal object using the user's selections
				{
				case "Bear":
					createdAnimal=new Bear(sizenum,animalCol,hspeednum,vspeednum,pan);
				
					break;
				case "Lion":
					
					createdAnimal=new Lion(sizenum,animalCol,hspeednum,vspeednum,pan);

					break;
					
				case "Elephant":
					createdAnimal=new Elephant(sizenum,animalCol,hspeednum,vspeednum,pan);
					
					break;
					
				case "Turtle":
					createdAnimal=new Turtle(sizenum,animalCol,hspeednum,vspeednum,pan);

					break;
					
				case "Giraffe":
					createdAnimal=new Giraffe(sizenum,animalCol,hspeednum,vspeednum,pan);

					break;
				
				}
				
				createdAnimal.loadImages(createdAnimal.getPath()); // loading image for the animal
				
				result = JOptionPane.OK_OPTION; // result- animal created successfully
	            setVisible(false); //hide window
				
            }
			
			
		});
		
		decision.add(addA); // add "add animal" button to decision panel
		this.add(decision); // ad the decision panel
		          
        this.pack();     
        this.setVisible(true); 
		
	}
	/**
	 * 
	 * @return result of process - cancel or success
	 */
	public int getRes() {return result;}
	
	/**
	 * 
	 * @return the animal created in the process
	 */
	public Animal getAnimal() {return createdAnimal;}
	

}
