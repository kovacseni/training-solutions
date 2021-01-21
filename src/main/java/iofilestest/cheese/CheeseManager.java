package iofilestest.cheese;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CheeseManager {

    public void saveToFile(Path path, List<Cheese> cheeseList) {
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(path)))) {
            for (Cheese c : cheeseList) {
                dos.writeUTF(c.getName());
                dos.writeDouble(c.getLactoseInhalt());
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't save data");
        }
    }

    public Cheese findCheese(Path path, String name) {
        Cheese foundCheese = null;
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(Files.newInputStream(path)))) {
            boolean b = true;
            while (b) {
            String cheeseName = dis.readUTF();
            double lactose = dis.readDouble();
                if (cheeseName.equals(name)) {
                    foundCheese = new Cheese(name, lactose);
                    b = false;
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't find cheese.", ioe);
        }
        return foundCheese;
    }
}
