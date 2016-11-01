package horsegame;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartFrame extends JFrame {
	JPanel centerPanel;
	Container container;
	HorsePanel horsePanel;
	public StartFrame(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Horse Game");
		setSize(Dimen.frameWidthSize,Dimen.frameHeightSize);
		setVisible(true);
		
		centerPanel = new CenterPanel();
	
		
		container = getContentPane();
		container.setLayout(null);
		
		container.add(centerPanel);
		
		container.revalidate();
		container.repaint();
		
	}
	
	//CenterPanel
	class CenterPanel extends JPanel {
		public CenterPanel(){
		setLayout(new FlowLayout()); 
		setBackground(Color.GRAY);
		setSize(Dimen.frameWidthSize,Dimen.frameHeightSize);

		JLabel startMent = new JLabel("S.T.A.R.T");
		JButton startButton = new JButton("PUSH");
		
		Font font = new Font("궁서",Font.BOLD,100);
		startMent.setFont(font);
		
		startButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JButton select = (JButton)e.getSource();
				
				if(select.getText().equals("PUSH"))//push 버튼 눌렸을 경우
				{
					container.removeAll();
					container.add(horsePanel = new HorsePanel());
					
					Thread th = new Thread(horsePanel);
					th.start();
					
					
					container.revalidate();
					container.repaint();
				}
			}
		});
		
		add(startMent);
		add(startButton);
		
		}
	}
}
