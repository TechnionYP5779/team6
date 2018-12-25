package parking;

import java.io.*;

import com.google.maps.errors.*;

import il.org.spartan.utils.*;

/** the object that represent a parking spot
 * @fluent.ly.Package parking
 * @fluent.ly.Since Dec 8, 2018
 * @fluent.ly.Author Or, Nitzan */
public class ParkingSpot {
  
  //ONLY THESE ARE RELEVANT CURRENTLY
  private final int id;
  private Address address;
  private String start_time;
  private String end_time;
  private int price;
  private String sellerID;
  private String buyerID;
  private String startDate;
  private String endDate;
  Pair<Double, Double> coordinates;
  private int slotCounter; // number of rent slots associated with this parking spot
  private static int uniqueId;

  /** initialize the parking spot with an address check validity of the address
   * check parking spot is not already belongs to a seller
   * @param a the address of the parking spot
   * @throws NullPointerException if the address is null */
  public ParkingSpot(int id, String seller, String buyer,  int price, final Address a, String start_time, String end_time, String startDate, String endDate) {
    // TODO: needs to check if address valid, means exist in our world
    // TODO: needs to check if parkingSpot already belongs to a seller
    if (a == null)
      throw new NullPointerException();
    this.id = id;
    this.setAddress(a);
    this.setStartHour(start_time);
    this.setEndHour(end_time);
    this.setPrice(price);
    this.startDate = startDate;
    this.endDate = endDate;
    this.sellerID = seller;
    this.buyerID = buyer;
    
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

  public ParkingSpot(String ownerID, Address address2, String startTime, String endTime, int price2) {
    // TODO Auto-generated constructor stub just for ignore errors for pushing
    id = 0;
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
  
  public String getSellerID() {
    return sellerID;
  }
  
  public void setSellerID(String sellerID) {
    this.sellerID = sellerID;
  }

  public String getBuyerID() {
    return buyerID;
  }
  public void setBuyerID(String buyerID) {
    this.buyerID = buyerID;
  }

  public String getStartDate() {
      return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public String getStartHour() {
    return start_time;
  }

  public void setStartHour(String startHour) {
    this.start_time = startHour;
  }

  public String getEndHour() {
    return end_time;
  }

  public void setEndHour(String endHour) {
    this.end_time = endHour;
  }
  
@Override 
  public String toString() {
    String buyer = buyerID == null ? "-" : buyerID;
    return ("id=" + id + ", seller=" + sellerID + ", buyer=" + buyer + ", price=" + price 
        + ", city=" + address.getCity() +", street="+ address.getStreet() + ", building=" + address.getBuilding()
        + ", startDate=" + startDate + ", endDate=" + endDate + ", start_time=" + start_time + ", end_time=" + end_time + ", latitude=" + coordinates.first + ", longitude=" + coordinates.second);
  }
  
}
