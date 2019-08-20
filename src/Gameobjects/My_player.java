package Gameobjects;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class My_player extends JComponent implements Runnable,KeyListener{
	ImageIcon myimage1;

    private int x;
    private int y;
    private int edgeOfWall=20;
    char whichmove;
    char upornot;
    int miane=0;
    int sum;
    int komaki=0;
    int currentWall=0;
    boolean stand=true;
    boolean JumpIsAllowed=false;
    int []xB=new int[3];
    int [] yB={391,203,15};
    int period;
    Checker checker=new Checker();
    int []helper = new int[11];
    char gameFinished='N';
    int []gap1 = new int[2];
    int []gap2 = new int[2];
    int []gap3 = new int[2];
    int []gap4 = new int[2];
    int []gap5 = new int[2];

	int []direction= new int[6];
	
   

	public void setMiane(int miane) {
		this.miane = miane;
		
	}
	
	

	



	public void setxB(int xBc,int j) {
		xB[j] = xBc;
	}



	public void setGameFinished(char gameFinished) {
		this.gameFinished = gameFinished;
	}


	public char getGameFinished() {
		return gameFinished;
	}
	public void setDirection(int[] direction) {
		this.direction = direction;
	}

	public My_player() {
        
        x=100;
        y=485;
    }
    

    public void paint(Graphics k){
		super.paint(k);
    	sum=x+miane;
    	
    	
    	if(stand==true){
    	myimage1=new ImageIcon(getClass().getResource("Stand.png"));
    	k.drawImage(myimage1.getImage(), sum, y,
				50, 60, null);	
    	}
    	
    	else{
      	myimage1=new ImageIcon(getClass().getResource("Sitted.png"));
      	k.drawImage(myimage1.getImage(), sum, y+25,
				50, 35, null);	
    	}
		

    	//(currentWall=1
    		
		helper[0]=(period*direction[1]+336)%1120;
		if (helper[0]<0){
			helper[0]+=1120;
		}
		gap1[0]=-60-(1-direction[1])*5+helper[0];
		
		
		helper[1]=(period*direction[1]+952)%1120;
		if (helper[1]<0){
			helper[1]+=1120;
		}
		
		gap1[1]=-60-(1-direction[1])*5+helper[1];
    	
    	
    	
    	
		//(currentWall=2    		
		helper[3]=(period*direction[2]+392)%1120;
		if (helper[3]<0){
			helper[3]+=1120;
		}
		gap2[0]=-60-(1-direction[2])*5+helper[3];
		
		
		helper[4]=(period*direction[2]+1064)%1120;
		if (helper[4]<0){
			helper[4]+=1120;
		}
		
		gap2[1]=-60-(1-direction[2])*5+helper[4];
   
    	
    	
		//(currentWall=3    		
    		helper[5]=(period*direction[3]+224)%1120;
    		if (helper[5]<0){
    			helper[5]+=1120;
    		}
    		gap3[0]=-60-(1-direction[3])*5+helper[5];
    		
    		
    		helper[6]=(period*direction[3]+784)%1120;
    		if (helper[6]<0){
    			helper[6]+=1120;
    		}
    		
    		gap3[1]=-60-(1-direction[3])*5+helper[6];
  
    	
    	
    		//(currentWall=4    		
    		helper[7]=(period*direction[4]+392)%1120;
    		if (helper[7]<0){
    			helper[7]+=1120;
    		}
    		gap4[0]=-60-(1-direction[4])*5+helper[7];
    		
    		
    		helper[8]=(period*direction[4]+672)%1120;
    		if (helper[8]<0){
    			helper[8]+=1120;
    		}
    		
    		gap4[1]=-60-(1-direction[4])*5+helper[8];
        
    	
    		//(currentWall=5    		
    		helper[9]=(period*direction[5]+336)%1120;
    		if (helper[9]<0){
    			helper[9]+=1120;
    		}
    		gap5[0]=-60-(1-direction[5])*5+helper[9];
    		
    		
    		helper[10]=(period*direction[5]+1008)%1120;
    		if (helper[10]<0){
    			helper[10]+=1120;
    		}
    		
    		gap5[1]=-60-(1-direction[5])*5+helper[10];
        	}


	public int getX() {
		return x;
	}

	@Override
	public void run() {
		
		
		if(upornot=='U'){
		for(int i=0;i<59;i+=1){
			upornot='N';
			if(i<53){
				y -= 2;	
			}
			else{
				y += 2;
			}
				
			try {
				Thread.sleep(6);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		}
		// TODO Auto-generated method stub
		else if(whichmove=='R'){
		for(int i=0;i<10;i+=2){
			if(sum<910){
				x+= 2;	
			}
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		}
		
		else if(whichmove=='L'){
			for(int i=0;i<10;i+=2){
				if(sum>60){
				x-= 2;	

				}
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
			}	
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		
		
		if( arg0.getKeyCode() == KeyEvent.VK_UP && currentWall<5 && JumpIsAllowed==true){


			upornot='U';
			currentWall++;
				new Thread(this).start();	
		
		
		
	}
		
		if( arg0.getKeyCode() == KeyEvent.VK_DOWN){
			stand=false;
		}
		
		
		
		if( arg0.getKeyCode() == KeyEvent.VK_RIGHT){
			if(x+miane<910&&stand==true){
				whichmove='R';
				new Thread(this).start();
				
		} 
		
	}		
				
		if( arg0.getKeyCode() == KeyEvent.VK_LEFT){
			if(x+miane>60&&stand==true){
				whichmove='L';
				new Thread(this).start();
		}
			
			else{
				//x=8;
			}
		}
		// TODO Auto-generated method stub
		
	}

	public int getCurrentWall() {
		return currentWall;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		if( arg0.getKeyCode() == KeyEvent.VK_DOWN){
			stand=true;	
		}
		
		if( arg0.getKeyCode() == KeyEvent.VK_RIGHT){
			whichmove='N';
		}
		if( arg0.getKeyCode() == KeyEvent.VK_LEFT){
			whichmove='N';
		}
		if( arg0.getKeyCode() == KeyEvent.VK_UP){
			
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

	public class Checker implements Runnable{
		int periodc;

		
		
		public void setPeriodc(int period) {
			this.periodc = period;
		}
		
		public Checker(){
		new Thread(this).start();
		}
		@Override
		
		public void run() {
			while(true){
				
				
				// this part checks if player must fall!
				if(gap1[0]!=0){
					
					
				if(y==391 &&gap1[0]-10<sum  && sum<gap1[0]+10&& whichmove=='N'){
					y+=94;
					currentWall--; 
				}
				if(y==391 &&gap1[1]-10<sum  && sum<gap1[1]+10&& whichmove=='N'){
					y+=94;
					currentWall--; 
				}
				if(y==297 &&gap2[0]-10<sum  && sum<gap2[0]+10&& whichmove=='N'){
					y+=94;
					currentWall--; 
				}
				if(y==297 &&gap2[1]-10<sum  && sum<gap2[1]+10&& whichmove=='N'){
					y+=94;
					currentWall--; 
				}
				if(y==203 &&gap3[0]-10<sum  && sum<gap3[0]+10&& whichmove=='N'){
					y+=94;
					currentWall--; 
				}
				if(y==203 &&gap3[1]-10<sum  && sum<gap3[1]+10&& whichmove=='N'){
					y+=94;
					currentWall--; 
				}
				
				if(y==109 &&gap4[0]-10<sum  && sum<gap4[0]+10&& whichmove=='N'){
					y+=94;
					currentWall--; 
				}
				if(y==109 &&gap4[1]-10<sum  && sum<gap4[1]+10&& whichmove=='N'){
					y+=94;
					currentWall--; 
				}
				
				if(y==15 &&gap5[0]-10<sum  && sum<gap5[0]+10&& whichmove=='N'){
					y+=94;
					currentWall--; 
				}
				if(y==15 &&gap5[1]-10<sum  && sum<gap5[1]+10&& whichmove=='N'){
					y+=94;
					currentWall--; 
				}
				
				//this part check if player has won
				if(y==15 && sum>900){
					gameFinished='K';
				}
				//this part checks if player has shot
				for(int k=0;k<3;k++){
					if(y==yB[k]&& xB[k]-20<sum+7 &&  sum+7<xB[k] &&stand==true){
						
						gameFinished='Y';
					}
					
				}
				
				// this part checks if player can jump!
				
				if((y==485 &&gap1[0]-edgeOfWall<sum  && sum<gap1[0]+edgeOfWall) || (y==485 &&gap1[1]-edgeOfWall<sum  && sum<gap1[1]+edgeOfWall) || (y==391 &&gap2[0]-edgeOfWall<sum  && sum<gap2[0]+edgeOfWall) || (y==391 &&gap2[1]-edgeOfWall<sum  && sum<gap2[1]+edgeOfWall) || (y==297 &&gap3[0]-edgeOfWall<sum  && sum<gap3[0]+edgeOfWall) || (y==297 &&gap3[1]-edgeOfWall<sum  && sum<gap3[1]+edgeOfWall) || (y==203 &&gap4[0]-30<sum  && sum<gap4[0]+edgeOfWall) || (y==203 &&gap4[1]-edgeOfWall<sum  && sum<gap4[1]+edgeOfWall) || (y==109 &&gap5[0]-edgeOfWall<sum  && sum<gap5[0]+edgeOfWall) || (y==109 &&gap5[1]-edgeOfWall<sum  && sum<gap5[1]+edgeOfWall)) {
					JumpIsAllowed=true;					
				}
				else{
					JumpIsAllowed=false;
				}
				
		
				}
				

				
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
			// TODO Auto-generated method stub
			
		}
		
	}

    
 
    
}