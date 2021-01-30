package exam02.photo;

public enum Quality {

    NO_STAR(0), ONE_STAR(1), TWO_STAR(2);

    private int star;

    Quality(int star) {
        this.star = star;
    }

    public int getStar() {
        return star;
    }
}
