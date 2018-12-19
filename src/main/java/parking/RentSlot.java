package parking;

/** the class that represents rent slot
 * @fluent.ly.Package parking
 * @fluent.ly.Since Dec 8, 2018
 * @fluent.ly.Author Or, Nitzan */
public class RentSlot {
  private final int id;
  private final ParkingSpot p;
  private final Time t;
  private double price;
  private Buyer b;
  private static int uniqueId;

  /** create new rent slot of a parking spot
   * @param s     the owner of the parking spot
   * @param p     the parking spot
   * @param t     the time that the parking spot can be rented
   * @param price the price of the rent slot
   * @throws NullPointerException     if one of the arguments is null
   * @throws IllegalArgumentException if s is not the owner of p */
  RentSlot(final Seller s, final ParkingSpot p, final Time t, final double price) {
    if (s == null || p == null || t == null)
      throw new NullPointerException();
    if (!p.getOwner().equals(s))
      throw new IllegalArgumentException();
    this.id = uniqueId++;
    this.p = p;
    this.t = t;
    this.price = price;
    this.b = null;
    p.addSlotOfParking();
  }

  /** call this when removing rent slot if the rent slot is removed due a parking
   * spot removal, no need to call this */
  public void closeRentSlot() {
    p.removeSlotOfParking();
  }

  /** @return id of the rent slot */
  public int getId() {
    return id;
  }

  /** @return the parking spot associates with this rent slot */
  public ParkingSpot getParkingSpot() {
    return p;
  }

  /** @return the time this rent slot can be rented */
  public Time getTime() {
    return t;
  }

  /** @return the price of this rent slot */
  public double getPrice() {
    return price;
  }

  /** updates the price of this rent slot
   * @param price the new price of this rent slot */
  public void setPrice(final double price) {
    this.price = price;
  }

  /** @return the buyer of the rent slot */
  public Buyer getBuyer() {
    return b;
  }

  /** updates the buyer of the rent slot
   * @param ¢ the new buyer of the rent slot */
  public void setBuyer(final Buyer ¢) {
    this.b = ¢;
  }
}
