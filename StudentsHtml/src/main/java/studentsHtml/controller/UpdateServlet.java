package studentsHtml.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import studentsHtml.dao.StudentDao;
import studentsHtml.dto.Student;

public class UpdateServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String address=req.getParameter("address");
		long phone=Long.parseLong(req.getParameter("phone"));
		
		Student student=new Student();
		student.setName(name);
		student.setAddress(address);
		student.setEmail(email);
		student.setPassword(password);
		student.setPhone(phone);
		
		StudentDao dao=new StudentDao();
		Student dbStudent=dao.updateStudent(id, student);
		if(dbStudent!=null) {
			PrintWriter printWriter=res.getWriter();
			printWriter.print("id Updated");
		}
		else {
			PrintWriter printWriter=res.getWriter();
			printWriter.print("sorry id is not present");
		}
		
		
	}
	

}
