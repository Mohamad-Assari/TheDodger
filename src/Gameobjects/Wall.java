package Gameobjects;


import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class Wall extends JComponent implements Runnable{
	ImageIcon singlebrick;
	ImageIcon door;
	int cycle=1120;
	int eachrow=18;
	
int []myX1={0,56,112,168,224,280,392,448,504,560,616,672,728,784,840,896,1008,1064};
int []myX2={0,56,112,168,224,280,336,448,504,560,616,672,728,784,840,896,952,1008};
int []myX3={0,56,112,168,280,336,392,448,504,560,616,672,728,840,896,952,1008,1064};
int []myX4={0,56,112,168,224,280,336,448,504,560,616,728,784,840,896,952,1008,1064};
int []myX5={0,56,112,168,224,280,392,448,504,560,616,672,728,784,840,896,952,1064};

	int []speedy={1,1,1,1,1};
	int []direction={0,-1,-1,-1,-1,-1};
	
	int miane=0;


	int period=0;
	int period1=0;
	int x=0;
	int currentWall=0;
	public void setDirr(boolean dir1, boolean dir2, boolean dir3, boolean dir4, boolean dir5){
	if(dir1)
		direction[1]=1;
	if(dir2)
		direction[2]=1;
	if(dir3)
		direction[3]=1;
	if(dir4)
		direction[4]=1;
	if(dir5)
		direction[5]=1;
		
		
	}
						
	
	public void setX(int x) {
		this.x = x;
	}

	public Wall(){
		
		door=new ImageIcon(getClass().getResource("door.png"));
		singlebrick=new ImageIcon(getClass().getResource("singlebrick.png"));
	}
	
	public void paint(Graphics g){
		
		super.paint(g);
		
		g.drawImage(door.getImage()	,945, 2,70,75,null );
		
		//first row
		for(int j=0;j<eachrow;j++){
		g.drawImage(singlebrick.getImage()	,-60+ (myX1[j]), 453,60,18,null );
		}
		
		
		//second row
		for(int j=0;j<eachrow;j++){
		g.drawImage(singlebrick.getImage()	,-60+(myX2[j]), 359,60,18,null );
		}
		
		
		//third row
		for(int j=0;j<eachrow;j++){
		g.drawImage(singlebrick.getImage()	,-60+ myX3[j], 265,60,18,null );
		}
	
		//forth row
		for(int j=0;j<eachrow;j++){
		g.drawImage(singlebrick.getImage()	,-60+myX4[j],171 ,60,18,null );
		}
		
	
		//fifth row
		for(int j=0;j<eachrow;j++){
		g.drawImage(singlebrick.getImage()	,-60+myX5[j], 77,60,18,null );
		}
			
	}

	@Override
	public void run() {
		
	while(true){
		
		
		for(int j=0;j<eachrow;j++){
			myX1[j]=(myX1[j]+direction[1]*speedy[0])%cycle;
			if (myX1[j]<0) myX1[j]+=cycle;

		}
		
		for(int j=0;j<eachrow;j++){
			myX2[j]=(myX2[j]+direction[2]*speedy[1])%cycle;
			if (myX2[j]<0) myX2[j]+=cycle;
		}
		
		for(int j=0;j<eachrow;j++){
			myX3[j]=(myX3[j]+direction[3]*speedy[2])%cycle;
			if (myX3[j]<0) myX3[j]+=cycle;

		}
		
		for(int j=0;j<eachrow;j++){
			myX4[j]=(myX4[j]+direction[4]*speedy[3])%cycle;
			if (myX4[j]<0) myX4[j]+=cycle;

		}
		
		for(int j=0;j<eachrow;j++){
			myX5[j]=(myX5[j]+direction[5]*speedy[4])%cycle;
			if (myX5[j]<0) myX5[j]+=cycle;

		}
		period++;
		
		
		if(0<x+miane && x+miane<960){
			miane+=direction[currentWall];	
			if(direction[currentWall]==1&& x+miane==960){
			miane-=direction[currentWall];
			}
			if(direction[currentWall]==-1&& x+miane==0){
				miane-=direction[currentWall];
				}
			
		}
		
		
		
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
	
	}	
	}

	public void setCurrentWall(int currentWall) {
		this.currentWall = currentWall;
	}

	public void setMiane(int miane) {
		this.miane = miane;
	}

	
	public int[] getDirection() {
		return direction;
	}

	public int getMiane() {
		return miane;
	}
	public int getPeriod() {	
		return period;
	}

	
	

}

