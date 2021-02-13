package week13d05;

import java.util.Optional;

public class SecondRowWriter implements RowWriter {

    @Override
    public Optional<String> getHeader() {
        return Optional.of("Megnevezés          Egységár (Ft) Darab Összeg");
    }

    @Override
    public String createLine(BillItem item) {
        return String.format("%-20s%13d %5d %6d%n", item.getName(), item.getUnitPrice(), item.getNumber(), (item.getUnitPrice() * item.getNumber()));
    }
}