package horsegame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WinnerPanel extends JPanel {
	
	JLabel horseName;
	JLabel horseLabel;
	JLabel ment;
	public WinnerPanel(Horse horse) {
		setLayout(null); 
		setBackground(Color.WHITE);
		setVisible(true);
		setSize(new Dimension(800,300));
		setLocation(80, 50);
	
		horseName = new JLabel(horse.getName());
		horseName.setLocation(370, 200);
		horseName.setSize(300, 100);
		Font font1 = new Font("Times",Font.BOLD,25);
		horseName.setForeground(Color.BLACK);
		horseName.setFont(font1);
		
		ment = new JLabel("W.I.N.N.E.R");
		ment.setLocation(320, 15);
		ment.setSize(200, 100);
		Font font2 = new Font("Times",Font.BOLD,35);
		ment.setFont(font2);
		ment.setForeground(Color.BLACK);
		
		horseLabel = horse.getHorseLabel();
		horseLabel.setIcon( new ImageIcon("src/images/"+horseName+"_win.gif"));
		horseLabel.setLocation(310, 50);
		horseLabel.setSize(200, 200);
		
	
		add(ment);
		add(horseName);
		add(horseLabel);
	}
	
}
