/**
 * 
 */
package com.johnwu.myspringmvcapp;

import static java.lang.annotation.ElementType.FIELD;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

//in order to create customized validate annotation:
//1.create the annotation class and adds the @Constraint 
//2.creates the validator class which implements the validation logic

@Documented
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = HobbyValidator.class)
/**
 * @author Zhou
 *
 */
public @interface IsValidHobby {
	String listOfValidHobbies() default "Music|Football|Hockey"; 
	String message() default "Please provide a valid hobby; " + 
			"accepted hobbies are - Music, Football, Hockey{Choose anyone}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default{}; 
}
