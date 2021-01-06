package exam02;

public class ArraySelector {

    public String selectEvens(int[] intArray) {
        String result = "";
        if (intArray.length > 0) {
            result = "[";
            for (int i = 0; i < intArray.length; i += 2) {
                result += intArray[i] + ", ";
            }
            result = result.substring(0, result.length() - 2);
            result += "]";
        }
        return result;
    }
}
