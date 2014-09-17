package JukeBox;

import java.util.ArrayDeque;

/**
 * Manages current and next songs to play.
 * Created by alexyang on 9/17/14.
 */
public class Playlist {
  private Song currentSong = null;
  private ArrayDeque<Song> queue = null;

  public Playlist() {
    this.queue = new ArrayDeque<Song>();
  }

  public Song getCurrentSong() {
    return currentSong;
  }

  public void setCurrentSong(Song currentSong) {
    this.currentSong = currentSong;
  }

  public Song getNextSong() {
    return queue.peek();
  }

  public void addSong(Song s) {
    queue.add(s);
  }
}
