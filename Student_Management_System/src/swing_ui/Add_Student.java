package swing_ui;

import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Add_Student  extends JFrame{
	JLabel  l1,l2,l3,l4,l5,l6;
	JTextField t1,t2,t3,t4,t5,t6;
	JButton btn1,btn2,btn3,btn4,btn5;
	TextArea ta1;
	StudentPojo currentStudent;
	
	public Add_Student() {
		// TODO Auto-generated constructor stub
		setLayout(new FlowLayout());
		l1=new JLabel("Student Id");
		t1=new JTextField(20);
		l2=new JLabel("Name");
		t2=new JTextField(20);
		l3=new JLabel("email");
		t3=new JTextField(20);
		l4=new JLabel("course");
		t4=new JTextField(20);
		l5=new JLabel("phone");
		t5=new JTextField(20);
		l6 = new JLabel("Enrollment Date (yyyy-MM-dd)");
		t6 = new JTextField(20);
		btn1=new JButton("Insert");
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = t2.getText();
				String email = t3.getText();
				String course = t4.getText();
				String phone = t5.getText();
				String enrollmentDate = t6.getText();
				
				if (name.isEmpty() || email.isEmpty() || course.isEmpty() || phone.isEmpty() || enrollmentDate.isEmpty()) {
					JOptionPane.showMessageDialog(null, "All fields are mandatory!", "Validation Error", JOptionPane.WARNING_MESSAGE);
					return;
				}
				StudentPojo studentPojo = new StudentPojo();
				studentPojo.setName(name);
				studentPojo.setEmail(email);
				studentPojo.setCourse(course);
				studentPojo.setPhone(phone);
				
				studentPojo.setEnrollmentDate(enrollmentDate);
				Operation operation = new Operation();
				operation.InsertStudent(studentPojo);
				
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
				ta1.setText("");
			}
		});
		btn2=new JButton("Update");
	btn2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (t1.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Enter Student ID to Update!", "Validation Error", JOptionPane.WARNING_MESSAGE);
				return;
			}
			int studentId = Integer.parseInt(t1.getText());
			StudentPojo pojo = new StudentPojo();
			pojo.setStudentId(studentId);
			Operation operation=new Operation();
			
			StudentPojo studentPojo=operation.ShowStudent(pojo);
			if (studentPojo != null) {
				t2.setText(studentPojo.getName());
				t3.setText(studentPojo.getEmail());
				t4.setText(studentPojo.getCourse());
				t5.setText(studentPojo.getPhone());
				t6.setText(studentPojo.getEnrollmentDate());
				currentStudent = studentPojo ;
				JOptionPane.showMessageDialog(null, "Previous data loaded! Modify and click Save to update.", "Update Mode", JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
	});
	btn3=new JButton("save");
	btn3.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if (t1.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "No student selected for update!", "Validation Error", JOptionPane.WARNING_MESSAGE);
				return;
			}
			int studentId = Integer.parseInt(t1.getText());
			String name = t2.getText().isEmpty() ? (currentStudent != null ? currentStudent.getName() : "") : t2.getText();
			String email = t3.getText().isEmpty() ? (currentStudent != null ? currentStudent.getEmail() : "") : t3.getText();
			String course = t4.getText().isEmpty() ? (currentStudent != null ? currentStudent.getCourse() : "") : t4.getText();
			String phone = t5.getText().isEmpty() ? (currentStudent != null ? currentStudent.getPhone() : "") : t5.getText();
			String enrollmentDate = t6.getText().isEmpty() ? (currentStudent != null ? currentStudent.getEnrollmentDate() : "") : t6.getText();
			StudentPojo pojo = new StudentPojo();
			pojo.setStudentId(studentId);
			pojo.setName(name);
			pojo.setEmail(email);
			pojo.setCourse(course);
			pojo.setPhone(phone);
			pojo.setEnrollmentDate(enrollmentDate);
			
			Operation operation = new Operation();
			operation.UpdateStudent(pojo);
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
			currentStudent = null;
		}
	});
	btn4=new JButton("Delete");
	btn4.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (t1.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Enter Student ID to Delete!", "Validation Error", JOptionPane.WARNING_MESSAGE);
				return;
			}
			int studentId = Integer.parseInt(t1.getText());
			StudentPojo studentPojo=new StudentPojo();
			studentPojo.setStudentId(studentId);
			Operation operation = new Operation();
			operation.DeleteStudent(studentPojo);
			t1.setText("");
//			int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this student?", "Confirmation", JOptionPane.YES_NO_OPTION);
//			
//			if (confirm == JOptionPane.YES_OPTION) {
//				StudentPojo pojo = new StudentPojo();
//				pojo.setStudentId(studentId);
//				
//				Operation operation = new Operation();
//				operation.DeleteStudent(pojo);
//			}
		}
	});
	btn5=new JButton("ShowAll");
	btn5.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Operation operation = new Operation();
			operation.ShowAllStudents(ta1);
		}
	});
	ta1 = new TextArea(10,50);
	ta1.setEditable(false);
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(l3);
		add(t3);
		add(l4);
		add(t4);
		add(l5);
		add(t5);
		add(l6);
		add(t6);
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btn5);
		add(ta1);
		
		setSize(900, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Add_Student();
	}
}
