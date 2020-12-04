package constructoroverloading.bus;

import java.util.ArrayList;
import java.util.List;

public class BusTimeTable {

    private List<SimpleTime> timeTable;

    public BusTimeTable(List<SimpleTime> timeTable) {
        this.timeTable = timeTable;
    }

    public BusTimeTable(int firstHour, int lastHour, int everyMinute) {
        this.timeTable = new ArrayList<>();
        for (int i = firstHour; i < lastHour + 1; i++) {
            timeTable.add(new SimpleTime(i, everyMinute));
        }
    }

    public List<SimpleTime> getTimeTable(){
        return timeTable;
    }

    public SimpleTime nextBus(SimpleTime actual) {
        SimpleTime next = null;
        for (int i = 0; i < timeTable.size(); i++) {
            if (timeTable.get(i).difference(actual) >= 0) {
                next = timeTable.get(i);
                break;
            }
        }
        if (next == null) {
            throw new IllegalStateException("No more buses today!");
        }
        return next;
    }

    public SimpleTime firstBus() {
        SimpleTime first = timeTable.get(0);
        for (int i = 0; i < timeTable.size(); i++) {
            if (timeTable.get(i).difference(first) < 0) {
                first = timeTable.get(i);
            }
        }
        return first;
    }
}
