package horsegame;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HorsePanel extends JPanel implements Runnable {
	
	ImageIcon[] imageIcons;
	JLabel[] horseImages;
	CenterPanel centerPanel;
	NorthPanel northPanel;
	SouthPanel southPanel;
	JLabel startButton;
	StopLogic horseLogic;
	StrategyObserver strategyObserver;

	private final static int horseNumber =3;
	private static ArrayList<Horse> horses;
	private final static int frameWidthSize = 1100;
	private final static int frameHeightSize = 600;
	final Color basicBagroundColor = new Color(160,228,249);

	public HorsePanel() {
		this.setSize(frameWidthSize,frameHeightSize);
		this.setLayout(new BorderLayout());
		setBackground(Color.white);

		horses = new ArrayList<Horse>();
		imageIcons = new ImageIcon[horseNumber];
		horseImages = new JLabel[horseNumber];
		centerPanel = new CenterPanel();
		northPanel = new NorthPanel();
		southPanel = new SouthPanel();
		
		//strategyObserver = new StrategyObserver();

		for (int i = 0; i < horseNumber; i++) {
			horses.add(new Horse(horseImages[i]));
			horses.get(i).setName("horse" + i);
			horses.get(i).addObserver(new StrategyObserver(horses.get(i)));
			horses.get(i).addObserver(new EnergyObserver(horses.get(i)));
			System.out.println(horses.get(i).getName() + " : ready "+  "----------------");
		}

		horseLogic = new StopLogic(this);
		horseLogic.start();

		add(centerPanel, BorderLayout.CENTER);
		add(northPanel, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);
		
		

	}

	class CenterPanel extends JPanel {
		JLabel[] lines;

		public CenterPanel() {
			setLayout(null);
			setBackground(null);
			setVisible(true);
			
			ImageIcon line = new ImageIcon("src/images/line.png");
			lines = new JLabel[horseNumber];

			for (int i = 0; i < horseNumber; i++) {

				imageIcons[i] = new ImageIcon("src/images/horse" + i + "_stop.gif");
				horseImages[i] = new JLabel(imageIcons[i]);
				horseImages[i].setLocation(35, 50 + 100 * i);
				horseImages[i].setSize(150, 80);

				lines[i] = new JLabel(line);
				lines[i].setSize(750, 10);
				lines[i].setLocation(120, 130 + 100 * i);
			
				add(lines[i]);
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
			ImageIcon icon = new ImageIcon("src/images/frame.png");
			Image img = icon.getImage();
			g.drawImage(img, 0, 0, this);
		}

	}// Center end

	class NorthPanel extends JPanel {

		public NorthPanel() {
			setSize(new Dimension(1000, 50));

			setBackground(basicBagroundColor);
			setLayout(new BorderLayout());

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

			add(startButton, BorderLayout.EAST);
		}
		
	}// North end

	class SouthPanel extends JPanel {
		public SouthPanel() {
			setLayout(new BorderLayout());
			setBackground(null);
			JLabel LabelBg = new JLabel(new ImageIcon("src/images/horsepanel_south_bg.png"));
			add(LabelBg, BorderLayout.CENTER);
		}
	}// South end

	public static int getHorseNumber() {
		return horseNumber;
	}

	public static int getFramewidthsize() {
		return frameWidthSize;
	}

	public static int getFrameheightsize() {
		return frameHeightSize;
	}
	
	public static ArrayList<Horse> getHorses(){
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
