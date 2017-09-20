package br.sp.cacarobos.rest;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.sp.cacarobos.dao.DaoUser;
import br.sp.cacarobos.model.Login;
import br.sp.cacarobos.model.User;
import br.sp.cacarobos.util.HttpError;
@RestController
public class ControllerRestUser {
	private DaoUser bdUser;
	
	@Autowired
	public ControllerRestUser(DaoUser bdUser) {
		this.bdUser=bdUser;
	}
	
	public ResponseEntity<Object> create(@RequestBody User u, @RequestBody Login l){
		try{
			u.setLogin(l);
			bdUser.create(u);
			return ResponseEntity.created(URI.create("/user/"+u.getId())).body(u);
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestUser(Create): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	public ResponseEntity<Object> read(@PathVariable("userId") Long userId){
		try{
			return new ResponseEntity<Object>(bdUser.read(userId), HttpStatus.OK);
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestUser(Read): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	public ResponseEntity<Object> update(@PathVariable("userId") Long userId, @RequestBody User u){
		try{
			u.setId(userId);
			bdUser.update(u);
			HttpHeaders header=new HttpHeaders();
			header.setLocation(URI.create("/user/"+u.getId()));
			return new ResponseEntity<Object>(u, HttpStatus.OK);
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestUser(Read): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	public ResponseEntity<Object> delete(@PathVariable("userId") Long userId){
		try{
			bdUser.delete(userId);
			return ResponseEntity.noContent().build();
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestUser(Delete): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	public ResponseEntity<Object> listAll(){
		try{
			return new ResponseEntity<Object>(bdUser.listAll(), HttpStatus.OK);
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestUser(List All): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
}
