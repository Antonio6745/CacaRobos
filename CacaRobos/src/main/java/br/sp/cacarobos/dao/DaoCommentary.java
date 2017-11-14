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
import br.sp.cacarobos.model.Login;
import br.sp.cacarobos.model.User;
import br.sp.cacarobos.model.UserType;
import br.sp.cacarobos.model.Valuer;

@Repository
public class DaoCommentary implements GenericDao<Commentary>{
	
	private Connection connection;
	
	@Autowired
	public DaoCommentary(DataSource data) {
		try {
			connection=data.getConnection();
		}catch(SQLException e){
			new RuntimeException("Error in DaoComment(Get Connection): "+e.getMessage());
		}
	}
	
	@Override
	public void create(Commentary t) {
		
	}
	
	public void create(Commentary t, boolean isAUser) {
		try {
			PreparedStatement command=connection.prepareStatement(
					isAUser==true?"INSERT INTO commentary (description, userId, reportId, userType) VALUES (?,?,?,?)":"INSERT INTO commentary (description, valuerId, reportId, userType) VALUES (?,?,?,?)");
			command.setString(1, t.getDescription());
			if(isAUser){
				command.setLong(2, t.getUser().getId());
			}else {
				command.setLong(2, t.getValuer().getId());
			}
			command.setLong(3, t.getReport().getId());
			command.setString(4, t.getUser().getLogin().getUserType());
			System.out.println( command);
			command.execute();
			command.close();
		}catch(SQLException e){
			new RuntimeException("Error in DaoComment(Create): "+e.getMessage());
		}
	}

	@Override
	public Commentary read(Long t) {
		try {
			PreparedStatement command=connection.prepareStatement("SELECT * FROM commentary WHERE id=?");
			command.setLong(1, t);
			ResultSet rs=command.executeQuery();
			Commentary c=null;
			if(rs.next()){
				c=new Commentary();
				c.setId(rs.getLong("id"));
				c.setDescription(rs.getString("description"));
				c.getReport().setId(rs.getLong("reportId"));
				c.setUser(retriveUser(rs.getLong("userId")));
				c.setValuer(retriveValuer(rs.getLong("valuerId")));
			}
			rs.close();
			command.close();
			return c;
		}catch(SQLException e){
			new RuntimeException("Error in DaoComment(Read): "+e.getMessage());
		}
		return null;
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
	
	private Valuer retriveValuer(Long t) {
		try {
		PreparedStatement command=connection.prepareStatement("SELECT * FROM valuer WHERE id=?");
		command.setLong(1, t);
		ResultSet rs=command.executeQuery();
		Valuer v=null;
		if(rs.next()) {
			v=new Valuer();
			v.setId(t);
			v.setName(rs.getString("name"));
			v.setProfilePicture(rs.getBytes("profilePicture"));
		}
		rs.close();
		command.close();
		return v;
		}catch(SQLException e) {
			throw new RuntimeException("Error in DaoCommentary(Retrieve Valuer):"+e.getMessage());
		}
	}
	
	private Login retriveLoginUserType(Long id){
		try{
			PreparedStatement command=connection.prepareStatement("SELECT userType FROM login WHERE id=?");
			command.setLong(1, id);
			ResultSet rs=command.executeQuery();
			Login l=null;
			if(rs.next()){
				l=new Login();
				l.setUserType(rs.getString(1));
			}
			rs.close();
			command.close();
			return l;
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoCommentary(Retrive Login User Type): "+e.getMessage());
		}
	}
	
	@Override
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

	@Override
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
			if (Long.valueOf(rs.getLong("userId")) != null) {
				c.getUser().setId(rs.getLong("userId"));
			} else if (Long.valueOf(rs.getLong("valuerId")) != null) {
				c.getValuer().setId(rs.getLong("valuerId"));
			}
			return c;
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoCommentary(Retrive data): "+e.getMessage());
		}
	}
	
	@Override
	public List<Commentary> listAll() {
		List<Commentary> list=new ArrayList<>();
		try {
			PreparedStatement command=connection.prepareStatement("SELECT * FROM commentary");
			ResultSet rs=command.executeQuery();
			while(rs.next()){
				Commentary c=retriveData(rs);
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

	public List<Commentary> listCommentsByReportId(Long t){
		List<Commentary> list=new ArrayList<>();
		try{
			PreparedStatement command=connection.prepareStatement("SELECT * FROM commentary WHERE reportId=?");
			command.setLong(1, t);
			ResultSet rs=command.executeQuery();
			while(rs.next()){
				Commentary c=retriveData(rs);
				c.setUser(retriveUser(rs.getLong("userId")));
				c.setValuer(retriveValuer(rs.getLong("valuerId")));

				list.add(c);
			}
			rs.close();
			command.close();
			return list;
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoCommentary(List comments by report id): "+e.getMessage());
		}
	}
	
}
