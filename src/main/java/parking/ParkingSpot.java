package parking;

import java.io.*;

import com.google.maps.errors.*;

import il.org.spartan.utils.*;

/** the object that represent a parking spot
 * @fluent.ly.Package parking
 * @fluent.ly.Since Dec 8, 2018
 * @fluent.ly.Author Or, Nitzan */
public class ParkingSpot {
  private final int id; // for now, will be more accurate later
  private Address address;
  private int ownerID;
  private String start_time;
  private String end_time;
  private int price;
  Pair<Double, Double> coordinates;
  private int slotCounter; // number of rent slots associated with this parking spot
  private static int uniqueId;

  /** initialize the parking spot with an address check validity of the address
   * check parking spot is not already belongs to a seller
   * @param a the address of the parking spot
   * @throws NullPointerException if the address is null */
  ParkingSpot(int ownerID, final Address a, String start_time, String end_time, int price) {
    // TODO: needs to check if address valid, means exist in our world
    // TODO: needs to check if parkingSpot already belongs to a seller
    if (a == null)
      throw new NullPointerException();
    this.id = uniqueId++;
    this.setAddress(a);
    this.setOwner(ownerID);
    this.setStart_time(start_time);
    this.setEnd_time(end_time);
    this.setPrice(price);
    this.slotCounter = 0;
    try {
      this.coordinates = mapUtils.basicUtils.geocodingAddress(a);
    } catch (ApiException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  ParkingSpot(final Address a) {
    // TODO: needs to check if address valid, means exist in our world
    // TODO: needs to check if parkingSpot already belongs to a seller
    if (a == null)
      throw new NullPointerException();
    this.id = uniqueId++;
   //TODO: implement
  }


  /** @return owner of the parking spot */
  public int getOwner() {
    return ownerID;
  }

  /** change owner of the parking spot
   * @param owner the new owner of the parking spot */
  public void setOwner(final int ownerID) {
    this.ownerID = ownerID;
  }

  /** @return address of the parking spot */
  public Address getAddress() {
    return address;
  }

  /** private method, change the address of the parking spot
   * @param ¢ the new address of the parking spot */
  private void setAddress(final Address ¢) {
    this.address = ¢;
  }

  /** increase the number of rent slots associated to this parking spot */
  public void addSlotOfParking() {
    ++this.slotCounter;
  }

  /** @return number of rent slots associated to this parking spot */
  public int getNumOfSlots() { // i.e. for limit the number of slots for each parking
    return slotCounter;
  }

  /** @return id of this parking spot */
  public int getId() {
    return id;
  }

  /** decrease the number of rent slots associated to this parking spot */
  public void removeSlotOfParking() {
    --this.slotCounter;
  }

  public String getStart_time() {
    return start_time;
  }

  public void setStart_time(String start_time) {
    this.start_time = start_time;
  }

  public String getEnd_time() {
    return end_time;
  }

  public void setEnd_time(String end_time) {
    this.end_time = end_time;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  @Override public String toString() {
    return "city=" + address.getCity() + ", street=" + address.getStreet() + ", building=" + address.getBuilding() + ", ownerID=" + ownerID
        + ", price=" + price + ", latitude=" + coordinates.first + ", longitude=" + coordinates.second;
    // return "city=" + address.getCity() + ", street=" + address.getStreet() + ",
    // building=" + address.getBuilding() + ", ownerID="
    // + ownerID + ", start_time=" + start_time + ", end_time=" + end_time + ",
    // price=" + price;
  }
}
