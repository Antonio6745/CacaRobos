package br.sp.cacarobos.controller;
import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.sp.cacarobos.dao.DaoReport;
import br.sp.cacarobos.dao.DaoVote;
import br.sp.cacarobos.model.Report;
import br.sp.cacarobos.model.User;
import br.sp.cacarobos.model.Valuer;
import br.sp.cacarobos.util.EmailUtils;

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
	public String createReport(Report r, User u, Model model)throws EmailException{
		if(!bdReport.reportAlreadyExists(r.getLink())){
			r.setUser(u);
			r.setTrackingCode(bdReport.create(r));
			model.addAttribute("reportAdded", r);
			EmailUtils emailUtils=new EmailUtils();
			emailUtils.sendReportCreatedEmail(u.getLogin().getUsername(), r.getTrackingCode());
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
	
	@RequestMapping("retriveReport")
	public String retriveReport(Report r, Model model){
		model.addAttribute("reportFinded", bdReport.read(r.getId()));
		return "";
	}
	
	@RequestMapping("updateReport")
	public String upadateReport(Report r){
		bdReport.update(r);
		return "redirect:";//to the report "profile page" witch has change
	}
	
	@RequestMapping("findReport")
	public String findReport(Report r, Model model){
		r=bdReport.read(r.getId());
		model.addAttribute("reportFinded", r);
		return "";//add report "profile page"
	}
	
	@RequestMapping("listAllMyActiveReports")
	public String listAllMyActiveReports(User u, Model model){
		model.addAttribute("allMyReports", bdReport.listAllReportsByUserId(u.getId(), true));
		return "";//add report page list
	}
	
	@RequestMapping("listAllMyDisactiveReports")
	public String listAllMyDisactiveReports(User u, Model model){
		model.addAttribute("allMyReports", bdReport.listAllReportsByUserId(u.getId(), false));
		return "";//add report page list
	}
	
	@RequestMapping("voteIsARobot")
	public String voteIsARobot(Report r, Valuer v){
		if(bdVote.alreadyVoted(r, v)){
			return "";//redirect to the same page, but with a warning saying "holly molly, u already had voted"
		}else {
			bdReport.addIsARobotOrNotVote(r.getId(), true);
		}
		return "redirect:";//redirect to the report page (tip: findReport?id=r.getId)
	}
	
	@RequestMapping("voteIsNotARobot")
	public String voteIsNotARobot(Report r, Valuer v){
		if(bdVote.alreadyVoted(r, v)){
			return "";////redirect to the same page, but with a warning saying "holly molly, u already had voted"
		}else{
			bdReport.addIsARobotOrNotVote(r.getId(), false);
		}
		return "redirect:";////redirect to the report page (tip: findReport?id=r.getId)
	}
}