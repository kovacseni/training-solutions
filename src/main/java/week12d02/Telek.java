package week12d02;

import java.util.Objects;

public class Telek implements Comparable<Telek> {

    private int oddEven;
    private int length;
    private String fence;

    public Telek(int oddEven, int length, String fence) {
        this.oddEven = oddEven;
        this.length = length;
        this.fence = fence;
    }

    public int getOddEven() {
        return oddEven;
    }

    public int getLength() {
        return length;
    }

    public String getFence() {
        return fence;
    }

    public int compareTo(Telek telek) {
        return Integer.valueOf(this.getLength()).compareTo(Integer.valueOf(telek.getLength()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telek telek = (Telek) o;
        return length == telek.length;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length);
    }
}
