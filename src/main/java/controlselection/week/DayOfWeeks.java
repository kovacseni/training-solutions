package controlselection.week;

public class DayOfWeeks {

    public String whichDay(String day) {
        String returnText;
        String name = day.toLowerCase();

        switch(name) {
            case "hétfő" :
                returnText = "hét eleje";
                break;
            case "kedd" :
            case "szerda" :
            case "csütörtök" :
                returnText = "hét közepe";
                break;
            case "péntek" :
                returnText = "majdnem hétvége";
                break;
            case "szombat" :
            case "vasárnap" :
                returnText = "hét vége";
                break;
            default :
                throw new IllegalArgumentException("Invalid day: " + day);
        }
        return returnText;
    }

}
