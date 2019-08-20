package Background;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;

@SuppressWarnings("serial")
public class G_Menu extends JPanel {
	JLabel namelabel;
	JTextField name;
	JLabel easy;
	JLabel normal;
	JLabel hard;


	
	
	JSlider difficulty;


	JCheckBox dir1;
	JCheckBox dir2;
	JCheckBox dir3;
	JCheckBox dir4;
	JCheckBox dir5;
	JButton exit;
	JButton next;
	Boarder b;
	public G_Menu(Boarder b){
		this.b=b;
		setLayout(null);
		
		namelabel = new JLabel();
		namelabel.setText("please enter your name:  ");
		namelabel.setSize(200,30);
		namelabel.setLocation(50, 50);
		
		
		easy = new JLabel();
		easy.setText("Easy");
		easy.setSize(30,30);
		easy.setLocation(145, 120);
		
		normal = new JLabel();
		normal.setText("Normal");
		normal.setSize(60,30);
		normal.setLocation(230, 120);
		
		
		hard = new JLabel();
		hard.setText("Hard");
		hard.setSize(60,30);
		hard.setLocation(330, 120);
		
		
		name =new JTextField();
		name.setSize(200,30);
		name.setLocation(220, 50);
		
		
		
		difficulty = new JSlider();
		difficulty.setMinimum(1);
		difficulty.setMaximum(3);
		difficulty.setMinorTickSpacing(1 );
		difficulty.setSize(200, 20);
		difficulty.setLocation(150, 150);

		

		
		dir1 = new JCheckBox("1st ---- >>");
		dir1.setSize(100, 20);
		dir1.setLocation(210, 230);
		
		dir2 = new JCheckBox("2nd ---- >>");
		dir2.setSize(100, 20);
		dir2.setLocation(210, 260);
		
		dir3 = new JCheckBox("3rd ---- >>");
		dir3.setSize(100, 20);
		dir3.setLocation(210, 290);

		dir4 = new JCheckBox("4th ---- >>");
		dir4.setSize(100, 20);
		dir4.setLocation(210, 320);

		dir5 = new JCheckBox("5th ---- >>");
		dir5.setSize(100, 20);
		dir5.setLocation(210, 350);
		
		exit = new JButton("Exit");
		exit.setSize(60, 40);
		exit.setLocation(15, 490);
		exit.setText("EXIT");
		
		next = new JButton("Next");
		next.setSize(60, 40);
		next.setLocation(430, 490);
		next.setText("next");
	
		add(namelabel);
		add(name);
		add(difficulty);
		add(dir1);
		add(dir2);
		add(dir3);
		add(dir4);
		add(dir5);
		add(exit);
		add(next);
		add(easy);
		add(normal);
		add(hard);

		next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				// TODO Auto-generated method stub
				
				
				
				b.setVisible(false);
				Boarder kk=new Boarder(name.getText(),difficulty.getValue(),dir1.isSelected(),dir2.isSelected(),dir3.isSelected(),dir4.isSelected(),dir5.isSelected());
				

				
				
				
			}
		});
		
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				b.setVisible(false);
			}
		});
		
		
	}
	
	
	
	

}
