package br.sp.cacarobos.controller;

<<<<<<< HEAD
import java.io.IOException;

=======
>>>>>>> Samuel
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD
import org.springframework.web.multipart.MultipartFile;

import br.sp.cacarobos.dao.DaoValuer;
import br.sp.cacarobos.model.Login;
=======

import br.sp.cacarobos.dao.DaoValuer;
import br.sp.cacarobos.model.Login;
import br.sp.cacarobos.model.User;
>>>>>>> Samuel
import br.sp.cacarobos.model.Valuer;

@Controller
public class ControllerValuer {
<<<<<<< HEAD
	
	private final DaoValuer bdValuer;
	
	@Autowired
	public ControllerValuer(DaoValuer bdValuer) {
		this.bdValuer=bdValuer;
	}
	
	//@RequestMapping("registerValuer")
	public String registerValuer(Valuer t, Login l, MultipartFile file){
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
=======

	private final DaoValuer bdV;
	
	@Autowired
	public ControllerValuer(DaoValuer bdV) {
		this.bdV = bdV;
	}
	
	@RequestMapping("homeV")
	public String homeValuer() {
		return "testeValuer";
	}
	
	@RequestMapping("addValuer")
	public String addV(Valuer v, Login l) {
		v.setActiveAccount(true);
		v.setLogin(l);
		bdV.create(v);
		
		return"testeValuer";
	}
	@RequestMapping("listAllValuer")
	public String listAllClients(Model model,Valuer v){
		System.out.println(v);
		model.addAttribute("val", bdV.listAll());
		return "listValuer";
	}
	@RequestMapping("deleteValuer")
	public String del(Valuer v) {
		bdV.delete(v.getId());
		return "redirect:listAllValuer";
>>>>>>> Samuel
	}
}
