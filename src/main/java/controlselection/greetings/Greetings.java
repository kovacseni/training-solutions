package controlselection.greetings;

public class Greetings {

    private int hour;
    private int minute;

    public String greet(int hour, int minute) {
        if (hour == 5 && minute == 0) {
           return "jó éjt";
        } else if (hour >= 5 && hour < 9) {
            return "jó reggelt";
        } else if (hour == 9 && minute == 0) {
            return "jó reggelt";
        } else if (hour >= 9 && hour < 18) {
            return "jó napot";
        } else if (hour == 18 && minute <= 30) {
            return "jó napot";
        } else if (hour == 18 && minute <= 59) {
            return "jó estét";
        } else if (hour == 19) {
            return "jó estét";
        } else if (hour == 20 && minute == 0) {
            return "jó estét";
        } else {
            return "jó éjt";
        }
    }

}
