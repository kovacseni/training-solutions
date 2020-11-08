package references.parameters;

public class ReferencesMain {

    public static void main(String[] args) {

        Person jani;
        Person joska;

        Person person = new Person ("János", 23);
        jani = person;
        joska = jani;

        joska.setName("József");

        System.out.println(person.getName());
        System.out.println(jani.getName());
        System.out.println(joska.getName());

        /* Mindhárom utasítás értéke "József". */

        int a;
        int b;

        a = 24;
        b = a;
        b++;

        System.out.println(a);
        System.out.println(b);

        /* a értéke 24, b értéke 25 */

        Person person1 = new Person ("Béla", 67);
        joska = person1;

        System.out.println(person1.getName() + person1.getAge());
        System.out.println(joska.getName() + joska.getAge());

        /* Mindkettő Béla67 */
    }
}
