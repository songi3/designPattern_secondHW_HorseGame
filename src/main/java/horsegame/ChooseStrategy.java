package horsegame;

public class ChooseStrategy extends Thread {
	
	Horse horse;
	
	public ChooseStrategy(Horse horse) {
		super();
		this.horse = horse;
	}

	public void choose(){
		int randomNumber = (int)(Math.random()*Dimen.strategyNumber)+1;
		switch(randomNumber){
		case 1:
			
			horse.setRunningStrategy( new FastRunning());
			System.out.println(horse.getName()+"Fast");
			break;
		
		case 2:
			horse.setRunningStrategy( new SlowRunning());
			System.out.println(horse.getName()+"Slow");
			break;
	
		}
	}
	
	public void run(){
		
		while(horse.getX()<850){
		try{
			
			choose();
			sleep(10000);
		
			
		}
		catch(InterruptedException e){}
		
		}
	}
}
