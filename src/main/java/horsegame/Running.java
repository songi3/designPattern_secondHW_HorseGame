package horsegame;

public class Running extends Thread {
	Horse horse;
	int interval;
	public Running(Horse horse){
		this.horse=horse;
	}
	public void run(){
		
		while(horse.getX()<850){
		interval= horse.getRunningStrategy().getInterval();
		
		horse.setLocation(horse.getX()+interval, horse.getY());
		try{
			Thread.sleep(100);
		}
		catch(InterruptedException e){}
		}
	}
}
