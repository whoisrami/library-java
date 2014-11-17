package RestaurantReservation;

/**
 * Author: Alex Yang
 * Date: 11/16/14
 * Dependencies:
 * - N/A
 * Description:
 * - N/A
 * Solution:
 * - N/A
 */
public class Table {
  int size;
  boolean taken;

  public Table(int size, boolean taken) {
    this.size = size;
    this.taken = false;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public boolean isTaken() {
    return taken;
  }

  public void setTaken(boolean taken) {
    this.taken = taken;
  }
}
