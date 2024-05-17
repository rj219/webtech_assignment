package Controller;

import java.io.IOException;

import Dao.Studentdao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;
@WebServlet("/reg")
public class RegController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		String gender = req.getParameter("gender");
		String password = req.getParameter("password");
		
		Student s = new Student();
		
		s.setFname(fname);
		s.setLname(lname);
		s.setEmail(email);
		s.setMobile(mobile);
		s.setGender(gender);
		s.setPass(password);
		
		Studentdao dao = new Studentdao();
		
		int i = dao.addOrupdate(s);
		
		if(i>0)
		{
			req.setAttribute("msg", "Registration Successful..!!");
			req.getRequestDispatcher("Home.jsp").forward(req, resp);
		}
		
	}

}
