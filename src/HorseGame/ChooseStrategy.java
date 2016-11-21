package HorseGame;

public class ChooseStrategy extends Thread {

	Horse horse;
	private int strategyNumber = 4;

	public ChooseStrategy(Horse horse) {
		super();
		this.horse = horse;
	}

	public void choose() {
		int randomNumber = (int) (Math.random() * strategyNumber) + 1;
		switch (randomNumber) {
		case 1:
			horse.setRunningStrategy(new VeryFastRunning(horse));
			break;

		case 2:
			horse.setRunningStrategy(new SlowRunning(horse));
			break;

		case 3:
			horse.setRunningStrategy(new BasicRunning(horse));
			break;

		case 4:
			horse.setRunningStrategy(new FastRunning(horse));
			break;
		}
	}

	public void run() {

		while (!Thread.currentThread().isInterrupted()) {
			try {
				choose();
				sleep(3000);

			} catch (InterruptedException e) {
				return;
			}
		}
	}
}
