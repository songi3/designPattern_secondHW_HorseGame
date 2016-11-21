package HorseGame;

import java.util.Observable;

import javax.swing.JLabel;

public class Horse extends Subject {
	private RunningStrategy runningStrategy;
	private String name;
	private JLabel horseLabel;
	private JLabel energyLabel;
	private Running running;
	private ChooseStrategy chooseStrategy;

	private Integer heartBeat = 80;
	private int Energy = 100;

	public Integer getHeartBeat() {
		return heartBeat;
	}

	public void setHeartBeat(int heartBeat) {
		this.heartBeat = heartBeat;
	}

	public int getEnergy() {
		return Energy;
	}

	public void setEnergy(int energy) {
		Energy = energy;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Horse(JLabel horseLabel, JLabel energyLabel) {
		this.horseLabel = horseLabel;
		this.energyLabel = energyLabel;
		setRunningStrategy(new BasicRunning(this));
	}

	public RunningStrategy getRunningStrategy() {
		return runningStrategy;
	}

	public void setRunningStrategy(RunningStrategy runningStrategy) {
		this.runningStrategy = runningStrategy;
		notifyObservers();
	}

	public JLabel getHorseLabel() {
		return horseLabel;
	}

	public JLabel getEnergyLabel() {
		return energyLabel;
	}

	public int getX() {
		return horseLabel.getX();
	}

	public int getY() {
		return horseLabel.getY();
	}

	public void setLocation(int x, int y) {
		horseLabel.setLocation(x, y);
		energyLabel.setLocation(x + 100, y + 30);
	}

	public void stop() {
		running.interrupt();
		chooseStrategy.interrupt();
	}

	public void run() {
		running = new Running(this);
		chooseStrategy = new ChooseStrategy(this);
		chooseStrategy.start();
		running.start();

	}

}
