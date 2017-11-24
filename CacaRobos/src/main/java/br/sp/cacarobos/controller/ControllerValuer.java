package br.sp.cacarobos.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import br.sp.cacarobos.dao.DaoCommentary;
import br.sp.cacarobos.dao.DaoReport;
import br.sp.cacarobos.dao.DaoValuer;
import br.sp.cacarobos.dao.DaoVote;
import br.sp.cacarobos.model.Login;
import br.sp.cacarobos.model.Report;
import br.sp.cacarobos.model.Valuer;
import br.sp.cacarobos.model.Vote;
import br.sp.cacarobos.util.EmailUtils;

@Controller
public class ControllerValuer {

	private final DaoValuer bdValuer;
	private final DaoReport bdReport;
	private final DaoVote bdVote;
	private final DaoCommentary bdCommentary;
	@Autowired
	public ControllerValuer(DaoValuer bdValuer,DaoReport bdReport, DaoVote bdVote,DaoCommentary bdCommentary) {
		this.bdReport = bdReport;
		this.bdValuer = bdValuer;
		this.bdVote=bdVote;
		this.bdCommentary=bdCommentary;
	}

	@RequestMapping("registerValuer")
	public String registerValuer(Valuer t, Login l, MultipartFile file) throws EmailException {
		t.setLogin(l);
		if (!file.isEmpty()) {
			try {
				t.setProfilePicture(file.getBytes());
			} catch (IOException e) {
				throw new RuntimeException("Error in ControllerValuer(Register valuer): " + e.getMessage());
			}
		} else {

		}
		CPFValidator validator = new CPFValidator();

		try {
			validator.assertValid(t.getCpf());
		} catch (InvalidStateException e) {
			throw new RuntimeException((Throwable) e.getInvalidMessages());
		}
		System.out.println(t);

		bdValuer.create(t);
		EmailUtils email = new EmailUtils();
		email.sendSubscribleEmailValuer(t.getLogin().getUsername());
		return "redirect:home";// add index page
	}

	// @RequestMapping("findValuer")
	public String findValuer(Valuer t, Model model) {
		model.addAttribute("valuerLocated", bdValuer.read(t.getId()));
		return "";// add page to use this method
	}

	// @RequestMapping("updateValuer"
	public String updateValuer(Valuer t) {
		bdValuer.update(t);
		return "";// add page to use this method
	}

	 @RequestMapping("deleteValuer")
	public String deleteValuer(Valuer t) {
		bdValuer.delete(t.getId());
		System.out.println(t);
		return "redirect:listValuerActive";
	}
	
	
	// @RequestMapping("listAllValuers")
	//public String listAllValuers(Model model) {
	//	model.addAttribute("", bdValuer.listAll());
	//	return "";// add valuer page list
	//}

	@RequestMapping("formValuer")
	public String homeValuer() {
		return "formularioValuer";
	}

	@RequestMapping("forgetPassword")
	public String forgetPassword() {

		return "resetpassword";
	}

	@RequestMapping("requestPassword")
	public String req() {

		return "request";
	}

	@RequestMapping("sendConfirm")
	public String confirm() {

		return "";
	}


	@ExceptionHandler(ClassCastException.class)
	public String cpfExcpetion() {
		return "erroDeSatanas";
	}
	@RequestMapping("listFeedValuer")
	public String feedU(Model model){
		List<Report> reportList = bdReport.listAll();
		reportList.forEach(i->i.setCommentaryList(bdCommentary.listCommentsByReportId(i.getId())));
		model.addAttribute("feedReportValuer", reportList);
		return "feedValuer";
	}
	@RequestMapping("voteRobotTrue")
	public String voteTrue(Vote v,@RequestParam("reportId") Long reportId,HttpSession s) {
		Valuer val =(Valuer) s.getAttribute("valuerLoggedIn"); 
		v.setReportId(reportId);
		v.setValuerId(val.getId());
		if(!bdVote.alreadyVoted(reportId, val.getId())) {
			bdReport.addVoteRobotTrue(reportId);
			bdReport.registerVote(v);
		}
		return"redirect:/listFeedValuer";
	}
	@RequestMapping("voteRobotFalse")
	public String voteFalse(Vote v,@RequestParam("reportId") Long reportId,HttpSession s) {
		Valuer val =(Valuer) s.getAttribute("valuerLoggedIn"); 
		v.setReportId(reportId);
		v.setValuerId(val.getId());
		if(!bdVote.alreadyVoted(reportId, val.getId())) {
			bdReport.addVoteRobotFalse(reportId);
			bdReport.registerVote(v);
		}
		return"redirect:/listFeedValuer";
	}
	@RequestMapping("aproveValuer")
	public String aprValuer(Valuer t) {
		bdValuer.validateAccount(t.getId(), true);
		return"redirect:listValuerActive";
	}
	@RequestMapping("rejectValuer")
	public String rejValuer(Valuer t) {
		bdValuer.validateAccount(t.getId(), false);
		return"redirect:listValuerInactive";
	}
}
