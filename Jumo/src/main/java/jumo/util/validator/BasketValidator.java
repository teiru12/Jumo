package jumo.util.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import jumo.model.BasketBean;

public class BasketValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return BasketBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {		

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "BNAME", "required");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "BEMAIL", "required");
		
	}

}