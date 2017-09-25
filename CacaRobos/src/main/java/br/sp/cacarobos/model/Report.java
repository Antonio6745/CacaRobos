package br.sp.cacarobos.model;
import java.time.LocalDateTime;
import java.util.List;

import br.sp.cacarobos.util.CodeGenerator;

public class Report {
	private Long id;
	private Status status;
	private String description;
	private User user;
	private Valuer valuer;
	private Boolean approveReport;
	private LocalDateTime dateReport;
	private Boolean activeReport;
	private VoteCounting voteCounting;
	private List<Commentary> commentaryList;
	private String trackingCode;
	private CodeGenerator codeGenerator;
	private String networkType;
	
	public Report() {
		voteCounting=new VoteCounting();
		user=new User();
		valuer=new Valuer();
		codeGenerator=new CodeGenerator();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStatus() {
		return status.toString();
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Valuer getValuer() {
		return valuer;
	}
	public void setValuer(Valuer valuer) {
		this.valuer = valuer;
	}
	public Boolean getApproveReport() {
		return approveReport;
	}
	public void setApproveReport(Boolean approveReport) {
		this.approveReport = approveReport;
	}
	public LocalDateTime getDateReport() {
		return dateReport;
	}
	public void setDateReport(LocalDateTime dateReport) {
		this.dateReport = dateReport;
	}
	public VoteCounting getVoteCounting() {
		return voteCounting;
	}
	public void setVoteCounting(VoteCounting voteCounting) {
		this.voteCounting = voteCounting;
	}
	public Boolean getActiveReport() {
		return activeReport;
	}
	public void setActiveReport(Boolean activeReport) {
		this.activeReport = activeReport;
	}
	public List<Commentary> getCommentaryList() {
		return commentaryList;
	}
	public void setCommentaryList(List<Commentary> commentaryList) {
		this.commentaryList = commentaryList;
	}
	public String getTrackingCode() {
		return trackingCode;
	}
	public void setTrackingCode(String trackingCode) {
		this.trackingCode = trackingCode;
	}
	public void setTrackingCode() {
		this.trackingCode = codeGenerator.generateCode();
	}
	public String getNetworkType() {
		return networkType;
	}
	public void setNetworkType(String networkType) {
		this.networkType = networkType;
	}
	@Override
	public String toString() {
		return "Report [id=" + id + ", status=" + status + ", description=" + description + ", user=" + user
				+ ", valuer=" + valuer + ", approveReport=" + approveReport + ", dateReport=" + dateReport
				+ ", activeReport=" + activeReport + ", voteCounting=" + voteCounting + "]";
	}
}
