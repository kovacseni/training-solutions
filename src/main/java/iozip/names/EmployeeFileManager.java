package iozip.names;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class EmployeeFileManager {

    public void saveEmployees(Path zipFilePath, List<String> names) {
        try (ZipOutputStream os = new ZipOutputStream(new BufferedOutputStream(Files.newOutputStream(zipFilePath)))) {
            os.putNextEntry(new ZipEntry("names.dat"));
            for (String s : names) {
                os.write(s.getBytes());
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file.", ioe);
        }
    }
}
