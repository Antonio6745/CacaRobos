package br.sp.cacarobos.dao;

import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.sp.cacarobos.model.UserType;
import br.sp.cacarobos.model.Valuer;
@Repository
public class DaoValuer implements GenericDao<Valuer>{

	private Connection connection;
	
	@Autowired
	public DaoValuer(DataSource data) {
		try {
			connection=data.getConnection();
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoValuer(Get Connection): "+e.getMessage());
		}
	}
	
	@Override
	public void create(Valuer t) {
		try {
			PreparedStatement command=connection.prepareStatement("INSERT INTO login (username, passcode, userType) VALUES (?,md5(?),?)", Statement.RETURN_GENERATED_KEYS);
			command.setString(1, t.getLogin().getUsername());
			command.setString(2, t.getLogin().getPassword());
			command.setString(3, UserType.VLR.userType);
			command.execute();
			ResultSet rs=command.getGeneratedKeys();
			rs.next();
			t.getLogin().setId(rs.getLong(1));
			command=connection.prepareStatement("INSERT INTO valuer (name, cpf, loginId, birthdate, profilePicture) VALUES (?,?,?,?,?)");
			command.setString(1, t.getName());
			command.setString(2, t.getCpf());
			command.setLong(3, t.getLogin().getId());
			command.setBlob(5, t.getProfilePicture()!=null?new ByteArrayInputStream(t.getProfilePicture()):null);
			command.execute();
			rs.close();
			command.close();
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoValuer(Create): "+e.getMessage());
		}
	}
	
	@Override
	public Valuer read(Long t) {
		try {
			PreparedStatement command=connection.prepareStatement("SELECT * FROM valuer WHERE id=?");
			command.setLong(1, t);
			ResultSet rs=command.executeQuery();
			Valuer v=null;
			if(rs.next()){
				v=new Valuer();
				v.setId(rs.getLong("id"));
				v.setName(rs.getString("name"));
				v.setCpf(rs.getString("cpf"));
				v.setLoginId(rs.getLong("loginId"));
				v.setActiveAccount(rs.getBoolean("activeAccount"));
				v.setProfilePicture(rs.getBytes("profilePicture"));
			}
			rs.close();
			command.close();
			return v;
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoValuer(Read): "+e.getMessage());
		}
	}

	@Override
	public void update(Valuer t) {
		try {
			PreparedStatement command=connection.prepareStatement("UPDATE valuer SET name=?, cpf=?, birthdate=?, profilePicture=? WHERE id=?");
			command.setString(1, t.getName());
			command.setString(2, t.getCpf());
			command.setBlob(4, t.getProfilePicture()!=null?new ByteArrayInputStream(t.getProfilePicture()):null);
			command.setLong(5, t.getId());
			command.execute();
			command.close();
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoValuer(Update): "+e.getMessage());
		}
	}

	public void validateAccount(Long t, boolean answer){
		try{
			PreparedStatement command=connection.prepareStatement(
					answer==true?"UPDATE valuer SET activeAccount=1 WHERE id=?":"UPDATE valuer SET activeAccount=0 WHERE id=?");
			command.setLong(1, t);
			command.execute();
			command.close();
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoValuer(Validate Account): "+e.getMessage());
		}
	}
	
	@Override
	public void delete(Long t) {
		try {
			PreparedStatement command=connection.prepareStatement("DELETE FROM valuer WHERE id=?");
			command.setLong(1, t);
			command.execute();
			command.close();
		}catch(SQLException e){
			new RuntimeException("Error in DaoValuer(Delete): "+e.getMessage());
		}
	}

	@Override
	public List<Valuer> listAll() {
		List<Valuer> list=new ArrayList<>();
		try {
			PreparedStatement command=connection.prepareStatement("SELECT * FROM valuer");
			ResultSet rs=command.executeQuery();
			while(rs.next()){
				Valuer v=new Valuer();
				v.setId(rs.getLong("id"));
				v.setName(rs.getString("name"));
				v.setCpf(rs.getString("cpf"));
				v.setLoginId(rs.getLong("loginId"));
				v.setActiveAccount(rs.getBoolean("activeAccount"));
				v.setProfilePicture(rs.getBytes("profilePicture"));
				list.add(v);
			}
			rs.close();
			command.close();
			return list;
		}catch(SQLException e){
			new RuntimeException("Error in DaoValuer(List All): "+e.getMessage());
		}
		return null;
	}

}