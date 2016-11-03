package horsegame;

import javax.swing.ImageIcon;

public class Running extends Thread {
	Horse horse;

	public Running(Horse horse) {
		this.horse = horse;
	}

	public void run() {

		while (!Thread.currentThread().isInterrupted()) {

			horse.getRunningStrategy().run();

			try {
				Thread.sleep(150);
			}

			catch (InterruptedException e) {
				System.out.println("runnign Thread end---");
				horse.getHorseLabel().setIcon(new ImageIcon("src/images/" + horse.getName() + "_stop.gif"));
				return;
			}
		}

	}
}
