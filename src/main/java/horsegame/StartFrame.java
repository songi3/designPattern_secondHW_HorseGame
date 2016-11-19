package horsegame;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartFrame extends JFrame {
	JPanel centerPanel;
	Container container;
	HorsePanel horsePanel;
	JLabel horseGame;

	public StartFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Horse Game");
		setSize(horsePanel.getFramewidthsize(), horsePanel.getFrameheightsize());
		setResizable(false);
		setVisible(true);

		centerPanel = new CenterPanel();

		container = getContentPane();
		container.setLayout(null);

		container.add(centerPanel);

		container.revalidate();
		container.repaint();

	}

	class CenterPanel extends JPanel {

		JLabel startGameLabel;

		public CenterPanel() {
			setLayout(null);
			setVisible(true);
			setBackground(null);
			setSize(horsePanel.getFramewidthsize(), horsePanel.getFrameheightsize());

			startGameLabel = new JLabel(new ImageIcon("src/images/startGame_button.png"));
			startGameLabel.setSize(410, 120);
			startGameLabel.setLocation(350, 420);

			startGameLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {

					container.removeAll();
					container.add(horsePanel = new HorsePanel());

					Thread th = new Thread(horsePanel);
					th.start();

					container.revalidate();
					container.repaint();
				}
			});

			add(startGameLabel);

			revalidate();
			repaint();
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			ImageIcon icon = new ImageIcon("src/images/horse_main.png");
			Image img = icon.getImage();
			g.drawImage(img, 0, 0, this);

		}

	}
}
