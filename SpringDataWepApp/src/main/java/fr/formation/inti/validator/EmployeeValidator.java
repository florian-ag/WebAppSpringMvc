package fr.formation.inti.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import fr.formation.inti.model.Employee;

@Component
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> paramClass) {
		return Employee.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Employee emp = (Employee) obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate", "startDate.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "title.required");
	
//		if (emp.firstName() != null) {
//			if (emp.getDeptid() <= 0) {
//				errors.rejectValue("deptid", "negativeValue", new Object[] { "'deptid'" }, "Deptid can't be negative");
//			}
//		}
//
//		if (emp.getAssignedid() != null) {
//			if (emp.getAssignedid() <= 0) {
//				errors.rejectValue("assignedid", "negativeValue", new Object[] { "'assignedid'" },
//						" Assignedid can't be negative");
//			}
//		}
//
//		if (emp.getSuperiorid() != null) {
//			if (emp.getSuperiorid() <= 0) {
//				errors.rejectValue("superiorid", "negativeValue", new Object[] { "'superiorid'" },
//						"Superiorid can't be negative");
//			}
//		}

	}
}
