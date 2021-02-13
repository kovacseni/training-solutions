package week13d05;

import java.util.Optional;

public class ThirdRowWriter implements RowWriter {

    @Override
    public Optional<String> getHeader() {
        return Optional.empty();
    }

    @Override
    public String createLine(BillItem item) {
        return String.format("%s %d * %d = %d%n", item.getName(), item.getNumber(), item.getUnitPrice(), (item.getNumber() * item.getUnitPrice()));
    }
}