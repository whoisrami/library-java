package ParkingGarage;

/**
 * Created by alexyang on 9/17/14.
 */
public class Test {
  public static void main (String[] args) {
    //TODO: improve design so vehicles attempt to park in smallest spot possible
    Garage garage = new Garage();
    Car car = new Car();
    garage.parkVehicle(car);
    garage.parkVehicle(new Motorcycle());
    garage.parkVehicle(new Bus());
    car.unPark();
    garage.parkVehicle(new Motorcycle());
  }
}
