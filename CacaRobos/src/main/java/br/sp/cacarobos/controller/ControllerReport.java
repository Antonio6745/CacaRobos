package br.sp.cacarobos.controller;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.sp.cacarobos.dao.DaoReport;
import br.sp.cacarobos.model.Report;
import br.sp.cacarobos.util.EmailUtils;

@Controller
public class ControllerReport {
	private final DaoReport bdReport;
	
	@Autowired
	public ControllerReport(DaoReport bdReport) {
		this.bdReport=bdReport;
	}
	
	@RequestMapping("createReport")
	public String createReport(Report r){
		r.getUser().setId((long)1);;
		bdReport.create(r);
		return "testeDoInferno";
	}
	
	//@RequestMapping("approveReport")
	public String approveReport(Report r) throws EmailException{
		bdReport.approveReport(r.getValuer().getId(), true);
		EmailUtils email=new EmailUtils();
		email.sendApproveReportEmail(r.getUser().getLogin().getUsername());
		return "";//add valuer main page
	}
}
