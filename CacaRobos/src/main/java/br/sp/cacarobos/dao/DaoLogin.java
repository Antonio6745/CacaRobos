package br.sp.cacarobos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import br.sp.cacarobos.model.Login;
import br.sp.cacarobos.model.Manager;
import br.sp.cacarobos.model.User;
import br.sp.cacarobos.model.Valuer;

@Repository
public class DaoLogin{
	
	private Connection connection;
	
	@Autowired
	public DaoLogin(DataSource data) {
		try {
			connection=data.getConnection();
		}catch(SQLException e){
			new RuntimeException("Error in DaoLogin(Get connection): "+e.getMessage());
		}
	}
	
	public Login sigin(Login t){
		try{
			PreparedStatement command=connection.prepareStatement("SELECT * FROM login WHERE username=? AND passcode=?");
			command.setString(1, t.getUsername());
			command.setString(2, t.getPassword());
			ResultSet rs=command.executeQuery();
			if(rs.next()){
				t.setId(rs.getLong("id"));
				t.setUserType(rs.getString("userType"));
			}else {
				t=null;
			}
			rs.close();
			command.close();
			return t;
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoLogin(Sigin): "+e.getMessage());
		}
	}
	
	public Manager retriveInfoManager(Login t){
		try{
			PreparedStatement command=connection.prepareStatement("SELECT * FROM manager WHERE loginId=?");
			command.setLong(1, t.getId());
			ResultSet rs=command.executeQuery();
			Manager m=null;
			if(rs.next()){
				m=new Manager();
				m.setLogin(t);
				m.setId(rs.getLong("id"));
				m.setName(rs.getString("name"));
				m.setCpf(rs.getString("cpf"));
				m.setProfilePicture(rs.getBytes("profilePicture"));
			}
			rs.close();
			command.close();
			return m;
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoLogin(Retrive Info Manager): "+e.getMessage());
		}
	}
	
	public User retriveInfoUser(Login t){
		try{
			PreparedStatement command=connection.prepareStatement("SELECT * FROM user WHERE loginId=?");
			command.setLong(1, t.getId());
			ResultSet rs=command.executeQuery();
			User u=null;
			if(rs.next()){
				u=new User();
				u.setLogin(t);
				u.setId(rs.getLong("id"));
				u.setNickname(rs.getString("nickname"));
				u.setProfilePicture(rs.getBytes("profilePicture"));
			}
			rs.close();
			command.close();
			return u;
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoLogin(Retrive Info User): "+e.getMessage());
		}
	}
	
	public Valuer retriveInfoValuer(Login t){
		try{
			PreparedStatement command=connection.prepareStatement("SELECT * FROM valuer WHERE loginId=?");
			command.setLong(1, t.getId());
			ResultSet rs=command.executeQuery();
			Valuer v=null;
			if(rs.next()){
				v=new Valuer();
				v.setLogin(t);
				v.setId(rs.getLong("id"));
				v.setName(rs.getString("name"));
				v.setCpf(rs.getString("cpf"));
				v.setActiveAccount(rs.getBoolean("activeAccount"));
				v.setProfilePicture(rs.getBytes("profilePicture"));
			}
			rs.close();
			command.close();
			return v;
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoLogin(Retrive Info Valuer): "+e.getMessage());
		}
	}
	
	public boolean emailAlreadyExists(Login t){
		try{
			PreparedStatement command=connection.prepareStatement("SELECT * FROM login WHERE username=?");
			command.setString(1, t.getUsername());
			ResultSet rs=command.executeQuery();
			boolean aux=rs.next();
			rs.close();
			command.close();
			return aux;
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoLogin(Email already exists): "+e.getMessage());
		}
	}
	
}