package connectJava;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.xdevapi.PreparableStatement;

public class DAO {
	
	public static void main(String[] args) {
		DAO obj_Dao = new DAO();
		obj_Dao.check_Data();
		obj_Dao.update();
	}
	
	public void check_Data() {
		
		DB_Connection objDb_Connection = new DB_Connection();
		Connection connection = objDb_Connection.getConnection();
		PreparedStatement ps = null;
		
		try {
			
			String query = "SELECT * from `Country`";
			 ps = connection.prepareStatement(query);
			 
			 ResultSet rs = ps.executeQuery();
			 
			 while (rs.next()) {
				System.out.println("Country : " + rs.getString("CountryName"));
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
public int update() {
		
		int status=0;
		int idCountry =0;
		String country_Name = "";
		
		try{
			Connection con= DB_Connection.getConnection();
			
			//PreparedStatement ps = con.prepareStatement("select CountryName from Country");
			PreparedStatement ps = con.prepareStatement("select * from Country");
			 
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				idCountry=rs.getInt("id");
				country_Name = rs.getString("countryName");
			}
			
			if( idCountry > 0){
			PreparedStatement ps2 = con.prepareStatement("update country set CountryName = ?");
			ps2.setString(1, country_Name);
			
			status = ps2.executeUpdate();
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}

	
//	public int update() {
//		
//		int status=0;
//		int idCountry = 0;
//		String countryName = "";
//		
//		try{
//			Connection con= DB_Connection.getConnection();
//			
//			//PreparedStatement ps = con.prepareStatement("select CountryName from Country");
//			PreparedStatement ps = con.prepareStatement("select CountryName from Country");
//			 
//			ResultSet rs = ps.executeQuery();
//			
//			if(rs.next()){
//				idCountry=rs.getInt("id");
//				countryName = rs.getString("countryName");
//			}
//			
//			if( idCountry > 0){
//			PreparedStatement ps2 = con.prepareStatement("update CountryName, CountryName = ?");
//			ps2.setString(1, countryName);
//			
//			status = ps2.executeUpdate();
//			}
//			con.close();
//		}catch(Exception e){System.out.println(e);}
//		
//		return status;
//	}
	
//	public static int save(String bookcallno,int studentid,String studentname,String studentcontact){
//		int status=0;
//		try{
//			Connection con=DB_Connection.getConnection();
//			
//			status= update(bookcallno);//updating quantity and issue
//			
//			if(status>0){
//			PreparedStatement ps=con.prepareStatement("insert into issuebooks(bookcallno,studentid,studentname,studentcontact) values(?,?,?,?)");
//			ps.setString(1,bookcallno);
//			ps.setInt(2,studentid);
//			ps.setString(3,studentname);
//			ps.setString(4,studentcontact);
//			status=ps.executeUpdate();
//			}
//			
//			con.close();
//			
//		}catch(Exception e){System.out.println(e);}
//		return status;
//	}
//	public static int Delete(String bookcallno,int studentid){
//		int status=0;
//		try{
//			Connection con= DB_Connection.getConnection();
//			
//			status= updatebook(bookcallno);//updating quantity and issue
//			
//			if(status>0){
//			PreparedStatement ps=con.prepareStatement("delete from issuebooks where bookcallno=? and studentid=?");
//			ps.setString(1,bookcallno);
//			ps.setInt(2,studentid);
//			status=ps.executeUpdate();
//			}
//			
//			con.close();
//		}catch(Exception e){System.out.println(e);}
//		return status;
//	}
}
