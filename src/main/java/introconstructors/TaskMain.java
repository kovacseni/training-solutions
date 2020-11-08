package introconstructors;

public class TaskMain {

    public static void main(String[] args) {
        Task task = new Task("Projektmunka", "Összefoglaló nagyfeladat az eddig tanultakból");

        task.setDuration(10);

        task.start();

        System.out.println("Cím: " + task.getTitle());
        System.out.println("Leírás: " + task.getDescription());
        System.out.println("Kezdés: " + task.getStartDateTime());
        System.out.println("Időtartam: " + task.getDuration() + " nap");
    }
}
