package br.sp.cacarobos.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.sp.cacarobos.dao.DaoCommentary;
import br.sp.cacarobos.dao.DaoReport;
import br.sp.cacarobos.model.Report;
import br.sp.cacarobos.model.Status;
import br.sp.cacarobos.model.User;

@Controller
public class ControllerReport {
	private final DaoReport bdReport;
	private final DaoCommentary bdCommentary;
	
	@Autowired
	public ControllerReport(DaoReport bdReport,DaoCommentary bdCommentary) {
		this.bdReport=bdReport;
		this.bdCommentary=bdCommentary;
	}

	@RequestMapping("sendReport")
	public String envDen(Report t,HttpSession session,User u) {
		u = (User)session.getAttribute("userLoggedIn");
		t.setUser(u);
		t.setStatus(Status.PROCESSING.status);
		bdReport.create(t);
		return"redirect:myReport";
	}
	
	@RequestMapping("myReport")
	public String myRep(Model model,HttpSession s,User u) {
		u = (User) s.getAttribute("userLoggedIn");
		System.out.println(u);
		List<Report> reportList = bdReport.listByUser(u.getId());
		reportList.forEach(i->i.setCommentaryList(bdCommentary.listCommentsByReportId(i.getId())));
		System.out.println(reportList);
		model.addAttribute("listMyReport", reportList);
		return "minhasDenuncias";
	}
	
	@RequestMapping("deleteReport")	
	public String delRep(Report r) {
		bdReport.delete(r.getId());
		return"redirect:/myReport";
	}
}
