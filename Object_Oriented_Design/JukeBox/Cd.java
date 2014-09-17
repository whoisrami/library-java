package JukeBox;

import java.util.ArrayList;

/**
 * Created by alexyang on 9/17/14.
 */
public class Cd {
  private String artist;
  private ArrayList<Song> songs;

  public Cd(ArrayList<Song> songs, String artist) {
    this.songs = songs;
    this.artist = artist;
  }

  public ArrayList<Song> getSongs() {
    return songs;
  }

  public void setSongs(ArrayList<Song> songs) {
    this.songs = songs;
  }

  public String getArtist() {
    return artist;
  }

  public void setArtist(String artist) {
    this.artist = artist;
  }
}
