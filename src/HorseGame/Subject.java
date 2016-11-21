package HorseGame;
import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
	private List<Observer> observers = new ArrayList<Observer>();

	public void addObserver(Observer observer) {
		this.observers.add(observer);
	}

	public void notifyObservers() {
		for (Observer o : observers)
			o.update();
	}

}
