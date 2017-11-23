package br.sp.cacarobos.controller;

import java.io.IOException;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import br.sp.cacarobos.dao.DaoReport;
import br.sp.cacarobos.dao.DaoUser;
import br.sp.cacarobos.model.Login;
import br.sp.cacarobos.model.User;
import br.sp.cacarobos.util.EmailUtils;

@Controller
public class ControllerUser {
	private final DaoUser bdUser;
	private final DaoReport bdReport;
	
	@Autowired
	public ControllerUser(DaoUser bdUser,DaoReport bdReport) {
		this.bdUser=bdUser;
		this.bdReport=bdReport;
	}
	
	@RequestMapping("registerUser")
	public String registerUser(User u, Login l, MultipartFile file, Model model) throws EmailException{
		u.setLogin(l);
		if(!file.isEmpty()){
			try{
				u.setProfilePicture(file.getBytes());
			}catch(IOException e){
				throw new RuntimeException("Error in ControllerUser(Register user): "+e.getMessage());
			}
		}
		bdUser.create(u);
		EmailUtils email=new EmailUtils();
		email.sendSubscribleEmailUser(u.getLogin().getUsername());
		model.addAttribute("user", u);
		return "confirmar";//add user register page
	}
	
	//@RequestMapping("findUser")
	public String findUser(User t, Model model){
		model.addAttribute("userLocated", bdUser.read(t.getId()));
		return "";//add page to use this method
	}
	
	//@RequestMapping("updateUser")
	public String updateUser(User t){
		bdUser.update(t);
		return "";//add page to use this method
	}
	
	//@RequestMapping("deleteUser")
	public String deleteUser(User t){
		bdUser.delete(t.getId());
		return "";//add page or method to be redirected
	}
	
	//@RequestMapping("listAllUsers")
	public String listAllUsers(Model model){
		model.addAttribute("userList", bdUser.listAll());
		return "";//add user list page
	}
	@RequestMapping("formUser")
	public String formU() {
		return "formularioUser";
	}
	@RequestMapping("home")
	public String index() {
		
		return"index";
	}
	@RequestMapping("listFeedUser")
	public String feedU(Model model){
		model.addAttribute("feedReportUser", bdReport.listAll());
		return "feedUser";
	}

	@RequestMapping("graficoUser")
	public String porNoGraficoU() {
		return"redirect:loadBasicStatistics";
	}



}
