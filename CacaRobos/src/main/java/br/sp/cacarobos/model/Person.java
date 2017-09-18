package br.sp.cacarobos.model;
import com.sun.org.apache.xml.internal.security.utils.Base64;
public abstract class Person {
	private Long id;
	private String name;
	private String cpf;
	private Login login;
	private byte[] profilePicture;
	
	public Person() {
		login=new Login();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	public void setLoginId(Long id) {
		login.setId(id);
	}
	public byte[] getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(byte[] profilePicture) {
		this.profilePicture = profilePicture;
	}
	public String getPhoto64(){
		return Base64.encode(profilePicture);
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", cpf=" + cpf + ", login=" + login + "]";
	}
}