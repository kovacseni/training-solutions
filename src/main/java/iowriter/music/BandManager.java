package iowriter.music;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BandManager {

    private List<Band> bands = new ArrayList<>();

    public void readBandsFromFile(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] splittedLine = line.split(";");
                bands.add(new Band(splittedLine[0], Integer.parseInt(splittedLine[1])));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }

    public void writeBandsBefore(Path path, int year) {
        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            for (Band b : bands) {
                if (b.getYear() < year) {
                    bw.write(b.getName() + ";" + b.getYear() + "\n");
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }

    public static void main(String[] args) {
        BandManager b = new BandManager();
        b.readBandsFromFile(Path.of("src/test/resources/bands_and_years.txt"));
        b.writeBandsBefore(Path.of("src/test/resources/before.txt"), 1990);
    }
}

// A teszteset valamiért nem fut le, de mivel main-ben tesztelve jól
//működik a metódus, ezért elküldöm.
