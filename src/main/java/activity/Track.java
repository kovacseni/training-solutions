package activity;

import java.util.ArrayList;
import java.util.List;

public class Track {

    private List<TrackPoint> trackPoints = new ArrayList<>();

    public List<TrackPoint> getTrackPoints() {
        return trackPoints;
    }

    public void addTrackPoint(TrackPoint point) {
        trackPoints.add(point);
    }

    public Coordinate findMinimumCoordinate() {
        double minLatitude = trackPoints.get(0).getCoordinate().getLatitude();
        double minLongitude = trackPoints.get(0).getCoordinate().getLongitude();
        for (TrackPoint t : trackPoints) {
            if (t.getCoordinate().getLatitude() < minLatitude) {
                minLatitude = t.getCoordinate().getLatitude();
            }
            if (t.getCoordinate().getLongitude() < minLongitude) {
                minLongitude = t.getCoordinate().getLongitude();
            }
        }
        Coordinate minCoordinate = new Coordinate(minLatitude, minLongitude);
        return minCoordinate;
    }

    public Coordinate findMaximumCoordinate() {
        double maxLatitude = trackPoints.get(0).getCoordinate().getLatitude();
        double maxLongitude = trackPoints.get(0).getCoordinate().getLongitude();
        for (TrackPoint t : trackPoints) {
            if (t.getCoordinate().getLatitude() > maxLatitude) {
                maxLatitude = t.getCoordinate().getLatitude();
            }
            if (t.getCoordinate().getLongitude() > maxLongitude) {
                maxLongitude = t.getCoordinate().getLongitude();
            }
        }
        Coordinate maxCoordinate = new Coordinate(maxLatitude, maxLongitude);
        return maxCoordinate;
    }

    public double getDistance() {
        double distance = 0;
        for (int i = 0; i < trackPoints.size() - 1; i++) {
            distance += (trackPoints.get(i + 1).getDistanceFrom(trackPoints.get(i)));
        }
        return distance;
    }

    public double getFullElevation() {
        double fullElevation = 0;
        for (int i = 0; i < trackPoints.size() - 1; i++) {
            if (trackPoints.get(i + 1).getElevation() > trackPoints.get(i).getElevation()) {
                fullElevation += (trackPoints.get(i + 1).getElevation() - trackPoints.get(i).getElevation());
            }
        }
        return fullElevation;
    }

    public double getFullDecrease() {
        double fullDecrease = 0;
        for (int i = 0; i < trackPoints.size() - 1; i++) {
            if (trackPoints.get(i + 1).getElevation() < trackPoints.get(i).getElevation()) {
                fullDecrease += Math.abs(trackPoints.get(i + 1).getElevation() - trackPoints.get(i).getElevation());
            }
        }
        return fullDecrease;
    }

    public double getRectangleArea() {
        double rectangleArea = (findMaximumCoordinate().getLatitude() - findMinimumCoordinate().getLatitude()) * (findMaximumCoordinate().getLongitude() - findMinimumCoordinate().getLongitude());
        return rectangleArea;
    }
}
