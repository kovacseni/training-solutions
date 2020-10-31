package classstructureconstructors;

public class BookMain {

    public static void main(String[] args) {
        Book ujKonyv = new Book("Molnár Ferenc", "A Pál utcai fiúk");

        ujKonyv.register("ISBN 9789634158851");

        System.out.println("Könyv szerzője: " + ujKonyv.getAuthor());
        System.out.println("Címe: " + ujKonyv.getTitle());
        System.out.println("Regisztrációs száma: " + ujKonyv.getRegNumber());
    }
}
