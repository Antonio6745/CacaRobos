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
import br.sp.cacarobos.model.User;
import br.sp.cacarobos.model.UserType;

@Repository
public class DaoUser implements GenericDao<User>{

	private Connection connection;
	
	@Autowired
	public DaoUser(DataSource data) {
		try {
			connection=data.getConnection();
		}catch(SQLException e){
			new RuntimeException("Error in DaoUser(Get Connection): "+e.getMessage());
		}
	}
	
	@Override
	public void create(User t) {
		try {
			PreparedStatement command=connection.prepareStatement("INSERT INTO login (username, passcode, userType) VALUES (?,md5(?),?)", Statement.RETURN_GENERATED_KEYS);
			command.setString(1, t.getLogin().getUsername());
			command.setString(2, t.getLogin().getPassword());
			command.setString(3, UserType.USR.userType);
			command.execute();
			ResultSet rs=command.getGeneratedKeys();
			rs.next();
			t.getLogin().setId(rs.getLong(1));
			command=connection.prepareStatement("INSERT INTO user (nickname, loginId, profilePicture) VALUES(?,?,?)");
			command.setString(1, t.getNickname());
			command.setLong(2, t.getLogin().getId());
			command.setBlob(3, t.getProfilePicture()!=null?new ByteArrayInputStream(t.getProfilePicture()):null);
			command.execute();
			rs.close();
			command. close();                       
		}catch(SQLException e){
			new RuntimeException("Error in DaoUser(Create): "+e.getMessage());
		}
	}

	@Override
	public User read(Long t) {
		try {
			PreparedStatement command=connection.prepareStatement("SELECT * FROM user WHERE id=?");
			command.setLong(1, t);
			ResultSet rs=command.executeQuery();
			User u = null;
			if(rs.next()){
				u=new User();
				u.setId(rs.getLong("id"));
				u.setNickname(rs.getString("nickname"));
				u.getLogin().setId(rs.getLong("loginId"));
				u.setProfilePicture(rs.getBytes("profilePicture"));
			}
			rs.close();
			command.close();
			return u;
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoUser(Read): "+e.getMessage());
		}
	}

	@Override
	public void update(User t) {
		try {
			PreparedStatement command=connection.prepareStatement("UPDATE user SET nickname=?, profilePicture=? WHERE id=?");
			command.setString(1, t.getNickname());
			command.setBlob(2, t.getProfilePicture()!=null?new ByteArrayInputStream(t.getProfilePicture()):null);
			command.setLong(3, t.getId());
			command.execute();
			command.close();
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoUser(Update): "+e.getMessage());
		}
	}

	@Override
	public void delete(Long t) {
		try {
			PreparedStatement command=connection.prepareStatement("DELETE FROM user WHERE id=?");
			command.setLong(1, t);
			command.execute();
			command.close();
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoUser(Delete): "+e.getMessage());
		}
	}

	@Override
	public List<User> listAll() {
		List<User> list=new ArrayList<>();
		try {
			PreparedStatement command=connection.prepareStatement("SELECT * FROM user");
			ResultSet rs=command.executeQuery();
			while(rs.next()){
				User u=new User();
				u.setId(rs.getLong("id"));
				u.setNickname(rs.getString("nickname"));
				u.getLogin().setId(rs.getLong("loginId"));
				u.setProfilePicture(rs.getBytes("profilePicture"));
				list.add(u);
			}
			rs.close();
			command.close();
			return list;
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoUser(List All): "+e.getMessage());
		}
	}

}
