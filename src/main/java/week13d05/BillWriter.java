package week13d05;

import java.util.ArrayList;
import java.util.List;

public class BillWriter {

    public String writeBills(List<BillItem> billItems, RowWriter rowWriter) {
        StringBuilder sb = new StringBuilder();
        if (rowWriter.getHeader().isPresent()) {
            sb.append(rowWriter.getHeader().get()).append("\n");
        }
        for (BillItem b : billItems) {
            String line = rowWriter.createLine(b);
            sb.append(line);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        BillWriter bw = new BillWriter();
        List<BillItem> billItems = new ArrayList<>();
        billItems.add(new BillItem("kenyér", 1, 320));
        billItems.add(new BillItem("tej", 2, 250));
        billItems.add(new BillItem("alma", 3, 40));

        System.out.println(bw.writeBills(billItems, new FirstRowWriter()));
        System.out.println(bw.writeBills(billItems, new SecondRowWriter()));
        System.out.println(bw.writeBills(billItems, new ThirdRowWriter()));
    }
}
