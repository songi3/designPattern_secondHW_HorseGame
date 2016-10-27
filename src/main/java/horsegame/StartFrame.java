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
	
	public StartFrame(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Horse Game");
		setSize(1000,650);
		setVisible(true);
		
		
		centerPanel = new CenterPanel();
		//centerPanel.setSize(1000,400);
		//centerPanel.setLocation(200, 200);
		
		container = getContentPane();
		container.setLayout(new FlowLayout());
		
		container.add(centerPanel);
		
	}
	
	//CenterPanel
	class CenterPanel extends JPanel {
		public CenterPanel(){
		setLayout(new FlowLayout()); //배치관리자 삭제 setLayout(null);
		setBackground(Color.GRAY);
		
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
					container.add(new HorsePanel());
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
