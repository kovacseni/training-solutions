package typeconversion.dataloss;

public class DataLoss {

    public void dataLoss() {

        long x = 0;
        for (long i = 0; i < 3;)  {
            long y = (long)(float)x;
            if (y != x) {
                System.out.println("Eredeti szám: " + x);
                System.out.println("Konvertált: " + y);
                System.out.println("Eredeti szám bináris számrendszerbe átváltva: " + Long.toBinaryString(x));
                System.out.println("Konvertált szám bináris számrendszerbe átváltva: " + Long.toBinaryString(y));
                i++;
            }
            x++;
        }
    }

    public static void main(String[] args) {
        DataLoss dataLoss = new DataLoss();

        dataLoss.dataLoss();
    }

}
