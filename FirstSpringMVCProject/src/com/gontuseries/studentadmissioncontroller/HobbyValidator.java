package com.gontuseries.studentadmissioncontroller;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//creating custom form validation annotation
//defines the logic to validate a given constraint for a given object
public class HobbyValidator implements ConstraintValidator<IsValidHobby, String> {
	
	private String listOfValidHobbies;
	
	@Override
	public void initialize(IsValidHobby invalidHobby) {
		// TODO Auto-generated method stub
		this.listOfValidHobbies=invalidHobby.listOfValidHobbies();
	}

	@Override
	public boolean isValid(String studentHobby, ConstraintValidatorContext ctx) {
		if (studentHobby == null) {
			return false;
		}

		if (studentHobby.matches(listOfValidHobbies)) {
			return true;
		} else {
			return false;
		}

	}

}
