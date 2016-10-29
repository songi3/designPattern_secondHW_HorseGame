package horsegame;

public class ChooseStrategy {
	RunningStrategy runningStrategy;
	
	public RunningStrategy choose(){
		int randomNumber = (int)(Math.random()*Dimen.strategyNumber)+1;
		switch(randomNumber){
		case 1:
			return runningStrategy = new FastRunning();
		
		case 2:
			return runningStrategy = new SlowRunning();
	
		}
		
		return null;
	}
}
