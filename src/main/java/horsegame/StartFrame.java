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

	// CenterPanel
	class CenterPanel extends JPanel {

		ImageIcon bg = new ImageIcon("src/images/startBaground_carrot.png");
		JButton startButton;

		public void paint(Graphics g) {

			g.drawImage(bg.getImage(), 0, 0, null);
			setOpaque(false);
		}

		public CenterPanel() {
			setLayout(null);
			setBackground(Color.GRAY);
			setSize(horsePanel.getFramewidthsize(), horsePanel.getFrameheightsize());

			startButton = new JButton(new ImageIcon("src/images/push_button.png"));
			startButton.setSize(200, 200);
			startButton.setLocation(750, 150);

			startButton.addMouseListener(new MouseAdapter() {
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

			add(startButton);
		}

	}
}
