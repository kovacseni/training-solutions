package array;

public class ArrayHandler {

    public boolean contains(int[] source, int itemToFind) {
        for (int i=0; i <= source.length; i++) {
            if (i == itemToFind) {
                return true;
            }
        }
    return false;
    }

    public int find(int[] source, int itemToFind) {
        for (int i=0; i < source.length; i++) {
            if (source[i] == itemToFind) {
                return i;
            }
        }
    return -1;}

    public static void main(String[] args) {

        ArrayHandler a = new ArrayHandler();

        int[] b = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(a.contains(b, 2));
        System.out.println(a.contains(b, 11));

        System.out.println(a.find(b, 2));
        System.out.println(a.find(b, 11));
    }


}
