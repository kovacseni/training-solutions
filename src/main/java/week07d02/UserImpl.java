package week07d02;

public class UserImpl implements User {

    private String userName;
    private String firstName;
    private String lastName;

    public UserImpl(String userName, String firstName, String lastName) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUsername() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
