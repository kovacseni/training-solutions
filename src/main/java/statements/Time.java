package statements;

public class Time {

    private int ora;
    private int perc;
    private int masodperc;

    public Time(int ora, int perc, int masodperc) {
        this.ora = ora;
        this.perc = perc;
        this.masodperc = masodperc;
    }

    public int getInMinutes() {
        int x = ora * 60 + perc;
        return x;
    }

    public int getInSeconds() {
        int y = ora * 3600 + perc * 60 + masodperc;
        return y;
    }

    public boolean earlierThan(Time masikIdo) {
        int ido1 = this.getInSeconds();
        int ido2 = masikIdo.getInSeconds();
        return ido1 < ido2;
    }

    public String toString() {
        return ora + ":" + perc + ":" + masodperc;
    }

}
