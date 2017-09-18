package br.sp.cacarobos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.sp.cacarobos.dao.DaoValuer;
import br.sp.cacarobos.model.Login;
import br.sp.cacarobos.model.Valuer;

@Controller
public class ControllerValuer {

	private final DaoValuer bdV;
	
	@Autowired
	public ControllerValuer(DaoValuer bdV) {
		this.bdV = bdV;
	}
	
	@RequestMapping("homeV")
	public String homeValuer() {
		return "testeValuer";
	}
	
	@RequestMapping("addValuer")
	public String addV(Valuer v, Login l) {
		v.setActiveAccount(true);
		v.setLogin(l);
		bdV.create(v);
		
		return"testeValuer";
	}
}
