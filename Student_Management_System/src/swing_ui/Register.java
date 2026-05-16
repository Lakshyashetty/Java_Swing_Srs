package swing_ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Register extends JFrame {
JLabel l1,l2,l3;
JTextField t1,t2,t3;
JButton btn1,btn2;
 
public Register() {
	// TODO Auto-generated constructor stub
	setLayout(new FlowLayout());
	l1=new JLabel("Name");
	t1=new JTextField(20);
	l2=new JLabel("Email");
	t2=new JTextField(20);
	l3=new JLabel("Password");
	t3=new JTextField(20);
	btn1=new JButton("Insert");
	btn1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String name=t1.getText();
			String email=t2.getText();
			String pass=t3.getText();
			
			Pojo pojo=new Pojo();
			pojo.setName(name);
			pojo.setEmail(email);
			pojo.setPassword(pass);
Operation operation=new Operation();
			operation.RegisterData(pojo);
			 new Login();
			 JOptionPane.showMessageDialog(null, "Registeration Successfully!");

			t1.setText("");
			t2.setText("");
			t3.setText("");
		}
	});
	add(l1);
	add(t1);
	add(l2);
	add(t2);
	add(l3);
	add(t3);
	add(btn1);
	setSize(400,400);
	setVisible(true);
}
public static void main(String[] args) {
	new Register();
}
}
