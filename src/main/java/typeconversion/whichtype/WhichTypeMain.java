package typeconversion.whichtype;

public class WhichTypeMain {

    public static void main(String[] args) {
        WhichType w = new WhichType();
        String a = Long.toString(Long.MAX_VALUE, 40000);
        String b = Long.toString((long)Byte.MAX_VALUE, 40000);
        String c = Long.toString((long)Short.MAX_VALUE, 40000);
        String d = Long.toString((long)Integer.MAX_VALUE, 40000);
        System.out.println(w.whichType(a));
        System.out.println(w.whichType(b));
        System.out.println(w.whichType(c));
        System.out.println(w.whichType(d));
    }

}
