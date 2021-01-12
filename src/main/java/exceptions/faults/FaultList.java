package exceptions.faults;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class FaultList {

    public List<String> processLines(List<String> lines) {
        if (lines == null) {
            throw new IllegalArgumentException("Empty list!");
        }

        List<String> faults = new ArrayList<>();
        for (String s : lines) {
            String[] words = s.split(",");
            int lineNumber = 0;
            try{
                lineNumber = Integer.parseInt(words[0]);
            } catch (NumberFormatException nfe) {
                lineNumber = -1;
            }
            if (lineNumber > -1) {
                ProcessingResult result = processLine(words);
                if (result != ProcessingResult.NO_ERROR) {
                    faults.add(lineNumber + "," + result.getCode());
                }
            }
        }
        return faults;
    }

    private ProcessingResult processLine(String[] words) {
        ProcessingResult result = ProcessingResult.NO_ERROR;
        if (words.length != 3) {
            result = ProcessingResult.WORD_COUNT_ERROR;
        }
        if (!isValueValid(words[1]) && !isDateValid(words[2])) {
            result = ProcessingResult.VALUE_AND_DATE_ERROR;
        } else if (!isDateValid(words[2])) {
            result = ProcessingResult.DATE_ERROR;
        } else if (!isValueValid(words[1])) {
            result = ProcessingResult.VALUE_ERROR;
        }
        return result;
    }

    private boolean isValueValid(String word) {
        try {
            Double.parseDouble(word);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    private boolean isDateValid(String word) {
        try {
            DateFormat df = new SimpleDateFormat("yyyy.MM.dd.");
            df.parse(word);
            return true;
        } catch (ParseException pe) {
            return false;
        }
    }
}
