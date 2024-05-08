package Controller;

import java.io.IOException;

import Validator.EmailValidator;
import Validator.Fnamevalidator;
import Validator.Lnamevalidator;
import Validator.PasswordValidator;
import Validator.mobileValidator;
import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebFilter("/reg")
public class ValidationStudentFilter extends HttpFilter {
	
	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String password = request.getParameter("password");
		
		RequestDispatcher rd = request.getRequestDispatcher("Studentform.jsp");
		
		
		if(fname.equals("")||fname.equals(null))
		{
			request.setAttribute("fnameerr", "First name can not be blank..!!!!");
			rd.forward(request, response);
		}
		else if(!Fnamevalidator.fnameCheck(fname))
		{
			request.setAttribute("fnameerr", "Invalid first name formate..!!!");
			rd.forward(request, response);
		}
		if(lname.equals("")||lname.equals(null))
		{
			request.setAttribute("lnameerr", "Last name can not be blank...!!!");
			rd.forward(request, response);
		}
		else if(!Lnamevalidator.lnameValidate(lname))
		{
			request.setAttribute("lnameerr", "Invalid last name formate");
			rd.forward(request, response);
		}
		if(email.equals("")||email.equals(null))
		{
			request.setAttribute("Emailerr", "Email can not be blank..!!");
			rd.forward(request, response);
		}
		else if(!EmailValidator.emailCheck(email))
		{
			request.setAttribute("Emailerr", "Invalid Email formate...!!!!");
			rd.forward(request, response);
		}
		if(mobile.equals("")||mobile.equals(null))
		{
			request.setAttribute("mobileerr", "Mobile can not be blank...!!!!");
			rd.forward(request, response);
		}
		else if(!mobileValidator.mobileValidator(mobile))
		{
			request.setAttribute("mobileerr", "mobile should be 10 digit");
			rd.forward(request, response);
		}
		if(password.equals("")||password.equals(null))
		{
			request.setAttribute("passErr", "Password can not be blank..!!!");
			rd.forward(request, response);
		}
		else if(!PasswordValidator.passwordvalidator(password))
		{
			request.setAttribute("passErr", "Pass must be in correct formate...!!!");
			rd.forward(request, response);
		}
		
		chain.doFilter(request, response);
		
	}
	

	
	
	

}
