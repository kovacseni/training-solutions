package localvariables;

public class DistanceMain {

    public static void main(String[] args) {

        Distance tavolsag = new Distance(356.70,true);
        System.out.println(tavolsag.getDistanceInKm() + ": " + tavolsag.isExact() + ", tehát pontos.");

        int szam = (int) tavolsag.getDistanceInKm();
        System.out.println(szam);
    }
}
