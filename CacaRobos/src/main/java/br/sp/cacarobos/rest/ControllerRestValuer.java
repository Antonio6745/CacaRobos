package br.sp.cacarobos.rest;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.sp.cacarobos.dao.DaoValuer;
import br.sp.cacarobos.model.Valuer;
import br.sp.cacarobos.util.HttpError;

@RestController
@RequestMapping("/valuer")
public class ControllerRestValuer {
	
	private final DaoValuer bdValuer;
	
	@Autowired
	public ControllerRestValuer(DaoValuer bdValuer) {
		this.bdValuer=bdValuer;
	}
	
	
	public ResponseEntity<Object> create(@RequestBody Valuer v){
		try{
			bdValuer.create(v);
			return ResponseEntity.created(URI.create("/valuer/"+v.getId())).body(v);
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestValuer(Create): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	public ResponseEntity<Object> read(@PathVariable("id") Long valuerId){
		try{
			return new ResponseEntity<Object>(bdValuer.read(valuerId), HttpStatus.OK);
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestValuer(Read): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	public ResponseEntity<Object> update(@PathVariable("id") Long valuerId, @RequestBody Valuer v){
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
	
	public ResponseEntity<Object> delete(@PathVariable("id") Long valuerId){
		try{
			bdValuer.delete(valuerId);
			return ResponseEntity.noContent().build();
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestValuer(Create): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	public ResponseEntity<Object> listAll(){
		try{
			return new ResponseEntity<Object>(bdValuer.listAll(), HttpStatus.OK);
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestValuer(Create): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
}
