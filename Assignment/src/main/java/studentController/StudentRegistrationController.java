package studentController;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import studentDao.stdDao;
import studentModel.Student;
@WebServlet("/rege")
public class StudentRegistrationController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		String gender = req.getParameter("gender");
		String pass = req.getParameter("pass");
		
		Student student = new Student();
		
		student.setFname(fname);
		student.setLname(lname);
		student.setEmail(email);
		student.setMobile(mobile);
		student.setGender(gender);
		student.setPass(pass);
		
		
		stdDao dao = new stdDao();
		
		if(id.equals("")||id.equals(null))
		{
			boolean b = dao.emailExit(student);
			
			if(b)
			{
				req.setAttribute("emailErr", "Email already exist...!!!");
				req.getRequestDispatcher("StudentRegistration.jsp").forward(req, resp);
			}
			else
			{
				int i = dao.studentRegistration(student);
				
				if(i>0)
				{
					req.setAttribute("registrationMsg", "Student Registration successfully..!!!!");
					req.getRequestDispatcher("StudentRegistration.jsp").forward(req, resp);
					
				}
				
			}
		}
		else
		{
			int uid = Integer.parseInt(id);
			student.setId(uid);
			boolean b = dao.emailExit(student);
			
			if(b)
			{
				req.setAttribute("emailErr", "Email already exist...!!!");
				req.getRequestDispatcher("StudentRegistration.jsp").forward(req, resp);	
			}
			else
			{
				int i = dao.updateStudent(student);
				if(i>0)
				{
					req.setAttribute("updateMsg", "Studet details update successfully...!!!");
					req.getRequestDispatcher("StudentRegistration.jsp").forward(req, resp);
				}
			}
		}
		
		
		
	}

}
