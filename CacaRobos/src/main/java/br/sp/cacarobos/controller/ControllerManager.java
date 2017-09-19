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
=======
>>>>>>> Samuel

import br.sp.cacarobos.dao.DaoManager;
import br.sp.cacarobos.model.Login;
import br.sp.cacarobos.model.Manager;
<<<<<<< HEAD

@Controller
public class ControllerManager {
	private final DaoManager bdManager;
	
	@Autowired
	public ControllerManager(DaoManager bdManager) {
		this.bdManager=bdManager;
	}
	
	//@RequestMapping("registerManager")
	public String registerManager(Manager t, Login l, MultipartFile file){
		t.setLogin(l);
		if(!file.isEmpty()){
			try{
				t.setProfilePicture(file.getBytes());
			}catch(IOException e){
				throw new RuntimeException("Error in ControllerManager(Register manager): "+e.getMessage());
			}
		}
		bdManager.create(t);
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
}
=======
import br.sp.cacarobos.model.Valuer;

@Controller
public class ControllerManager {

	private final DaoManager bdM;
	
	@Autowired
	public ControllerManager (DaoManager bdM) {
		this.bdM = bdM;
	}
	@RequestMapping("homeM")
	public String homeManager() {
		
		return"testeManager";
	}
	@RequestMapping("addManager")
	public String ad(Manager m , Login l) {
		m.setLogin(l);
		bdM.create(m);
		return "testeManager";
		
	}
	@RequestMapping("listAllManager")
	public String listAllClients(Model model,Manager m){
		System.out.println(m);
		model.addAttribute("man", bdM.listAll());
		return "listManager";
	}
	@RequestMapping("deleteManager")
	public String del(Manager m) {
		bdM.delete(m.getId());
		return "redirect:listAllManager";
	}
}
>>>>>>> Samuel
