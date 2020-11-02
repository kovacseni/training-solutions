package introdate;

public class EmployeeTest {

    public static void main(String[] args) {

        Employee dolgozo = new Employee(1983, 11, 9, "Kiss Gizella");

        System.out.println(dolgozo.getName());
        System.out.println(dolgozo.getDateOfBirth());
        System.out.println(dolgozo.getBeginEmployment());

        dolgozo.setName("Nagyné Kiss Gizella");
        System.out.println(dolgozo.getName());

        System.out.println("");
        System.out.println("A dolgozó adatai:");
        System.out.println(dolgozo.dolgozoOsszesAdata());

    }
}
