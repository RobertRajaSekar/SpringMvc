package studentsHtml.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import studentsHtml.dao.StudentDao;
import studentsHtml.dto.Student;

public class SignupServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
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
	
	StudentDao studentDao=new StudentDao();
	Student dbStudent=studentDao.saveStudent(student);
	RequestDispatcher dispatcher=req.getRequestDispatcher("Login.html");
	dispatcher.forward(req, res);
	}

}
