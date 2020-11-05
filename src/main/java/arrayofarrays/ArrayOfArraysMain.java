package arrayofarrays;

import java.util.Arrays;

public class ArrayOfArraysMain {

    private int[][] a;

    public void printArrayOfArrays(int[][] a) {
        this.a = a;
        for (int kulsoTomb[] : a) {
            for (int belsoTombok : kulsoTomb) {
                System.out.print(belsoTombok);
            }
            System.out.println();
        }
    }

    public int[][] multiplicationTable(int size) {
       this.a = a;
       a = new int[size][size];
       for (int i = 0; i < size; i++)  {
           for (int j = 0; j < size; j++) {
               a[i][j] = (i+1) * (j+1);
           }
       }
       return a;
       }

       public int[][] triangularMatrix(int size) {
        this.a = a;
        a = new int[size][];
        for (int i = 0; i < size; i++) {
            a[i] = new int[i+1];
            for (int j = 0; j < i+1; j++) {
                a[i][j] = i;
            }
        }
        return a;
       }

    public int[][] getValues() {
        this.a = a;
        a = new int[12][];
        int[] b = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 0; i < a.length; i++) {
            a[i] = new int[b[i]];
        }
        return a;
    }

    public void printArrayOfArraysBonusz(int[][] a) {
        this.a = a;
        for (int kulsoTomb[] : a) {
            for (int belsoTombok : kulsoTomb) {
                if (belsoTombok < 10) {
                    System.out.print("  ");
                }
                if (belsoTombok >= 10 && belsoTombok < 100) {
                    System.out.print(" ");
                }
                System.out.print(belsoTombok);
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {

        ArrayOfArraysMain matrix = new ArrayOfArraysMain();

        int[][] tombokTombje = {{1, 2, 3}, {10, 20, 30}, {100, 200, 300}};

        matrix.printArrayOfArrays(tombokTombje);

        System.out.println(Arrays.deepToString(matrix.multiplicationTable(5)));
        matrix.printArrayOfArrays(matrix.multiplicationTable(6));

        System.out.println(Arrays.deepToString(matrix.triangularMatrix(5)));
        matrix.printArrayOfArrays(matrix.triangularMatrix(7));

        System.out.println(Arrays.deepToString(matrix.getValues()));
        matrix.printArrayOfArrays(matrix.getValues());

        matrix.printArrayOfArraysBonusz(tombokTombje);
    }


}
