package horsegame;

import java.util.ArrayList;

import javax.swing.JPanel;

public class HorseLogic extends Thread {
	ArrayList<Horse> horses;
	HorsePanel horsePanel;
	Horse Winner;
	WinnerPanel winnerPaenl;
	final int endLine = 795;

	public HorseLogic(ArrayList<Horse> horses, HorsePanel horsePanel) {
		this.horses = horses;
		this.horsePanel = horsePanel;
	}

	public void run() {
		while (true) {
			for (int i = 0; i < horsePanel.getHorseNumber(); i++) {
				if (horses.get(i).getX() >= endLine) {
					Winner = horses.get(i);
					winnerPaenl = new WinnerPanel(Winner);
					System.out.println("GameOver");
					horsePanel.centerPanel.remove();
					horsePanel.centerPanel.setPanel(winnerPaenl);
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
