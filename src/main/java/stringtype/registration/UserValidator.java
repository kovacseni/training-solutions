package stringtype.registration;

public class UserValidator {

    public boolean isValidUsername(String username) {
        if (username.equals("")){
            return false;
        } else {
            return true;
        }
    }

    public boolean isValidPassword(String password1, String password2) {
        return password1.length() >= 8 && password1.equals(password2);
    }

    public boolean isValidEmail(String email) {
        int kukac = email.indexOf("@");
        int pont = email.indexOf(".");
        int hossz = email.length();

        return kukac > 0 && pont > (kukac + 1) && pont < (hossz - 1);
    }

}
