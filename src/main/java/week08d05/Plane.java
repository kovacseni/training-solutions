package week08d05;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Plane {

    public int getLongestOcean(Path path) {
        int max = 0;
        try (BufferedInputStream bis = new BufferedInputStream(Files.newInputStream(path))) {
            byte[] bytes = new byte[1];
            int size = 0;
            int sum0 = 0;
            while ((size = bis.read(bytes)) > 0) {
                if (bytes[0] == 48) {
                    sum0++;
                }
                if (bytes[0] == 49) {
                    if (sum0 > max) {
                        max = sum0;
                    }
                    sum0 = 0;
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
        return max;
    }

    public int getLongestEarth(Path path) {
        int max = 0;
        try (BufferedInputStream bis = new BufferedInputStream(Files.newInputStream(path))) {
            byte[] bytes = new byte[1];
            int size = 0;
            int sum1 = 0;
            while ((size = bis.read(bytes)) > 0) {
                if (bytes[0] == 49) {
                    sum1++;
                }
                if (bytes[0] == 48) {
                    if (sum1 > max) {
                        max = sum1;
                    }
                    sum1 = 0;
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
        return max;
    }
}
