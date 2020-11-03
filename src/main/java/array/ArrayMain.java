package array;

public class ArrayMain {

    public static void main(String[] args) {

        String[] hetNapjai = {"hétfő", "kedd", "szerda", "csütörtök", "péntek", "szombat", "vasárnap"};
        System.out.println(hetNapjai[1]);
        System.out.println(hetNapjai.length);

        int[] ketto = new int[5];
        ketto[0] = 1;
        for (int i = 1; i < ketto.length; i++) {
            ketto[i] = ketto[i-1] * 2;
        }
        for (int i = 0; i < ketto.length; i++) {
            System.out.println(ketto[i]);
        }

        boolean[] b = {false, true, false, true, false, true};
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }



    }
}


