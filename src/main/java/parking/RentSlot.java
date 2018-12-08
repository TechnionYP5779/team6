package parking;

/**
 * the object that represents rent slot
 * @fluent.ly.Package parking
 * @fluent.ly.Since Dec 8, 2018
 * @fluent.ly.Author Or, Nitzan
 */

public class RentSlot {
  private int id;
  private ParkingSpot p;
  private Time t;
  private double price;
  private Buyer b;
  private static int uniqueId;

  /**
   * 
   * @param s the owner of the parking that will be rented
   * @param p the parking spot to be rented
   * @param t the time that the parking spot will be rented
   * @param price the price of the rent slot
   */
  RentSlot(Seller s, ParkingSpot p, Time t, double price) {
    if(s == null || p == null || t == null)
      throw new NullPointerException();
    if(!p.getOwner().equals(s))
      throw new IllegalArgumentException();
    this.id = uniqueId++;
    this.p = p;
    this.t = t;
    this.price = price;
    this.b = null;
    p.addSlotOfParking();
  }
  
  /**
   * call this when removing rent slot
   * if the rent slot is removed due a parking spot removal, no need to call this
   */
  public void closeRentSlot() {
    p.removeSlotOfParking();
  }
  
  
  /**
   * 
   * @return id of this rent slot
   */
  public int getId() {
    return id;
  }
  /**
   * 
   * @return the parking spot associates with this rent slot
   */
  public ParkingSpot getParkingSpot() {
    return p;
  }
  
  /**
   * 
   * @return the time this rent slot is rented
   */
  public Time getTime() {
    return t;
  }
  
  /**
   * 
   * @return the price of this rent slot
   */
  public double getPrice() {
    return price;
  }
  
  /**
   * updates the price of this rent slot
   * @param price the new price of this rent slot
   */
  public void setPrice(double price) {
    this.price = price;
  }
  
  /**
   * 
   * @return the person who rents this rent slot
   */
  public Buyer getBuyer() {
    return b;
  }
}
