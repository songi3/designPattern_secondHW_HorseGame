package horsegame;

import java.util.ArrayList;

public class HorseLogic extends Thread {
	ArrayList<Horse> horses;
	Horse Winner;
	boolean flag = false;

	public HorseLogic(ArrayList<Horse> horses) {
		this.horses = horses;
	}

	public void run() {

		while (true) {
			for (int i = 0; i < Dimen.horseNumber; i++) {
				if (horses.get(i).getX() >= Dimen.endLine) {
					Winner = horses.get(i);
					System.out.println("Over");
					new WinnerFrame(Winner);
					this.interrupt();
				}
			}
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				for (int i = 0; i < Dimen.horseNumber; i++)
					horses.get(i).stop();
				System.out.println("end");
				return;
			}

		}

	}
}
