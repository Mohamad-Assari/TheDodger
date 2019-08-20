package Gameobjects;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class Birds extends JComponent implements Runnable{

	ImageIcon []bird= new ImageIcon[3];
	ImageIcon bullet;
	int []lefttorightBullet={-1,-1,1};
	int numberOfBird;
	
	boolean [] bulletalive={false,false,false};
	int [] xBullet={980,980,10};
	int [] xBullett={980,980,10};
	int [] yBullet={405,210,25};
	
	int [] xBird={970,970,5};
	int [] yBird={380,190,5};
	
	int XBullet;
	
			public Birds(int num){
				numberOfBird=num;
		bird[0]=new ImageIcon(getClass().getResource("bird1.png"));
		bird[1]=new ImageIcon(getClass().getResource("bird2.png"));
		bird[2]=new ImageIcon(getClass().getResource("bird3.png"));
		
		bullet=new ImageIcon(getClass().getResource("bullet.png"));
		new Thread(this).start();
		
	}
	
	
	
			public void paint(Graphics h){
				super.paint(h);
				
				
				h.drawImage(bird[numberOfBird-1].getImage()	,xBird[numberOfBird-1], yBird[numberOfBird-1],40,40,null );
				
				

	if(bulletalive[numberOfBird-1]==true){
	h.drawImage(bullet.getImage()	,xBullet[numberOfBird-1], yBullet[numberOfBird-1],20,5,null );
	}

				
				
			}
	
	
	
	
	
	
	
	
	
	
	
	

	public int getXBullet() {
				return XBullet;
			}



	@Override
	public void run() {
		
		
		
		
		
		
		
		while(true){
			
			while(bulletalive[numberOfBird-1]==false){
				Random rn = new Random();
				int answer = rn.nextInt(100) + 1;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// TODO Auto-generated method stub
				if(answer>=70){
					bulletalive[numberOfBird-1]=true;
				}
			}
			
			
			
			
			
			if(bulletalive[numberOfBird-1]==true){

		xBullet[numberOfBird-1]+=lefttorightBullet[numberOfBird-1];
		XBullet=xBullet[numberOfBird-1];
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(xBullet[numberOfBird-1]<0 || 1100<xBullet[numberOfBird-1]){
			bulletalive[numberOfBird-1]=false;
			xBullet[numberOfBird-1]=xBullett[numberOfBird-1];
			
		}
		}
	}
	}
	
	

}
