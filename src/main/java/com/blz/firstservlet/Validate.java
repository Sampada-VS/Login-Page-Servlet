package com.blz.firstservlet;

public class Validate {

	public static boolean checkValidation(String username, String userpwd) {
		boolean result = false;
		String nameRegex = "^[A-Z][a-z]{2,}$";
		String pwdRegex = "^(?=.*[0-9])(?=.*[A-Z])[a-zA-Z0-9!@#$%^&*]{8,}$";
		if (username.matches(nameRegex) && userpwd.matches(pwdRegex)
			&& userpwd.length() - userpwd.replaceAll("\\W", "").length() == 1) {
			result = true;
		}
		return result;
	}
}
