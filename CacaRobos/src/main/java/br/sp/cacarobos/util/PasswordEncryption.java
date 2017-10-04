package br.sp.cacarobos.util;

import java.security.MessageDigest;

public class PasswordEncryption {
	public static String encrypt(String password){
		String passwordEncrypted="";
		try{
			MessageDigest algorithm=MessageDigest.getInstance("SHA-256");
			byte[] messageDigest=algorithm.digest(password.getBytes("UTF-8"));
			for(byte b:messageDigest){
				passwordEncrypted+=String.format("%02x", 0xFF & b);
			}
			return passwordEncrypted;
		}catch(Exception e){
			throw new RuntimeException("Error in Encryption256(Encrypt): "+e.getMessage());
		}
	}
}
