package week02;

import java.util.Scanner;

public class PhoneBonus{

    private String type;
    private int mem;

    public PhoneBonus(String type, int mem) {
        this.type = type;
        this.mem = mem;
    }

    public String getType() {
        return type;
    }

    public int getMem() {
        return mem;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMem(int mem) {
        this.mem = mem;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Type1: ");
        String type1 = scanner.nextLine();

        System.out.println("Mem1: ");
        int mem1 = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Type2: ");
        String type2 = scanner.nextLine();

        System.out.println("Mem2: ");
        int mem2 = scanner.nextInt();
        scanner.nextLine();

        PhoneBonus phone1 = new PhoneBonus(type1, mem1);
        PhoneBonus phone2 = new PhoneBonus(type2, mem2);

        System.out.println(phone1.getType());
        System.out.println(phone1.getMem());
        System.out.println(phone2.getType());
        System.out.println(phone2.getMem());
        System.out.println("Type1: " + phone1.getType() + ", Mem1: " + phone1.getMem());
        System.out.println("Type2: " + phone2.getType() + ", Mem2: " + phone2.getMem());
    }
}