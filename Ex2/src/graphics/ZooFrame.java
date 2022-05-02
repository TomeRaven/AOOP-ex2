package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import animals.Animal;
import animals.Bear;
import graphics.ZooPanel;

/**
 * 
 * @author tomer handali 206751489
 * this class is intended to present a frame for the panel and the bottom buttons
 */
public class ZooFrame extends JFrame implements ActionListener{
	

	JMenuBar menuBar; //nav bar
	JMenu fileMenu; // menu for file option
	JMenu backgroundMenu; //menu for background option
	JMenu helpMenu; //menu for help option
	
	JMenuItem exitItem; // menu item to exit application
	
	JMenuItem imageItem; // menu item to set image as background
	JMenuItem greenItem; // menu item to set green color as background
	JMenuItem noneItem; // menu item to set nothing in background
	
	JMenuItem helpItem; // menu item to see help option
	
	ZooPanel zoo; // drawing panel
	

	JButton addb; // add animal button
	JButton moveb; // move animal button
	JButton clearb; // clear all button
	JButton foodb; // feed animals button
	JButton infob; // info about animals button
	JButton exitb; // exit application button
	
	
	public ZooFrame()
	{
		this.setLayout(new BorderLayout());
		addb=new JButton("Add Animal");
		addb.setPreferredSize(new Dimension(200,50));
		moveb= new JButton("Move Animal");
		moveb.setPreferredSize(new Dimension(200,50));
		clearb=new JButton("Clear");
		clearb.setPreferredSize(new Dimension(200,50));
		foodb=new JButton("Food");
		foodb.setPreferredSize(new Dimension(200,50));
		infob=new JButton("Info");
		infob.setPreferredSize(new Dimension(200,50));
		exitb=new JButton("Exit");
		exitb.setPreferredSize(new Dimension(200,50));
		
		addb.addActionListener(this);
		exitb.addActionListener(this);
		moveb.addActionListener(this);
		clearb.addActionListener(this);
		foodb.addActionListener(this);
		infob.addActionListener(this);
		
		JPanel bottomButtons = new JPanel();
		bottomButtons.setLayout(new BoxLayout(bottomButtons, BoxLayout.LINE_AXIS));
		bottomButtons.add(addb);
		bottomButtons.add(Box.createHorizontalGlue());
		bottomButtons.add(moveb);
		bottomButtons.add(Box.createHorizontalGlue());
		bottomButtons.add(clearb);
		bottomButtons.add(Box.createHorizontalGlue());
		bottomButtons.add(foodb);
		bottomButtons.add(Box.createHorizontalGlue());
		bottomButtons.add(infob);
		bottomButtons.add(Box.createHorizontalGlue());
		bottomButtons.add(exitb);

		
		menuBar= new JMenuBar();
		
		fileMenu = new JMenu("File");
		backgroundMenu = new JMenu("Background");
		helpMenu = new JMenu("Help");
		
		exitItem = new JMenuItem("Exit");
		imageItem = new JMenuItem("Image");
		greenItem = new JMenuItem("Green");
		noneItem = new JMenuItem("None");
		helpItem = new JMenuItem("Help");
		
		exitItem.addActionListener(this);
		imageItem.addActionListener(this);
		greenItem.addActionListener(this);
		noneItem.addActionListener(this);
		helpItem.addActionListener(this);
		
		fileMenu.add(exitItem);
		
		backgroundMenu.add(imageItem);
		backgroundMenu.add(greenItem);
		backgroundMenu.add(noneItem);
		
		
		helpMenu.add(helpItem);
		
		
		menuBar.add(fileMenu);
		menuBar.add(backgroundMenu);
		menuBar.add(helpMenu);
		
		zoo = new ZooPanel();
		
		this.add(zoo,BorderLayout.CENTER);
		
		this.add(bottomButtons,BorderLayout.SOUTH);
		
		this.setTitle("Zoo");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000,800);
		
		this.setJMenuBar(menuBar);
		this.setVisible(true);
		
		
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand()=="Exit")
			System.exit(ABORT);
		
		if(e.getActionCommand()=="Green")
		{
			zoo.removeimg(); // removing image from background if any
			
			zoo.setcol(Color.green); //setting the color and background color green
			
			zoo.setBackground(Color.green);
			
			
			zoo.repaint(); // repainting panel
		}	
		if(e.getActionCommand()=="Image")
		{
			zoo.setimg(new String("assignment2_pictures//savanna.png")); //assigning image to background
			
			repaint(); // repainting panel
		}
		if(e.getActionCommand()=="None")
		{
			zoo.removeimg(); // removing image from background if any
			
			zoo.setcol(Color.WHITE); //setting the color and background color white (as in none)
		
			zoo.setBackground(Color.WHITE);
			
			zoo.repaint(); // repainting panel
		}
		if(e.getActionCommand()=="Help")	
			JOptionPane.showMessageDialog(null, "Home Work 2\nGUI"); // help dialog
		
		
		if(e.getActionCommand()=="Add Animal")
		{
			
			if(zoo.getarrsize()<=10)
				{
					AddAnimalDialog d = new AddAnimalDialog(this,zoo); //creating add animal dialog
				
					if(d.getRes()==JOptionPane.OK_OPTION) //checking if user decided on creating an animal
					{
							zoo.addAnimal(d.getAnimal()); //adding animal
							
							zoo.repaint(); // repainting panel
					
					}	
				}		
			else
				JOptionPane.showMessageDialog(null, "You cannot add more than 10 animals","Max Animals cap",JOptionPane.ERROR_MESSAGE);

		}
				
			
		
		if(e.getActionCommand()=="Move Animal")
		{
			if(zoo.getarrsize()>0)
			{
				MoveAnimalDialog m = new MoveAnimalDialog(this,zoo); //creating move animal dialog
				
				if(m.getres()==JOptionPane.OK_OPTION) //checking if user decided on moving an animal
					zoo.manageZoo(); // looking for changes
			}
			else
				JOptionPane.showMessageDialog(null, "You need to add at least one animal","No Animals Found",JOptionPane.ERROR_MESSAGE);

			
		}
		
		if(e.getActionCommand()=="Clear")
		{
			
			zoo.removeAll(); // clearing all objects from screen
			
			zoo.repaint(); // repainting panel
			
		}
		
		if(e.getActionCommand()=="Food")
		{
			
			new FoodDialog(this,zoo); //creating food dialog
			
			zoo.repaint(); // repainting panel
		}
		
		if(e.getActionCommand()=="Info")
		{
			JFrame info = new JFrame("Info"); //creating a frame for info table
			
			InfoModel model=new InfoModel(zoo.getarr());
			JTable table=new JTable(model); //creating info table with data
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setPreferredScrollableViewportSize(new Dimension(500,70));
			table.setFillsViewportHeight(true);
			info.add(new JScrollPane(table));
			info.pack();
			info.setVisible(true);
			
		}
		
	}
	
	public static void main(String args[]) {
		
		new ZooFrame(); //creating the frame object
		
	}

}
