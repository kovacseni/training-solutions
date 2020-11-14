package controlselection.month;

public class DayInMonth {

    private int year;
    private String month;

    public int numberOfDays(int year, String month) {
        int numberOfDays;
        String monthName = month.toUpperCase();
        switch (monthName) {
            case "JANUÁR" :
            case "MÁRCIUS" :
            case "MÁJUS" :
            case "JÚLIUS" :
            case "AUGUSZTUS" :
            case "OKTÓBER" :
            case "DECEMBER" :
                numberOfDays = 31;
                break;
            case "ÁPRILIS" :
            case "JÚNIUS" :
            case "SZEPTEMBER" :
            case "NOVEMBER" :
                numberOfDays = 30;
                break;
            case "FEBRUÁR" :
                if (year % 400 == 0) {
                    numberOfDays = 29;
                } else if (year % 400 == 100 || year % 400 == 200 || year % 400 == 300) {
                    numberOfDays = 28;
                } else if (year % 4 == 0) {
                    numberOfDays = 29;
                } else {
                    numberOfDays = 28;
                }
                break;
            default :
                throw new IllegalArgumentException("Invalid month: " + month);
        }
    return numberOfDays;
    }
}


 /* if (year % 4 == 1 || year % 4 == 2 || year % 4 == 3) {
         numberOfDays = 28;
         } else if (year % 4 == 0 && year % 400 == 0) {
         numberOfDays = 29;
         } else {
         numberOfDays = 29;
         }
         break; */