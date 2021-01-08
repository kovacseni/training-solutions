package activity;

public class TrackPoint {

    private Coordinate coordinate;
    private double elevation;
    public final static double AVERAGE_RADIUS_OF_EARTH_KM = 6371;

    public TrackPoint(Coordinate coordinate, double elevation) {
        this.coordinate = coordinate;
        this.elevation = elevation;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public double getElevation() {
        return elevation;
    }

    public double getDistanceFrom(TrackPoint point) {

        double latitudeDistance = Math.toRadians(point.getCoordinate().getLatitude() - this.getCoordinate().getLatitude());
        double longitudeDistance = Math.toRadians(point.getCoordinate().getLongitude() - this.getCoordinate().getLongitude());

        double a = Math.sin(latitudeDistance / 2) * Math.sin(latitudeDistance / 2)
                + Math.cos(Math.toRadians(this.getCoordinate().getLatitude())) * Math.cos(Math.toRadians(point.getCoordinate().getLatitude()))
                * Math.sin(longitudeDistance / 2) * Math.sin(longitudeDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = AVERAGE_RADIUS_OF_EARTH_KM * c * 1000;

        double height = this.getElevation() - point.getElevation();

        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return Math.sqrt(distance);
    }
}
