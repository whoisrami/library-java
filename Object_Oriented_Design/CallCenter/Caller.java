package CallCenter;

/**
 * Created by alexyang on 9/16/14.
 */
public class Caller {
  private String name;
  private int userId;

  public Caller(String name, int id) {
    this.name = name;
    this.userId = id;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
