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

	public void run(){
		int end = 1;
		while(end!=5){
		
			try{
				runningStrategy.run(this);
				Thread.sleep(1000);
				end++;
				
			}
			catch(InterruptedException e){}
			
		}
		
	}
	
	

}
