package ParkingGarage;

/**
 * Created by alexyang on 9/17/14.
 */
public class Bus extends Vehicle {
  public Bus() {
    this.spotsNeeded = 5;
    this.size = VehicleSize.Large;
  }

  @Override
  public boolean canFitInSpot(Spot spot) {
    return spot.getSize() == VehicleSize.Large;
  }
}
