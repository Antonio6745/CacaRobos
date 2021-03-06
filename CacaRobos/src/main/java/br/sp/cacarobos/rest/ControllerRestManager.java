package br.sp.cacarobos.rest;
import java.net.URI;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.sp.cacarobos.dao.DaoManager;
import br.sp.cacarobos.model.Manager;
import br.sp.cacarobos.util.EmailUtils;
import br.sp.cacarobos.util.HttpError;
@RestController
@RequestMapping("/manager")
public class ControllerRestManager {
	
	private final DaoManager bdManager;
	
	@Autowired
	public ControllerRestManager(DaoManager bdManager) {
		this.bdManager=bdManager;
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> create(@RequestBody Manager m){
		try{
			bdManager.create(m);
			try {
				EmailUtils email = new EmailUtils();
				email.sendSubscribleEmailUser(m.getLogin().getUsername());
			} catch (EmailException e) {
				throw new RuntimeException("Error in ControllerRestManager(Create): "+e.getMessage());
			}
			return ResponseEntity.created(URI.create("/manager/"+m.getId())).body(m);
		}catch(Exception e){
			HttpError error =new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestManager(Create): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	@RequestMapping(value = "/{managerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> read(@PathVariable("managerId") Long managerId){
		try{
			return new ResponseEntity<Object>(bdManager.read(managerId), HttpStatus.OK);
		}catch(Exception e){
			HttpError error =new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestManager(Read): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	@RequestMapping(value = "/{managerId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> update(@PathVariable("managerId") Long managerId, @RequestBody Manager m){
		try{
			m.setId(managerId);
			bdManager.update(m);
			HttpHeaders headers=new HttpHeaders();
			headers.setLocation(URI.create("/manager/"+m.getId()));
			return new ResponseEntity<Object>(m, HttpStatus.OK);
		}catch(Exception e){
			HttpError error =new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestManager(Update): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	@RequestMapping(value = "/{managerId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("managerId") Long managerId){
		try{
			bdManager.delete(managerId);
			return ResponseEntity.noContent().build();
		}catch(Exception e){
			HttpError error =new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestManager(Delete): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> listAll(){
		try{
			return new ResponseEntity<Object>(bdManager.listAll(), HttpStatus.OK);
		}catch(Exception e){
			HttpError error =new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestManager(List all): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
}