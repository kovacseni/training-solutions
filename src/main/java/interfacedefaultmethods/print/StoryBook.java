package interfacedefaultmethods.print;

import java.util.ArrayList;
import java.util.List;

public class StoryBook implements Printable {

    private List<ColoredPage> coloredPages = new ArrayList<>();

    @Override
    public int getLength() {
        return coloredPages.size();
    }

    @Override
    public String getPage(int numberOfPage) {
        return coloredPages.get(numberOfPage).getPage();
    }

    @Override
    public String getColor(int numberOfPage) {
        return coloredPages.get(numberOfPage).getColor();
    }

    public void addPage(String page, String color) {
        coloredPages.add(new ColoredPage(page, color));
    }
}
