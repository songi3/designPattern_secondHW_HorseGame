package HorseGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
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
	JLabel endLabel;
	JPanel centerPanel;
	Horse horse;

	ImageIcon one;
	ImageIcon two;
	ImageIcon three;

	public WinnerPanel(Horse horse, HorsePanel horsePanel) {
		setSize(new Dimension(600, 450));
		setLayout(new BorderLayout());
		setUndecorated(true);
		setShape(new RoundRectangle2D.Float(0, 0, this.getWidth(), this.getHeight(), 30, 30));

		Dimension frameSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		setVisible(true);

		this.horsePanel = horsePanel;
		this.horse = horse;

		centerPanel = new CenterPanel();
		add(centerPanel, BorderLayout.CENTER);

		revalidate();
		repaint();

	}

	public class CenterPanel extends JPanel {

		public CenterPanel() {
	
			setLayout(null);
			setVisible(true);
			setBackground(Color.WHITE);
			setSize(new Dimension(600, 450));

			one = new ImageIcon(getClass().getClassLoader().getResource("images/horsePanel_horseNameImage_1.png"));
			two = new ImageIcon(getClass().getClassLoader().getResource("images/horsePanel_horseNameImage_2.png"));
			three = new ImageIcon(getClass().getClassLoader().getResource("images/horsePanel_horseNameImage_3.png"));

			if (horse.getName().equals("horse0"))
				horseName = new JLabel(one);
			else if (horse.getName().equals("horse1"))
				horseName = new JLabel(two);
			else if (horse.getName().equals("horse2"))
				horseName = new JLabel(three);

			horseName.setLocation(160, 320);
			horseName.setSize(300, 100);
			Font font1 = new Font("Times", Font.BOLD, 25);
			horseName.setForeground(Color.BLACK);
			horseName.setFont(font1);

			ment = new JLabel("W.I.N.N.E.R");
			ment.setLocation(210, 50);
			ment.setSize(200, 100);
			Font font2 = new Font("Times", Font.BOLD, 35);
			ment.setFont(font2);
			ment.setForeground(Color.BLACK);

			horseLabel = new JLabel(
					new ImageIcon(getClass().getClassLoader().getResource("images/" + horse.getName() + "_stop.gif")));
			horseLabel.setLocation(100, 120);
			horseLabel.setSize(400, 200);

			endLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("images/exitButton.png")));
			endLabel.setLocation(550, 0);
			endLabel.setSize(50, 50);
			endLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.exit(0);
				}
			});

			add(endLabel);
			add(ment);
			add(horseName);
			add(horseLabel);
		}
	}

}
