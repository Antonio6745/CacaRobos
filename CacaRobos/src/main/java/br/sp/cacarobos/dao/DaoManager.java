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

import br.sp.cacarobos.model.Manager;
import br.sp.cacarobos.model.UserType;
@Repository
public class DaoManager implements GenericDao<Manager>{

	private Connection connection;
	
	@Autowired
	public DaoManager(DataSource data) {
		try {
			connection=data.getConnection();
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoManager(Get Connection): "+e.getMessage());
		}
	}
	
	@Override
	public void create(Manager t) {
		try {
			PreparedStatement command=connection.prepareStatement("INSERT INTO login (username, passcode, userType) VALUES (?,md5(?),?)", Statement.RETURN_GENERATED_KEYS);
			command.setString(1, t.getLogin().getUsername());
			command.setString(2, t.getLogin().getPassword());
			command.setString(3, UserType.ADM.userType);
			command.execute();
			ResultSet rs=command.getGeneratedKeys();
			rs.next();
			t.getLogin().setId(rs.getLong(1));
			command=connection.prepareStatement("INSERT INTO manager (name, cpf, loginId, birthdate, profilePicture) VALUES (?,?,?,?,?)");
			command.setString(1, t.getName());
			command.setString(2, t.getCpf());
			command.setLong(3, t.getLogin().getId());
			command.setBlob(5, t.getProfilePicture()!=null?new ByteArrayInputStream(t.getProfilePicture()):null);
			command.execute();
			rs.close();
			command.close();
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoManager(Create): "+e.getMessage());
		}
	}
	
	@Override
	public Manager read(Long t) {
		try {
			PreparedStatement command=connection.prepareStatement("SELECT * FROM manager WHERE id=?");
			command.setLong(1, t);
			ResultSet rs=command.executeQuery();
			Manager m=null;
			if(rs.next()){
				m=new Manager();
				m.setId(rs.getLong("id"));
				m.setName(rs.getString("name"));
				m.setCpf(rs.getString("cpf"));
				m.getLogin().setId(rs.getLong("loginId"));
				m.setProfilePicture(rs.getBytes("profilePictures"));
			}
			rs.close();
			command.close();
			return m;
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoManager(Read): "+e.getMessage());
		}
	}

	@Override
	public void update(Manager t) {
		try {
			PreparedStatement command=connection.prepareStatement("UPDATE manager SET name=?, cpf=?, birthdate=?, profilePicture=? WHERE id=?");
			command.setString(1, t.getName());
			command.setString(2, t.getCpf());
			command.setBlob(4, t.getProfilePicture()!=null?new ByteArrayInputStream(t.getProfilePicture()):null);
			command.setLong(5, t.getId());
			command.execute();
			command.close();
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoManager(Update): "+e.getMessage());
		}
	}

	@Override
	public void delete(Long t) {
		try {
			PreparedStatement command=connection.prepareStatement("DELETE FROM manager WHERE id=?");
			command.setLong(1, t);
			command.execute();
			command.close();
		}catch(SQLException e){
			new RuntimeException("Error in DaoManager(Delete): "+e.getMessage());
		}
	}

	@Override
	public List<Manager> listAll() {
		List<Manager> list=new ArrayList<>();
		try {
			PreparedStatement command=connection.prepareStatement("SELECT * FROM manager");
			ResultSet rs=command.executeQuery();
			while(rs.next()){
				Manager m=new Manager();
				m.setId(rs.getLong("id"));
				m.setName(rs.getString("name"));
				m.setCpf(rs.getString("cpf"));
				m.getLogin().setId(rs.getLong("loginId"));
				m.setProfilePicture(rs.getBytes("profilePicture"));
				list.add(m);
			}
			rs.close();
			command.close();
			return list;
		}catch(SQLException e){
			new RuntimeException("Error in DaoManager(List All): "+e.getMessage());
		}
		return null;
	}

}
