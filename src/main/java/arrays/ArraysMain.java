package arrays;

import java.util.Arrays;
import java.util.List;

public class ArraysMain {

    public String numberOfDaysAsString() {
        int[] numberOfDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return Arrays.toString(numberOfDays);
    }

    public List<String> daysOfWeek() {
        String[] napok = {"Hétfő", "Kedd", "Szerda", "Csütörtök", "Péntek", "Szombat", "Vasárnap"};
        return Arrays.asList(napok);
    }

    public String multiplicationTableAsString(int size){
        int[][] szorzotabla = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                szorzotabla[i][j] = (i+1) * (j+1);
            }
        }
        return Arrays.deepToString(szorzotabla);
    }

    public boolean sameTempValues(double[] day, double[] anotherDay) {
        return Arrays.equals(day, anotherDay);
    }

    public boolean sameTempValuesDaylight(double[] day, double[] anotherDay) {
        int rovidebbNap = Math.min(day.length,anotherDay.length);
        Arrays.copyOfRange(day, 0, rovidebbNap);
        Arrays.copyOfRange(anotherDay, 0, rovidebbNap);
        return Arrays.equals(Arrays.copyOfRange(day, 0, rovidebbNap),  Arrays.copyOfRange(anotherDay, 0, rovidebbNap));
    }


    private int[] megtett;
    private int[] kihuzott;
    public boolean wonLottery(int[] megtett, int[] kihuzott) {
        this.megtett = Arrays.copyOf(megtett, megtett.length);
        this.kihuzott = Arrays.copyOf(kihuzott, kihuzott.length);
        Arrays.sort(this.megtett);
        Arrays.sort(this.kihuzott);
        return Arrays.equals(this.megtett, this.kihuzott);
    }




    public static void main(String[] args) {

        ArraysMain proba = new ArraysMain();

        System.out.println(proba.numberOfDaysAsString());
        System.out.println(proba.daysOfWeek());

        System.out.println(proba.multiplicationTableAsString(8));

        double[] a = {23, 25, 27, 32};
        double[] b = {24, 26, 27, 33};
        double[] c = {22, 23, 26, 30};
        double[] d = {22, 23, 26, 30};
        System.out.println(proba.sameTempValues(a, b));
        System.out.println(proba.sameTempValues(c, d));

        double[] w = {23, 20, 19, 16};
        double[] x = {23, 20, 19};
        double[] y = {24, 22, 19};
        System.out.println(proba.sameTempValuesDaylight(w, x));
        System.out.println(proba.sameTempValuesDaylight(w, y));

        int[] megtett1 = {81, 57, 85, 59, 84};
        int[] kihuzott1 = {45, 76, 43, 86, 57};
        int[] megtett2 = {19, 29, 5, 23, 2};
        int[] kihuzott2 = {2, 29, 23, 19, 5};
        System.out.println(proba.wonLottery(megtett1, kihuzott1));
        System.out.println(proba.wonLottery(megtett2, kihuzott2));
        System.out.println(Arrays.toString(megtett1));
        System.out.println(Arrays.toString(kihuzott1));
        System.out.println(Arrays.toString(megtett2));
        System.out.println(Arrays.toString(kihuzott2));
    }

}
