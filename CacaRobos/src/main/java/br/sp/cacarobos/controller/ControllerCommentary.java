package br.sp.cacarobos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.sp.cacarobos.dao.DaoCommentary;
import br.sp.cacarobos.model.Commentary;
import br.sp.cacarobos.model.Report;
import br.sp.cacarobos.model.User;
import br.sp.cacarobos.model.UserType;
import br.sp.cacarobos.model.Valuer;

@Controller
public class ControllerCommentary {
	private final DaoCommentary bdCommentary;
	
	@Autowired
	public ControllerCommentary(DaoCommentary bdCommentary) {
		this.bdCommentary=bdCommentary;
	}
	
	@RequestMapping("registerUserCommentary")
	public String registerUserCommentary(Commentary c, User u, Report r){
		c.setReport(r);
		c.setUser(u);
		c.setUserType(UserType.USR.userType);
		bdCommentary.createUserCommentary(c);
		return "redirect:";//to the same report "profile page"
	}
	
	@RequestMapping("registerValuerCommentary")
	public String registerValuerCommentary(Commentary c, Valuer v, Report r){
		c.setReport(r);
		c.setValuer(v);
		c.setUserType(UserType.VLR.userType);
		bdCommentary.createValuerCommentary(c);
		return "redirect:";//to the same report "profile page"
	}
	
	@RequestMapping("deleteCommentary")
	public String deleteCommentary(Commentary c){
		bdCommentary.delete(c.getId());
		return "redirect:";//to the same report "profile page"
	}
	
	@RequestMapping("updateCommenatary")
	public String updateCommenatary(Commentary c){
		bdCommentary.update(c);
		return "redirect:";//guess what i'll say
	}
}
