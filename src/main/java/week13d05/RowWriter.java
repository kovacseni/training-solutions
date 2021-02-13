package week13d05;

import java.util.Optional;

public interface RowWriter {

    Optional<String> getHeader();

    String createLine(BillItem item);
}
