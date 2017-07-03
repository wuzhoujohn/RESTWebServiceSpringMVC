/**
 * 
 */
package com.johnwu.myspringmvcapp;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Zhou
 *
 */
public class HobbyValidator implements ConstraintValidator<IsValidHobby, String>{
	
	private String listOfValidHobbies;

	//a Validator class used by a custom annotation always implements the
	//ConstraintValidator interface and override two of its methos - initialize and isValid
	@Override
	public void initialize(IsValidHobby isValidHobby) {
		// initialize is always called before calling isValid
		this.listOfValidHobbies = isValidHobby.listOfValidHobbies();
	}

	@Override
	public boolean isValid(String studentHobby, ConstraintValidatorContext ctx) {
		//this method has to be called in oreder to perform validation
		// TODO Auto-generated method stub
		if(studentHobby == null){
			return false;
		}
		if(studentHobby.matches(this.listOfValidHobbies)){
			return true;
		}else{
			return false;
		}
	}

}
