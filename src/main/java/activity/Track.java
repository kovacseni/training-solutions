package activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
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

    public void loadFromGpx() {
        Path path = Path.of("src/test/resources/track.gpx");
        try (BufferedReader br = Files.newBufferedReader(path)) {
            Coordinate[] helpArray = new Coordinate[1];
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("<trkpt")) {
                    Coordinate coordinate = getNewCoordinate(line);
                    helpArray[0] = coordinate;
                }
                if (line.contains("<ele")) {
                    addNewTrackPointToList(line, helpArray[0]);
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }

        private Coordinate getNewCoordinate(String line) {

            int index1 = line.indexOf("lat=");
            String lat = line.substring(index1 + 5, index1 + 15);
            double latitude = Double.parseDouble(lat);
            int index2 = line.indexOf("lon=");
            String lon = line.substring(index2 + 5, index2 + 15);
            double longitude = Double.parseDouble(lon);

            return new Coordinate(latitude, longitude);
        }

        private void addNewTrackPointToList(String line, Coordinate coordinate) {
            int index3 = line.indexOf("<ele>");
            String ele = line.substring(index3 + 5, index3 + 10);
            Double elevation = Double.parseDouble(ele);

            trackPoints.add(new TrackPoint(coordinate, elevation));
        }
    }

