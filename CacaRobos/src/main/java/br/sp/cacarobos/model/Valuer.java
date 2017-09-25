package br.sp.cacarobos.model;

public class Valuer extends Person{
	private Boolean activeAccount;
	private String reason;
	public Boolean getActiveAccount() {
		return activeAccount;
	}
	public void setActiveAccount(Boolean activeAccount) {
		this.activeAccount = activeAccount;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
}