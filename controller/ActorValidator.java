package mainPackage.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import mainPackage.domain.Actor;

public class ActorValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Actor.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Actor a = (Actor) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Your name is empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "agent", "", "Your name is empty.");
		
		if (a.getLanguage().equals("English")) {
			//valid
		} else if (a.getLanguage().equals("Spanish")) {
			//valid
		} else if (a.getLanguage().equals("French")) {
			//valid
		} else {
			errors.rejectValue("language", "", "Your language has to be english, spanish or french.");
		}
		
		if (a.getAge() < 1) {
			errors.rejectValue("age", "", "Your age has to be in between 1 or 110.");
		} else if (a.getAge() > 110) {
			errors.rejectValue("age", "", "Your age has to be in between 1 or 110.");
		}
	}

}
