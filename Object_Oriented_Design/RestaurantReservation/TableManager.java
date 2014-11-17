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
public class TableManager {
  private Table[] tables;
  private int availableTables = 0;

  public TableManager(int numTables) {
    tables = new Table[numTables];

    int largeTables = numTables/4;
    int mediumTables = numTables/4;
    int smallTables = numTables - largeTables - mediumTables;

    for (int i = 0;  i < numTables; i++) {
      int size = 8;
      if (i < smallTables) {
        size = 2;
      } else if (i < smallTables + mediumTables) {
        size = 4;
      }

      //initialize all tables
      tables[i] = new Table(size, false);
    }

    this.availableTables = numTables;
  }

  //returns index in array where table is open, -1 if not found
  //could be further optimized to get table with smallest size possibility
  public int findOpenTable(Party party) {
    for (int i = 0; i < tables.length; i++) {
//      System.out.println(tables[i].getSize());
      if (tables[i].getSize() >= party.getSize() && !tables[i].isTaken()) {
        System.out.println("found table at: " + i);
        return i;
      }
    }

    System.out.println("no tables available.");
    return -1;
  }

  //TODO: needs to account for setting times in the future
  public boolean reserve(Party party) {
    //if available table found, reserve it.
    int tableIndex = this.findOpenTable(party);
    if (tableIndex > -1) {
      tables[tableIndex].setTaken(true);
      party.setTable(tables[tableIndex]);
      return true;
    }
    return false;
  }
}
