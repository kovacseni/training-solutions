package week09d03;

import java.util.Random;

public class Person {

    private String name;
    private int age;
    private Present present;

    public Person(String name, int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Az életkor nem lehet negatív szám!");
        }
        this.name = name;
        this.age = age;
        this.present = setPresent();
    }

    public Present setPresent() {
        Random random = new Random(1);
        int indexOfPresent = 0;
        if (this.age <= 14) {
            indexOfPresent = random.nextInt(4);
        } else if (this.age > 14) {
            indexOfPresent = random.nextInt(3) + 1;
        }

        Present presentOfThisPerson = Present.values()[indexOfPresent];
        return presentOfThisPerson;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Present getPresent() {
        return present;
    }
}
