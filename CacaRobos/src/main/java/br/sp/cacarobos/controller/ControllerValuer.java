package br.sp.cacarobos.controller;

import java.io.IOException;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import br.sp.cacarobos.dao.DaoValuer;
import br.sp.cacarobos.model.Login;
import br.sp.cacarobos.model.Valuer;
import br.sp.cacarobos.util.EmailUtils;

@Controller
public class ControllerValuer {
	
	private final DaoValuer bdValuer;
	
	@Autowired
	public ControllerValuer(DaoValuer bdValuer) {
		this.bdValuer=bdValuer;
	}
	
	//@RequestMapping("registerValuer")
	public String registerValuer(Valuer t, Login l, MultipartFile file) throws EmailException{
		t.setLogin(l);
		if(!file.isEmpty()){
			try{
				t.setProfilePicture(file.getBytes());
			}catch(IOException e){
				throw new RuntimeException("Error in ControllerValuer(Register valuer): "+e.getMessage());
			}
		}else{
			
		}
		bdValuer.create(t);
		EmailUtils email=new EmailUtils();
		email.sendSubscribleEmailValuer(t.getLogin().getUsername());
		return "";//add index page
	}
	
	//@RequestMapping("findValuer")
	public String findValuer(Valuer t, Model model){
		model.addAttribute("valuerLocated", bdValuer.read(t.getId()));
		return "";//add page to use this method
	}
	
	//@RequestMapping("updateValuer")
	public String updateValuer(Valuer t){
		bdValuer.update(t);
		return "";//add page to use this method
	}
	
	//@RequestMapping("deleteValuer")
	public String deleteValuer(Valuer t){
		bdValuer.delete(t.getId());
		return "";//add page or method to keep going
	}
	
	//@RequestMapping("listAllValuers")
	public String listAllValuers(Model model){
		model.addAttribute("", bdValuer.listAll());
		return "";//add valuer page list
	}
	
	//@RequestMapping("approveReport")
	public String approveValuerAccount(Valuer v)throws EmailException{
		bdValuer.validateAccount(v.getId(), true);
		EmailUtils email=new EmailUtils();
		email.sendApproveAccountEmail(v.getLogin().getUsername());
		return "";//add manager main page
	}
}
