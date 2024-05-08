package Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {
	
	public static boolean passwordvalidator(String Password)
	{
		boolean b = false;
		
		Pattern pattern = Pattern.compile("(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*()-+=?]).{8,}");
		
		Matcher match = pattern.matcher(Password);
		
		b = match.matches();
		
		return b;
		
	}

}
