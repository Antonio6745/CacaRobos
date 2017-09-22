package br.sp.cacarobos.controller;

import java.io.IOException;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import br.sp.cacarobos.dao.DaoManager;
import br.sp.cacarobos.dao.DaoValuer;
import br.sp.cacarobos.model.Login;
import br.sp.cacarobos.model.Manager;
import br.sp.cacarobos.model.Valuer;
import br.sp.cacarobos.util.EmailUtils;

@Controller
public class ControllerManager {
	private final DaoManager bdManager;
	private final DaoValuer bdValuer;
	
	@Autowired
	public ControllerManager(DaoManager bdManager, DaoValuer bdValuer) {
		this.bdManager=bdManager;
		this.bdValuer=bdValuer;
	}
	
	//@RequestMapping("registerManager")
	public String registerManager(Manager t, Login l, MultipartFile file) throws EmailException{
		t.setLogin(l);
		if(!file.isEmpty()){
			try{
				t.setProfilePicture(file.getBytes());
			}catch(IOException e){
				throw new RuntimeException("Error in ControllerManager(Register manager): "+e.getMessage());
			}
		}
		bdManager.create(t);
		EmailUtils email=new EmailUtils();
		email.sendSubscribleEmailManger(t.getLogin().getUsername());
		return "";//add manager main page
	}
	
	//@RequestMapping("findManager")
	public String findManager(Manager t, Model model){
		model.addAttribute("managerLocated", bdManager.read(t.getId()));
		return "";//add page to use this method
	}
	
	//@RequestMapping("updateManager")
	public String updateManager(Manager t){
		bdManager.update(t);
		return "";//add page to use this method
	}
	
	//@RequestMapping("deleteManager")
	public String deleteManager(Manager t){
		bdManager.delete(t.getId());
		return "";//add page or method to keep going
	}
	
	//@RequestMapping("listAllManagers")
	public String listAllManagers(Model model){
		model.addAttribute("mamagerList",bdManager.listAll());
		return "";//add page to use this method
	}
	
	//@RequestMapping("approveReport")
	public String approveValuerAccount(Valuer v)throws EmailException{
		bdValuer.validateAccount(v.getId(), true);
		EmailUtils email=new EmailUtils();
		email.sendApproveAccountEmail(v.getLogin().getUsername());
		return "";//add manager main page
	}
}