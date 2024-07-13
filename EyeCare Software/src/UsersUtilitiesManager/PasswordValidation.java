package UsersUtilitiesManager;

public class PasswordValidation {
	
	public boolean matchPassword(String currentpass , String newPass) {
		return currentpass.equals(newPass); 
	}
	
}