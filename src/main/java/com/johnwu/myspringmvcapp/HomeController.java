package com.johnwu.myspringmvcapp;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	//initbinder annotation is used for creating customized format while performing data binding
	@InitBinder
	public void initBinder(WebDataBinder binder){
		//create the a new dateformat
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy**mm**dd");
		//resgister the new dateformat to the binder
		binder.registerCustomEditor(Date.class, "studentDOB", new CustomDateEditor(dateFormat, false));
		binder.registerCustomEditor(String.class, "studentName", new StudentNameEditor());
	}
	//method that deals with "/AdmissionForm.html" request
	@RequestMapping(value = "/AdmissionForm.html", method = RequestMethod.GET)
	public ModelAndView home() {
		//System.out.println("we are in admissionform ");
		ModelAndView model1 = new ModelAndView("admissionform");
		return model1;
	}
	
	@ModelAttribute
	public void addCommonVaribale(Model model1){
		model1.addAttribute("headermessage", "Welcome to my spring web application(Zhou Wu)");
	}
	
	
	@RequestMapping(value = "/submitAdmissionForm.html", method = RequestMethod.POST)
	public ModelAndView mainPage(@Valid @ModelAttribute("student1") Student student1, BindingResult result){
		if(result.hasErrors()){
			System.out.println("there is some errors");
			ModelAndView model1 = new ModelAndView("admissionform");
			return model1;
		}
		ModelAndView model1 = new ModelAndView("AdmissionSuccess");
		return model1;
	}
	
}
