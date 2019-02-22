package com.gontuseries.studentadmissioncontroller;

import java.beans.PropertyEditorSupport;

//must extend propertyeditorsupport when creating custom editor
// String value will be passed in the URL as path variable, and we’ll bind that value as an ExoticType object which merely
//keeps the value as an attribute
public class StudentNameEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String studentName) throws IllegalArgumentException {
		if(studentName.contains("Mr. ")|| studentName.contains("Ms. ")) {
			setValue(studentName);
			
		}else {
			studentName = "Ms. "+studentName;
			setValue(studentName);
		}
	}
}
