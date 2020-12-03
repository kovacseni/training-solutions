package immutable.satellite;

import java.util.ArrayList;
import java.util.List;

public class SpaceAgency {

    private List<Satellite> satellites = new ArrayList<>();

    public void registerSatellite(Satellite satellite) {
        if (satellite == null) {
            throw new NullPointerException("Parameter must not be null!");
        }
        satellites.add(satellite);
    }

    public Satellite findSatelliteByRegisterIdent(String registerIdent) {
        if (isEmpty(registerIdent)) {
            throw new IllegalArgumentException("RegisterIdent must be given!");
        }

        Satellite satellite = null;
        for (Satellite s : satellites) {
            if (s.getRegisterIdent().equals(registerIdent)) {
                satellite = s;
            }
        }

        if (satellite == null) {
            throw new IllegalArgumentException("Satellite with the given registration cannot be found!" + registerIdent);
        }

        return satellite;
    }

    @Override
    public String toString() {
        String satellitesListString = "[";
        for (Satellite s : satellites) {
            satellitesListString = satellitesListString + s.toString() + ", ";
        }
        satellitesListString = satellitesListString.substring(0, satellitesListString.length() - 2);
        satellitesListString = satellitesListString + "]";
        return satellitesListString;
    }

    private boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }
}
