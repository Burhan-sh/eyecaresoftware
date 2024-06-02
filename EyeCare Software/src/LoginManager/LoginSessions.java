package LoginManager;

public class LoginSessions {
	
    private static String userId;

    public static String getUserId() {
        return userId;
    }

    public static void setUserId(String userId) {
    	LoginSessions.userId = userId;
    }
    
}
