package horsegame;

import java.util.Observable;
import java.util.Observer;

public class StrategyObserver implements Observer {

	private RunningStrategy runningStrategy;
	
	@Override
	public void update(Observable arg0, Object arg1) {
		
		if(arg1 instanceof RunningStrategy)
			{
			runningStrategy = (RunningStrategy)arg1;
			displayStrategy();
			}
	}
	
	public void displayStrategy(){
		System.out.println("Strategy : "+ runningStrategy);
	}

}
