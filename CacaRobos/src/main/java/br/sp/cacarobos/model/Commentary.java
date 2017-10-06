package br.sp.cacarobos.model;

public class Commentary {
	private Long id;
	private String description;
	private User user;
	private Valuer valuer;
	private Report report;
	private String userType;
	public Commentary() {
		user=new User();
		valuer=new Valuer();
		report=new Report();
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Report getReport() {
		return report;
	}
	public void setReport(Report report) {
		this.report = report;
	}
	public Valuer getValuer() {
		return valuer;
	}
	public void setValuer(Valuer valuer) {
		this.valuer = valuer;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	@Override
	public String toString() {
		return "Commentary [id=" + id + ", description=" + description + ", user=" + user + ", valuer=" + valuer
				+ ", report=" + report + ", userType=" + userType + "]";
	}
}
