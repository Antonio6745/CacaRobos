package br.sp.cacarobos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.sp.cacarobos.dao.DaoManager;
import br.sp.cacarobos.model.Login;
import br.sp.cacarobos.model.Manager;
import br.sp.cacarobos.model.Valuer;

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
	@RequestMapping("listAllManager")
	public String listAllClients(Model model,Manager m){
		System.out.println(m);
		model.addAttribute("man", bdM.listAll());
		return "listManager";
	}
	@RequestMapping("deleteManager")
	public String del(Manager m) {
		bdM.delete(m.getId());
		return "redirect:listAllManager";
	}
}
