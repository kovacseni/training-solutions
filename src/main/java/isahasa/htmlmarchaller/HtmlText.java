package isahasa.htmlmarchaller;

public class HtmlText implements TextSource {

    private String plainText;

    public HtmlText(String plainText) {
        this.plainText = plainText;
    }

    public String getPlainText() {
        return plainText;
    }
}
