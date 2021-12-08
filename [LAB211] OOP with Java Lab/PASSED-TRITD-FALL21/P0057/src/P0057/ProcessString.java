package P0057;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProcessString {

	public boolean containsWhiteSpace(String s) {
		for (char c : s.toCharArray()) {
			if (Character.isWhitespace(c)) {
				return true;
			}
		}
		return false;
	}

	public boolean password_Validation(String password) {
		if ((password.length() >= 8) && !containsWhiteSpace(password)) {
			Pattern special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
			Matcher hasSpecial = special.matcher(password);
			return hasSpecial.find();
		} else
			return false;
	}

	public boolean userName_Validation(String username) {
		if ((username.length() >= 5) && !containsWhiteSpace(username)) {
			return true;
		}
		return false;
	}
}
