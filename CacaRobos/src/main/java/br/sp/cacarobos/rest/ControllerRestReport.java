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
	
	@RequestMapping(value="/createReport", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> create(@RequestBody Report r){
		try{
			bdReport.create(r);
			return ResponseEntity.created(URI.create("/report/"+r.getId())).body(r);
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestReport(Create): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	@RequestMapping(value="/readReport/{reportId}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> read(@PathVariable("reportId") Long reportId){
		try{
			return new ResponseEntity<Object>(bdReport.read(reportId), HttpStatus.OK);
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestReport(Read): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	@RequestMapping(value="/updateReport/{reportId}", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
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
	
	@RequestMapping(value="/deleteReport/{reportId}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("reportId") Long reportId){
		try{
			bdReport.delete(reportId);
			return ResponseEntity.noContent().build();
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestReport(Delete): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	@RequestMapping(value="/listAllReports", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> listAll(){
		try{
			return new ResponseEntity<Object>(bdReport.listAll(), HttpStatus.OK);
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestReport(List all): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	@RequestMapping(value="/reportAlreadyExists", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> reportAlreadyExists(@RequestBody Report r){
		try{
			return new ResponseEntity<Object>(bdReport.reportAlreadyExists(r.getLink()), HttpStatus.OK);
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestReport(Report Already Exists): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	@RequestMapping(value="/approveReport/{reportId}", method=RequestMethod.GET)
	public ResponseEntity<Object> approveReport(@PathVariable("reportId") Long reportId){
		try{
			bdReport.approveReport(reportId, true);
			return ResponseEntity.noContent().build();
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestReport(Approve Report): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	@RequestMapping(value="/disapproveReport/{reportId}", method=RequestMethod.GET)
	public ResponseEntity<Object> disapproveReport(@PathVariable("reportId") Long reportId){
		try{
			bdReport.approveReport(reportId, false);
			return ResponseEntity.noContent().build();
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestReport(Disapprove report): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	@RequestMapping(value="/updateStatus/{reportId}", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> updateStatus(@PathVariable("reportId") Long reportId, @RequestBody Report r){
		try{
			bdReport.updateStatus(reportId, r.getStatus());
			return ResponseEntity.noContent().build();
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestReport(Update Status): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
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
	
	@RequestMapping(value="/addIsARobotVote/{reportId}", method=RequestMethod.GET)
	public ResponseEntity<Object> addIsARobotVote(@PathVariable("reportId") Long reportId){
		try{
			bdReport.addVoteRobotTrue(reportId);
			return ResponseEntity.noContent().build();
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestReport(Add is a robot vote): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	@RequestMapping(value="/addIsNotARobotVote/{reportId}", method=RequestMethod.GET)
	public ResponseEntity<Object> addIsNotARobotVote(@PathVariable("reportId") Long reportId){
		try{
			bdReport.addVoteRobotFalse(reportId);
			return ResponseEntity.noContent().build();
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestReport(Add is not a robot vote): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	@RequestMapping(value="/listOnlyActiveReports", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> listOnlyActiveReports(){
		try{
			return new ResponseEntity<Object>(bdReport.listAllActiveReports(), HttpStatus.OK);
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestReport(List only active reports): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
	
	@RequestMapping(value="/listAllActiveReportsByValuerId/{reportId}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> listAllActiveReportsByValuerId(@PathVariable("reportId") Long reportId){
		try{
			return new ResponseEntity<Object>(bdReport.listAllReportsByValuerId(reportId, true), HttpStatus.OK);
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestReport(List all active reports by valuer id): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}

	@RequestMapping(value="/listAllDisactiveReportsByValuerId/{reportId}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> listAllDisactiveReportsByValuerId(@PathVariable("reportId") Long reportId){
		try{
			return new ResponseEntity<Object>(bdReport.listAllReportsByValuerId(reportId, false), HttpStatus.OK);
		}catch(Exception e){
			HttpError error=new HttpError(HttpStatus.INTERNAL_SERVER_ERROR, "Error in ControllerRestReport(List all disactive reports by valuer id): "+e.getMessage());
			return ResponseEntity.status(error.getHttpStatus()).body(error);
		}
	}
}