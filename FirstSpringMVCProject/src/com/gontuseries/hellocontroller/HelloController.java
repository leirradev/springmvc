package com.gontuseries.hellocontroller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("/greet")
public class HelloController {
//public class HelloController extends AbstractController {

	@RequestMapping("/welcome/{countryName}/{userName}")
	public ModelAndView helloWorld(@PathVariable Map<String, String> patWars) {
		String name = patWars.get("userName");
		String country = patWars.get("countryName");
		
		ModelAndView model = new ModelAndView("HelloPage");
		model.addObject("msg","Hello "+ name + ", You are from "+country);
		
		return model;
	}
	
	/*@RequestMapping("/hi")
	public ModelAndView hiWorld() {
		ModelAndView model = new ModelAndView("HelloPage");
		model.addObject("msg", "hi world");
		
		return model;
	}*/
	
	/*@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView modelandview = new ModelAndView("HelloPage");
		modelandview.addObject("msg", "Hi User, welcome to the first spring MVC application");
		return modelandview;
	}*/
}
