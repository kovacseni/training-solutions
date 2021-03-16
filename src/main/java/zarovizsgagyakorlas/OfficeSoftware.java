package zarovizsgagyakorlas;

public class OfficeSoftware extends Software {

    public OfficeSoftware(String name, int price) {
        super(name, price);
    }

    @Override
    public void increasePrice() {
        super.price = (int)(super.price * 1.05);
    }
}
