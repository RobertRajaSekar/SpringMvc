package studentsHtml.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import studentsHtml.dao.StudentDao;
import studentsHtml.dto.Student;

public class SelectServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		StudentDao dao=new StudentDao();
		Student dbstudent=dao.findStudent(id);
		if(dbstudent!=null) {
			PrintWriter printWriter=res.getWriter();
			printWriter.print(dbstudent);
		}
		else {
			PrintWriter printWriter=res.getWriter();
			printWriter.print("Sorry id is not present");
		}
		
	}

}
