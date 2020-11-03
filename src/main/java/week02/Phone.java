package week02;

public class Phone {

    private String type;
    private int mem;

    public Phone(String type, int mem) {
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

        Phone phone1 = new Phone("xy", 2);
        Phone phone2 = new Phone("ab", 3);

        System.out.println(phone1.getType());
        System.out.println(phone1.getMem());
        System.out.println(phone2.getType());
        System.out.println(phone2.getMem());
    }
}
