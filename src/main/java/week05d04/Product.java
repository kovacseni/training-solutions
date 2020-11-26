package week05d04;

import java.time.LocalDate;

public class Product {

    private String name;
    private LocalDate expiryDate;

    public Product (String name, int year, int month, int day) {
        this.name = name;
        expiryDate = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }
}
