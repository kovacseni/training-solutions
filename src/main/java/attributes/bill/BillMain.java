package attributes.bill;

public class BillMain {

    public static void main(String[] args) {

    Bill bill = new Bill();

    Item item = new Item("Kenyér", 2, 300);
    bill.addItem(item);

    item = new Item("Tej", 3, 250);
    bill.addItem(item);

    item = new Item("Vaj", 1, 330);
    bill.addItem(item);

    item = new Item("Felvágott", 2, 370);
    bill.addItem(item);

    item = new Item("Sajt", 3, 440);
    bill.addItem(item);

        System.out.println(bill.getItems());
        System.out.println(bill.calculateTotalPrice());


    }

}
