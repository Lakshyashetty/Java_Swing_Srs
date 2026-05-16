package swing_ui;



public class StudentPojo {
	private int studentId;
	private String name;
	private String email;
	private String course;
	private String phone;
	private String enrollmentDate;
	
	public int getStudentId() {
		return studentId;
	}
	
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCourse() {
		return course;
	}
	
	public void setCourse(String course) {
		this.course = course;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEnrollmentDate() {
		return enrollmentDate;
	}
	
	public void setEnrollmentDate(String enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}
	
	@Override
	public String toString() {
		return "StudentPojo [studentId=" + studentId + ", name=" + name + ", email=" + email
				+ ", course=" + course + ", phone=" + phone + ", enrollmentDate=" + enrollmentDate + "]";
	}
}