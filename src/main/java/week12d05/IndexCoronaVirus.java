package week12d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class IndexCoronaVirus {

    public int findCoronaVirus(Path path){
        int sumCoronaVirus = 0;
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains("koronavírus")) {
                    sumCoronaVirus++;
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
        return sumCoronaVirus;
    }

    public static void main(String[] args) {
        Path path = Path.of("src/main/resources/index.html");
        System.out.println(new IndexCoronaVirus().findCoronaVirus(path));
    }
}
