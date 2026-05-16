package swing_ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login extends JFrame {
JLabel l1,l2;
JTextField t1,t2;
JButton btn1;
 
public Login() {
	// TODO Auto-generated constructor stub
	setLayout(new FlowLayout());
	l1=new JLabel("Name");
	t1=new JTextField(20);
	l2=new JLabel("Password");
	t2=new JTextField(20);
	btn1=new JButton("Submit");
	btn1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				PreparedStatement preparedStatement=GetConnection.getConnection().prepareStatement("select * from users where username=? and password=?");
				preparedStatement.setString(1, t1.getText());
				preparedStatement.setString(2, t2.getText());
				ResultSet resultSet=preparedStatement.executeQuery();
				if (resultSet.next()) {
					System.out.println("Login Successful");
					new Dashboard();
				} else {
					System.out.println("Login Failed");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
	add(l1);
	add(t1);
	add(l2);
	add(t2);
	add(btn1);
	setSize(400,400);
	setVisible(true);
}
public static void main(String[] args) {
	new Login();
}
}
