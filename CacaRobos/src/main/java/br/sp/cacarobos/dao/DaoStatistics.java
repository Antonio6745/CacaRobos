package br.sp.cacarobos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.sp.cacarobos.model.Statistics;

@Repository
public class DaoStatistics {
	private Connection connection;
	
	@Autowired
	public DaoStatistics(DataSource data) {
		try {
			this.connection=data.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("Error in DaoStatistics(GetConnection): "+e.getMessage());
		}
	}
	
	public Statistics countFacebookReports(){
		try {
			PreparedStatement command=connection.prepareStatement("SELECT COUNT(socialNetworkType) FROM report WHERE socialNetworkType='Facebook'");
			ResultSet rs=command.executeQuery();
			rs.next();
			Statistics s=new Statistics();
			s.setFacebookReports(rs.getInt(1));
			rs.close();
			command.close();
			return s;
		} catch (SQLException e) {
			throw new RuntimeException("Error in DaoStatistics(Retrive by social network): "+e.getMessage());
		}
	}
	
	public Statistics countTwitterReports(){
		try {
			PreparedStatement command=connection.prepareStatement("SELECT COUNT(socialNetworkType) FROM report WHERE socialNetworkType='Twitter'");
			ResultSet rs=command.executeQuery();
			rs.next();
			Statistics s=new Statistics();
			s.setFacebookReports(rs.getInt(1));
			rs.close();
			command.close();
			return s;
		} catch (SQLException e) {
			throw new RuntimeException("Error in DaoStatistics(Retrive by social network): "+e.getMessage());
		}
	}
	
	public Statistics countInstagramReports(){
		try {
			PreparedStatement command=connection.prepareStatement("SELECT COUNT(socialNetworkType) FROM report WHERE socialNetworkType='Intagram'");
			ResultSet rs=command.executeQuery();
			rs.next();
			Statistics s=new Statistics();
			s.setFacebookReports(rs.getInt(1));
			rs.close();
			command.close();
			return s;
		} catch (SQLException e) {
			throw new RuntimeException("Error in DaoStatistics(Retrive by social network): "+e.getMessage());
		}
	}
	
	public Statistics countGooglePlusReports(){
		try {
			PreparedStatement command=connection.prepareStatement("SELECT COUNT(socialNetworkType) FROM report WHERE socialNetworkType='Google +'");
			ResultSet rs=command.executeQuery();
			rs.next();
			Statistics s=new Statistics();
			s.setFacebookReports(rs.getInt(1));
			rs.close();
			command.close();
			return s;
		} catch (SQLException e) {
			throw new RuntimeException("Error in DaoStatistics(Retrive by social network): "+e.getMessage());
		}
	}
	
	public Statistics countReportCompleted(){
		try{
			PreparedStatement command=connection.prepareStatement("SELECT COUNT(activeReport) FROM report WHERE activeReport=0");
			ResultSet rs=command.executeQuery();
			rs.next();
			Statistics i=new Statistics();
			i.setReportCompleted(rs.getInt(1));
			rs.close();
			command.close();
			return i;
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoStatistics(): "+e.getMessage());
		}
	}
	
	public Statistics countUsers(){
		try{
			PreparedStatement command=connection.prepareStatement("SELECT COUNT(id) FROM user");
			ResultSet rs=command.executeQuery();
			rs.next();
			Statistics i=new Statistics();
			i.setUserTotal(rs.getInt(1));
			rs.close();
			command.close();
			return i;
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoStatistics(Count users): "+e.getMessage());
		}
	}
	
	public Statistics countManagers(){
		try{
			PreparedStatement command=connection.prepareStatement("SELECT COUNT(id) FROM manager");
			ResultSet rs=command.executeQuery();
			rs.next();
			Statistics i=new Statistics();
			i.setManagerTotal((rs.getInt(1)));
			rs.close();
			command.close();
			return i;
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoStatistics(Count managers): "+e.getMessage());
		}
	}
	
	public Statistics countValuers(){
		try{
			PreparedStatement command=connection.prepareStatement("SELECT COUNT(id) FROM valuer");
			ResultSet rs=command.executeQuery();
			rs.next();
			Statistics i=new Statistics();
			i.setValuerTotal((rs.getInt(1)));
			rs.close();
			command.close();
			return i;
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoStatistics(Count valuers): "+e.getMessage());
		}
	}
}
