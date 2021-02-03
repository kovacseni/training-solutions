package lambdacomparator.cloud;

public class CloudStorage implements Comparable<CloudStorage> {

    private String provider;
    private int space;
    private PayPeriod period;
    private double price;

    public CloudStorage(String provider, int space) {
        this.provider = provider;
        this.space = space;
    }

    public CloudStorage(String provider, int space, PayPeriod period, double price) {
        this(provider, space);
        this.period = period;
        this.price = price;
    }

    public String getProvider() {
        return provider;
    }

    public int getSpace() {
        return space;
    }

    public PayPeriod getPeriod() {
        return period;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int compareTo(CloudStorage other) {
        double thisValue = this.period != null ? this.price * 12 / this.period.getLength() / this.space * 1000 : 0;
        double otherValue = other.period != null ? other.price * 12 / other.period.getLength() / other.space * 1000 : 0;
        return Double.compare(thisValue, otherValue);
    }
}
