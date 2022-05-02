package graphics;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import animals.Animal;
import mobility.Point;

/**
 * 
 * @author tomer handali 206751489
 * this class is intended to present a dialog for the user to move an animal
 */
public class MoveAnimalDialog extends JDialog{

	private String[] selectstr; // Strings of animals and some of their details
	private final JComboBox<String> comboAnimal; //combobox for selection of animals

	private JTextField xcord; // x coordinate textbox
	private JTextField ycord; // y coordinate textbox
	
	private int result; // result determined
	
	public MoveAnimalDialog(Frame window, ZooPanel zoo)
	{
		super(window,"Move Animal",true);
		
		arrangestr(zoo.getarr()); // arranging the string array to present the animals
		
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS)); // setting vertical box layout
		
        this.add(new JLabel("Choose the animal you want to move:")); // label request
        this.add(comboAnimal=new JComboBox<String>(this.selectstr)); // receiving selection

        this.add(Box.createRigidArea(new Dimension(10,10))); //spacing betwenn components


        this.add(new JLabel("Set animal X coordinate (must be between "+Point.min_x+" - "+Point.max_x+" ):")); // label request
        xcord=new JTextField(); //creating textbox
        this.add(xcord); //adding textbox

        this.add(Box.createRigidArea(new Dimension(10,10)));//spacing betwenn components

        this.add(new JLabel("Set animal Y coordinate (must be between "+Point.min_y+" - "+Point.max_y+" ):")); // label request
        ycord=new JTextField(); //creating textbox
        this.add(ycord);//adding textbox
        
        this.add(Box.createRigidArea(new Dimension(10,10)));//spacing betwenn components
        
        JPanel decision=new JPanel(); //creating horizontal boxlayout panel for decision buttons
        decision.setLayout(new BoxLayout(decision,BoxLayout.LINE_AXIS));

		JButton cancel = new JButton("Cancel"); // creating cancel button
		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
                result = JOptionPane.CANCEL_OPTION;

				setVisible(false);
			}
		});
		decision.add(cancel); // adding cancel button
		
		decision.add(Box.createHorizontalGlue());//spacing betwenn components

		JButton moveA=new JButton("Move Animal"); //adding move animal button
		moveA.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				

				String textnum; //object to receive text
				int xnum; // integer x coordinate object
				int ynum; // integer y coordinate object
				
				int selectindex=comboAnimal.getSelectedIndex(); // selected animal index
				
				textnum = xcord.getText(); // receiving x coordinate text
				
				// parsing the text to integer - if user did not enter an integer number error message will show up 
				try {
					 xnum = Integer.parseInt(textnum);
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "X coordinate must be integer number only","Invalid input!",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if(xnum < Point.min_x || xnum > Point.max_x) { //checking range validity
				
					JOptionPane.showMessageDialog(null, "X coordinate range "+Point.min_x+"-"+Point.max_x+" only","Out of bounds!",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				textnum = ycord.getText(); // receiving y coordinate text
				
				// parsing the text to integer - if user did not enter an integer number error message will show up 
				try {
					 ynum = Integer.parseInt(textnum);
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Y coordinate must be integer number only","Invalid input!",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if(ynum < Point.min_y || ynum > Point.max_y) { //checking range validity
				
					JOptionPane.showMessageDialog(null, "Y coordinate range "+Point.min_y+"-"+Point.max_y+" only","Out of bounds!",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				zoo.getarr().get(selectindex).move(new Point(xnum,ynum)); // moving animal
				

				result = JOptionPane.OK_OPTION;
	            setVisible(false);
				
			}
			
		});
		decision.add(moveA); // adding button to decision panel
				
	    this.add(decision); // adding panel to dialog
        this.pack();    
        this.setVisible(true);
		
	}
	
	private void arrangestr(ArrayList<Animal> arr)
	{
		this.selectstr=new String[arr.size()];
		Animal curr;
		
		for(int i=0;i<arr.size();++i)
		{
			curr=arr.get(i);
			this.selectstr[i]=new String((i+1)+". "+curr.getAnimalName()+" , "+curr.getColor()+" , "+curr.getLocation());
			
			
		}
		
		
	}

	
	public int getres() {return result;}

}
