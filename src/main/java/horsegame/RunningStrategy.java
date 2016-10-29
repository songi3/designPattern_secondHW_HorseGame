package horsegame;

import javax.swing.JLabel;

public abstract class RunningStrategy {
	int xPos;
	int yPos;
	
	public void setPos(int xPos,int yPos){
		this.xPos=xPos;
		this.yPos=yPos;
	}
	public abstract void run(Horse horse);
	
}
