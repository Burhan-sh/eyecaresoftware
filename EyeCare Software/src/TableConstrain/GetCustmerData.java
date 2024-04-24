package TableConstrain;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class GetCustmerData{

	Connection conn = null;
    PreparedStatement pstmt = null;
    
    @SuppressWarnings("serial")
	public DefaultTableModel getModelData() {
    	
    	DefaultTableModel model = new DefaultTableModel() {
    	    @Override
    	    public boolean isCellEditable(int row, int column) {
    	       return false;
    	    }
    	};
    	
    	model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Address");
        model.addColumn("ContectNo");
        model.addColumn("ExaminedBy");
        model.addColumn("BirthDate");
        model.addColumn("Gender");
        model.addColumn("Age");
    	
        try {
            String url = "jdbc:sqlite:EyeCare.db";
            conn = DriverManager.getConnection(url);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM CustomerInfo");
            
            while (rs.next()) {
            	model.addRow(new Object[]{rs.getString("id") , rs.getString("Name"), rs.getString("Address"), rs.getString("ContectNo"), rs.getString("ExaminedBy"), rs.getString("BirthDate"), rs.getString("Gender"), rs.getInt("Age")});
            }
         
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    	return model;
    }

}
