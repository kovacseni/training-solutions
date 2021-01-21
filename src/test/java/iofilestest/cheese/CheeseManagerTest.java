package iofilestest.cheese;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CheeseManagerTest {

    @TempDir
    public File folder;
    private CheeseManager cheese;
    private List<Cheese> cheeseList;

    @BeforeEach
    public void setUp() {
        cheese = new CheeseManager();
        cheeseList = new ArrayList<>();
        cheeseList.add(new Cheese("Trappista", 32.0));
        cheeseList.add(new Cheese("Edami", 21.2));
        cheeseList.add(new Cheese("Pannonia", 42.7));
        cheeseList.add(new Cheese("Gouda", 72.1));
        cheeseList.add(new Cheese("Karaván", 24.5));
    }

    @Test
    public void testSaveToFile() {
        List<Cheese> testList = new ArrayList<>();
        boolean b = true;
        Path path = new File(folder, "cheese.dat").toPath();
        cheese.saveToFile(path, cheeseList);
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(Files.newInputStream(path)))) {
            while (2 > 1) {
                String temp = dis.readUTF();
                double number = dis.readDouble();
                testList.add(new Cheese(temp,number));
            }
        } catch (IOException ioe) {
            b = false;
        }

        Assertions.assertEquals(5, testList.size());

        Assertions.assertEquals("Trappista", testList.get(0).getName());
        Assertions.assertEquals(32.0, testList.get(0).getLactoseInhalt());

        Assertions.assertEquals("Edami", testList.get(1).getName());
        Assertions.assertEquals(21.2, testList.get(1).getLactoseInhalt());

        Assertions.assertEquals("Pannonia", testList.get(2).getName());
        Assertions.assertEquals(42.7, testList.get(2).getLactoseInhalt());

        Assertions.assertEquals("Gouda", testList.get(3).getName());
        Assertions.assertEquals(72.1, testList.get(3).getLactoseInhalt());

        Assertions.assertEquals("Karaván", testList.get(4).getName());
        Assertions.assertEquals(24.5, testList.get(4).getLactoseInhalt());
    }

    @Test
    public void testException() {
        Path path = new File(folder, "cheese.dat").toPath();
        cheese.saveToFile(path, cheeseList);
        Exception ex = Assertions.assertThrows(IllegalStateException.class, () -> cheese.findCheese(path, "Oázis"));

        Assertions.assertEquals("Can't find cheese.", ex.getMessage());
    }

    @Test
    public void testFindCheese() {
        Path path = new File(folder, "cheese.dat").toPath();
        cheese.saveToFile(path, cheeseList);
        Cheese foundCheese = cheese.findCheese(path, "Gouda");

        Assertions.assertEquals(72.1, foundCheese.getLactoseInhalt());
    }
}
