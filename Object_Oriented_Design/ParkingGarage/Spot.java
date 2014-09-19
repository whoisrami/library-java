package ParkingGarage;

/**
 * Created by alexyang on 9/17/14.
 */
public class Spot {
  private Vehicle vehicle = null;
  private VehicleSize size;

  private int row;
  private int spotNumber;
  private Level level;

  public Spot(int spotNumber, Level level, int row, VehicleSize size) {
    this.spotNumber = spotNumber;
    this.level = level;
    this.row = row;
    this.size = size;
  }

  public boolean isOpen() {
    return vehicle == null;
  }

  public void free() {
    this.vehicle = null;
    this.level.incrementAvailableSpots();
  }

  public Vehicle getVehicle() {
    return vehicle;
  }

  public void parkVehicle(Vehicle vehicle) {
    if (!vehicle.canFitInSpot(this) && this.isOpen()) {
      System.out.println("Can't fit: " + vehicle.getClass().getSimpleName());
      return;
    }
    this.vehicle = vehicle;
    vehicle.park(this);
  }

  public VehicleSize getSize() {
    return size;
  }

  public int getRow() {
    return row;
  }

  public int getSpotNumber() {
    return spotNumber;
  }

  public Level getLevel() {
    return level;
  }
}
