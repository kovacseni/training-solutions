package week13d05;

import java.util.Optional;

public class FirstRowWriter implements RowWriter {

    @Override
    public Optional<String> getHeader() {
        return Optional.empty();
    }

    @Override
    public String createLine(BillItem item) {
        return String.format("%d %s, darabja %d Ft%n", item.getNumber(), item.getName(), item.getUnitPrice());
    }
}