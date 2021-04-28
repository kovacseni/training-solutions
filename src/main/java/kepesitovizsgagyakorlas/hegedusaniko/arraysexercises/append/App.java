package kepesitovizsgagyakorlas.hegedusaniko.arraysexercises.append;

public class App {

    public int[] append(int[] a1, int[] a2) {
        int[] result = new int[a1.length + a2.length];
        for (int i = 0; i < a1.length; i++) {
            result[i] = a1[i];
        }

        for (int i = 0; i < a2.length; i++) {
            result[i + a1.length] = a2[i];
        }
        return result;
    }
}
