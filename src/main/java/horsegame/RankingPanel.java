package horsegame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class RankingPanel extends JPanel{
	Horse horse;
	Container container;
	public RankingPanel(Horse horse){
		container = getRootPane();
		this.horse=horse;
		
		setSize(Dimen.frameWidthSize, Dimen.frameHeightSize);
		setLayout(new BorderLayout());
		setBackground(Color.DARK_GRAY);
		setVisible(true);
		container.removeAll();
		container.add(this, BorderLayout.CENTER);
	}

	
}
