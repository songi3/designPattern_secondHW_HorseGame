package HorseGame;

import javax.swing.JLabel;

public class HeartBeatObserver implements Observer {

	private Horse horse;
	private HorsePanel horsePanel;
	
	public HeartBeatObserver(Horse horse,HorsePanel horsePanel) {
		super();
		this.horse = horse;
		this.horsePanel = horsePanel;
	}

	public void displayStrategy() {
		System.out.println(horse.getName() + " HertBeat : " + horse.getHeartBeat());

		JLabel [] heartLabel = horsePanel.getHeartBeatLabel();
	
		if(horse.getName().equals("horse0"))
			heartLabel[0].setText(horse.getHeartBeat().toString());		
		else if(horse.getName().equals("horse1"))
			heartLabel[1].setText(horse.getHeartBeat().toString());
		else if(horse.getName().equals("horse2"))
			heartLabel[2].setText(horse.getHeartBeat().toString());
		
		horsePanel.setHeartBeatLabel(heartLabel);

	}
	
	@Override
	public void update() {
		 horse.getRunningStrategy().changeHeartBeat();
		 displayStrategy(); 
	}
}
