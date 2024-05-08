package Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lnamevalidator {
	
	public static boolean lnameValidate(String lname)
	{
		boolean b = false;
		
		Pattern pattern = Pattern.compile("^[A-Za-z]+$");
		
		Matcher match = pattern.matcher(lname);
		
		b = match.matches();
		
		return b;
	}

}
