package stringconcat.stringconcat;

public class Name {

    private Title title;
    private String familyName;
    private String middleName;
    private String givenName;

    public boolean isEmpty(String s) {
        return s == null || s.trim().equals("");
    }

    public Name(String familyName, String middleName, String givenName, Title title) {
        if (isEmpty(familyName) || isEmpty(givenName)) {
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }
        if (isEmpty(familyName) || isEmpty(givenName)) {
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }

        this.familyName = familyName;
        this.middleName = middleName;
        this.givenName = givenName;
        this.title = title;
    }

    public Name(String familyName, String middleName, String givenName) {
        if (isEmpty(familyName) || isEmpty(givenName)) {
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }
        if (isEmpty(familyName) || isEmpty(givenName)) {
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }

        this.familyName = familyName;
        this.middleName = middleName;
        this.givenName = givenName;
    }

    public String concatNameWesternStyle() {
        if (title == null && isEmpty(middleName)) {
            return givenName + " " + familyName;
        } else if (title == null && !isEmpty(middleName)) {
            return givenName + " " + middleName + " " + familyName;
        } else if (title != null && isEmpty(middleName)) {
            return title.getTitleString() + " " + givenName + " " + familyName;
        } else {
            return title.getTitleString() + " " + givenName + " " + middleName + " " + familyName;
        }
    }

    public String concatNameHungarianStyle() {
        if (title == null && isEmpty(middleName)) {
            return familyName.concat(" ").concat(givenName);
        } else if (title == null && !isEmpty(middleName)) {
            return familyName.concat(" ").concat(middleName).concat(" ").concat(givenName);
        } else if (title != null && isEmpty(middleName)) {
            return title.getTitleString().concat(" ").concat(familyName).concat(" ").concat(givenName);
        } else {
            return title.getTitleString().concat(" ").concat(familyName).concat(" ").concat(middleName).concat(" ").concat(givenName);
        }
    }

}
