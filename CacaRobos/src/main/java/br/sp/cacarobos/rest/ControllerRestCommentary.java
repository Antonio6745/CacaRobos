package br.sp.cacarobos.rest;

import java.net.URI;

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

import br.sp.cacarobos.dao.DaoCommentary;
import br.sp.cacarobos.model.Commentary;
import br.sp.cacarobos.util.HttpError;

@RestController
public class ControllerRestCommentary {
	private final DaoCommentary bdCommentary;
	
	@Autowired
	public ControllerRestCommentary(DaoCommentary bdCommentary) {
		this.bdCommentary=bdCommentary;
	}
	
	@RequestMapping(value="/commentary/createUserCommentary", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> createUserCommentary(@RequestBody Commentary c){
		try{
			System.out.println(c);
			bdCommentary.createUserCommentary(c);
			System.out.println("passou e salvou");
			return ResponseEntity.created(URI.create("/commentary/"+c.getId())).body(c);
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestCommentary(Create user commentary): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	@RequestMapping(value="/commentary/createValuerCommentary", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> createValuerCommentary(@RequestBody Commentary c){
		try{
			bdCommentary.createValuerCommentary(c);
			return ResponseEntity.created(URI.create("/commentary/"+c.getId())).body(c);
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestCommentary(Create valuer commentary): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	@RequestMapping(value="/commentary/{commentaryId}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> read(@PathVariable("commentaryId") Long commentaryId){
		try{
			return new ResponseEntity<Object>(bdCommentary.read(commentaryId), HttpStatus.OK);
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestCommentary(Read): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	@RequestMapping(value="/commentary/{commentaryId}", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> update(@PathVariable("commentaryId") Long commentaryId, @RequestBody Commentary c){
		try{
			c.setId(commentaryId);
			bdCommentary.update(c);
			HttpHeaders httpHeaders=new HttpHeaders();
			httpHeaders.setLocation(URI.create("/commentary/"+c.getId()));
			return new ResponseEntity<Object>(c, HttpStatus.OK);
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestCommentary(Update): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	@RequestMapping(value="/commentary/{commentaryId}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("commentaryId") Long commentaryId){
		try{
			bdCommentary.delete(commentaryId);
			return ResponseEntity.noContent().build();
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestCommentary(Delete): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	@RequestMapping(value="/commentary", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> listAll(){
		try{
			return new ResponseEntity<Object>(bdCommentary.listAll(), HttpStatus.OK);
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestCommentary(List all): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
}
