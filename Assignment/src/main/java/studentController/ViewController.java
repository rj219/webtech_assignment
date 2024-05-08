package studentController;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import studentDao.stdDao;
import studentModel.Student;


@WebServlet("/StudentView")
public class ViewController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		stdDao dao = new stdDao();
		ArrayList<Student> std = dao.getAllstudent();
		
		req.setAttribute("data", std);
		req.getRequestDispatcher("Disp.jsp").forward(req, resp);
		
	}
	
}
