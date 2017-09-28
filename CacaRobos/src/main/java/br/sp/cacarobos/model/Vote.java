package br.sp.cacarobos.model;
public class Vote {
	private Long id;
	private Long reportId;
	private Long valuerId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getReportId() {
		return reportId;
	}
	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}
	public Long getValuerId() {
		return valuerId;
	}
	public void setValuerId(Long valuerId) {
		this.valuerId = valuerId;
	}
	@Override
	public String toString() {
		return "Vote [id=" + id + ", reportId=" + reportId + ", valuerId=" + valuerId + "]";
	}
	
}