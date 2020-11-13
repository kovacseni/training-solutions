package week03;

public class PhoneParser {

    public Phone parsePhone(String s) {
        String prefix = s.substring(0, 2);
        String number = s.substring(2);
        Phone phone = new Phone(prefix, number);
        return phone;
    }

    public static void main(String[] args) {
        PhoneParser parser = new PhoneParser();
        Phone phone = parser.parsePhone("301234567");
        System.out.println(phone.getPrefix());
        System.out.println(phone.getNumber());
        System.out.println(phone.toString());
    }
}
