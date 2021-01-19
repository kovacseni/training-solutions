package ioprintwriter.salary;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SalaryWriter {

    private List<String> names;

    public SalaryWriter(List<String> names) {
        this.names = names;
    }

    public void writeNamesAndSalaries(Path path) {
       try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(path))) {
           for (String s : names) {
               pw.print(s + ": ");
               if (s.startsWith("Dr.")) {
                   pw.print(500000);
               } else if (s.startsWith("Mr.") || s.startsWith("Mrs.")) {
                   pw.print(200000);
               } else {
                   pw.print(100000);
               }
               pw.print("\n");
           }
       } catch (IOException ioe) {
           throw new IllegalStateException("Can not write file.", ioe);
       }
    }
}
