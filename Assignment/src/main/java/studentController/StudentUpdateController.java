package studentController;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import studentDao.stdDao;
import studentModel.Student;
@WebServlet("/update")
public class StudentUpdateController  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action = req.getParameter("action");
		int id = Integer.parseInt(req.getParameter("id"));
		stdDao dao = new stdDao();
		
		if(action.equals("edit"))
		{
			Student s = dao.getstudent(id);
			req.setAttribute("sdata", s);
			req.getRequestDispatcher("StudentRegistration.jsp").forward(req, resp);
		}
		else if(action.equals("delete"))
		{
			int i = dao.deleteStudent(id);
			
			if(i>0)
			{
				req.setAttribute("deleteMsg", "student deleted Successfully...!!!");
				req.getRequestDispatcher("StudentView").forward(req, resp);
			}
		}
		
	}

}
