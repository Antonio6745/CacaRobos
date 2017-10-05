package br.sp.cacarobos.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.sp.cacarobos.dao.DaoLogin;
import br.sp.cacarobos.model.Login;
import br.sp.cacarobos.model.UserType;
import br.sp.cacarobos.util.HttpError;

@RestController
public class ControllerRestLogin {
	private final DaoLogin bdLogin;
	
	@Autowired
	public ControllerRestLogin(DaoLogin bdLogin) {
		this.bdLogin=bdLogin;
	}
	
	@RequestMapping(value="/login/sigin", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> sigin(@RequestBody Login l){
		try{
			l=bdLogin.sigin(l);
			if(l.getUserType().equals(UserType.ADM.userType)){
				return new ResponseEntity<Object>(bdLogin.retriveInfoManager(l), HttpStatus.OK);
			}else if(l.getUserType().equals(UserType.VLR.userType)){
				return new ResponseEntity<Object>(bdLogin.retriveInfoValuer(l), HttpStatus.OK);
			}else if(l.getUserType().equals(UserType.USR.userType)){
				return new ResponseEntity<Object>(bdLogin.retriveInfoUser(l), HttpStatus.OK);
			}
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new HttpError(HttpStatus.UNAUTHORIZED, "Email ou senha incorretos"));
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.UNAUTHORIZED, "Error in ControllerRestLogin(Sigin): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
}
