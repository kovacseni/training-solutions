package interfacedefaultmethods.print;

public class ColoredPage {

    private String page;
    private String colorOfPage;

    public ColoredPage(String page, String colorOfPage) {
        this.page = page;
        this.colorOfPage = colorOfPage;
    }

    public ColoredPage(String page) {
        this.page = page;
        this.colorOfPage = Printable.BLACK;
    }

    public String getPage() {
        return page;
    }

    public String getColor() {
        return colorOfPage;
    }
}
