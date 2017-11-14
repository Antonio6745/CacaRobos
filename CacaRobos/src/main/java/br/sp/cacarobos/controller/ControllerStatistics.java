package br.sp.cacarobos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.sp.cacarobos.dao.DaoStatistics;
import br.sp.cacarobos.model.Statistics;

@Controller
public class ControllerStatistics {
	private final DaoStatistics bdStatistics;
	
	@Autowired
	public ControllerStatistics(DaoStatistics bdStatistics) {
		this.bdStatistics=bdStatistics;
	}
	
	@RequestMapping("loadBasicStatistics")
	public String loadBasicStatistics(Model model){
		Statistics s=new Statistics();
		s.setFacebookReports(bdStatistics.countFacebookReports().getFacebookReports());
		s.setTwitterReports(bdStatistics.countTwitterReports().getTwitterReports());
		s.setInstagramReports(bdStatistics.countInstagramReports().getInstagramReports());
		s.setGooglePlusReport(bdStatistics.countGooglePlusReports().getGooglePlusReport());
		model.addAttribute("basicStatistcs",s);
		return "";// add basic statistics page
	}
	
	@RequestMapping("loadAllStatistics")
	public String loadAllStatistcs(Model model){
		Statistics s=new Statistics();
		s.setFacebookReports(bdStatistics.countFacebookReports().getFacebookReports());
		s.setTwitterReports(bdStatistics.countTwitterReports().getTwitterReports());
		s.setInstagramReports(bdStatistics.countInstagramReports().getInstagramReports());
		s.setGooglePlusReport(bdStatistics.countGooglePlusReports().getGooglePlusReport());
		s.setUserTotal(bdStatistics.countUsers().getUserTotal());
		s.setValuerTotal(bdStatistics.countValuers().getValuerTotal());
		s.setManagerTotal(bdStatistics.countManagers().getManagerTotal());
		model.addAttribute("allStatistics",s);
		return "";//add all statistics page
	}
}
