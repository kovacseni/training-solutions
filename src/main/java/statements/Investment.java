package statements;

public class Investment {

    public static final double COST = 0.3;

    private int fund;
    private int interestRate;
    private boolean active = true;

    public Investment(int fund, int interestRate) {
        this.fund = fund;
        this.interestRate = interestRate;
    }

    public int getFund() {
        return fund;
    }

    public double getYield(int days) {
        return fund * days * interestRate / (100.0 * 365);
    }

    public double close(int days) {
        double kivett = (fund + fund * days * interestRate / (100 * 365)) * ((100 - COST) / 100);
        double lezart = active ? kivett : 0;

        active = false;
        return lezart;
    }
}
