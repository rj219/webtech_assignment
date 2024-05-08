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
@WebServlet("/deletedData")
public class deletedDataController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		stdDao dao = new stdDao();
		
		ArrayList<Student> s = dao.deletedData();
		
		req.setAttribute("Ddata", s);
		req.getRequestDispatcher("deletedData.jsp").forward(req, resp);
		
	}

}
