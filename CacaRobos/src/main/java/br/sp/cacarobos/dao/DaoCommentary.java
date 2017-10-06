package br.sp.cacarobos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.sp.cacarobos.model.Commentary;
import br.sp.cacarobos.model.User;
import br.sp.cacarobos.model.UserType;
import br.sp.cacarobos.model.Valuer;

@Repository
public class DaoCommentary{
	
	private Connection connection;
	
	@Autowired
	public DaoCommentary(DataSource data) {
		try {
			connection=data.getConnection();
		}catch(SQLException e){
			new RuntimeException("Error in DaoComment(Get Connection): "+e.getMessage());
		}
	}
	
	public void createUserCommentary(Commentary t) {
		try {
			PreparedStatement command=connection.prepareStatement("INSERT INTO commentary (description, userId, reportId, userType) VALUES (?,?,?,?)");
			command.setString(1, t.getDescription());
			command.setLong(2, t.getUser().getId());
			command.setLong(3, t.getReport().getId());
			command.setString(4, UserType.USR.userType);
			command.execute();
			command.close();
		}catch(SQLException e){
			new RuntimeException("Error in DaoComment(Create): "+e.getMessage());
		}
	}

	public void createValuerCommentary(Commentary t) {
		try {
			PreparedStatement command=connection.prepareStatement("INSERT INTO commentary (description, valuerId, reportId, userType) VALUES (?,?,?,?)");
			command.setString(1, t.getDescription());
			command.setLong(2, t.getValuer().getId());
			command.setLong(3, t.getReport().getId());
			command.setString(4, UserType.VLR.userType);
			command.execute();
			command.close();
		}catch(SQLException e){
			new RuntimeException("Error in DaoComment(Create): "+e.getMessage());
		}
	}
	
	public Commentary read(Long t) {
		try {
			PreparedStatement command=connection.prepareStatement("SELECT * FROM commentary WHERE id=?");
			command.setLong(1, t);
			ResultSet rs=command.executeQuery();
			Commentary c=null;
			if(rs.next()){
				c=retriveData(rs);
				if(c.getUserType().equals(UserType.USR.userType)) {
					c.setUser(retriveUser(c.getUser().getId()));
				}else {
					c.setValuer(retriveValuer(c.getValuer().getId()));
				}
			}
			rs.close();
			command.close();
			return c;
		}catch(SQLException e){
			new RuntimeException("Error in DaoComment(Read): "+e.getMessage());
		}
		return null;
	}
	
	private Valuer retriveValuer(Long t){
		try{
			PreparedStatement command=connection.prepareStatement("");
			command.setLong(1, t);
			ResultSet rs=command.executeQuery();
			Valuer v = null;
			if(rs.next()){
				v=new Valuer();
				v.setId(rs.getLong("id"));
				v.setName(rs.getString("name"));
				v.setCpf(rs.getString("cpf"));
				v.setActiveAccount(rs.getBoolean("activeAccount"));
				v.setProfilePicture(rs.getBytes("profilePicture"));
				v.setReason(rs.getString("reason"));
			}
			rs.close();
			command.close();
			return v;
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoCommentary(Retrive Valuer): "+e.getMessage());
		}
	}
	
	private User retriveUser(Long t){
		try{
			PreparedStatement command=connection.prepareStatement("SELECT * FROM user WHERE id=?");
			command.setLong(1, t);
			ResultSet rs=command.executeQuery();
			User u=null;
			if(rs.next()){
				u=new User();
				u.setId(t);
				u.setNickname(rs.getString("nickname"));
				u.setProfilePicture(rs.getBytes("profilePicture"));
			}
			rs.close();
			command.close();
			return u;
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoCommenatry(Retrive User): "+e.getMessage());
		}
	}
	
	public void update(Commentary t) {
		try {
			PreparedStatement command=connection.prepareStatement("UPDATE commentary SET description=? WHERE id=?");
			command.setString(1, t.getDescription());
			command.setLong(2, t.getId());
			command.execute();
			command.close();
		}catch(SQLException e){
			new RuntimeException("Error in DaoComment(Update): "+e.getMessage());
		}
	}

	public void delete(Long t) {
		try {
			PreparedStatement command=connection.prepareStatement("DELETE FROM commentary WHERE id=?");
			command.setLong(1, t);
			command.execute();
			command.close();
		}catch(SQLException e){
			new RuntimeException("Error in DaoComment(Delete): "+e.getMessage());
		}
	}

	private Commentary retriveData(ResultSet rs){
		try{
			Commentary c=new Commentary();
			c.setId(rs.getLong("id"));
			c.setDescription(rs.getString("description"));
			c.getReport().setId(rs.getLong("reportId"));
			c.getUser().setId(rs.getLong("userId"));
			return c;
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoCommentary(Retrive data): "+e.getMessage());
		}
	}
	
	public List<Commentary> listAll() {
		List<Commentary> list=new ArrayList<>();
		try {
			PreparedStatement command=connection.prepareStatement("SELECT * FROM commentary");
			ResultSet rs=command.executeQuery();
			while(rs.next()){
				Commentary c=retriveData(rs);
				c.setUser(retriveUser(c.getUser().getId()));
				list.add(c);
			}
			rs.close();
			command.close();
			return list;
		}catch(SQLException e){
			new RuntimeException("Error in DaoComment(List All): "+e.getMessage());
		}
		return null;
	}
	
}
