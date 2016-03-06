import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class GUI extends JFrame implements ActionListener{
	
	//GUI Definitions
	static JPanel list_panel = new JPanel();
	static JTabbedPane tabbed_pane = new JTabbedPane();
	static JPanel syll_panel = new JPanel();
	static JPanel data_panel = new JPanel();
	static JMenuBar mb = new JMenuBar();
	static JList<Syllabus> syll_list = new JList<Syllabus>();
	
	
	public GUI(){
		super("UniLens");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(list_panel,BorderLayout.WEST);
		add(tabbed_pane);
		setJMenuBar(mb);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
