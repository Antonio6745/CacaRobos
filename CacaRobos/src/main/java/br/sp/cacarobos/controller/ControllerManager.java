package br.sp.cacarobos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.sp.cacarobos.dao.DaoManager;
import br.sp.cacarobos.model.Login;
import br.sp.cacarobos.model.Manager;

@Controller
public class ControllerManager {

	private final DaoManager bdM;
	
	@Autowired
	public ControllerManager (DaoManager bdM) {
		this.bdM = bdM;
	}
	@RequestMapping("homeM")
	public String homeManager() {
		
		return"testeManager";
	}
	@RequestMapping("addManager")
	public String ad(Manager m , Login l) {
		m.setLogin(l);
		bdM.create(m);
		return "testeManager";
		
	}
}
