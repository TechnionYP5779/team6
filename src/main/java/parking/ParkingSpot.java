package parking;

/** the object that represent a parking spot
 * @fluent.ly.Package parking
 * @fluent.ly.Since Dec 8, 2018
 * @fluent.ly.Author Or, Nitzan */
public class ParkingSpot {
  private int id; // for now, will be more accurate later
  private Address address;
  private Seller owner;
  private int slotCounter; // number of rent slots associated with this parking spot
  private static int uniqueId;

  /** initialize the parking spot with an address check validity of the address
   * check parking spot is not already belongs to a seller
   * @param a the address of the parking spot
   * @throws NullPointerException if the address is null */
  ParkingSpot(Address a) {
    // TODO: needs to check if address valid, means exist in our world
    // TODO: needs to check if parkingSpot already belongs to a seller
    if (a == null)
      throw new NullPointerException();
    this.id = uniqueId++;
    this.setAddress(a);
    this.setOwner(null);
    this.slotCounter = 0;
  }

  /** @return owner of the parking spot */
  public Seller getOwner() {
    return owner;
  }

  /** change owner of the parking spot
   * @param owner the new owner of the parking spot */
  public void setOwner(Seller owner) {
    this.owner = owner;
  }

  /** @return address of the parking spot */
  public Address getAddress() {
    return address;
  }

  /** private method, change the address of the parking spot
   * @param ¢ the new address of the parking spot */
  private void setAddress(Address ¢) {
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
}
