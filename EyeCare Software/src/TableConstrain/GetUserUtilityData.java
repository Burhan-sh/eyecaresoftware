package TableConstrain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import UsersUtilitiesManager.ContainerObject;

public class GetUserUtilityData {
	Connection conn = null;
	ResultSet rs = null;
    PreparedStatement pstmt = null;
    
	public GetUserUtilityData() {
    	String url = "jdbc:sqlite:EyeCare.db";
        try {
			this.conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<ContainerObject> getUserData() {
		ResultSet rs = null;
		List<ContainerObject> objList = new ArrayList<>();
		
        String sql = "SELECT user_id, username, password FROM userInfo WHERE is_active = 1";
        
        try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String user_id = rs.getString("user_id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				ContainerObject obj = new ContainerObject(user_id, username, password);
				objList.add(obj);
			}
        } catch (SQLException e) {
			e.printStackTrace();
		} finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
		return objList;
	}
}
