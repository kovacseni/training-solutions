package stringtype;

public class StringTypeMain {

    public static void main(String[] args) {

        String prefix = "Hello ";
        String name = "John Doe";
        String message = prefix + name;

        System.out.println(message);

        int a = 444;
        message = message + a;
        System.out.println(message);

        boolean b = message.equals("Hello John Doe");
        System.out.println(b);

        boolean c = message.equals("Hello John Doe444");
        System.out.println(c);

        String x = "";
        String y = "";
        String z = x + y;
        System.out.println(z.length());

        String abcde = "Abcde";
        System.out.println(abcde.length());

        System.out.println(abcde.substring(0,1));
        System.out.println(abcde.substring(2,3));
        System.out.println(abcde.substring(0,3));
    }
}
