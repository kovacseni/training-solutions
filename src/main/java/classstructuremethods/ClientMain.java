package classstructuremethods;

public class ClientMain {

    public static void main(String[] args) {

        Client ugyfel = new Client();

        ugyfel.setName("Jóska Pista");
        ugyfel.setYear(1964);
        ugyfel.setAddress("Mars, Jupiter utca 8.");

        System.out.println(ugyfel.getName());
        System.out.println(ugyfel.getYear());
        System.out.println(ugyfel.getAddress());

        ugyfel.migrate("Jupiter, Fekete lyuk utca 56.");
        System.out.println("A lakcím változtatás sikeres! Az új cím: " + ugyfel.getAddress());
        
    }
}
