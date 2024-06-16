package LoginManager;

import java.util.HashMap;
import java.util.Map;

public class LoginAuthintication {
    private static final String DEFAULT_USERNAME = "master_admin";
    private static final String DEFAULT_PASSWORD = "super@eyecare";
    private Map<String, String> userTable = new HashMap<>();

    public LoginAuthintication(String username, String password) {
        // Add some example users to the userTable
        userTable.put("user1", "password1");
        userTable.put("user2", "password2");
   
        if(this.hasSQLInjectionRisk(username) && this.hasSQLInjectionRisk(password) ) {
        	if(this.authenticate(username,password)) {
        		System.out.println("Password Matched !!!");
        	}else {
        		System.out.println("Password Not Matched !!!");
        	}
        }else {
        	System.out.println("security vulnerability Warning!!");
        }
    }

    public boolean authenticate(String username, String password) {
        if (DEFAULT_USERNAME.equals(username) && DEFAULT_PASSWORD.equals(password)) {
            return true;
        }
        String storedPassword = userTable.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }
    
    private boolean hasSQLInjectionRisk(String input) {
        String[] sqlInjectionRiskWords = {"SELECT", "INSERT", "UPDATE", "DELETE", "DROP", "--", ";", "/*", "*/"};
        for (String riskWord : sqlInjectionRiskWords) {
            if (input.toUpperCase().contains(riskWord)) {
                return false;
            }
        }
        return true;
    }
}