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
			
			horse.setRunningStrategy( new BestFastRunning());
			System.out.println(horse.getName()+"BestFast");
			break;
		
		case 2:
			horse.setRunningStrategy( new SlowRunning());
			System.out.println(horse.getName()+"Slow");
			break;
	
		case 3:
			horse.setRunningStrategy( new BasicRunning());
			System.out.println(horse.getName()+"Basic");
			break;
			
		case 4:
			horse.setRunningStrategy( new FastRunning());
			System.out.println(horse.getName()+"Fast");
			break;
		}
	}
	
	public void run(){
		
		while(horse.getX()<Dimen.endLine){
		try{
			
			choose();
			sleep(3000);
		
			
		}
		catch(InterruptedException e){}
		
		}
	}
}
