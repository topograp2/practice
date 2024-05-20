import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ManageMenu {
	String url = "jdbc:mysql://localhost:3306/teamproject";
	
	
	public boolean deletePassenger(String firstName, String lastName) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql;
		try {
			conn = DriverManager.getConnection(url, "root", "root");
			sql = "DELETE FROM Passenger WHERE firstName = ? and lastName = ? ;";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
			
			int count = pstmt.executeUpdate();
			if(count == 0) {
				System.out.println("Fail : No value");
				return false;
			}
			
			
		}catch(SQLException e) {
			System.out.println("Fail : SQL error");
			return true;
		}finally {
			try{
		  		if(conn != null && !conn.isClosed()) {
		  			conn.close();
		  		}
		  		if(pstmt != null && !pstmt.isClosed()) {
		  			pstmt.close();
		  		}
		 	}
		  	catch(SQLException e) {
		  		e.printStackTrace();
		  	}
		}
		return true;
		
	}

}
