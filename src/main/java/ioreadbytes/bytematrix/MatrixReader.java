package ioreadbytes.bytematrix;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MatrixReader {

    private List<byte[]> myMatrix;

    public List<byte[]> getMyMatrix() {
        return myMatrix;
    }

    public void readBytesAndCreateMatrix(String filename) {
        Path path = Path.of(filename);
        try(InputStream is = new BufferedInputStream(Files.newInputStream(path))) {
            byte[] bytes = new byte[1000];
            int size;
            while ((size = is.read(bytes)) > 0) {
                myMatrix.add(bytes);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }

    public int numberOfColumnsWhereMoreZeros() {
        int columns = 0;
        for (int i= 0; i < 1000; i++) {
            int zero = 0;
            int one = 0;

            for (int j = 0; j < myMatrix.size(); j++) {
                if (myMatrix.get(j)[i] == 48) {
                    zero++;
                } else {
                    one++;
                }
            }
            if (zero > one) {
                columns++;
            }
        }
        return columns;
    }
}
