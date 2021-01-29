package week12d02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Utca {

    private List<Telek> sites = new ArrayList<>();

    public List<Telek> getSites() {
        return new ArrayList<>(sites);
    }

    public void readSitesFromFile(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] splittedLine = line.split(" ");
                sites.add(new Telek(Integer.parseInt(splittedLine[0]), Integer.parseInt(splittedLine[1]), splittedLine[2]));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }

    public List<Telek> sortList() {
        List<Telek> sorted = new ArrayList<>(sites);
        Collections.sort(sorted, new Comparator<Telek>() {
            @Override
            public int compare(Telek t1, Telek t2) {
                return t1.compareTo(t2);
            }
        });
        return sorted;
    }

    public int houseNumber() {
        int lastHouse = sites.get(sites.size() - 1).getOddEven();
        int count = 0;
        if (lastHouse == 1) {
            count = -1;
        }
        for (Telek t : sites) {
            if (t.getOddEven() == lastHouse) {
                count += 2;
            }
        }
        return count;
    }

    public void writeStreetOdd(Path path) {
        List<Telek> streetOdd = streetOddList();
        int count = 1;
        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            for (Telek t : streetOdd) {
                String fence = "";
                for (int i = 1; i <= t.getLength(); i++) {
                    fence += t.getFence();
                }
                bw.write("(" + count + ")" + fence + "\n");
                count += 2;
                fence = "";
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file.", ioe);
        }
    }

    private List<Telek> streetOddList() {
        List<Telek> streetOdd = new ArrayList<>();
        for (Telek t : sites) {
            if (t.getOddEven() == 1) {
                streetOdd.add(t);
            }
        }
        return streetOdd;
    }
 }
