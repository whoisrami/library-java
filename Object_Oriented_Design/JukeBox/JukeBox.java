package JukeBox;

import java.util.Set;

/**
 * Created by alexyang on 9/17/14.
 */
public class JukeBox {
  private User user;
  private Playlist playlist;
  private Set<Cd> collection;
  private Cd cd;

  public JukeBox() {};
  public JukeBox(User user, Playlist playlist, Set<Cd> collection, Cd cd) {
    this.user = user;
    this.playlist = playlist;
    this.collection = collection;
    this.cd = cd;
  }

  public User getUser() {
    return user;
  }

  public void play() {
    //play the song
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Playlist getPlaylist() {
    return playlist;
  }

  public void setPlaylist(Playlist playlist) {
    this.playlist = playlist;
  }

  public Set<Cd> getCollection() {
    return collection;
  }

  public void setCollection(Set<Cd> collection) {
    this.collection = collection;
  }

  public Cd getCd() {
    return cd;
  }

  public void setCd(Cd cd) {
    this.cd = cd;
  }

}
