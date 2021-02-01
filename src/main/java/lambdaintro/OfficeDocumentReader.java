package lambdaintro;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OfficeDocumentReader {

    public List<File> listOfficeDocuments(File path) {

        List<File> files = new ArrayList<>();
        List<File> files1 = Arrays.asList(path.listFiles());
        String docx = ".docx";
        String pptx = ".pptx";
        String xlsx = ".xlsx";
        for (File f : files1) {
            if (f.isFile() && (f.getName().toLowerCase().endsWith(docx) || f.getName().toLowerCase().endsWith(pptx) || f.getName().toLowerCase().endsWith(xlsx))) {
                files.add(f);
            }
        }
        files.sort(Comparator.naturalOrder());
        return files;
    }
}
