package com.gontuseries.studentadmissioncontroller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//import spring mvc framework jars and commons-logging
//download apache tomcat for web server
//tells spring that the class specified contains methods that will handle http request without you having to implement the
//Controller interface or extend a subclass that implements the controller
@Controller
public class StudentAdmissionController {

//	@initbinder and webdatabinder - annotate it with @InitBinder which plays the role to identify WebDataBinder method in our 
//	controller. registerCustomEditor() is a method of WebDataBinder which configures PropertyEditor like CustomDateEditor
//	WebDataBinder binds custom validators
	@InitBinder
	public void initBinder(WebDataBinder binder) {
//		binder.setDisallowedFields(new String[] {"studentMobile"});
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy****MM****dd");
		
		binder.registerCustomEditor(Date.class, "studentDOB", new CustomDateEditor(dateFormat, false));
		binder.registerCustomEditor(String.class, "studentName", new StudentNameEditor());
	}
	
//	@requestmapping - used to map web requests to Spring Controller methods. This annotation maps HTTP requests to handler methods
//	of MVC and REST controllers
//	modelandview - Holder for both Model and View in the web MVC framework
	@RequestMapping(value = "/admissionForm.html", method = RequestMethod.GET)
	public ModelAndView getAdmissionForm() throws Exception{
		String exceptionOccured = "ARITHMETIC_EXCEPTION1";
		
		if(exceptionOccured.equalsIgnoreCase("NULL_POINTER")) {
			throw new NullPointerException("Null Pointer Exception");
		}else if(exceptionOccured.equalsIgnoreCase("IO_EXCEPTION")) {
			throw new IOException("IO Exception");
		}else if(exceptionOccured.equalsIgnoreCase("ARITHMETIC_EXCEPTION")) {
			throw new Exception("Arithmetic Exception");
		}

		ModelAndView model1 = new ModelAndView("AdmissionForm");
		return model1;
//		model.addObject("headerMessage", "BulSU College of Engineering, Philippines");
	}
	
//	@modelattribute - an annotation that binds a method parameter or method return value to a named model attribute and then
//	exposes it to a web view
//	Spring invokes all methods that have @ModelAttribute annotation before handler methods 
//	(i.e. methods annotated with the @RequestMapping) in a same controller
//	Model - To provide a view with usable data, we simply add this data to its Model object. Additionally, maps with 
//	attributes can be merged with Model instances
	@ModelAttribute
	public void addingCommonObjects(Model model1) {
		model1.addAttribute("headerMessage", "BulSU College of Engineering, Philippines");
	}
	
//	@requestparam - annotation is used to bind parameter values of query string to the controller method parameters
//	this annotation is used to map web requests onto specific handler classes and/or handler methods.
//	public ModelAndView submitAdmissionForm(@RequestParam(value="studentName", defaultValue="MR. ABCDE") String name
//		,@RequestParam("studentHobby") String hobby) {
	
//	public ModelAndView submitAdmissionForm(@RequestParam Map<String, String> reqPar) {
//		String name =reqPar.get("studentName");
//		String hobby=reqPar.get("hobby");

//	public ModelAndView submitAdmissionForm(@RequestParam("studentName") String name
//		, @RequestParam("studentHobby") String hobby) {
//		Student student1 = new Student();
//		student1.setStudentName(name);
//		student1.setStudentHobby(hobby);

//	Form Validations - should import hibernate validator jars
//	@Valid - verifies whether there are any validation errors
//	bindingresult - Spring's object that holds the result of the validation and binding and contains errors that may have 
//	occurred. Spring then invokes the validator and puts any errors in the BindingResult and adds the BindingResult to the 
//	view model
	@RequestMapping(value = "/submitAdmissionForm.html", method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@Valid @ModelAttribute("student1") Student student1, BindingResult result) {
		if (result.hasErrors()) {
			ModelAndView model1 = new ModelAndView("AdmissionForm");
			return model1;
		}

		ModelAndView model1 = new ModelAndView("AdmissionSuccess");
		return model1;
//		model.addObject("headerMessage","BulSU College of Engineering, Philippines");
//		model.addObject("student1", student1);
	}
}