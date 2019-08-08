package connectJava;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.xdevapi.PreparableStatement;

public class DAO {
	
	public static void main(String[] args) {
		DAO obj_Dao = new DAO();
		obj_Dao.check_Data();
		obj_Dao.save();
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
	
public int save() {
		
		int status= 0;
		int idCountry = 0;
		String country_Name = "";
		
		DB_Connection objDb_Connection = new DB_Connection();
		Connection connection = objDb_Connection.getConnection();
		PreparedStatement ps = null;
		
		try{
			Connection con= DB_Connection.getConnection();
			
			String query = "INSERT INTO `Country`(`CountryName`) VALUES (?)";
			ps = connection.prepareStatement(query);
			ps.setString(1, country_Name);
			//System.out.println(query);
			
			// this is problem.
			int rs = ps.executeUpdate();
			con.close();
		
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}

	
public static int update(){
	
	int status=0;
	int quantity=0,issued=0;
	DB_Connection objDb_Connection = new DB_Connection();
	
	try{
		Connection con= objDb_Connection.getConnection();
		
		PreparedStatement ps=con.prepareStatement("select quantity,issued from books where callno=?");
		ps.setString(1,);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			quantity=rs.getInt("quantity");
			issued=rs.getInt("issued");
		}
		
		if(quantity>0){
		PreparedStatement ps2=con.prepareStatement("update books set quantity=?,issued=? where callno=?");
		ps2.setInt(1,quantity-1);
		ps2.setInt(2,issued+1);
		ps2.setString(3,bookcallno);
		
		status=ps2.executeUpdate();
		}
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
	
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
