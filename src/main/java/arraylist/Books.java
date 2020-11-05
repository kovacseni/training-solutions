package arraylist;

import java.util.ArrayList;
import java.util.List;

public class Books{

    private List<String> books = new ArrayList<>();

    public void addTitle(String  title) {
        books.add(title);
    }
     public List<String> getTitles() {
        return books;
     }

    public static void main(String[] args) {

        Books konyvLista = new Books();

        konyvLista.addTitle("Egri csillagok");
        konyvLista.addTitle("A Pál utcai fiúk");
        konyvLista.addTitle("Tüskevár");
        konyvLista.addTitle("Kincskereső kisködmön");

        System.out.println(konyvLista.getTitles());
    }

}