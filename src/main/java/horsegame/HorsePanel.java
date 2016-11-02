package horsegame;

import java.awt.BorderLayout;
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
	// Horse[] horses;
	ImageIcon[] imageIcons;
	JLabel[] horseImages;
	CenterPanel centerPanel;
	NorthPanel northPanel;
	SouthPanel southPanel;
	JLabel startButton;
	HorseLogic horseLogic;
	private static ArrayList<Horse> horses;

	public HorsePanel() {
		this.setSize(Dimen.frameWidthSize, Dimen.frameHeightSize);
		this.setLayout(new BorderLayout());
		setBackground(Color.white);


		horses = new ArrayList<Horse>();
		imageIcons = new ImageIcon[Dimen.horseNumber];
		horseImages = new JLabel[Dimen.horseNumber];
		centerPanel = new CenterPanel();
		northPanel = new NorthPanel();
		southPanel = new SouthPanel();

		for (int i = 0; i < Dimen.horseNumber; i++) {
			horses.add(new Horse(horseImages[i]));
			horses.get(i).setName("horse" + i);
			System.out.println(horses.get(i).getName() + "----------");
		}

		horseLogic = new HorseLogic(horses,this);
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

			ImageIcon line = new ImageIcon("src/images/line.png");
			lines = new JLabel[Dimen.horseNumber];

			setVisible(true);

			for (int i = 0; i < Dimen.horseNumber; i++) {

				imageIcons[i] = new ImageIcon("src/images/horse" + i + "_stop.gif");
				horseImages[i] = new JLabel(imageIcons[i]);
				horseImages[i].setLocation(25, 50 + 100 * i);
				horseImages[i].setSize(150, 80);

				lines[i] = new JLabel(line);
				lines[i].setSize(750, 10);
				lines[i].setLocation(100, 130 + 100 * i);
				add(lines[i]);
				add(horseImages[i]);

			}

		}
		
		public void remove(){
			this.removeAll();
		}
		public void setPanel(JPanel panel){
			add(panel);
		}
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			ImageIcon icon=new ImageIcon("src/images/frame.png");
			Image img=icon.getImage();		
			g.drawImage(img, 0,0,this);
		}
		
		

	}// Center end

	class NorthPanel extends JPanel {
		
		
		public NorthPanel() {
			setSize(new Dimension(1000, 50));
			
			setBackground(Dimen.basicBagroundColor);
			setLayout(new BorderLayout());
			
			
			ImageIcon push = new ImageIcon("src/images/start_button.png");
			startButton = new JLabel(push);
			startButton.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					// pushButton.setIcon(new ImageIcon(""));
					for (int i = 0; i < Dimen.horseNumber; i++) {
						horseImages[i].setIcon(new ImageIcon("src/images/horse" + i + ".gif"));
						horses.get(i).run();

					}
				}
			});

			add(startButton,BorderLayout.EAST);
		}
	}// North end

	class SouthPanel extends JPanel {
		public SouthPanel() {
			// setSize(new Dimension(1000, 150));
			setLayout(new BorderLayout());
			setBackground(null);
			JLabel LabelBg = new JLabel(new ImageIcon("src/images/horsepanel_south_bg.png"));
			add(LabelBg, BorderLayout.CENTER);
		}
	}// South end

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
