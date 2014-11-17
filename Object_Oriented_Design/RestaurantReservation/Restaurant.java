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
public class Restaurant {
  private final int NUM_TABLES = 10;
  TableManager tableManager;

  public Restaurant() {
    this.tableManager = new TableManager(NUM_TABLES);
  }

  public boolean reserve(Party party) {
    return tableManager.reserve(party);
  }

}
