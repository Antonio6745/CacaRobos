package br.sp.cacarobos.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import br.sp.cacarobos.model.Report;
import br.sp.cacarobos.model.SocialNetworkType;
import br.sp.cacarobos.model.Status;
import br.sp.cacarobos.model.User;
import br.sp.cacarobos.model.Valuer;
import br.sp.cacarobos.util.CodeGenerator;

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
			PreparedStatement command=connection.prepareStatement("INSERT INTO report (status, description, userId, trackingCode, socialNetworkType, link, dateReport) VALUES (?,?,?,?,?,?,?)");
			command.setString(1, Status.PROCESSING.getStatus());
			command.setString(2, t.getDescription());
			command.setLong(3, t.getUser().getId());
			String codeGenerated=new CodeGenerator().generateCode();
			while(trackingCodeAlreadyExists(codeGenerated)){
				codeGenerated=new CodeGenerator().generateCode();
			}
			command.setString(4, codeGenerated);
			command.setString(5, t.getNetworkType());
			command.setString(6, t.getLink());
			command.setDate(7, Date.valueOf(LocalDate.now()));
			command.execute();
			command.close();
		}catch(SQLException e){
			new RuntimeException("Error in DaoReport(Create): "+e.getMessage());
		}
	}

	private boolean trackingCodeAlreadyExists(String trackingCode){
		try{
			PreparedStatement command=connection.prepareStatement("SELECT * FROM report WHERE trackingCode=?");
			command.setString(1, trackingCode);
			ResultSet rs=command.executeQuery();
			boolean alreadyExists;
			if(rs.next()){
				alreadyExists=true;
			}else{
				alreadyExists=false;
			}
			rs.close();
			command.close();
			return alreadyExists;
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoReport(Tracking code already exists): "+e.getMessage());
		}
	}
	
	public boolean reportAlreadyExists(String link){
		try{
			PreparedStatement command=connection.prepareStatement("SELECT * FROM report WHERE link=?");
			command.setString(1, link);
			ResultSet rs=command.executeQuery();
			boolean reportAlreadyExists;
			if(rs.next()){
				reportAlreadyExists=true;
			}else{
				reportAlreadyExists=false;
			}
			rs.close();
			command.close();
			return reportAlreadyExists;
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoReport(Report already exists): "+e.getMessage());
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
				r=retriveData(rs);
			}
			rs.close();
			command.close();
			return r;
		}catch(SQLException e){
			new RuntimeException("Error in DaoReport(Read): "+e.getMessage());
		}
		return null;
	}

	private Valuer retriveValuer(Long t){
		try{
			PreparedStatement command=connection.prepareStatement("SELECT * FROM valuer WHERE id=?");
			command.setLong(1, t);
			ResultSet rs=command.executeQuery();
			Valuer v=null;
			if(rs.next()){
				v=new Valuer();
				v.setId(t);
				v.setName(rs.getString("name"));
				v.setCpf(rs.getString("cpf"));
				v.setActiveAccount(rs.getBoolean("activeAccount"));
				v.setProfilePicture(rs.getBytes("profilePicture"));
			}
			rs.close();
			command.close();
			return v;
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoReport(Retrive valuer): "+e.getMessage());
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
			throw new RuntimeException("Error in DaoReport(Retrive User): "+e.getMessage());
		}
	}
	
	@Override
	public void update(Report t) {
		try {
			PreparedStatement command=connection.prepareStatement("UPDATE report SET description=?, socialNetworkType=?, link=? WHERE id=?");
			command.setString(1, t.getDescription());
			command.setString(2, t.getNetworkType());
			command.setString(3, t.getLink());
			command.setLong(4, t.getId());
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
	
	public void activeReport(Long t, boolean answer){
		try{
			PreparedStatement command=connection.prepareStatement(
					answer==true?"UPDATE report SET activeReport=1 WHERE id=?":"UPDATE report SET activeReport=0 WHERE id=?");
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
			PreparedStatement command=connection.prepareStatement("UPDATE report SET isARobotVotes=?, isNotARobotVotes=? WHERE id=?");
			System.out.println(r);
			if(itIsARobot){
				r.getVoteCounting().addIsARobotVote();
			}else {
				r.getVoteCounting().addIsNotARobotVote();
			}
			System.out.println(r);
			command.setInt(1, r.getVoteCounting().getIsARobot());
			command.setInt(2, r.getVoteCounting().getIsNotARobot());
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
					r.setStatus(status.status);
					break;
				}
			}
			String socialNetwork=rs.getString("socialNetworkType");
			for(SocialNetworkType networkType: SocialNetworkType.values()){
				if(networkType.socialNetworkType.equals(socialNetwork)){
					r.setNetworkType(socialNetwork);
					break;
				}
			}
			r.setUser(retriveUser(rs.getLong("userId")));
			r.setValuer(retriveValuer(rs.getLong("valuerId")));
			r.setDateReport(LocalDate.parse(rs.getDate("dateReport").toString()));
			r.setActiveReport(rs.getBoolean("activeReport"));
			r.getVoteCounting().setIsARobot(rs.getInt("isARobotVotes"));
			r.getVoteCounting().setIsNotARobot(rs.getInt("isNotARobotVotes"));
			r.setLink(rs.getString("link"));
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
	
	public List<Report> listAllReportsByUserId(Long l, boolean activeReports){
		List<Report> list=new ArrayList<Report>();
		try {
			PreparedStatement command=connection.prepareStatement(
					activeReports==true?"SELECT * FROM report WHERE userId=? AND activeReport=1":"SELECT * FROM report WHERE userId=? AND activeReport=0");
			command.setLong(1, l);
			ResultSet rs=command.executeQuery();
			while(rs.next()){
				Report r=retriveData(rs);
				list.add(r);
			}
			rs.close();
			command.close();
			return list;
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoReport(List all reports by user id): "+e.getMessage());
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
	
	public List<Report> listBySocialNetwork(String socialNetwork){
		List<Report> list=new ArrayList<>();
		try{
			PreparedStatement command=connection.prepareStatement("SELECT * FROM report WHERE socialNetworkType=?");
			command.setString(1, socialNetwork);
			ResultSet rs=command.executeQuery();
			while(rs.next()){
				Report r=retriveData(rs);
				list.add(r);
			}
			rs.close();
			command.close();
			return list;
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoReport(List by social network): "+e.getMessage());
		}
	}
	
	public Report readByTrackingCode(String trackingCode){
		try{
			PreparedStatement command=connection.prepareStatement("SELECT * FROM report WHERE trackingCode=?");
			command.setString(1, trackingCode);
			ResultSet rs=command.executeQuery();
			Report r=null;
			if(rs.next()){
				r=retriveData(rs);
			}
			rs.close();
			command.close();
			return r;
		}catch(SQLException e){
			throw new RuntimeException("Error in DaoReport(Read by tracking code): "+e.getMessage());
		}
	}
}
