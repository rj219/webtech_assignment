package Controller;

import java.io.IOException;
import java.util.List;

import Dao.Studentdao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;

@WebServlet("/viewdata")
public class ViewController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		Studentdao dao = new Studentdao();
		
		List<Student> st = dao.viewallStudent();
		
		req.setAttribute("sdata", st);
		req.getRequestDispatcher("View.jsp").forward(req, resp);
		
		
	}

}
