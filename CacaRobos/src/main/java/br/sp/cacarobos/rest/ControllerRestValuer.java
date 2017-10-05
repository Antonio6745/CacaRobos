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
public class ControllerRestValuer {
	
	private final DaoValuer bdValuer;
	
	@Autowired
	public ControllerRestValuer(DaoValuer bdValuer) {
		this.bdValuer=bdValuer;
	}
	
	@RequestMapping(value="/valuer", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> create(@RequestBody Valuer v){
		try{
			bdValuer.create(v);
			try {
				EmailUtils email = new EmailUtils();
				email.sendSubscribleEmailValuer(v.getLogin().getUsername());
			} catch (EmailException e) {
				throw new RuntimeException("Error in ControllerRestValuer(Create): "+e.getMessage());
			}
			return ResponseEntity.created(URI.create("/valuer/"+v.getId())).body(v);
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestValuer(Create): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	@RequestMapping(value="/valuer/{valuerId}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> read(@PathVariable("valuerId") Long valuerId){
		try{
			return new ResponseEntity<Object>(bdValuer.read(valuerId), HttpStatus.OK);
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestValuer(Read): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	@RequestMapping(value="/valuer/{valuerId}", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
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
	
	@RequestMapping(value="/valuer/{valuerId}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("valuerId") Long valuerId){
		try{
			bdValuer.delete(valuerId);
			return ResponseEntity.noContent().build();
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestValuer(Create): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	@RequestMapping(value="/valuer", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> listAll(){
		try{
			return new ResponseEntity<Object>(bdValuer.listAll(), HttpStatus.OK);
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestValuer(Create): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	@RequestMapping(value="/valuer/validateAccount/{valuerId}", method=RequestMethod.GET)
	public ResponseEntity<Object> validateAccount(@PathVariable("valuerId") Long valuerId){
		try{
			bdValuer.validateAccount(valuerId, true);
			EmailUtils email=new EmailUtils();
			email.sendApproveAccountEmail(bdValuer.read(valuerId).getLogin().getUsername());
			return ResponseEntity.noContent().build();
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestValuer(validadteAccount): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}

	@RequestMapping(value="/valuer/unvalidateAccount/{valuerId}", method=RequestMethod.GET)
	public ResponseEntity<Object> unvalidateAccount(@PathVariable("valuerId") Long valuerId){
		try{
			bdValuer.validateAccount(valuerId, false);
			EmailUtils email=new EmailUtils();
			email.sendApproveAccountEmail(bdValuer.read(valuerId).getLogin().getUsername());
			return ResponseEntity.noContent().build();
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestValuer(validadteAccount): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	@RequestMapping(value="/valuer/cpfAlreadyExists/{cpf}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> cpfAlreadyExists(@PathVariable("cpf") String cpf){
		try{
			return new ResponseEntity<Object>(bdValuer.cpfAlreadyExists(cpf) ,HttpStatus.OK);
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestValuer(CPF already exists): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
}
