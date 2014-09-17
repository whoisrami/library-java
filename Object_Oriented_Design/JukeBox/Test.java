package JukeBox;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by alexyang on 9/17/14.
 */
public class Test {
  public static void main(String[] args) {
    //initialize list of songs
    ArrayList<Song> songs = new ArrayList<>();
    songs.add(new Song("Alex's song"));
    songs.add(new Song("my song 2"));
    String artist = "Alex";

    //create a cd
    Cd cd1 = new Cd(songs, artist);
    Set<Cd> cds = new HashSet<Cd>();
    cds.add(cd1);

    JukeBox jb = new JukeBox();
    jb.setCollection(cds); //set cd collection inside jukebox
    jb.setUser(new User("Alex", 1)); //initialize user

    //access via Iterator
    Iterator iterator = jb.getCollection().iterator();
    Cd currCd = null;
    while (iterator.hasNext()) {
      currCd = (Cd) iterator.next(); //find a cd
    }

    jb.setCd(currCd); //set cd
    jb.setPlaylist(new Playlist()); //initialize playlist

    Song songFromCd = jb.getCd().getSongs().get(0); //get song from cd
    jb.getPlaylist().addSong(songFromCd); //add song from cd to playlist
    Song s = jb.getPlaylist().getNextSong();
    jb.getPlaylist().setCurrentSong(s);
    jb.play();
  }
}
