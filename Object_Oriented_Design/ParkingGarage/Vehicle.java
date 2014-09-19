package ParkingGarage;

import java.util.ArrayList;

/**
 * Created by alexyang on 9/17/14.
 */
public abstract class Vehicle {
  protected int spotsNeeded;
  protected ArrayList<Spot> parkedSpots = new ArrayList<Spot>();
  protected VehicleSize size;

  public int getSpotsNeeded() {
    return spotsNeeded;
  }

  public VehicleSize getSize() {
    return size;
  }

  public void park(Spot spot) {
    parkedSpots.add(spot);
  }

  public ArrayList<Spot> getParkedSpots() {
    return parkedSpots;
  }

  //remove vehicle from all spots, then clear it
  public void unPark() {
    for (Spot spot : this.parkedSpots) {
      spot.free();
    }
    this.parkedSpots.clear();
    System.out.println(this.getClass().getSimpleName() + " unparked.");
  }

  public abstract boolean canFitInSpot(Spot spot);
}
