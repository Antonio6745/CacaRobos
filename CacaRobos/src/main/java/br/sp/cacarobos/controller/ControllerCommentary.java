package br.sp.cacarobos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.sp.cacarobos.dao.DaoCommentary;
import br.sp.cacarobos.model.Commentary;
import br.sp.cacarobos.model.Report;
import br.sp.cacarobos.model.User;

@Controller
public class ControllerCommentary {
	private final DaoCommentary bdCommentary;
	
	@Autowired
	public ControllerCommentary(DaoCommentary bdCommentary) {
		this.bdCommentary=bdCommentary;
	}
	
	@RequestMapping("registerCommentary")
	public String registerCommentary(Commentary c, User u, Report r){
		c.setReport(r);
		c.setUser(u);
		bdCommentary.create(c);
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
