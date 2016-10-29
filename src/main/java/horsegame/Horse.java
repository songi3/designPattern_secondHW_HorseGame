package horsegame;

import javax.swing.JLabel;

import lombok.Getter;
import lombok.Setter;

public class Horse {
	private RunningStrategy runningStrategy;
	private String name;
	private JLabel horseLabel;
	Running running;
	ChooseStrategy chooseStrategy;
	
	public void setName(String name) {
		this.name = name;
	}


	public String getName() {
		return name;
	}


	public Horse(JLabel horseLabel){
		this.horseLabel=horseLabel;
		setRunningStrategy(new BasicRunning());
	}
	

	public RunningStrategy getRunningStrategy() {
		return runningStrategy;
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
	public void stop(){
		this.running.interrupt();
		this.chooseStrategy.interrupt();
	}

	
	public void run(){
		running=new Running(this);
		chooseStrategy= new ChooseStrategy(this);
		chooseStrategy.start();
		running.start();
		
		
	}
	
	

}
