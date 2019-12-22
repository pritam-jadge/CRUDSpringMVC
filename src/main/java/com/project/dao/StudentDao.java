package com.project.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.project.bean.Student;

public class StudentDao 
{
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	} 
	
	public int save(Student st)
	{  
	    String sql="insert into student(name,city) values('"+st.getName()+"','"+st.getCity()+"')";  
	    return template.update(sql);  
	}
	
	public int update(Student st)
	{  
	    String sql="update student set rollno="+st.getRollNumber()+",name='"+st.getName()+"',city='"+st.getCity()+"' where rollno="+st.getRollNumber()+"";  
	    return template.update(sql);  
	}
	
	public int delete(int rollNumber)
	{  
	    String sql="delete from student where rollno="+rollNumber+"";  
	    return template.update(sql);  
	}
	
	public Student editStudentRecord(int rollNumber)
	{
		String sql = "select rollno,name,city from student where rollno = ?";
		return template.queryForObject(sql, new Object[]{rollNumber}, (rs, rowNum) ->
        new Student(
        		rs.getInt("rollno"),
                rs.getString("name"),
                rs.getString("city")
        ));
	}
	
	public List<Student> getStudents()
	{  
	    return template.query("select * from student",new RowMapper<Student>(){  
	        public Student mapRow(ResultSet rs, int row) throws SQLException {  
	            Student std=new Student();  
	            std.setRollNumber(rs.getInt(1));
	            std.setName(rs.getString(2));  
	            std.setCity(rs.getString(3));  
	            return std;  
	        }  
	    });  
	}
}
