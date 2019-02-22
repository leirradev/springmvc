package com.gontuseries.studentadmissioncontroller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//using interceptor
//HandlerInterceptorAdapter is abstract adapter class for the HandlerInterceptor interface, for simplified implementation 
//of pre-only/post-only interceptors
public class DayOfWeekBasedAccessInterceptor extends HandlerInterceptorAdapter {
// This method is used to intercept the request before it’s handed over to the handler method
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
			Object handler) throws  Exception{
		
		Calendar cal = Calendar.getInstance();
		
		int dayOfWeek = cal.get(cal.DAY_OF_WEEK);
		
//		1 - sunday 2 - monday ... 7 - saturday
		if(dayOfWeek ==1) {
			response.getWriter().write("The website is closed on Sunday; please try accessing it on any other week day!");
			return false;
		}
		
		return true;
	}
	
//	called when HandlerAdapter has invoked the handler but DispatcherServlet is yet to render the view
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler
			, ModelAndView modelAndView) throws Exception {
		
		System.out.println("HandlerInterceptorAdapter: Spring MVC called postHandle method for "
		+request.getRequestURI().toString());
	}
	
//	callback method that is called once the handler is executed and view is rendered
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler
			, Exception ex) throws Exception {
		
		System.out.println("HandlerInterceptorAdapter: Spring MVC called afterCompletion method for "
				+request.getRequestURI().toString());
	}
	
}
