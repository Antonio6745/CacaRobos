package br.sp.cacarobos.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.sp.cacarobos.dao.DaoLogin;
import br.sp.cacarobos.model.Login;
import br.sp.cacarobos.model.Manager;
import br.sp.cacarobos.model.User;
import br.sp.cacarobos.model.UserType;
import br.sp.cacarobos.model.Valuer;

@Controller
public class ControllerLogin {
	private final DaoLogin bdLogin;
	public ControllerLogin(DaoLogin bdLogin){
		this.bdLogin=bdLogin;
	}
	
	@RequestMapping("home")
	public String home() {return "testeDoInferno";}
	
	@RequestMapping("sigin")
	public String sigin(Login l, HttpSession session){
		l=bdLogin.sigin(l);
		if(l!=null){
			if(l.getUserType().equals(UserType.ADM.userType)){
				Manager t=bdLogin.retriveInfoManager(l);
				session.setAttribute("managerLoggedIn", t);
				return "mainPageManager";
			}else if(l.getUserType().equals(UserType.USR.userType)){
				User t=bdLogin.retriveInfoUser(l);
				session.setAttribute("userLoggedIn", t);
				return "mainPageUser";
			}else if(l.getUserType().equals(UserType.VLR.userType)){
				Valuer t=bdLogin.retriveInfoValuer(l);
				session.setAttribute("valuerLoggedIn", t);
				return "mainPageValuer";
			}
		}
		return "testeDoInferno";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "";//add index page
	}
}
