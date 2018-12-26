package parking;

import java.io.*;

import com.google.maps.errors.*;

import il.org.spartan.utils.*;

/** the object that represent a parking spot
 * @fluent.ly.Package parking
 * @fluent.ly.Since Dec 8, 2018
 * @fluent.ly.Author Or, Nitzan */
public class ParkingSpot {
  // ONLY THESE ARE RELEVANT CURRENTLY
  private final int id;
  private Address address;
  private String startHour;
  private String endHour;
  private int price;
  private String sellerID;
  private String buyerID;
  private String startDate;
  private String endDate;
  Pair<Double, Double> coordinates;
  private int slotCounter; // number of rent slots associated with this parking spot

  /** initialize the parking spot with an address check validity of the address
   * check parking spot is not already belongs to a seller
   * @param a the address of the parking spot
   * @throws NullPointerException if the address is null */
  public ParkingSpot(final int id, final String seller, final String buyer, final int price, final Address a, final String startHour,
      final String endHour, final String startDate, final String endDate) {
    // TODO: needs to check if address valid, means exist in our world
    // TODO: needs to check if parkingSpot already belongs to a seller
    if (a == null)
      throw new NullPointerException();
    this.id = id;
    this.setAddress(a);
    this.setStartHour(startHour);
    this.setEndHour(endHour);
    this.setPrice(price);
    this.startDate = startDate;
    this.endDate = endDate;
    this.sellerID = seller;
    this.buyerID = buyer;
    this.slotCounter = 0;
    try {
      this.coordinates = mapUtils.basicUtils.geocodingAddress(a);
    } catch (IOException | InterruptedException | ApiException ¢) {
      ¢.printStackTrace();
    }
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

  public void setSellerID(final String sellerID) {
    this.sellerID = sellerID;
  }

  public String getBuyerID() {
    return buyerID;
  }

  public void setBuyerID(final String buyerID) {
    this.buyerID = buyerID;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(final String startDate) {
    this.startDate = startDate;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(final int price) {
    this.price = price;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(final String endDate) {
    this.endDate = endDate;
  }

  public String getEndTime() {
    return endDate + "T" + endHour;
  }

  public String getStartHour() {
    return startHour;
  }

  public void setStartHour(final String startHour) {
    this.startHour = startHour;
  }

  public String getStartTime() {
    return startDate + "T" + startHour;
  }

  public String getEndHour() {
    return endHour;
  }

  public void setEndHour(final String endHour) {
    this.endHour = endHour;
  }

  public Double getLatitude() {
    return coordinates.first;
  }

  public Double getLongitude() {
    return coordinates.second;
  }

  @Override public String toString() {
    return "parkingSpotId=" + id + ", sellerId=" + sellerID + ", buyerId=" + (buyerID == null ? "-" : buyerID) + ", price=" + price + ", city="
        + address.getCity() + ", street=" + address.getStreet() + ", building=" + address.getBuilding() + ", start_time=" + startDate + " "
        + startHour + ", end_time=" + endDate + " " + endHour + ", latitude=" + coordinates.first + ", longitude=" + coordinates.second;
  }
}
