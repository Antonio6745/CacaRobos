package br.sp.cacarobos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.sp.cacarobos.dao.DaoUser;
import br.sp.cacarobos.model.Login;
import br.sp.cacarobos.model.User;

@Controller
public class ControllerUser {
	private final DaoUser bdUser;
	
	@Autowired
	public ControllerUser(DaoUser bdUser) {
		this.bdUser=bdUser;
	}
	
	@RequestMapping("add")
	public String add(User u, Login l){
	
		u.setLogin(l);
		System.out.println(u);
		bdUser.create(u);
		return "testeDoInferno";
	}
	@RequestMapping("listAllUser")
	public String listAllClients(Model model){
		System.out.println();
		model.addAttribute("us", bdUser.listAll());
		return "listUser";
	}
}
