package no.hvl.dat108;

public class ValidatorTemp {
	
	public static boolean isValidTemp(String s) {
		return s != null
				&& !s.isEmpty()
				&& containsOnlyDigits(s);
	}
	
	private static boolean containsOnlyDigits(String s) {
		boolean result = true;
		
		if (!s.matches("[0-9]+(\\.){0,1}[0-9]*")) {
			result = false;
		}
		return result;
	}
	
	public static boolean isValidNumber (String s, String convert) {
		boolean result = true;
		Double tall = Double.parseDouble(s);
		
		if (convert.contains("fahr")) {
			if (tall <= -459.67) {
				result = false;
			}
		} else if (convert.contains("cels")) {
			if (tall <= -273.5) {
				result = false;
			}
		}
	
		return result;
	}

}
