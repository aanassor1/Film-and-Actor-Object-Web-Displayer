package mainPackage.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import mainPackage.Hw1Application;
import mainPackage.domain.Film;

public class FilmValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Film.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Film f = (Film) target;

		for (Film theListFilm : Hw1Application.films) {
			if (f.getId() == theListFilm.getId()) {
				errors.rejectValue("id", "", "ID already in use.");	
			}
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "", "Your film has no title.");
		
		if (f.getSetting().length() < 18) {
			errors.rejectValue("setting", "", "Your setting has to be more than 18 characters and cannot be empty.");
		}
		
	}

}
