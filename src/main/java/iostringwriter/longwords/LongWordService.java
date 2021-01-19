package iostringwriter.longwords;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

public class LongWordService {

    public void wordLength(Writer writer, List<String> longWords) {
        PrintWriter pw = new PrintWriter(writer);
        for (String s : longWords) {
            pw.print(s + ":" + s.length() + "\n");
        }
    }

    public String writeWithStringWriter(List<String> longWords) {
        try (StringWriter sw = new StringWriter()) {
            wordLength(sw, longWords);
            return sw.toString();
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write.", ioe);
        }
    }
}
