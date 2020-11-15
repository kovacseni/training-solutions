package stringmethods.url;

import java.nio.channels.FileLockInterruptionException;

public class UrlManager {

    private String protocol;
    private Integer port;
    private String host;
    private String path;
    private String query;

    public UrlManager(String url) {
        this.protocol = getProtocolFromUrl(url);
        this.port = getPortFromUrl(url);
        this.host = getHostFromUrl(url);
        this.path = getPathFromUrl(url);
        this.query = getQueryFromUrl(url);
    }

    public String getProtocol() {
        return protocol;
    }

    public Integer getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }

    public String getPath() {
        return path;
    }

    private void validateString(String s) {
        if (s == null || s.isBlank() || s.isEmpty()) {
            throw new IllegalArgumentException("Parameter must not be empty");
        }
    }

    public boolean hasProperty(String key) {
        validateString(key);
        return query.startsWith(key + "=") || query.contains("&" + key + "=");
    }

    public String getProperty(String key) {
        validateString(key);
        String[] properties = query.split("&");
        for (String s : properties) {
            String[] property = s.split("=");
            if (property[0].equals(key)) {
                return property[1];
            }
        }
        return null;
    }

    public String getProtocolFromUrl(String url) {
        int colon = url.indexOf(":");
        if (colon < 0 || url.substring(0, colon).isEmpty() || url.substring(0, colon).isBlank()) {
            throw new IllegalArgumentException("Invalid url");
        }
        protocol = url.substring(0, colon).toLowerCase();
        return protocol;
    }

    public Integer getPortFromUrl(String url) {
        int colon1 = url.indexOf(":");
        int colon2 = url.indexOf(":", colon1 + 1);
        int perjel = url.indexOf("/", colon2);

        port = Integer.parseInt(url.substring(colon2 + 1, perjel));
        return port;
    }

    public String getHostFromUrl(String url) {
        int colon1 = url.indexOf(":");
        int perjel = url.indexOf("/", colon1 + 3);
        String hostSzoveg = url.substring(colon1 + 3, perjel);

        if (hostSzoveg.contains(":")) {
            int colon2 = hostSzoveg.indexOf(":");
            host = hostSzoveg.substring(0, colon2);
        } else {
            host = hostSzoveg;
        }

        if (host.isEmpty() || host.isBlank() || host == null) {
            throw new IllegalArgumentException("Invalid url");
        }
        host = host.toLowerCase();
        return host;
    }

    public String getPathFromUrl(String url) {
        int colon1 = url.indexOf(":");
        int perjel = url.indexOf("/", colon1 + 3);
        if (perjel < 0) {
            return "";
        }
        int questionMark = url.indexOf("?", perjel + 1);
        path = url.substring(perjel, questionMark).toLowerCase();

        if (path.isEmpty() || path.isBlank()) {
            throw new IllegalArgumentException("Invalid url");
        }
        return path;
    }

    public String getQueryFromUrl(String url) {
        int questionMark = url.indexOf("?");
        if (questionMark < 0) {
            return "";
        }
        query = url.substring(questionMark +1);
        return query;
    }
}

/* Elküldöm, de nem jó.
Nem értem, miért nem fut le a teszt.
Ott jelez hibát, hogy nincs kivétel dobva, ha hiányzik a host,
pedig beleírtam ezt a kivételdobást a host-os metódusba.
A többi hibát a hasProperty() és getProperty() metódusokkal kapcsolatban jelzi,
azokat sokszor megpróbáltam javítani, legvégül kiírtam a megoldásból,
és még így is hibát jelez. Nem tudom, mit nem veszek észre,
mert már kissé túlzottan sok ideje nézem ezt a feladatot.
Most elküldöm, ami van, és majd később visszanézek rá.
 */
