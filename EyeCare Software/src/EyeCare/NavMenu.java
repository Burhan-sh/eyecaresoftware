package EyeCare;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class NavMenu extends JMenuBar {
	private NavBarHandler navBarHandler;
    public NavMenu() {
    	
    	 navBarHandler = new NavBarHandler();
    	 
    	/* Home Menu Start */
        JMenu homeMenu = new JMenu("Home");
        configureMenu(homeMenu, "home.png", 20, 20);   
        add(homeMenu);

        JMenuItem sleepModeMenuItem = new JMenuItem("Sleep Mode");
        homeMenu.add(createMenuItem(sleepModeMenuItem, "night-mode.png", "       Ctrl + L", navBarHandler::onSleepModeMenuItemClick));

        homeMenu.add(new JPopupMenu.Separator()); // Add horizontal line after the first menu item

        JMenuItem importMenuItem = new JMenuItem("Import");
        homeMenu.add(createMenuItem(importMenuItem, "import.png", "                Ctrl + I", navBarHandler::onImportMenuItemClick));

        JMenuItem exportMenuItem = new JMenuItem("Export");
        homeMenu.add(createMenuItem(exportMenuItem, "export.png", "                Ctrl + E", navBarHandler::onExporttMenuItemClick));

        homeMenu.add(new JPopupMenu.Separator()); // Add horizontal line after the third menu item

        JMenuItem printPreviewMenuItem = new JMenuItem("Print Invoice");
        homeMenu.add(createMenuItem(printPreviewMenuItem, "preview.png", "      Ctrl + P", navBarHandler::onPrintPreviewtMenuItemClick));

        homeMenu.add(new JPopupMenu.Separator()); // Add horizontal line after the fifth menu item

        JMenuItem closedMenuItem = new JMenuItem("Closed");
        homeMenu.add(createMenuItem(closedMenuItem, "closed.png", "               Ctrl + Q", navBarHandler::onClosedBtnClicked));
        /* Home Menu end */ 
        
    	/* Admin Menu Start */
        JMenu adminstrative = new JMenu("Adminstrative Options");
        configureMenu(adminstrative, "admin-options.png", 20, 20);
        add(adminstrative);

        JMenuItem changePassMenuItem = new JMenuItem("Change Password");
        adminstrative.add(createMenuItem(changePassMenuItem, "reset-password.png", "           Ctrl + K", navBarHandler::onChangePassMenuItemClick));

        adminstrative.add(new JPopupMenu.Separator()); // Add horizontal line after the first menu item

        JMenuItem userAccessMenuItem = new JMenuItem("User's Accessbity");
        adminstrative.add(createMenuItem(userAccessMenuItem, "user.png", "             Ctrl + U", navBarHandler::onUserAccessMenuItemClick));

        JMenuItem guestUserMenuItem = new JMenuItem("Guest User's Accessbity");
        adminstrative.add(createMenuItem(guestUserMenuItem, "guest.png", "   Ctrl + G", navBarHandler::onGuestAccessMenuItemClick));
        
        /* Admin Menu end */ 
        
    	/* Setting Menu Start */
        JMenu settings = new JMenu("Settings");
        configureMenu(settings, "setting.png", 20, 20);
        add(settings);

        JMenuItem utilityMenuItem = new JMenuItem("Change Utility Settings");
        settings.add(createMenuItem(utilityMenuItem, "utility.png", "        Shift + U", navBarHandler::onUtilityMenuItem));

        settings.add(new JPopupMenu.Separator()); // Add horizontal line after the first menu item

        JMenuItem allCustomerMenuItem = new JMenuItem("List Of All Customers");
        settings.add(createMenuItem(allCustomerMenuItem, "user-list.png", "           Shift + L", navBarHandler::onCustomerListMenuItem));

        JMenuItem prescriptionMenuItem = new JMenuItem("List Of All Prescription");
        settings.add(createMenuItem(prescriptionMenuItem, "prescription.png", "        Shift + P", navBarHandler::onPrescriptionListMenuItem));
        
        /* Setting Menu end */ 
        
    	/* Help Menu Start */
        JMenu help = new JMenu("Help");
        configureMenu(help, "help-desk.png", 20, 20);
        add(help);

        JMenuItem detailsMenuItem = new JMenuItem("Software Details");
        help.add(createMenuItem(detailsMenuItem, "details-about.png", "        Ctrl + H", navBarHandler::onHelpMenuItem));
        
        /* Help Menu end */ 
    }
    
    private JMenuItem createMenuItem(JMenuItem menuItem, String iconFileName, String shortcut, ActionListener actionListener) {
        configureMenuItem(menuItem, iconFileName, 16, 16, shortcut);
        menuItem.addActionListener(actionListener);
        return menuItem;
    }

    private void configureMenu(JMenu menu, String iconFileName, int width, int height) {
        menu.setFont(menu.getFont().deriveFont(15f));
        menu.setActionCommand(menu.getText());

        // Load and resize the icon
        ImageIcon icon = new ImageIcon(getClass().getResource("/" + iconFileName));
        Image resizedImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        menu.setIcon(new ImageIcon(resizedImage));
    }

    private void configureMenuItem(JMenuItem menuItem, String iconFileName, int width, int height, String additionalInfo) {
        menuItem.setFont(menuItem.getFont().deriveFont(13f));
        menuItem.setMargin(new Insets(10, 20, 10, 20));
        menuItem.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Load and resize the icon
        ImageIcon icon = new ImageIcon(getClass().getResource("/" + iconFileName));
        Image resizedImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        menuItem.setIcon(new ImageIcon(resizedImage));

        // Add additional information to the text
        String text = menuItem.getText() + " " + additionalInfo;
        menuItem.setText(text);
    }
}