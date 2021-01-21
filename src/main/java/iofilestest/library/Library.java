package iofilestest.library;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> registry = new ArrayList<>();

    public List<Book> getRegistry() {
        return new ArrayList<>(registry);
    }

    public void add(Book... books) {
        boolean isInTheList = false;
        for (Book b : books) {
            for (Book book : registry) {
                if (b.getAuthor().equals(book.getAuthor()) && b.getTitle().equals(book.getTitle())) {
                    isInTheList = true;
                }
            }
            if (isInTheList == false) {
                registry.add(b);
            }
        }
    }

    public void saveBooks(Path path) {
        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            for (Book b : registry) {
                bw.write(b.getAuthor());
                bw.write(": ");
                bw.write(b.getTitle());
                bw.write("\n");
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Error while saving.", ioe);
        }
    }

    public void loadBooks(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] splittedLine = line.split(": ");
                add(new Book(splittedLine[0], splittedLine[1]));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't load text.", ioe);
        }
    }
}
