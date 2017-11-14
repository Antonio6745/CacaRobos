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

import br.sp.cacarobos.model.Report;
import br.sp.cacarobos.model.Valuer;
import br.sp.cacarobos.model.Vote;

@Repository
public class DaoVote implements GenericDao<Vote>{
	private Connection connection;
	
	@Autowired
	public DaoVote(DataSource data) {
		try{
			this.connection=data.getConnection();
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoVote(Get Connection): "+e.getMessage());
		}
	}
	
	@Override
	public void create(Vote v){
		try{
			PreparedStatement command=connection.prepareStatement("INSERT INTO votes(reportId, valuerId) VALUES (?,?)");
			command.setLong(1, v.getReportId());
			command.setLong(2, v.getValuerId());
			command.execute();
			command.close();
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoVote(Create): "+e.getMessage());
		}
	}
	
	@Override
	public Vote read(Long t) {
		try{
			PreparedStatement command=connection.prepareStatement("SELECT * FROM votes WHERE id=?");
			command.setLong(1, t);
			ResultSet rs=command.executeQuery();
			Vote v=null;
			if(rs.next()){
				v=retriveData(rs);
			}
			rs.close();
			command.close();
			return v;
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoVote(Read): "+e.getMessage());
		}
	}
	
	private Vote retriveData(ResultSet rs){
		try{
			Vote v=new Vote();
			v.setId(rs.getLong("id"));
			v.setReportId(rs.getLong("reportId"));
			v.setValuerId(rs.getLong("valuerId"));
			return v;
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoVote(): "+e.getMessage());
		}
	}
	
	@Override
	public void update(Vote t) {
		try{
			PreparedStatement command=connection.prepareStatement("UPDATE votes SET valuerId=?, reportId=? WHERE id=?");
			command.setLong(1, t.getValuerId());
			command.setLong(2, t.getReportId());
			command.setLong(3, t.getId());
			command.execute();
			command.close();
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoVote(Update): "+e.getMessage());
		}
	}
	
	@Override
	public void delete(Long t) {
		try{
			PreparedStatement command=connection.prepareStatement("DELETE FROM votes WHERE id=?");
			command.setLong(1, t);
			command.execute();
			command.close();
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoVote(Delete): "+e.getMessage());
		}
	}
	
	@Override
	public List<Vote> listAll() {
		List<Vote> list=new ArrayList<Vote>();
		try{
			PreparedStatement command=connection.prepareStatement("SELECT * FROM votes");
			ResultSet rs=command.executeQuery();
			while(rs.next()){
				Vote v=retriveData(rs);
				list.add(v);
			}
			rs.close();
			command.close();
			return list;
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoVote(List All): "+e.getMessage());
		}
	}
	
	public boolean alreadyVoted(Vote v){
		try{
			PreparedStatement command=connection.prepareStatement("SELECT * FROM votes WHERE reportId=? AND valuerId=?");
			command.setLong(1, v.getReportId());
			command.setLong(2, v.getValuerId());
			ResultSet rs=command.executeQuery();
			boolean alreadyVoted;
			if(rs.next()){
				alreadyVoted=true;
			}else {
				alreadyVoted=false;
			}
			rs.close();
			command.close();
			return alreadyVoted;
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoVote(Already voted): "+e.getMessage());
		}
	}
	
	public boolean alreadyVoted(Report r, Valuer v){
		Vote vote=new Vote();
		vote.setReportId(r.getId());
		vote.setValuerId(v.getId());
		return alreadyVoted(vote);
	}
}