package CallCenter;

/**
 * Created by alexyang on 9/16/14.
 */
public enum Rank {
  Responder (0),
  Manager (1),
  Director (2);

  private int value;

  private Rank(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }
}

