package br.sp.cacarobos.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class ExceptionHandlerController {
	@ExceptionHandler(ClassCastException.class)
	public String cpfExcepetion() {
		return "cpfError";
	}
	@ExceptionHandler(SQLException.class)
	public String sqlEx() {
		return"erroSQL";
	}
	@ExceptionHandler(NullPointerException.class)
	public String nullPointerHandler() {
		return"erroNull";
	}
}
