package week08d04;

public class Trainer {

    private CanMark canMark;

    public Trainer(CanMark canMark) {
        this.canMark = canMark;
    }

    public int giveMark() {
        return canMark.giveMark();
    }

    public static void main(String[] args) {
        Trainer trainer1 = new Trainer(new GoodMood());
        Trainer trainer2 = new Trainer(new BadMood());

        System.out.println(trainer1.giveMark());
        System.out.println(trainer2.giveMark());
    }
}
