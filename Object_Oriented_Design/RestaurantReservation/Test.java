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
public class Test {
  public static void main(String args[]) {
    Restaurant restaurant = new Restaurant();

    Party alex = new Party("alex", 3);
    restaurant.reserve(alex);

    alex.leave();
  }
}
