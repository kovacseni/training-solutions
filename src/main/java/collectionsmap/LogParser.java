package collectionsmap;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class LogParser {

    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final int IP = 0;
    public static final int DATE = 1;
    public static final int LOGIN = 2;
    public static final int FIELDS = 3;
    public static final String SEPARATOR = ":";

    public Map<String, List<Entry>> parseLog(String log) {
        Map<String, List<Entry>> elements = new HashMap<>();
        try (Scanner scanner = new Scanner(log)){
            while (scanner.hasNext()) {
                String line = scanner.next();
                String[] temp = line.split(SEPARATOR);
                if (temp.length != FIELDS) {
                    throw new IllegalArgumentException("Incorrect log: incorrect number of fields");
                }
                LocalDate entryDate;
                try {
                    entryDate = LocalDate.parse(temp[DATE], DATE_FORMAT);
                } catch (DateTimeParseException dfe) {
                    throw new IllegalArgumentException("Incorrect log: incorrect date", dfe);
                }
                if (!elements.containsKey(temp[IP])) {
                    elements.put(temp[IP], new ArrayList<>());
                }
                elements.get(temp[IP]).add(new Entry(temp[IP], temp[LOGIN], entryDate));
            }
        }
        return elements;
    }
}
