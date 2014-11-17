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
public class Reservation {
  private String start;
  private Party party;

  public Reservation(Party party, String start, String end) {
    this.party = party;
    this.start = start;
  }

  public String getStart() {
    return start;
  }

  public void setStart(String start) {
    this.start = start;
  }

  public Party getParty() {
    return party;
  }

  public void setParty(Party party) {
    this.party = party;
  }
}
