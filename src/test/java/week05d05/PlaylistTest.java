package week05d05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PlaylistTest {

    private List<Song> songList;
    private Playlist playlist;

     @BeforeEach
    public void setUp() {
         songList = new ArrayList<>();
         playlist = new Playlist(songList);

         Song song1 = new Song("Enter Sandman", 329, "Metallica");
         Song song2 = new Song("Fear Of The Dark", 442, "Iron Maiden");
         Song song3 = new Song("Origin", 228, "Korubaan");
         Song song4 = new Song("November Rain", 537, "Guns'n Roses");
         Song song5 = new Song("Summertime City", 254, "Therion");

         songList.add(song1);
         songList.add(song2);
         songList.add(song3);
         songList.add(song4);
         songList.add(song5);
     }

     @Test
    public void playlistToStringTest() {
         Assertions.assertEquals("Zeneszám adatai: Metallica: Enter Sandman, hossza: 329 sec; Zeneszám adatai: Iron Maiden: Fear Of The Dark, hossza: 442 sec; Zeneszám adatai: Korubaan: Origin, hossza: 228 sec; Zeneszám adatai: Guns'n Roses: November Rain, hossza: 537 sec; Zeneszám adatai: Therion: Summertime City, hossza: 254 sec; ", playlist.toString(songList));
     }

     @Test
    public void playlistSongsLongerThanTest() {
         List<Song> s = playlist.findByLengthGreaterThan(7);
         Assertions.assertEquals("Zeneszám adatai: Iron Maiden: Fear Of The Dark, hossza: 442 sec; Zeneszám adatai: Guns'n Roses: November Rain, hossza: 537 sec; ", playlist.toString(s));
     }

     @Test
    public void playlistSongsLongerThanTest2() {
         Assertions.assertEquals(3, playlist.findByLengthGreaterThan(5).size());
     }
}
