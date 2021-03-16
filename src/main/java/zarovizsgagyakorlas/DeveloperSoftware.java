package zarovizsgagyakorlas;

public class DeveloperSoftware extends Software {

    public DeveloperSoftware(String name, int price) {
        super(name, price);
    }

    @Override
    public void increasePrice() {
        super.price = (int)(super.price * 1.1);
    }
}
