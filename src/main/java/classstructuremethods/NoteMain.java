package classstructuremethods;

public class NoteMain {

    public static void main(String[] args) {

        Note jegyzet = new Note();

        jegyzet.setName("Sanyi");
        jegyzet.setTopic("Elegem van...");
        jegyzet.setText("Fáradt vagyok!");

        System.out.println(jegyzet.getName());
        System.out.println("(" + jegyzet.getTopic() + ")");
        System.out.println(jegyzet.getText());

        System.out.println(jegyzet.getNoteText());
    }
}
