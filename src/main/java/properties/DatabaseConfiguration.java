package properties;

import java.io.*;
import java.util.Properties;

public class DatabaseConfiguration {

    private static final String CHARSET = "UTF - 8";
    private Properties config;

    public DatabaseConfiguration() {
        try (InputStream is = DatabaseConfiguration.class.getResourceAsStream("/db.properties")) {
            readFromFile(is);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file from classpath", ioe);
        }
    }

    public DatabaseConfiguration(File file) {
        try (FileInputStream fis = new FileInputStream(file)) {
            readFromFile(fis);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file", ioe);
        }
    }

    private Properties readFromFile(InputStream is) throws IOException {
        config = new Properties();
        InputStreamReader isr = new InputStreamReader(is);
        config.load(isr);

        return config;
    }

    public String getHost() {
        return config.getProperty("db.host");
    }

    public int getPort() {
        return Integer.parseInt(config.getProperty("db.port"));
    }

    public String getSchema() {
        return config.getProperty("db.schema");
    }
}
