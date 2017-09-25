package br.sp.cacarobos.model;
public enum UserType {
	ADM("ADM"),USR("USR"),VLR("VLR");
	public String userType;
	
	UserType(String userType){
		this.userType=userType;
	}
	@Override
	public String toString() {
		return this.userType;
	}
}
