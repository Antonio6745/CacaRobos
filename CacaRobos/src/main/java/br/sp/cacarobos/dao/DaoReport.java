package br.sp.cacarobos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.sp.cacarobos.model.Report;
import br.sp.cacarobos.model.Status;
import br.sp.cacarobos.model.User;

@Repository
public class DaoReport implements GenericDao<Report>{
	
	private Connection connection;
	
	@Autowired
	public DaoReport(DataSource data) {
		try {
			connection=data.getConnection();
		}catch(SQLException e){
			new RuntimeException("Error in DaoReport(Get Connection): "+e.getMessage());
		}
	}
	
	@Override
	public void create(Report t) {
		try {
			PreparedStatement command=connection.prepareStatement("INSERT INTO report (status, description, userId) VALUES (?,?,?)");
			command.setString(1, t.getStatus());
			command.setString(2, Status.PROCESSING.status);
			command.setLong(3, t.getUser().getId());
			command.execute();
			command.close();
		}catch(SQLException e){
			new RuntimeException("Error in DaoReport(Create): "+e.getMessage());
		}
	}

	@Override
	public Report read(Long t) {
		try {
			PreparedStatement command=connection.prepareStatement("SELECT * FROM report WHERE id=?");
			command.setLong(1, t);
			ResultSet rs=command.executeQuery();
			Report r=null;
			if(rs.next()){
				r=new Report();
				r.setId(rs.getLong("id"));
				r.setDescription(rs.getString("description"));
				String statusId=rs.getString("status");
				for(Status status : Status.values()){
					if(status.status.equals(statusId)){
						r.setStatus(status);
						break;
					}
				}
				r.setUser(retriveUser(rs.getLong("userId")));
				r.setValuerId(rs.getLong("valuerId"));
				r.setApproveReport(rs.getBoolean("approveReport"));
				r.setDateReport(LocalDateTime.parse(rs.getDate("dateReport").toString()));
				r.setActiveReport(rs.getBoolean("activeReport"));
				r.getVoteCounting().setIsARobot(rs.getInt("isARobotVotes"));
				r.getVoteCounting().setIsNotARobot(rs.getInt("isNotARobotVotes"));
			}
			rs.close();
			command.close();
			return r;
		}catch(SQLException e){
			new RuntimeException("Error in DaoReport(Read): "+e.getMessage());
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
	
	@Override
	public void update(Report t) {
		try {
			PreparedStatement command=connection.prepareStatement("UPDATE report SET description=? WHERE id=?");
			command.setString(1, t.getDescription());
			command.setLong(2, t.getId());
			command.execute();
			command.close();
		}catch(SQLException e){
			new RuntimeException("Error in DaoReport(Update): "+e.getMessage());
		}
	}

	public void updateStatus(Long t, String status){
		try{
			PreparedStatement command=connection.prepareStatement("UPDATE report SET status=? WHERE id=?");
			command.setString(1, status);
			command.setLong(2, t);
			command.execute();
			command.close();
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoReport(Update Status): "+e.getMessage());
		}
	}
	
	public void approveReport(Long t, boolean answer){
		try{
			PreparedStatement command=connection.prepareStatement(
					answer==true?"UPDATE report SET approveReport=1 WHERE id=?":"UPDATE report SET approveReport=0 WHERE id=?");
			command.setLong(1, t);
			command.execute();
			command.close();
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoReport(Approve Report): "+e.getMessage());
		}
	}
	
	public void activeReport(Long t, boolean answer){
		try{
			PreparedStatement command=connection.prepareStatement(
					answer==true?"UPDATE report SET activeReport=1 WHERE id=?":"UPDATE report SET activeReport=1 WHERE id=?");
			command.setLong(1, t);
			command.execute();
			command.close();
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoReport(Active Report): "+e.getMessage());
		}
	}
	
	public void addIsARobotOrNotVote(Long t, boolean itIsARobot){
		try{
			Report r=read(t);
			PreparedStatement command=connection.prepareStatement("UPDATE report SET isARobotVotes=?, isARobotVotes=? WHERE id=?");
			if(itIsARobot){
				command.setInt(1, r.getVoteCounting().getIsARobot()+1);
				command.setInt(2, r.getVoteCounting().getIsNotARobot());
			}else {
				command.setInt(1, r.getVoteCounting().getIsARobot());
				command.setInt(2, r.getVoteCounting().getIsNotARobot()+1);
			}
			command.setLong(3, r.getId());
			command.execute();
			command.close();
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoReport(Add is a robot or not vote): "+e.getMessage());
		}		
	}
	
	@Override
	public void delete(Long t) {
		try {
			PreparedStatement command=connection.prepareStatement("DELETE FROM report WHERE id=?");
			command.setLong(1, t);
			command.execute();
			command.close();
		}catch(SQLException e){
			new RuntimeException("Error in DaoReport(Delete): "+e.getMessage());
		}
	}
	
	private Report retriveData(ResultSet rs){
		try{
			Report r=new Report();
			r.setId(rs.getLong("id"));
			r.setDescription(rs.getString("description"));
			String statusId=rs.getString("status");
			for(Status status : Status.values()){
				if(status.status.equals(statusId)){
					r.setStatus(status);
					break;
				}
			}
			r.setUserId(rs.getLong("userId"));
			r.setValuerId(rs.getLong("valuerId"));
			r.setApproveReport(rs.getBoolean("approveReport"));
			r.setDateReport(LocalDateTime.parse(rs.getDate("dateReport").toString()));
			r.setActiveReport(rs.getBoolean("activeReport"));
			r.getVoteCounting().setIsARobot(rs.getInt("isARobotVotes"));
			r.getVoteCounting().setIsNotARobot(rs.getInt("isNotARobotVotes"));
			return r;
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoReport(Retrive data): "+e.getMessage());
		}
	}

	@Override
	public List<Report> listAll() {
		List<Report> list=new ArrayList<>();
		try {
			PreparedStatement command=connection.prepareStatement("SELECT * FROM report");
			ResultSet rs=command.executeQuery();
			while(rs.next()){
				Report r=retriveData(rs);
				list.add(r);
			}
			rs.close();
			command.close();
			return list;
		}catch(SQLException e){
			new RuntimeException("Error in DaoReport(List All): "+e.getMessage());
		}
		return null;
	}
	
	
	public List<Report> retriveOnlyActiveReports(){
		List<Report> list=new ArrayList<>();
		try{
			PreparedStatement command=connection.prepareStatement("SELECT * FROM report WHERE activeReport=1");
			ResultSet rs=command.executeQuery();
			while(rs.next()){
				Report r=retriveData(rs);
				list.add(r);
			}
			rs.close();
			command.close();
			return list;
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoReport(Retrive only active reports): "+e.getMessage());
		}
	}
	
	public List<Report> listAllReportsByValuerId(Long t, boolean activeReports){
		List<Report> list=new ArrayList<>();
		try{
			PreparedStatement command=connection.prepareStatement(
					activeReports==true?"SELECT * FROM report WHERE valuerId=? AND activeReport=1":"SELECT * FROM report WHERE valuerId=? AND activeReport=0");
			command.setLong(1, t);
			ResultSet rs=command.executeQuery();
			while(rs.next()){
				Report r=retriveData(rs);
				list.add(r);
			}
			rs.close();
			command.close();
			return list;
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoReport(List all reports by valuer id): "+e.getMessage());
		}
	}
	
	public List<Report> listAllActiveReports(){
		List<Report> list=new ArrayList<>();
		try{
			PreparedStatement command=connection.prepareStatement("SELECT * FROM report WHERE activeReport=1");
			ResultSet rs=command.executeQuery();
			while(rs.next()){
				Report r=retriveData(rs);
				list.add(r);
			}
			rs.close();
			command.close();
			return list;
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoReport(List all active reports): "+e.getMessage());
		}
	}
	
}
