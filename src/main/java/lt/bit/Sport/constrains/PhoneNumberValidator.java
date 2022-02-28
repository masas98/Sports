package lt.bit.Sport.constrains;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
	
		
		return value.matches("[+][0-9]{11}");
	}
	
	
	
	
}
