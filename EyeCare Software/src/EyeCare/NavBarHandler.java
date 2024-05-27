package EyeCare;

import NavigationManager.*;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import TableConstrain.*;

class NavBarHandler {
	PrintPreview printPreview;
	ExtraFunctions exFunctions;
	JComponent component; // The component to which the shortcuts will be bound
	
	public NavBarHandler() {		
		this.printPreview = new PrintPreview();
		registerKeyEvents();
	}

    private void registerKeyEvents() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID() == KeyEvent.KEY_PRESSED) {
                    if (e.isControlDown() && !e.isShiftDown()) {
                        switch (e.getKeyCode()) {
                            case KeyEvent.VK_P:
                            	onPrintPreviewtMenuItemClick(null);
                                return true;
                            case KeyEvent.VK_I:
                                onImportMenuItemClick(null);
                                return true;
                            case KeyEvent.VK_E:
                                onExporttMenuItemClick(null);
                                return true;
                            case KeyEvent.VK_L:
                                onSleepModeMenuItemClick(null);
                                return true;
                            case KeyEvent.VK_H:
                                onDetailsMenuItemClick(null);
                                return true;
                            case KeyEvent.VK_U:
                            	onUserAccessMenuItemClick(null);
                                return true; 
                            case KeyEvent.VK_G:
                            	onGuestAccessMenuItemClick(null);
                                return true;        
                            case KeyEvent.VK_K:
                                onChangePassMenuItemClick(null);
                                return true;
                            case KeyEvent.VK_Q:
                                onClosedBtnClicked(null);
                                return true;
                            // Add more shortcuts as needed
                        }
                    } else if (e.isShiftDown() && !e.isControlDown()) {
                        switch (e.getKeyCode()) {
                        case KeyEvent.VK_U:
                        	onUtilityMenuItem(null);
                            return true;
                        case KeyEvent.VK_L:
                        	onCustomerListMenuItem(null);
                            return true;
                        case KeyEvent.VK_P:
                        	onPrescriptionListMenuItem(null);
                            return true;
                        // Add more shortcuts as needed
                        }
                    }
                }
                return false; // Let other key events be handled normally
            }
        });
    }
	
	public void onSleepModeMenuItemClick(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "On sleep mode is under process");
    }
	
    public void onPrintPreviewtMenuItemClick(ActionEvent e) {
    	PrintPreview printPreview = new PrintPreview();
    	
    	if(main.isDataSelected) {
    		GetPrescriptionData getData = new GetPrescriptionData();
    		Boolean test = getData.isPrescriptionDataMatch(main.selectedFirstValue);
    		if(test) {
    			printPreview.setPrintData(main.selectedFirstValue);
    		}else {
    			JOptionPane.showMessageDialog(null, "No invoice is found for this person");
    		}
    	}else {
    		JOptionPane.showMessageDialog(null, "Please Select Billing Details");
    	}
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
        JOptionPane.showMessageDialog(null, "Change Password is under process");
    }
    
	public void onUserAccessMenuItemClick(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "User Access is under process");
	}
	
	public void onGuestAccessMenuItemClick(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "guest Access is under process");
	}

	public void onUtilityMenuItem(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "Utility is under process");
	}
	
	public void onPrescriptionListMenuItem(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "PrescriptionList is under process");
	}
	
	public void onHelpMenuItem(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "Help is under process");
	}
	
	public void onCustomerListMenuItem(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "Customer List is under process");
	}

    public void onUtilityMenuItemClick(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Change Utility Settings is under process");
    }

    public void onDetailsMenuItemClick(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Software Details is under process");
    } 
    
    public void onClosedBtnClicked(ActionEvent e) {
        int response = JOptionPane.showConfirmDialog(
                null,
                "Are you sure you want to exit?",
                "Confirm Exit",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (response == JOptionPane.YES_OPTION) {
        	Launcher.frame.dispose();
        }
    } 
}