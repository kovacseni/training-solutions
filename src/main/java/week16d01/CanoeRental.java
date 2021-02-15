package week16d01;

import java.time.LocalDateTime;

public class CanoeRental {

    private String name;
    private CanoeType canoeType;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean active;

    public CanoeRental(String name, CanoeType canoeType, LocalDateTime startTime) {
        this.name = name;
        this.canoeType = canoeType;
        this.startTime = startTime;
        this.active = true;
    }

    public String getName() {
        return name;
    }

    public CanoeType getCanoeType() {
        return canoeType;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public boolean isActive() {
        return active;
    }

    public void setEndTime(LocalDateTime endTime) {
        if (endTime.isBefore(this.startTime)) {
            throw new IllegalArgumentException("End time must be later than start time.");
        }
        this.endTime = endTime;
        this.active = false;
    }

    public double calculateRentalSum() {
        double price = 5000.0;
        return price * this.canoeType.getRate();
    }

    @Override
    public String toString() {
        return "CanoeRental{" +
                "name='" + name + '\'' +
                ", canoeType=" + canoeType +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", active=" + active +
                '}';
    }
}
