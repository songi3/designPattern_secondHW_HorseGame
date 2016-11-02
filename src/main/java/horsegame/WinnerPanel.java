package horsegame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WinnerPanel extends JPanel {
	JLabel horseLabel;
	JLabel horseName;
	ImageIcon horseImage = new ImageIcon("src/images/"+"horse0"+"_win.gif");
	
	public WinnerPanel(Horse horse) {
		setLayout(null); 
		setBackground(Color.WHITE);
		setVisible(true);
		setSize(new Dimension(800,300));
		setLocation(80, 50);
	
		horseName = new JLabel(horse.getName());
		horseName.setLocation(400, 200);
		horseName.setSize(100, 100);
	
		horseLabel = new JLabel(horseImage);
		horseLabel.setLocation(300, 50);
		horseLabel.setSize(200, 200);
	
		add(horseName);
		add(horseLabel);
	}
	
}
