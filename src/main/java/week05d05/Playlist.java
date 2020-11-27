package week05d05;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    private List<Song> songList;

    public Playlist(List<Song> songList) {
        this.songList = songList;
    }

    public List<Song> findByLengthGreaterThan(int mins) {
        List<Song> songsLongerThan = new ArrayList<>();
        double lengthInMins = (double)mins;

        for (Song s : songList) {
            if ((s.getLengthInSeconds() / 60D) > lengthInMins) {
                songsLongerThan.add(s);
            }
        }
        return songsLongerThan;
    }

    public String toString(List<Song> list) {
        String songListString = "";
        for (Song s : list) {
            songListString = songListString + s.toString() + "; ";
        }
        return songListString;
    }
}
