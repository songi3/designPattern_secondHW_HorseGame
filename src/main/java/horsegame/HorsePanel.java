package horsegame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HorsePanel extends JPanel {
	Horse[] horses;
	ImageIcon[] imageIcons;
	JLabel [] horseImages;
	CenterPanel centerPanel;
	NorthPanel northPanel;
	
	public HorsePanel() {
		this.setSize(Dimen.frameWidthSize, Dimen.frameHeightSize);
		this.setLayout(new BorderLayout());
		this.setBackground(Color.DARK_GRAY);
		horses = new Horse[Dimen.horseNumber];
		imageIcons = new ImageIcon[Dimen.horseNumber];
		horseImages = new JLabel[Dimen.horseNumber];
		centerPanel = new CenterPanel();
		northPanel = new NorthPanel();
	
		
		add(centerPanel,BorderLayout.CENTER);
		add(northPanel,BorderLayout.NORTH);
		revalidate();
		repaint();

	}
	
	class CenterPanel extends JPanel {
		public CenterPanel(){
			setLayout(new GridLayout(2, 3)); //배치관리자 삭제 setLayout(null);
			setBackground(Color.GRAY);
			setSize(400,400);
			setLocation(40,40);
			
			setVisible(true);
			for(int i=0;i<Dimen.horseNumber;i++){
				imageIcons[i] = new ImageIcon("src/images/horse"+i+".gif");
				horseImages[i] = new JLabel(imageIcons[i]);
				horseImages[i].setSize(100, 70);
				horseImages[i].setLocation(50, 100);
				add(horseImages[i]);

			}
			
			
		}
	}//Center end
	
	class NorthPanel extends JPanel{
		public NorthPanel(){
			JLabel ment =new JLabel("dd");
			add(ment);
		}
	}//North end
	
	



}


