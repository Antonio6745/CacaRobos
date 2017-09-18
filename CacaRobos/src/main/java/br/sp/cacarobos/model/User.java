package br.sp.cacarobos.model;

import com.sun.org.apache.xml.internal.security.utils.Base64;

public class User {
	private Long id;
	private String nickname;
	private byte[] profilePicture;
	private Login login;
	
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	public void setLoginId(Long id){
		login.setId(id);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
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
		return "User [id=" + id + ", nickname=" + nickname + "]";
	}
	
}
