package introexception.patient;

public class Patient {

    private String name;
    private String socialSecurityNumber;
    private int yearOfBirth;

    public Patient(String name, String socialSecurityNumber, int yearOfBirth) {

        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("A név kötelezően megadandó!");
        }
        if (yearOfBirth < 1900) {
            throw new IllegalArgumentException("A születési évnek 1900 utáninak kell lennie!");
        }
        if (!new SsnValidator().isValidSsn(socialSecurityNumber)) {
            throw new IllegalArgumentException("Ez nem egy valódi TAJ-szám!");
        }

        this.name = name;
        this.socialSecurityNumber = socialSecurityNumber;
        this.yearOfBirth = yearOfBirth;

    }

    public String getName() {
        return name;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
}
