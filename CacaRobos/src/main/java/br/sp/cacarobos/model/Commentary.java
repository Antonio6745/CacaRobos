package br.sp.cacarobos.model;

public class Commentary {
	private Long id;
	private String description;
	private User user;
	private Report report;
	public Commentary() {
		user=new User();
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
	@Override
	public String toString() {
		return "Comment [id=" + id + ", description=" + description + ", user=" + user + "]";
	}
	
	
}
