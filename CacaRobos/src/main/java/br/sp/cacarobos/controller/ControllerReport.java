package br.sp.cacarobos.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.sp.cacarobos.dao.DaoReport;
import br.sp.cacarobos.dao.DaoVote;
import br.sp.cacarobos.model.Report;
import br.sp.cacarobos.model.User;

@Controller
public class ControllerReport {
	private final DaoReport bdReport;
	private final DaoVote bdVote;
	@Autowired
	public ControllerReport(DaoReport bdReport, DaoVote bdVote) {
		this.bdReport=bdReport;
		this.bdVote=bdVote;
	}
	
	@RequestMapping("registerReport")
	public String createReport(Report r, User u){
		if(!bdReport.reportAlreadyExists(r.getLink())){
			r.setUser(u);
			bdReport.create(r);
		}else {
			return "";
		}
		return "redirect:mainPageUser";//or we can redirect the user to some "thank u 4 the report"
	}
	
	@RequestMapping("createReport")
	public String createReport(){
		return "";//add page to create a report
	}
	
	@RequestMapping("searchTrackingCode")
	public String searchTrackingCode(Report r, Model model){
		model.addAttribute("reportFinded", bdReport.readByTrackingCode(r.getTrackingCode()));
		return "";//add page
	}
}