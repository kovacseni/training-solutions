package week05d05;

public class User {

    private String firstName;
    private String lastName;
    private String email;

    public User(String firstName, String lastName, String email) {

        if (email.indexOf("@") < 0 || email.indexOf(".") < 0) {
            throw new IllegalArgumentException("Az e-mail cím nem megfelelő!");
        }
        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()) {
            throw new IllegalArgumentException("Semelyik mezőt ne hagyja üresen!");
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
