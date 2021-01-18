package ioreadwritebytes.temperatures;

public class Temperatures {

    private byte[] data;

    public Temperatures(byte[] data) {
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }

    public double getYearAverage() {
        double yearAverage = 0;
        for (byte b : data) {
            yearAverage += b;
        }
        yearAverage /= data.length;
        return yearAverage;
    }

    public double getMonthAverage() {
        double monthAverage = 0;
        for (int i = data.length - 1; i >= data.length - 30; i--) {
            monthAverage += data[i];
        }
        monthAverage /= 30;
        return monthAverage;
    }
}
