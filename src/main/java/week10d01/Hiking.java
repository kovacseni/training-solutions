package week10d01;

import java.util.ArrayList;
import java.util.List;

public class Hiking {

    public double getPlusElevation(List<GPSCoordinates> listOfGPSCoordinates) {
       List<Double> listOfElevation = listOfElevation(listOfGPSCoordinates);
       double sumPlusElevation = 0;
       for (int i = 0; i < listOfElevation.size() - 1; i++) {
           if (listOfElevation.get(i + 1) > listOfElevation.get(i)) {
               sumPlusElevation += (listOfElevation.get(i + 1) - listOfElevation.get(i));
           }
       }
       return sumPlusElevation;
    }

    private List<Double> listOfElevation(List<GPSCoordinates> listOfGPSCoordinates) {
        List<Double> listOfElevations = new ArrayList<>();
        for (GPSCoordinates g : listOfGPSCoordinates) {
            listOfElevations.add(g.getElevation());
        }
        return listOfElevations;
    }
}
