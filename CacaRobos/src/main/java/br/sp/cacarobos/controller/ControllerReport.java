package br.sp.cacarobos.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.sp.cacarobos.dao.DaoReport;
import br.sp.cacarobos.model.Report;

@Controller
public class ControllerReport {
	private final DaoReport bdReport;
	
	@Autowired
	public ControllerReport(DaoReport bdReport) {
		this.bdReport=bdReport;
	}
	
	@RequestMapping("createReport")
	public String createReport(Report r){
		bdReport.create(r);
		return "testeDoInferno";
	}
}