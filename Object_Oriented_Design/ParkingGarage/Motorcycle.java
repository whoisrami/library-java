package ParkingGarage;

/**
 * Created by alexyang on 9/17/14.
 */
public class Motorcycle extends Vehicle {
  public Motorcycle() {
    this.size = VehicleSize.Motorcycle;
    this.spotsNeeded = 1;
  }

  public boolean canFitInSpot(Spot spot) {
    return true; //motorcycle can fit in any spot
  }
}
