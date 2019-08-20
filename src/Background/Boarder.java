package Background;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Boarder extends JFrame {
	
	
	
	Dimension screen ;
	
	public Boarder (String name, int level,boolean dir1, boolean dir2, boolean dir3, boolean dir4, boolean dir5){
		screen = Toolkit.getDefaultToolkit().getScreenSize(); 

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
	
		setBackground(Color.BLACK);
		
		
		
			setTitle("The Dodger");
			setSize((int)screen.getWidth()*3/4 ,(int) screen.getHeight()*3/4);
			setLocation((int) screen.getWidth()/8 ,(int) screen.getHeight()/8);
			
			
			
			
			
			
			
			
			
			
			
			
			
			Inside objOfInside = new Inside( screen, this,name,  level, dir1,  dir2,  dir3,  dir4,  dir5);
			this.addKeyListener(objOfInside.player);
			//(new Thread(objOfInside)).start();
			this.getContentPane().add(objOfInside);
			setVisible(true);
			

		
		
		
	}
	public Boarder(String secondconstructor){
		
		
		screen = Toolkit.getDefaultToolkit().getScreenSize(); 

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
	
		setBackground(Color.BLACK);
		
		
		
		
		
		
		
		setSize((int)screen.getWidth()*3/8 ,(int) screen.getHeight()*3/4);
		setLocation((int) screen.getWidth()*5/16 ,(int) screen.getHeight()/8);
		setTitle("Menu");
		
		
		
		
		G_Menu menu = new G_Menu(this);
		this.getContentPane().add(menu);
		setVisible(true);	
		
	}
	
	
	
	
}
