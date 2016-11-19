package horsegame;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WinnerPanel extends JFrame {
	
	JLabel horseName;
	JLabel horseLabel;
	JLabel ment;
	HorsePanel horsePanel;
	
	public WinnerPanel(Horse horse,HorsePanel horsePanel) {
		setLayout(null); 
		setBackground(Color.WHITE);
		setSize(new Dimension(600,450));
		setUndecorated(true);
		
		Dimension frameSize = this.getSize(); 
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
		setVisible(true);
		
		this.horsePanel = horsePanel;
		
		
		
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
		horseLabel.setIcon( new ImageIcon("src/images/"+horseName+".gif"));
		horseLabel.setLocation(310, 50);
		horseLabel.setSize(200, 200);
		
		add(ment);
		add(horseName);
		add(horseLabel);
	}
	
}
