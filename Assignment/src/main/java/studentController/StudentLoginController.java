package studentController;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import studentDao.stdDao;
import studentModel.Student;
@WebServlet("/Studentlogin")
public class StudentLoginController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		
		Student student = new Student();
		
		student.setEmail(email);
		student.setPass(pass);
		
		stdDao dao = new stdDao();
		
		String lname = dao.loginChk(student);
		
		if(lname==null)
		{
			req.setAttribute("loginErr", "Invalid Credentials..!!!!");
			req.getRequestDispatcher("StudentLogin.jsp").forward(req, resp);
		}
		else
		{
			req.setAttribute("LoginMsg", "Login  Sccessfully..!!!");
			req.setAttribute("lname", lname);
			req.getRequestDispatcher("otpGenerator").forward(req, resp);
			
		}
		
		}

}
