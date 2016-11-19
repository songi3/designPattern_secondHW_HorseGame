package horsegame;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HorsePanel extends JPanel implements Runnable {

	ImageIcon[] imageIcons;
	JLabel[] horseImages;
	CenterPanel centerPanel;
	NorthPanel northPanel;
	JLabel startButton;
	StopLogic horseLogic;
	StrategyObserver strategyObserver;

	ArrayList<JLabel> horseNameLabel;
	ArrayList<JLabel> horseBeatLabel;

	private final static int horseNumber = 3;
	private static ArrayList<Horse> horses;
	private final static int frameWidthSize = 1100;
	private final static int frameHeightSize = 650;
	final Color basicBagroundColor = new Color(160, 228, 249);

	public HorsePanel() {
		this.setSize(frameWidthSize, frameHeightSize);
		this.setLayout(new BorderLayout());
		setBackground(Color.white);

		horses = new ArrayList<Horse>();
		imageIcons = new ImageIcon[horseNumber];
		horseImages = new JLabel[horseNumber];
		centerPanel = new CenterPanel();
		northPanel = new NorthPanel();
		// southPanel = new SouthPanel();

		horseNameLabel = new ArrayList<JLabel>();
		horseBeatLabel = new ArrayList<JLabel>();

		// strategyObserver = new StrategyObserver();

		for (int i = 0; i < horseNumber; i++) {
			horses.add(new Horse(horseImages[i]));
			horses.get(i).setName("horse" + i);
			horses.get(i).addObserver(new StrategyObserver(horses.get(i)));
			horses.get(i).addObserver(new EnergyObserver(horses.get(i)));

			horseNameLabel.add(new JLabel(horses.get(i).getName()));
			horseBeatLabel.add(new JLabel(horses.get(i).getHeartBeat().toString()));

			System.out.println(horses.get(i).getName() + " : ready " + "----------------");
		}

		horseLogic = new StopLogic(this);
		horseLogic.start();

		add(centerPanel, BorderLayout.CENTER);
		add(northPanel, BorderLayout.NORTH);
		// add(southPanel, BorderLayout.SOUTH);

	}

	class CenterPanel extends JPanel {
		// JLabel[] lines;

		public CenterPanel() {
			setLayout(null);
			setBackground(null);
			setVisible(true);

			for (int i = 0; i < horseNumber; i++) {

				imageIcons[i] = new ImageIcon("src/images/horse" + i + "_stop.gif");
				horseImages[i] = new JLabel(imageIcons[i]);
				horseImages[i].setLocation(0, 150 * i + 5);
				horseImages[i].setSize(280, 200);

				add(horseImages[i]);

			}
		}

		public void remove() {
			this.removeAll();
		}

		public void setPanel(JPanel panel) {
			add(panel);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			ImageIcon icon = new ImageIcon("src/images/horsePanel_backGround.png");
			Image img = icon.getImage();
			g.drawImage(img, 0, 0, this);
		}

	}// Center end

	class NorthPanel extends JPanel {

		ImageIcon one;
		ImageIcon two;
		ImageIcon three;

		Image imageOne;
		Image imageTwo;
		Image imageThree;

		public NorthPanel() {

			setPreferredSize(new Dimension(1000, 100));
			setVisible(true);
			setBackground(null);
			setLayout(null);

			ImageIcon push = new ImageIcon("src/images/start_button.png");
			startButton = new JLabel(push);
			startButton.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					for (int i = 0; i < horseNumber; i++) {
						horseImages[i].setIcon(new ImageIcon("src/images/horse" + i + ".gif"));
						horses.get(i).run();

					}
				}
			});

			one = new ImageIcon("src/images/horsePanel_horseNameImage_1.png");
			two = new ImageIcon("src/images/horsePanel_horseNameImage_2.png");
			three = new ImageIcon("src/images/horsePanel_horseNameImage_3.png");

			imageOne = one.getImage();
			imageTwo = two.getImage();
			imageThree = three.getImage();

			/*
			 * imageOne = new JLabel(one); imageTwo = new JLabel(two);
			 * imageThree = new JLabel(three);
			 * 
			 * 
			 * imageTwo.setLocation(100, 50); imageTwo.setSize(70, 70);
			 * 
			 * imageThree.setLocation(100, 50); imageThree.setSize(70, 70);
			 */

			startButton.setSize(70, 70);
			startButton.setLocation(900, 10);
			startButton.setVisible(true);
			add(startButton);
			// repaint();

		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			ImageIcon icon = new ImageIcon("src/images/horsepanel_north_bg.png");
			Image img = icon.getImage();
			g.drawImage(img, 0, 0, this);
			g.drawImage(imageOne, 20, 0, this);
			g.drawImage(imageTwo, 220, 0, this);
			g.drawImage(imageThree, 420, 0, this);

		}

	}// North end

	/*
	 * class SouthPanel extends JPanel { public SouthPanel() { setLayout(new
	 * BorderLayout()); setBackground(null); //JLabel LabelBg = new JLabel(new
	 * ImageIcon("src/images/horsepanel_south_bg.png")); //add(LabelBg,
	 * BorderLayout.CENTER); } }// South end
	 */
	public static int getHorseNumber() {
		return horseNumber;
	}

	public static int getFramewidthsize() {
		return frameWidthSize;
	}

	public static int getFrameheightsize() {
		return frameHeightSize;
	}

	public static ArrayList<Horse> getHorses() {
		return horses;
	}

	@Override
	public void run() {
		while (true) {
			revalidate();
			repaint();
			try {

				Thread.sleep(5);
			} catch (InterruptedException e) {
			}
		}

	}

}
