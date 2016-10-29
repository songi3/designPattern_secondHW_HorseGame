package horsegame;

import javax.swing.JLabel;

import lombok.Getter;
import lombok.Setter;

public class Horse extends Thread {
	private RunningStrategy runningStrategy;
	private String name;
	private JLabel horseLabel;
	
	public Horse(JLabel horseLabel){
		this.horseLabel=horseLabel;
	}
	

	public void setRunningStrategy(RunningStrategy runningStrategy) {
		this.runningStrategy = runningStrategy;
	}


	public JLabel getHorseLabel() {
		return horseLabel;
	}
	
	public int getX(){
		return horseLabel.getX();
	}
	
	public int getY(){
		return horseLabel.getY();
	}
	
	public void setLocation(int x,int y){
		horseLabel.setLocation(x,y);
	}

	public void run(){
		int end = getX();
		while(end!=850){
		
			try{
				runningStrategy.run(this);
				Thread.sleep(100);
				end = getX();
				
			}
			catch(InterruptedException e){}
			
		}
		
	}
	
	

}
