package properties;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class JavaTools {

    private static final String CHARSET = "UTF-8";
    private Properties tools;

    public JavaTools() {
        try (InputStream is = JavaTools.class.getResourceAsStream("/javatools.properties")) {
            tools = readFromFile(is);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file from classpath", ioe);
        }
    }

    public Set<String> getToolKeys() {
        Properties prop = new Properties();
        Set<String> keys = tools.stringPropertyNames();
        Set<String> result = new HashSet<>();
        for (String s : keys) {
            if (s.contains("name")) {
                result.add(s.substring(0, s.indexOf('.')));
            }
        }
        return result;
    }

    public Set<String> getTools() {
        Set<String> result = new HashSet<>();
        for (String s : getToolKeys()) {
            result.add(getName(s));
        }
        return result;
    }

    public String getName(String key) {
        return tools.getProperty(key + ".name");
    }

    public String getUrl(String key) {
        return tools.getProperty(key + ".url");
    }

    private Properties readFromFile(InputStream is) throws IOException {
        InputStreamReader isr = new InputStreamReader(is);
        Properties prop = new Properties();
        prop.load(isr);
        return prop;
    }
}
