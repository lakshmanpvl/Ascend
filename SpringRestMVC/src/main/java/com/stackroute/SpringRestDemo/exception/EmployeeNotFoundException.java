package com.stackroute.SpringRestDemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND, reason="Employee id doesn't exist")
public class EmployeeNotFoundException extends Exception{

}
