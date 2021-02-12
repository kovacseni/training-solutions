package week15d04;

public enum ConsonantVowelEtcEnum {

    CONSONANT(0), VOWEL(0), ETC(0);

    private int count;

    ConsonantVowelEtcEnum(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}