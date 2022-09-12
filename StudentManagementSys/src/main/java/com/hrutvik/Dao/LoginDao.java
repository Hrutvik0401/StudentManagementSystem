package com.hrutvik.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.hrutvik.model.Student;

public class LoginDao {
	public String Validate(String uname, String pass) {
		
		Connection connection = null;
		String password = null;
		String result = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "root");
			PreparedStatement stmt = connection.prepareStatement("SELECT password FROM student where username='"+uname+"' ");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				password = rs.getString(1);
			}
			
			if (password.equals(pass)) {
				result = "Success";
			}else {
				result = "Fail";
			}
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}
	
public Student UserRegitration(Student student) {
	
		Student student1 = new Student();
		
		student1.setSid(student.getSid());
		student1.setSname(student.getSname());
		student1.setEmail(student.getEmail());
		student1.setUsername(student.getUsername());
		student1.setPassword(student.getPassword());
		student1.setMobile(student.getMobile());
	
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "root");
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO student VALUES(?,?,?,?,?,?)");
			
			stmt.setInt(1, student1.getSid());
			stmt.setString(2, student1.getSname());
			stmt.setString(3, student1.getEmail());
			stmt.setString(4, student1.getUsername());
			stmt.setString(5, student1.getPassword());
			stmt.setLong(6, student1.getMobile());

			int rs = stmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
		return student;
	}

public List<Student> GetStudents() {
	
	List<Student> students = new ArrayList<Student>();
	Student student = null;
	Connection connection = null;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "root");
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM student");
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			student = new Student();
			student.setSid(rs.getInt(1));
			student.setSname(rs.getString(2));
			student.setEmail(rs.getString(3));
			student.setUsername(rs.getString(4));
			student.setPassword(rs.getString(5));
			student.setMobile(rs.getLong(6));
			
			students.add(student);	
		}
		
	} catch (Exception e) {
		System.out.println(e);
	}finally {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	return  students;
}
public Student getStudentById(int SId) {
	
	Connection connection = null;
	Student student = null;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "root");
		PreparedStatement stmt = connection.prepareStatement("SELECT* FROM student where sid = ?");
		stmt.setInt(1, SId);
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			student = new Student();
			student.setSid(rs.getInt(1));
			student.setSname(rs.getString(2));
			student.setEmail(rs.getString(3));
			student.setUsername(rs.getString(4));
			student.setPassword(rs.getString(5));
			student.setMobile(rs.getLong(6));
		}
	} catch (Exception e) {
		System.out.println(e);
	}finally {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	return student;
}

public Student UpdateStudent( Student student) {
	
	Student student1 = new Student();
	
	student1.setSid(student.getSid());
	student1.setSname(student.getSname());
	student1.setEmail(student.getEmail());
	student1.setUsername(student.getUsername());
	student1.setPassword(student.getPassword());
	student1.setMobile(student.getMobile());

	Connection connection = null;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "root");
		PreparedStatement stmt = connection.prepareStatement("UPDATE student SET sname=?, email=?, username=?, password=?, mobile=? where sid=?");
		
		
		stmt.setString(1, student1.getSname());
		stmt.setString(2, student1.getEmail());
		stmt.setString(3, student1.getUsername());
		stmt.setString(4, student1.getPassword());
		stmt.setLong(5, student1.getMobile());
		stmt.setInt(6, student1.getSid());

		int rs = stmt.executeUpdate();
		
	} catch (Exception e) {
		System.out.println(e);
	}finally {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	return student;
}
	
public Student DeleteStudentById(int SId) {
	
	Connection connection = null;
	Student student = null;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "root");
		PreparedStatement stmt = connection.prepareStatement(" DELETE FROM student where sid = ?");
		stmt.setInt(1, SId);
		int rs = stmt.executeUpdate();
		
	} catch (Exception e) {
		System.out.println(e);
	}finally {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	return student;
}
}
