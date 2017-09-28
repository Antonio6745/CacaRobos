package br.sp.cacarobos.controller;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import br.sp.cacarobos.dao.DaoLogin;
import br.sp.cacarobos.model.Login;
import br.sp.cacarobos.model.Manager;
import br.sp.cacarobos.model.User;
import br.sp.cacarobos.model.UserType;
import br.sp.cacarobos.model.Valuer;
@Controller
public class ControllerLogin {
	private final DaoLogin bdLogin;
	/*
	@Autowired
	ServletContext context;
	*/
	@Autowired
	public ControllerLogin(DaoLogin bdLogin){
		this.bdLogin=bdLogin;
	}
	
	@RequestMapping("home")
	public String home() {
		return "testeDoInferno";
	}
	
	@RequestMapping("sigin")
	public String sigin(Login l, HttpSession session) throws Base64DecodingException{
		l=bdLogin.sigin(l);
		if(l!=null){
			if(l.getUserType().equals(UserType.ADM.userType)){
				Manager t=bdLogin.retriveInfoManager(l);
				/*if(t.getProfilePicture()==null){
					t.setProfilePicture(Base64.decode(context.getRealPath("/WEB-INF/resouces/profilePictureDefault.jpg")));
				}*/
				session.setAttribute("managerLoggedIn", t);
				return "redirect:mainPageManager";
			}else if(l.getUserType().equals(UserType.USR.userType)){
				User t=bdLogin.retriveInfoUser(l);
				/*if(t.getProfilePicture()==null){
					t.setProfilePicture(Base64.decode(context.getRealPath("/WEB-INF/resouces/profilePictureDefault.jpg")));
				}*/
				session.setAttribute("userLoggedIn", t);
				return "redirect:mainPageUser";
			}else if(l.getUserType().equals(UserType.VLR.userType)){
				Valuer t=bdLogin.retriveInfoValuer(l);
				/*if(t.getProfilePicture()==null){
					t.setProfilePicture(Base64.decode(context.getRealPath("/WEB-INF/resouces/profilePictureDefault.jpg")));
				}*/
				session.setAttribute("valuerLoggedIn", t);
				return "redirect:mainPageValuer";
			}
		}
		return "testeDoInferno";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "";//add index page
	}
}
