package br.sp.cacarobos.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.sp.cacarobos.dao.DaoCommentary;
import br.sp.cacarobos.dao.DaoReport;
import br.sp.cacarobos.model.Commentary;
import br.sp.cacarobos.model.Report;
import br.sp.cacarobos.model.User;
import br.sp.cacarobos.model.Valuer;

@Controller
public class ControllerCommentary {
	private final DaoCommentary bdCommentary;
	private final DaoReport bdReport;

	public ControllerCommentary(DaoCommentary bdCommentary, DaoReport bdReport) {
		this.bdCommentary = bdCommentary;
		this.bdReport = bdReport;
	}

	@RequestMapping("listCommentary")
	public String comen(Report r,Model model) {
		model.addAttribute("listCommentary", bdCommentary.listCommentsByReportId(r.getId()));
		model.addAttribute("report",bdReport.read(r.getId()));
		bdCommentary.listCommentsByReportId(r.getId());
		return "telaComentarios";
	}

	@RequestMapping("createCommentary/{reportId}")
	public String createCommentary(Commentary c, HttpSession s, Model m, @PathVariable("reportId") Long reportId){
		c.getReport().setId(reportId);
		if(s.getAttribute("userLoggedIn")!=null){
			c.setUser((User) s.getAttribute("userLoggedIn"));
			bdCommentary.create(c, true);
		}
		if(s.getAttribute("valuerLoggedIn")!=null){
			c.setValuer((Valuer) s.getAttribute("valuerLoggedIn"));
			bdCommentary.create(c, false);
		}
		bdCommentary.create(c);
		m.addAttribute("id", reportId);
		return "redirect:/listCommentary";
	}
}
