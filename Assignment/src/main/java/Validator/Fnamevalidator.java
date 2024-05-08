package Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Fnamevalidator {
	
	public static boolean fnameCheck(String fname)
	{
		boolean b = false;
		
		Pattern pattern = Pattern.compile("^[A-Za-z].+$");
		
		Matcher match = pattern.matcher(fname);
		
		b = match.matches();
		
		return b;
	}

}
