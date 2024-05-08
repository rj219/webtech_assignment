package Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
	
	public static boolean emailCheck(String email)
	{
		boolean b = false;
		
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+@[a-z]+\\.[a-z]+$");
		
		Matcher match = pattern.matcher(email);
		
		b = match.matches();
		
		return b;
	}

}
