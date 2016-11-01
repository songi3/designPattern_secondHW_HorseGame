package horsegame;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class WinnerFrame extends JFrame {
	JLabel horseLabel;
	JLabel horseName;
	public WinnerFrame(Horse horse) {
		setLayout(new FlowLayout()); 
		setBackground(Color.GRAY);
		setSize(Dimen.frameWidthSize/2,Dimen.frameHeightSize/2);
		setVisible(true);
		
		horseName = new JLabel(horse.getName());
		horseLabel = horse.getHorseLabel();
		add(horseLabel);
		add(horseName);
	}
}
