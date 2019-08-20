package Background;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Gameobjects.Birds;
import Gameobjects.My_player;
import Gameobjects.Wall;

public class Inside extends JPanel implements Runnable{
	
	private Dimension screen;
int screenwidth;
	int screenheight;
	My_player player;
	int numberOfBirds;
	 ArrayList<Birds> birds;
	Boarder b;

	boolean gamefinished=false;
	String name;
	boolean dir1;
	boolean dir2;
	boolean dir3;
	boolean dir4;
	boolean dir5;
	
	int mia;
	
	Wall wall = new Wall();
	
	
	public Inside (Dimension screen, Boarder b,String name, int level,boolean dir1, boolean dir2, boolean dir3, boolean dir4, boolean dir5) {
		this.screen = screen;
		this.b = b;
		this.name=name;
		this.dir1=dir1;
		this.dir1=dir2;
		this.dir1=dir3;
		this.dir1=dir4;
		this.dir1=dir5;
		numberOfBirds=level;
		wall.setDirr( dir1,  dir2,  dir3,  dir4,  dir5);
		
		
		player=new My_player();
		birds=new ArrayList<Birds>();
		for(int j=1;j<=numberOfBirds;j++){
		birds.add(new Birds(j));
		}
		
		
		
		setLayout(null);

		setBackground(Color.gray);
		new Thread(this).start();
		new Thread(wall).start();

		
}

	
	
	
	@Override
	public void paint(Graphics arg0) {
		// TODO Auto-generated method stub
		super.paint(arg0);
		if (!gamefinished){

		wall.paint(arg0);
		player.paint(arg0);
		player.setDirection(wall.getDirection());
		if(player.getGameFinished()=='Y'&& !gamefinished){
			player.setGameFinished('N');
			
			gamefinished=true;
			
			int finish = JOptionPane.showConfirmDialog(null,
					"Oh "+name+" you lost the game \n Do you wish to continue?", "Game Over :(",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
			
			if (finish == 1)
				System.exit(0);
			
			if (finish == 0) {
				b.setVisible(false);
				
				Boarder m = new Boarder("secondconstructor");
			}
				
		}

		if(player.getGameFinished()=='K'&& !gamefinished){
			player.setGameFinished('N');
			gamefinished=true;
			
			int finish = JOptionPane.showConfirmDialog(null,
					"Congratulations "+name+" !! you won the game \n Do you want to play it again?", "Victory :)",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
			
			if (finish == 1)
				System.exit(0);
			
			if (finish == 0) {
				b.setVisible(false);
				
				Boarder m = new Boarder("secondconstructor");
			}
				
		}
		
		
		
		for(int j=0;j<numberOfBirds;j++){
			birds.get(j).paint(arg0);
			player.setxB(birds.get(j).getXBullet(), j);
			
			}
		

		player.setMiane(wall.getMiane());
		player.setPeriod(wall.getPeriod());
		wall.setX(player.getX());
		wall.setCurrentWall(player.getCurrentWall());
		
		
		}
	}




	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}

			repaint();
		}
	}


	
}