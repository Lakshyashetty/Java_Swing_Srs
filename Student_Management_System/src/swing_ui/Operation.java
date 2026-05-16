package swing_ui;

import java.awt.TextArea;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Operation {
  void RegisterData(Pojo pojo) {
	// TODO Auto-generated method stub
	  try {
		PreparedStatement preparedStatement=GetConnection.getConnection().prepareStatement("insert into users (username,email,password) values(?,?,?)");
		preparedStatement.setString(1, pojo.getName());
		preparedStatement.setString(2, pojo.getEmail());
		preparedStatement.setString(3, pojo.getPassword());
		preparedStatement.executeUpdate();
		System.out.println("DataInserted...");
		
	  } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }

}
  
   void InsertStudent(StudentPojo studentPojo ) {
	// TODO Auto-generated method stub
try {
	PreparedStatement preparedStatement=GetConnection.getConnection().prepareStatement("insert into students (name, email, course, phone, enrollment_date) values(?,?,?,?,?)");
	preparedStatement.setString(1, studentPojo.getName());
	preparedStatement.setString(2, studentPojo.getEmail());
	preparedStatement.setString(3, studentPojo.getCourse());
	preparedStatement.setString(4, studentPojo.getPhone());
	preparedStatement.setString(5, studentPojo.getEnrollmentDate());
	preparedStatement.executeUpdate();
	JOptionPane.showMessageDialog(null, "Student Data Added Successfully",null, JOptionPane.INFORMATION_MESSAGE);
	System.out.println("Data Inserted Successfully");
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
   public StudentPojo  ShowStudent ( StudentPojo studentPojo) {
	// TODO Auto-generated method stub
	   try {
			PreparedStatement preparedStatement = GetConnection.getConnection()
					.prepareStatement("select * from students where student_id=?");
			preparedStatement.setInt(1, studentPojo.getStudentId());
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				studentPojo.setStudentId(resultSet.getInt(1));
				studentPojo.setName(resultSet.getString(2));
				studentPojo.setEmail(resultSet.getString(3));
				studentPojo.setCourse(resultSet.getString(4));
				studentPojo.setPhone(resultSet.getString(5));
				studentPojo.setEnrollmentDate(resultSet.getString(6));
				System.out.println("Student Data Found: " + studentPojo.toString());
				return studentPojo;
			} else {
				JOptionPane.showMessageDialog(null, "No Student Found with ID: " + studentPojo.getStudentId(), "Not Found", JOptionPane.WARNING_MESSAGE);
				System.out.println("Student Not Found");
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

}
    void UpdateStudent(StudentPojo studentPojo) {
	// TODO Auto-generated method stub
    	try {
			PreparedStatement preparedStatement = GetConnection.getConnection().prepareStatement("update students set name=?, email=?, course=?, phone=?, enrollment_date=? where student_id=?");
			preparedStatement.setString(1, studentPojo.getName());
			preparedStatement.setString(2, studentPojo.getEmail());
			preparedStatement.setString(3, studentPojo.getCourse());
			preparedStatement.setString(4, studentPojo.getPhone());
			preparedStatement.setString(5, studentPojo.getEnrollmentDate());
			preparedStatement.setInt(6, studentPojo.getStudentId());
			preparedStatement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Student Updated Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
			System.out.println("Student Data Updated...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
     void DeleteStudent( StudentPojo studentPojo) {
		// TODO Auto-generated method stub
    	 PreparedStatement preparedStatement;
		 try {
			preparedStatement = GetConnection.getConnection().prepareStatement("delete from students where student_id=?");
			preparedStatement.setInt(1, studentPojo.getStudentId());
			int result = preparedStatement.executeUpdate();
			if (result > 0) {
				JOptionPane.showMessageDialog(null, "Student Deleted Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
				System.out.println("Student Data Deleted...");
			} else {
				JOptionPane.showMessageDialog(null, "No Student Found with ID: " + studentPojo.getStudentId(), "Not Found", JOptionPane.WARNING_MESSAGE);
			}
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			 JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		 }
			
	}
     
  
    
    
    
     void ShowAllStudents( TextArea ta1) {
		// TODO Auto-generated method stub
    	 try {
 			PreparedStatement preparedStatement = GetConnection.getConnection().prepareStatement("select * from students");
 			ResultSet resultSet = preparedStatement.executeQuery();
 			
 			ta1.setText("");
 			boolean found = false;
 			while (resultSet.next()) {
 				ta1.append("ID: " + resultSet.getInt(1) + " | Name: " + resultSet.getString(2) + " | Email: " + resultSet.getString(3) + " | Course: " + resultSet.getString(4)	+ " | Phone: " + resultSet.getString(5) + " | Date: " + resultSet.getString(6) + "\n");
 				found = true;
 			}
 			
 			if (!found) {
 				ta1.setText("No Students Found in Database");
 			}
 			System.out.println("All Students Retrieved...");
 		} catch (SQLException e) {
 			ta1.setText("Error: " + e.getMessage());
 			e.printStackTrace();
 		}

	}
}
