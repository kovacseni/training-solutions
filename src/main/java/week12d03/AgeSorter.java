package week12d03;

public class AgeSorter {

    public int[] sortAges(int[] ages) {
        int[] result = new int[ages.length];
        for (int i = ages.length - 1; i >= 0; i--) {
            int max = findMax(ages);
            int maxIndex = findMaxIndex(ages, max);
            result[i] = max;
            ages[maxIndex] = 0;
        }
        return result;
    }

    private int findMax(int[] ages) {
        int max = ages[0];
        for (int i : ages) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    private int findMaxIndex(int[] ages, int max) {
        int maxIndex = 0;
        for (int i = 0; i < ages.length; i++) {
            if (ages[i] == max) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
