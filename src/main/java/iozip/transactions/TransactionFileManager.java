package iozip.transactions;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class TransactionFileManager {

    public void saveTransactions(Path zipFilePath, List<Transaction> transactions) {
        try (ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(Files.newOutputStream(zipFilePath)))) {
            for (Transaction t : transactions) {
                String fileName = Long.toString(t.getId());
                zos.putNextEntry(new ZipEntry(fileName));
                zos.write(t.getTime().toString().getBytes());
                zos.write("\n".getBytes());
                zos.write(t.getAccount().getBytes());
                zos.write("\n".getBytes());
                zos.write(Double.toString(t.getAmount()).getBytes());
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file.", ioe);
        }
    }
}
