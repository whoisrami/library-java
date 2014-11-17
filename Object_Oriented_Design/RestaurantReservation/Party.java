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
public class Party {
  private int size;
  private String name;
  private Table table;

  public Party (String name, int size) {
    this.size = size;
    this.name = name;
    this.table = null;
  }

  public void leave() {
    System.out.println("leaving table size: " + table.getSize());
    table.setTaken(false);
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Table getTable() {
    return table;
  }

  public void setTable(Table table) {
    this.table = table;
  }
}
