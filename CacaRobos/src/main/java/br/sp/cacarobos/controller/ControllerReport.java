package br.sp.cacarobos.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.sp.cacarobos.dao.DaoReport;
import br.sp.cacarobos.model.Report;
import br.sp.cacarobos.model.Status;
import br.sp.cacarobos.model.User;
import br.sp.cacarobos.util.EmailUtils;

@Controller
public class ControllerReport {
	private final DaoReport bdReport;
	
	@Autowired
	public ControllerReport(DaoReport bdReport) {
		this.bdReport=bdReport;
	}
	
	//@RequestMapping("approveReport")
	public String approveReport(Report r) throws EmailException{
		bdReport.approveReport(r.getValuer().getId(), true);
		EmailUtils email=new EmailUtils();
		email.sendApproveReportEmail(r.getUser().getLogin().getUsername());
		return "";//add valuer main page
	}
	@RequestMapping("sendReport")
	public String envDen(Report t,HttpSession session,User u) {
		u = (User)session.getAttribute("userLoggedIn");
		t.setUser(u);
		t.setStatus(Status.PROCESSING.status);
		System.out.println(t);
		bdReport.create(t);
		return"redirect:myReport";
	}
	@RequestMapping("myReport")
	public String myRep(Model model,HttpSession s,User u) {
		u = (User) s.getAttribute("userLoggedIn");
		model.addAttribute("listMyReport", bdReport.listByUser(u.getId()));
		return "minhasDenuncias";
	}
	@RequestMapping("deleteReport")	
	public String delRep(Report r) {
		bdReport.delete(r.getId());
		return"redirect:/myReport";
	}
}
