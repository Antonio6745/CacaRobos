package br.sp.cacarobos.model;

public class Statistics {
	private Integer facebookReports;
	private Integer instagramReports;
	private Integer twitterReports;
	private Integer googlePlusReport;
	private Integer reportCompleted;
	private Integer userTotal;
	private Integer valuerTotal;
	private Integer managerTotal;
	public Integer getFacebookReports() {
		return facebookReports;
	}
	public void setFacebookReports(Integer facebookReports) {
		this.facebookReports = facebookReports;
	}
	public Integer getInstagramReports() {
		return instagramReports;
	}
	public void setInstagramReports(Integer instagramReports) {
		this.instagramReports = instagramReports;
	}
	public Integer getTwitterReports() {
		return twitterReports;
	}
	public void setTwitterReports(Integer twitterReports) {
		this.twitterReports = twitterReports;
	}
	public Integer getGooglePlusReport() {
		return googlePlusReport;
	}
	public void setGooglePlusReport(Integer googlePlusReport) {
		this.googlePlusReport = googlePlusReport;
	}
	public Integer getReportCompleted() {
		return reportCompleted;
	}
	public void setReportCompleted(Integer reportCompleted) {
		this.reportCompleted = reportCompleted;
	}
	public Integer getUserTotal() {
		return userTotal;
	}
	public void setUserTotal(Integer userTotal) {
		this.userTotal = userTotal;
	}
	public Integer getValuerTotal() {
		return valuerTotal;
	}
	public void setValuerTotal(Integer valuerTotal) {
		this.valuerTotal = valuerTotal;
	}
	public Integer getManagerTotal() {
		return managerTotal;
	}
	public void setManagerTotal(Integer managerTotal) {
		this.managerTotal = managerTotal;
	}
	@Override
	public String toString() {
		return "Statistics [facebookReports=" + facebookReports + ", instagramReports=" + instagramReports
				+ ", twitterReports=" + twitterReports + ", googlePlusReport=" + googlePlusReport + ", reportCompleted="
				+ reportCompleted + ", userTotal=" + userTotal + ", valuerTotal=" + valuerTotal + ", managerTotal="
				+ managerTotal + "]";
	}
}
