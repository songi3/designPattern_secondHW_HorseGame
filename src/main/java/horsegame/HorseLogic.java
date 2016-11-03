package horsegame;

import java.awt.BorderLayout;
import java.util.ArrayList;

public class HorseLogic extends Thread {
	ArrayList<Horse> horses;
	HorsePanel horsePanel;
	Horse Winner;
	final int endLine = 790;

	public HorseLogic(ArrayList<Horse> horses, HorsePanel horsePanel) {
		this.horses = horses;
		this.horsePanel = horsePanel;
	}

	public void run() {
		while (true) {
			for (int i = 0; i < horsePanel.getHorseNumber(); i++) {
				if (horses.get(i).getX() >= endLine) {
					Winner = horses.get(i);
					System.out.println("GameOver");
					horsePanel.centerPanel.remove();
					horsePanel.centerPanel.setPanel(new WinnerPanel(Winner));
					this.interrupt();
				}
			}
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				for (int i = 0; i < horsePanel.getHorseNumber(); i++)
					horses.get(i).stop();
				System.out.println("end");
				return;
			}

		}

	}
}
