package br.sp.cacarobos.controller;

import java.io.IOException;

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
import br.sp.cacarobos.dao.DaoReport;
import br.sp.cacarobos.dao.DaoValuer;
import br.sp.cacarobos.model.Login;
import br.sp.cacarobos.model.Valuer;
import br.sp.cacarobos.model.Vote;
import br.sp.cacarobos.util.EmailUtils;

@Controller
public class ControllerValuer {

	private final DaoValuer bdValuer;
	private final DaoReport bdReport;

	@Autowired
	public ControllerValuer(DaoValuer bdValuer,DaoReport bdReport) {
		this.bdReport = bdReport;
		this.bdValuer = bdValuer;
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

	// @RequestMapping("deleteValuer")
	public String deleteValuer(Valuer t) {
		bdValuer.delete(t.getId());
		return "";// add page or method to keep going
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
		model.addAttribute("feedReportValuer", bdReport.listAll());
		return "feedValuer";
	}
	@RequestMapping("voteRobotTrue")
	public String voteTrue(Vote v,@RequestParam("reportId") Long reportId,HttpSession s) {
		
		Valuer val = null;
		val = (Valuer) s.getAttribute("valuerLoggedIn"); 
		v.setReportId(reportId);
		v.setValuerId(val.getId());
		bdReport.addVoteRobotTrue(reportId);
		return"redirect:/listFeedValuer";
	}
	@RequestMapping("voteRobotFalse")
	public String voteFalse(Vote v,@RequestParam("reportId") Long reportId,HttpSession s) {
		
		Valuer val = null;
		val = (Valuer) s.getAttribute("valuerLoggedIn"); 
		v.setReportId(reportId);
		v.setValuerId(val.getId());
		bdReport.addVoteRobotFalse(reportId);
		bdReport.registerVote(v);
		return"redirect:/listFeedValuer";
	}
}
