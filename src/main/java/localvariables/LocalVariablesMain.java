package localvariables;

public class LocalVariablesMain {

    public static void main(String[] args) {

        boolean b = 2==1;
        System.out.println(b);

        int a = 2;
        int i = 3; int j = 4;
        int k;
        k = i;

       /* System.out.println(t); */

        String s = "Hello World";
        String t = s;
        System.out.println(s);
        System.out.println(t);

        {
          int x = 0;

            System.out.println(a);
        }
       /* System.out.println(x); */

    }
}
