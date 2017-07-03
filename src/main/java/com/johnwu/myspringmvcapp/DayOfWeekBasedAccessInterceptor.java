package com.johnwu.myspringmvcapp;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//in order to instruct Spring MVC to perform some tasks before handling a request
//1.Include a java Class which extends HandlerInterceptorAdapter class and overrides
//one of its methos with the name preHandle
//2.Write the code in the prehandle method which you want spring MVC to execute before
//handling the request
//3. put an enty of this newly added Java Class in the Spring's configuration


//this class is implemented by the logic that it would not accept requests on Sunday

public class DayOfWeekBasedAccessInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle) throws Exception{
		Calendar cal = Calendar.getInstance();
		int dayOfWeek = cal.get(cal.DAY_OF_WEEK);//getting the day on which request is made
		System.out.println("today is " + dayOfWeek);
		if(dayOfWeek == 1){
			response.getWriter().write("Today is Sunday, the WebSite is closed today, please revisit during other day");
			return false;
		}
		return true;
	}
	
	//posthandle is called right after the spring MVC executes request handler method for the request and before delegate to view file
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception{
		System.out.println("HandlerInterceptorAdapter : Spring MVC called postHandle method for " + request.getRequestURI().toString());
	}
	
	//afterCompletion is called right after the view file produces response object for the request
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception{
		System.out.println("HandlerInterceptorAdapter : Spring MVC called afterCompletion method for " + request.getRequestURI().toString());
	}
}
