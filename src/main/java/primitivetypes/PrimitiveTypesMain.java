package primitivetypes;

public class PrimitiveTypesMain {

    public static void main(String[] args) {
        PrimitiveTypes pt = new PrimitiveTypes();
        System.out.println(pt.toBinaryString(200));
        System.out.println(Integer.toBinaryString(200));
        System.out.println(pt.toBinaryString(200).length());
    }
}
