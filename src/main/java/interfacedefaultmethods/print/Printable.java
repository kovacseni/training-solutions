package interfacedefaultmethods.print;

public interface Printable {

    String BLACK = "#000000";

    int getLength();

    String getPage(int numberOfPage);

    default String getColor(int numberOfPage) {
        return BLACK;
    }
}
