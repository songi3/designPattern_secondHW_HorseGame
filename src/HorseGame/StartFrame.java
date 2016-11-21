package HorseGame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

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
		setTitle("Horse Game");
		setSize(horsePanel.getFramewidthsize(), horsePanel.getFrameheightsize());
		setResizable(false);
		setUndecorated(true);
		setVisible(true);
		setShape(new RoundRectangle2D.Float(0, 0, this.getWidth(), this.getHeight(), 30, 30));

		Dimension frameSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

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

			startGameLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("images/startGame_button.png")));
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
			ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("images/horse_main.png"));
			Image img = icon.getImage();
			g.drawImage(img, 0, 0, this);

		}

	}
}
