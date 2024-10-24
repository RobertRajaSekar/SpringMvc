package studentsHtml.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentsHtml.dao.StudentDao;
import studentsHtml.dto.Student;

public class UpdateServlet1 extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
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
			resp.sendRedirect("https://youtu.be/3wDiqlTNlfQ?feature=shared");
		}
		else {
			PrintWriter printWriter=resp.getWriter();
			printWriter.print("sorry id is not present");
		}
		
    }
}
