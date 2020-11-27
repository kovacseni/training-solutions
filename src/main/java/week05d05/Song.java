package week05d05;

public class Song {

    private String name;
    private long lengthInSeconds;
    private String artist;

    public Song(String name, long lengthInSeconds, String artist) {
        if (isEmpty(name) || isEmpty(artist)) {
            throw new IllegalArgumentException("Az előadó neve és a zeneszám címe nem maradhat üresen!");
        }
        if (lengthInSeconds <= 0) {
            throw new IllegalArgumentException("A zeneszám hosszát meg kell adni!");
        }


        this.name = name;
        this.lengthInSeconds = lengthInSeconds;
        this.artist = artist;
    }

    public long getLengthInSeconds() {
        return lengthInSeconds;
    }

    @Override
    public String toString() {
        return "Zeneszám adatai: " + artist + ": " + name + ", hossza: " + lengthInSeconds + " sec";
    }

    private boolean isEmpty(String str) {
        return (str == null || "".equals(str) || str.isBlank());
    }
}
