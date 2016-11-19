package horsegame;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
	
	
	private JLabel[] HeartBeatLabel;
	private JLabel[] StrategyLabel;
	
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

		HeartBeatLabel = new JLabel[horseNumber];
		StrategyLabel = new JLabel[horseNumber];
		// strategyObserver = new StrategyObserver();

		for (int i = 0; i < horseNumber; i++) {
			horses.add(new Horse(horseImages[i]));
			horses.get(i).setName("horse" + i);
			horses.get(i).addObserver(new StrategyObserver(horses.get(i),this));
			horses.get(i).addObserver(new EnergyObserver(horses.get(i)));
			horses.get(i).addObserver(new HeartBeatObserver(horses.get(i),this));

			HeartBeatLabel[i] = new JLabel(horses.get(i).getHeartBeat().toString());
			StrategyLabel[i] = new JLabel(horses.get(i).getRunningStrategy().getName());

			System.out.println(horses.get(i).getName() + " : ready " + "----------------");
		}

		northPanel = new NorthPanel();

		horseLogic = new StopLogic(this);
		horseLogic.start();

		add(centerPanel, BorderLayout.CENTER);
		add(northPanel, BorderLayout.NORTH);
		
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

		JLabel[] BeatNameLabel;
		JLabel[] StrategyNameLabel;
		
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

			startButton.setSize(200, 50);
			startButton.setLocation(900, 10);
			startButton.setVisible(true);
			
			BeatNameLabel= new JLabel[horseNumber];
			StrategyNameLabel = new JLabel[horseNumber];
			
			Font font = new Font("돋움",Font.BOLD,20);
			Font font2 = new Font("돋움",Font.BOLD,15);
			
			for(int i=0;i<horseNumber;i++){
				BeatNameLabel[i] = new JLabel("HeartBeat : ");
				BeatNameLabel[i].setSize(150,50);
				BeatNameLabel[i].setLocation(280*i+90, 0);
				BeatNameLabel[i].setFont(font);
				BeatNameLabel[i].setForeground(Color.BLACK);
				
				HeartBeatLabel[i].setSize(50,50);
				HeartBeatLabel[i].setLocation(280*i+210, 0);
				HeartBeatLabel[i].setFont(font);
				HeartBeatLabel[i].setForeground(Color.BLACK);
				
				StrategyNameLabel[i] = new JLabel("Strategy : ");
				StrategyNameLabel[i].setSize(170,50);
				StrategyNameLabel[i].setLocation(280*i+90, 20);
				StrategyNameLabel[i].setFont(font);
				StrategyNameLabel[i].setForeground(Color.BLACK);
				
				StrategyLabel[i].setSize(130,50);
				StrategyLabel[i].setLocation(280*i+190, 20);
				StrategyLabel[i].setFont(font);
				StrategyLabel[i].setForeground(Color.BLACK);
				
				add(StrategyLabel[i]);
				add(StrategyNameLabel[i]);
				add(BeatNameLabel[i]);
				add(HeartBeatLabel[i]);
			}
			
			add(startButton);
			// repaint();

		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			ImageIcon icon = new ImageIcon("src/images/horsepanel_north_bg.png");
			Image img = icon.getImage();
			g.drawImage(img, 0, 0, this);
			g.drawImage(imageOne, 20, 0, this);
			g.drawImage(imageTwo, 300, 0, this);
			g.drawImage(imageThree, 580, 0, this);

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

	
	public  void setHeartBeatLabel(JLabel[] heartBeatLabel) {
		HeartBeatLabel = heartBeatLabel;
	}
	
	public  JLabel[] getHeartBeatLabel() {
		return HeartBeatLabel;
	}
	
	public JLabel[] getStrategyLabel() {
		return StrategyLabel;
	}

	public void setStrategyLabel(JLabel[] strategyLabel) {
		StrategyLabel = strategyLabel;
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
