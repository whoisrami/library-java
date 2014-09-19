package ParkingGarage;

/**
 * Created by alexyang on 9/17/14.
 */
public class Car extends Vehicle {
  public Car()  {
    this.spotsNeeded = 1;
    this.size = VehicleSize.Compact;
  }

  @Override
  public boolean canFitInSpot(Spot spot) {
    return spot.getSize() != VehicleSize.Motorcycle;
  }
}
