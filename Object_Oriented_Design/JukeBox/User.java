package JukeBox;

/**
 * Created by alexyang on 9/17/14.
 */
public class User {
  private String name;
  private int ID;

  public User(String name, int ID) {
    this.name = name;
    this.ID = ID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getID() {
    return ID;
  }

  public void setID(int ID) {
    this.ID = ID;
  }
}
