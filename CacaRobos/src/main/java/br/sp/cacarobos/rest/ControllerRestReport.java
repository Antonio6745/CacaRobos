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
import br.sp.cacarobos.dao.DaoReport;
import br.sp.cacarobos.model.Report;
import br.sp.cacarobos.util.HttpError;
@RestController
public class ControllerRestReport {
	private final DaoReport bdReport;
	
	@Autowired
	public ControllerRestReport(DaoReport bdReport) {
		this.bdReport=bdReport;
	}
	
	@RequestMapping(value="/report", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> create(@RequestBody Report r){
		try{
			bdReport.create(r);
			return ResponseEntity.created(URI.create("/report/"+r.getId())).body(r);
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestReport(Create): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	@RequestMapping(value="/report/{reportId}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> read(@PathVariable("reportId") Long reportId){
		try{
			return new ResponseEntity<Object>(bdReport.read(reportId), HttpStatus.OK);
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestReport(Read): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	@RequestMapping(value="/report/{reportId}", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> update(@PathVariable("reportId") Long reportId, @RequestBody Report r){
		try{
			r.setId(reportId);
			bdReport.update(r);
			HttpHeaders headers=new HttpHeaders();
			headers.setLocation(URI.create("/report/"+r.getId()));
			return new ResponseEntity<Object>(r, HttpStatus.OK);
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestReport(Update): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	@RequestMapping(value="/report/{reportId}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("reportId") Long reportId){
		try{
			bdReport.delete(reportId);
			return ResponseEntity.noContent().build();
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestReport(Delete): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	@RequestMapping(value="/report", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> listAll(){
		try{
			return new ResponseEntity<Object>(bdReport.listAll(), HttpStatus.OK);
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestReport(List all): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	@RequestMapping(value="/report/reportAlreadyExists", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> reportAlreadyExists(@RequestBody Report r){
		try{
			return new ResponseEntity<Object>(bdReport.reportAlreadyExists(r.getLink()), HttpStatus.OK);
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestReport(Report Already Exists): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	@RequestMapping(value="/report/updateStatus/{reportId}", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> updateStatus(@PathVariable("reportId") Long reportId, @RequestBody Report r){
		try{
			bdReport.updateStatus(reportId, r.getStatus());
			return ResponseEntity.noContent().build();
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestReport(Update Status): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	/*
	@RequestMapping(value="/activeReport/{reportId}", method=RequestMethod.GET)
	public ResponseEntity<Object> activeReport(@PathVariable("reportId") Long reportId){
		try{
			bdReport.activeReport(reportId, true);
			return ResponseEntity.noContent().build();
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestReport(Active report): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	@RequestMapping(value="/disactiveReport/{reportId}", method=RequestMethod.GET)
	public ResponseEntity<Object> disactiveReport(@PathVariable("reportId") Long reportId){
		try{
			bdReport.activeReport(reportId, false);
			return ResponseEntity.noContent().build();
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestReport(Disactive report): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	*/
	
	@RequestMapping(value="/report/addIsARobotVote/{reportId}", method=RequestMethod.GET)
	public ResponseEntity<Object> addIsARobotVote(@PathVariable("reportId") Long reportId){
		try{
			bdReport.addIsARobotOrNotVote(reportId, true);
			return ResponseEntity.noContent().build();
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestReport(Add is a robot vote): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	@RequestMapping(value="/report/addIsNotARobotVote/{reportId}", method=RequestMethod.GET)
	public ResponseEntity<Object> addIsNotARobotVote(@PathVariable("reportId") Long reportId){
		try{
			bdReport.addIsARobotOrNotVote(reportId, false);
			return ResponseEntity.noContent().build();
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestReport(Add is not a robot vote): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	@RequestMapping(value="/report/listOnlyActiveReports", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> listOnlyActiveReports(){
		try{
			return new ResponseEntity<Object>(bdReport.listAllActiveReports(), HttpStatus.OK);
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestReport(List only active reports): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	@RequestMapping(value="/report/listAllActiveReportsByValuerId/{reportId}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> listAllActiveReportsByValuerId(@PathVariable("reportId") Long reportId){
		try{
			return new ResponseEntity<Object>(bdReport.listAllReportsByValuerId(reportId, true), HttpStatus.OK);
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestReport(List all active reports by valuer id): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}

	@RequestMapping(value="/report/listAllDisactiveReportsByValuerId/{reportId}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> listAllDisactiveReportsByValuerId(@PathVariable("reportId") Long reportId){
		try{
			return new ResponseEntity<Object>(bdReport.listAllReportsByValuerId(reportId, false), HttpStatus.OK);
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestReport(List all disactive reports by valuer id): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	@RequestMapping(value="/report/listAllActiveReports", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> listAllActiveReports(){
		try{
			return new ResponseEntity<Object>(bdReport.listAllActiveReports(), HttpStatus.OK);
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestReport(List all active reports): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	@RequestMapping(value="/report/listBySocialNetwork", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> listBySocialNetwork(@RequestBody Report r){
		try{
			return new ResponseEntity<Object>(bdReport.listBySocialNetwork(r.getNetworkType()), HttpStatus.OK);
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestReport(List by social network): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	@RequestMapping(value="/report/updateReportTimeAvaliable/{time}", method=RequestMethod.GET)
	public ResponseEntity<Object> updateReportTimeAvaliable(@PathVariable("time") Integer time){
		try{
			bdReport.updateReportTimeAvaliable(time);
			return ResponseEntity.noContent().build();
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestReport(Update report time avaliale): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
}