package TableConstrain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import LoginManager.EncriptAbsration;

public class getUserInformation {
	Connection conn = null;
	ResultSet rs = null;
    PreparedStatement pstmt = null;
    
    public getUserInformation() {
    	String url = "jdbc:sqlite:sysconfig/EyeCare.db";
        try {
			this.conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public HashMap <String, String> getUserInfo() {
    	HashMap <String, String> userTable = new HashMap<>();
    	
        String sql = "SELECT username, password FROM userInfo WHERE is_active = 1";
        try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
		        String username = rs.getString("username");
		        String Enpassword = rs.getString("password");
		        EncriptAbsration ea = new EncriptAbsration();
		        String depassword = ea.setDecryption(Enpassword);   
		        userTable.put(username, depassword);
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
    	return userTable;
    }
    
    public String getUserId(String username) {
    	String user_id = null;
    	String sql = "SELECT user_id FROM userInfo WHERE username = \"" + username + "\";";
    	 try {
 			pstmt = conn.prepareStatement(sql);
 			rs = pstmt.executeQuery();
 			while (rs.next()) {
 		        user_id = rs.getString("user_id");
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
    	 return user_id;
    }

    public Boolean updatePassword(String userid, String password) {
    	
    	String updateSql = "UPDATE userInfo SET password = ? WHERE user_id = ?";
    	PreparedStatement updateStmt = null;
    	Boolean sucess = null;
    	try {
    	    updateStmt = conn.prepareStatement(updateSql);
    	    updateStmt.setString(1, password);
    	    updateStmt.setString(2, userid);

    	    int rowsAffected = updateStmt.executeUpdate();
    	    if (rowsAffected > 0) {
    	        sucess = true;
    	    } else {
    	        sucess = false;
    	    }
    	} catch (SQLException e) {
    	    e.printStackTrace();
    	} finally {
    	    if (updateStmt != null) {
    	        try {
    	            updateStmt.close();
    	        } catch (SQLException e) {
    	            e.printStackTrace();
    	        }
    	    }
    	}
		return sucess;
    }
}
