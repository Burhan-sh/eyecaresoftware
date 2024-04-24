package EyeCare;

import NavigationManager.*;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

class NavBarHandler {
	PrintPreview printPreview;
	ExtraFunctions exFunctions;
	
	public NavBarHandler() {
		this.printPreview = new PrintPreview();
	}
	
	public void onSleepModeMenuItemClick(ActionEvent e) {
  
    }
	
    public void onPrintPreviewtMenuItemClick(ActionEvent e) {
//    	PrintPreview printPreview = new PrintPreview();
    	
    	if(main.isDataSelected) {
//    	    Object firstValue = this.exFunctions.getCustomerJTable();
    	    System.out.println(main.selectedFirstValue);
//    	    printPreview.setPrintData(firstValue);
    	    JOptionPane.showMessageDialog(null, "yes");
    	}else {
    		JOptionPane.showMessageDialog(null, "Please Select Billing Details");
    	}
    }
    
    public void onPrintMenuItemClick(ActionEvent e) {
//    	Object firstValue = main.selectedFirstValue;
//    	new Printing(firstValue);
    }
    
	public void onImportMenuItemClick(ActionEvent e) {
		ImportProcess importProcess = new ImportProcess();
		importProcess.importBackup();
	}
	
    
    public void onExporttMenuItemClick(ActionEvent e) {
    	ExportProcess exportProcess = new ExportProcess();
    	exportProcess.exportBackup();
    }
    

    public void onChangePassMenuItemClick(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Change Password Clicked");
    }

    public void onUtilityMenuItemClick(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Change Utility Settings Clicked");
    }

    public void onDetailsMenuItemClick(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Software Details Clicked");
    }    


}