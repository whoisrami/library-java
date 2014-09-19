package ParkingGarage;

/**
 * Created by alexyang on 9/17/14.
 */
public class Garage {
  private Level[] levels;
  private final int NUM_LEVELS = 3;
  private final int NUM_SPOTS = 30;

  public Garage() {
    levels = new Level[NUM_LEVELS];
    for (int i = 0; i < NUM_LEVELS; i++) {
      levels[i] = new Level(i, NUM_SPOTS);
    }
  }

  /* Park the vehicle in a spot (or multiple spots). Return false if failed. */
  public boolean parkVehicle(Vehicle vehicle) {
    for (int i = 0; i < levels.length; i++) {
      if (levels[i].parkVehicle(vehicle)) {
        System.out.println("Successfully Parked " + vehicle.getClass().getSimpleName());
        return true;
      }
    }
    return false;
  }
}
