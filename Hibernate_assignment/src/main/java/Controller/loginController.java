package Controller;

import java.io.IOException;

import Dao.Studentdao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;
@WebServlet("/login")
public class loginController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String password = req.getParameter("pass");
		
		Student s = new Student();
		
		s.setEmail(email);
		s.setPass(password);
		
		
		Studentdao dao = new Studentdao();
		
		Student st = dao.loginChk(s);
		
		System.out.println(st);
		
		if(st.equals("")||st.equals(null))
		{
			req.setAttribute("msg", "login Successfull..!!");
		}
		else
		{
			req.getRequestDispatcher("Login.jsp").forward(req, resp);
		}
		
		
		
	}

}
