package horsegame;

import java.util.ArrayList;

public class HorseLogic extends Thread {
	ArrayList<Horse> horses;
	boolean flag = false;

	public HorseLogic(ArrayList<Horse> horses) {
		this.horses = horses;
	}

	public void run() {

		while (flag != true) {
			for (int i = 0; i < Dimen.horseNumber; i++) {
				if (horses.get(i).getX() >= Dimen.endLine) {
					System.out.println("Over");
					flag = true;
				}
			}
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				return;
			}

		}
		for (int i = 0; i < Dimen.horseNumber; i++)
			horses.get(i).stop();
		System.out.println("end");

	}
}
