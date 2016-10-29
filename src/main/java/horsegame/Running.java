package horsegame;

import javax.swing.ImageIcon;

public class Running extends Thread {
	Horse horse;
	int interval;
	public Running(Horse horse){
		this.horse=horse;
	}
	public void run(){
		
		while(horse.getX()<Dimen.endLine){
		interval= horse.getRunningStrategy().getInterval();
		
		horse.setLocation(horse.getX()+interval, horse.getY());
		
		try{
			Thread.sleep(150);
		}
		catch(InterruptedException e){
			return ;
		}
		}
		
		horse.getHorseLabel().setIcon(new ImageIcon("src/images/"+horse.getName()+"_stop.gif"));
		//new RankingPanel(horse);
	}
}
