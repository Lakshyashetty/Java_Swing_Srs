package swing_ui;
import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.event.*;


public class Dashboard extends JFrame {

	JMenuBar bar;
	JMenu menu1, menu2;
	JMenuItem item1, item2;
	

	public Dashboard() {
		// TODO Auto-generated constructor stub
		setLayout(new FlowLayout());
		
		bar = new JMenuBar();
		menu1 = new JMenu("File");
		menu2 = new JMenu("Student");
		item1 = new JMenuItem("Logout");
		item1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new Login();
			}
		});

		item2 = new JMenuItem("Add Student");
		item2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Add_Student();
			}
		});

	
		bar.add(menu1);
		bar.add(menu2);
		menu1.add(item1);
		menu2.add(item2);
		setJMenuBar(bar);
		setTitle("Dashboard");
		setSize(400, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Dashboard();
	}
}