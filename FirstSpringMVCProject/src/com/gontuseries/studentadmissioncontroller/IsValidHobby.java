package com.gontuseries.studentadmissioncontroller;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

//creating own form validation annotation
//@Documented is a meta-annotation. You apply @Documented when defining an annotation, to ensure that classes using your
//annotation show this in their generated JavaDoc
@Documented

//we defined the class that is going to validate our field, the message() is the error message that is showed in the 
//user interface and the additional code is most boilerplate code to conforms to the Spring standards
@Constraint(validatedBy = HobbyValidator.class)

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IsValidHobby {
	
	String listOfValidHobbies() default "Music|Football|Cricket|Hockey";
	
	String message() default "Please provide a valid Hobby: "
	+"accepted hobbies are - Music, Football, Cricket and Hockey (choose anyone)";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
