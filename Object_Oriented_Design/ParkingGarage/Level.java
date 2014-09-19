package ParkingGarage;

import java.util.ArrayList;

/**
 * Created by alexyang on 9/17/14.
 */
public class Level {
  private int floor;
  private Spot[] spots;
  private int availableSpots = 0;
  private static final int SPOTS_PER_ROW = 10;

  public Level(int floor, int numberSpots) {
    this.floor = floor;
    this.spots = new Spot[numberSpots];

    //setup all spots
    int largeSpots = numberSpots / 4;
    int bikeSpots = numberSpots / 4;
    int compactSpots = numberSpots - largeSpots - bikeSpots;

    for (int i = 0; i < numberSpots; i++) {
      VehicleSize size = VehicleSize.Motorcycle;
      if (i < largeSpots) {
        size = VehicleSize.Large;
      } else if (i < largeSpots + compactSpots) {
        size = VehicleSize.Compact;
      }
      int row = i / SPOTS_PER_ROW;
      //spotnumber, level, row, size
      spots[i] = new Spot(i, this, row, size);
    }

    this.availableSpots = numberSpots;
  }

  //park the vehicle
  public boolean parkVehicle(Vehicle vehicle) {
    int spotNumber = this.findPossibleSpots(vehicle);
    if (spotNumber == -1) {
      System.out.println("No spots possible");
      return false;
    } else {
      this.parkStartingAtSpot(spotNumber, vehicle);
      return true;
    }
  }

  //park vehicle in all spots starting at spotNumber
  private void parkStartingAtSpot(int spotNumber, Vehicle vehicle) {
    for (int i = spotNumber; i < spotNumber + vehicle.getSpotsNeeded(); i++) {
      spots[i].parkVehicle(vehicle);
      System.out.println(vehicle.getClass().getSimpleName() + " Parked at Spot " + i);
    }
    availableSpots -= vehicle.getSpotsNeeded();
  }

  //finds FIRST AVAILABLE possible spot, return -1 if no spots available
  private int findPossibleSpots(Vehicle vehicle) {
    int spotsNeeded = vehicle.getSpotsNeeded();
    if (spotsNeeded > this.availableSpots) {
      return -1;
    } else {
      int counter = 0;
      int rowcounter = 0;
      for (int i = 0; i < spots.length; i++) {
        rowcounter++;
        if (rowcounter == SPOTS_PER_ROW) counter = 0;

        if (spots[i].isOpen() && vehicle.canFitInSpot(spots[i])) {
          counter++;
        } else {
          counter = 0;
        }
        if (spotsNeeded == counter) return i - spotsNeeded + 1;
      }
      return -1;
    }
  }

  public int getFloor() {
    return floor;
  }

  public Spot[] getSpots() {
    return spots;
  }

  public int getAvailableSpots() {
    return availableSpots;
  }

  public static int getSpotsPerRow() {
    return SPOTS_PER_ROW;
  }

  public void incrementAvailableSpots() {
    this.availableSpots++;
  }
}
