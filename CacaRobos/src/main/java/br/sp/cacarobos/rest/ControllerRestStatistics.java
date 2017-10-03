package br.sp.cacarobos.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.sp.cacarobos.dao.DaoStatistics;
import br.sp.cacarobos.model.SocialNetworkType;
import br.sp.cacarobos.model.UserType;
import br.sp.cacarobos.util.HttpError;

@RestController
public class ControllerRestStatistics {
	private final DaoStatistics bdStatistics;
	
	@Autowired
	public ControllerRestStatistics(DaoStatistics bdStatistics) {
		this.bdStatistics=bdStatistics;
	}
	
	@RequestMapping(value="/statistics/{userType}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> countTotalUsers(@PathVariable("userType") String userType){
		try{
			if(userType.equals(UserType.ADM.userType)){
				return new ResponseEntity<Object>(bdStatistics.countManagers(), HttpStatus.OK);
			}else if(userType.equals(UserType.VLR.userType)){
				return new ResponseEntity<Object>(bdStatistics.countValuers(), HttpStatus.OK);
			}else if(userType.equals(UserType.USR.userType)){
				return new ResponseEntity<Object>(bdStatistics.countUsers(), HttpStatus.OK);
			}
			return ResponseEntity.noContent().build();
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestStatistics(Count total users): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	@RequestMapping(value="/statistics/{network}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> countBySocialNetwork(@PathVariable("network") String network){
		try{
			if(network.equals(SocialNetworkType.FACEBOOK.socialNetworkType)){
				return new ResponseEntity<Object>(bdStatistics.countFacebookReports(), HttpStatus.OK);
			}else if(network.equals(SocialNetworkType.INSTAGRAM.socialNetworkType)){
				return new ResponseEntity<Object>(bdStatistics.countInstagramReports(), HttpStatus.OK);
			}else if(network.equals(SocialNetworkType.TWITTER.socialNetworkType)){
				return new ResponseEntity<Object>(bdStatistics.countTwitterReports(), HttpStatus.OK);
			}else if(network.equals(SocialNetworkType.GOOGLE_PLUS.socialNetworkType)){
				return new ResponseEntity<Object>(bdStatistics.countGooglePlusReports(), HttpStatus.OK);
			}
			return ResponseEntity.noContent().build();
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestStatistics(Count by social network): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
}
