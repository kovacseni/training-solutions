package iofiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Installer {

    public void install(String installFolder) {
        Path sourcePath = Path.of("/install/");
        Path targetPath = Path.of(installFolder);

        if (!Files.exists(targetPath) || !Files.isDirectory((targetPath))) {
            throw new IllegalArgumentException("The given directory doesn't exist");
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/install/install.txt")))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.endsWith("/")) {
                    Files.createDirectories(targetPath.resolve(line));
                } else {
                    Files.copy(this.getClass().getResourceAsStream(sourcePath + line), targetPath.resolve(line), StandardCopyOption.REPLACE_EXISTING);
                }
            }
        } catch (IOException ioe) {
                throw new IllegalStateException("Can not read file.", ioe);
        }
    }
}

//Nem fut a teszt, mert valamiért az else-ágba belép, de az ott lévő utasítást nem tudja végrehajtani,
//és NullPointerException-t dob. Nem jöttem rá, hogy mi a hiba, a leírtaknak melyik része null.
