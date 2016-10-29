package horsegame;

import javax.swing.JLabel;


public class FastRunning extends RunningStrategy {

	public void run(Horse horse) {
		int x;
		int y;
		
		JLabel horseLabel = horse.getHorseLabel();
		x= horseLabel.getX();
		y= horseLabel.getY();
		
		horseLabel.setLocation(x+50, y);
		
		

	}

}
