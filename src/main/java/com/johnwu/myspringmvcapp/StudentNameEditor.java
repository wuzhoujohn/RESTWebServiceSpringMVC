package com.johnwu.myspringmvcapp;

import java.awt.Component;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.beans.PropertyChangeListener;
import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;

public class StudentNameEditor extends PropertyEditorSupport {
	@Override
	public void setAsText(String studentName) throws IllegalArgumentException{
		//checks if studentName contains gender, if yes then set the value, or add "Ms." as default value
		if(studentName.contains("Mr.") || studentName.contains("Ms.")){
			setValue(studentName);
		}else{
			studentName = "Ms." + studentName;
			setValue(studentName);
		}
	}
}
