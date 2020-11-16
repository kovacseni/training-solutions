package week04;

public class NameChanger {

    private String fullName;

    public NameChanger(String fullName) {

        if (fullName == null || fullName.equals("") || fullName.isBlank()) {
            throw new IllegalArgumentException("Invalid Name:<" + fullName + ">");
        }

        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public String changeFirstName (String firstName) {

        int szokoz = fullName.indexOf(" ");
        String vezeteknev = fullName.substring(0, szokoz + 1);
        return vezeteknev + firstName;
    }
}
