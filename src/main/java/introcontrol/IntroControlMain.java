package introcontrol;

public class IntroControlMain {

    public static void main(String[] args) {

        IntroControl pelda = new IntroControl();

        System.out.println(pelda.substractTenIfGreaterThanTen(9));
        System.out.println(pelda.substractTenIfGreaterThanTen(10));
        System.out.println(pelda.substractTenIfGreaterThanTen(12));
        System.out.println(pelda.substractTenIfGreaterThanTen(23));

        System.out.println(pelda.describeNumber(-1));
        System.out.println(pelda.describeNumber(0));
        System.out.println(pelda.describeNumber(1));
        System.out.println(pelda.describeNumber(23));

        System.out.println(pelda.greetingToJoe("Joe"));
        System.out.println(pelda.greetingToJoe("Jack"));

        System.out.println(pelda.calculateBonus(23));
        System.out.println(pelda.calculateBonus(1000000));
        System.out.println(pelda.calculateBonus(1200300));

        System.out.println(pelda.calculateConsumption(3241, 7643));
        System.out.println(pelda.calculateConsumption(6789, 23));

        pelda.printNumbers(23);

        pelda.printNumbersBetween(20, 23);
        pelda.printNumbersBetween(53, 48);

        pelda.printNumbersBetweenAnyDirection(45, 52);
        pelda.printNumbersBetweenAnyDirection(63, 57);

        pelda.printOddNumbers(23);

    }
}
