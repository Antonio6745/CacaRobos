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
import br.sp.cacarobos.dao.DaoValuer;
import br.sp.cacarobos.model.Valuer;
import br.sp.cacarobos.util.EmailUtils;
import br.sp.cacarobos.util.HttpError;

@RestController
@RequestMapping("/valuer")
public class ControllerRestValuer {
	
	private final DaoValuer bdValuer;
	
	@Autowired
	public ControllerRestValuer(DaoValuer bdValuer) {
		this.bdValuer=bdValuer;
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> create(@RequestBody Valuer v){
		try{
			bdValuer.create(v);
			try {
				EmailUtils email = new EmailUtils();
				email.sendSubscribleEmailUser(v.getLogin().getUsername());
			} catch (EmailException e) {
				throw new RuntimeException("Error in ControllerRestUser(Create): "+e.getMessage());
			}
			return ResponseEntity.created(URI.create("/valuer/"+v.getId())).body(v);
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestValuer(Create): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	@RequestMapping(value="/{valuerId}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> read(@PathVariable("valuerId") Long valuerId){
		try{
			return new ResponseEntity<Object>(bdValuer.read(valuerId), HttpStatus.OK);
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestValuer(Read): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	@RequestMapping(value="/{valuerId}", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> update(@PathVariable("valuerId") Long valuerId, @RequestBody Valuer v){
		try{
			v.setId(valuerId);
			bdValuer.update(v);
			HttpHeaders header=new HttpHeaders();
			header.setLocation(URI.create("/valuer/"+v.getId()));
			return new ResponseEntity<Object>(v, HttpStatus.OK);
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestValuer(Create): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	@RequestMapping(value="/{valuerId}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("id") Long valuerId){
		try{
			bdValuer.delete(valuerId);
			return ResponseEntity.noContent().build();
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestValuer(Create): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> listAll(){
		try{
			return new ResponseEntity<Object>(bdValuer.listAll(), HttpStatus.OK);
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestValuer(Create): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
}
