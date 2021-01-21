package ioconvert.products;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.List;

public class ProductWriter {

    public void saveProduct(OutputStream os, List<Product> products) {
        try (PrintStream ps = new PrintStream(os)) {
            for (Product p : products) {
                ps.print(p.getName());
                ps.print(";");
                ps.print(p.getPrice());
                ps.println();
            }
        }
    }
}
