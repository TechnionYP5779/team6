package parking;

public class ParkingSpot {
  private int id; // for now, will be more accurate later
  private Address address;
  private Seller owner;
  private int slotCounter;
  private static int uniqueId;

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

  public Seller getOwner() {
    return owner;
  }

  public void setOwner(Seller owner) {
    this.owner = owner;
  }

  public Address getAddress() {
    return address;
  }

  private void setAddress(Address ¢) {
    this.address = ¢;
  }

  public void addSlotOfParking() {
    ++this.slotCounter;
  }

  public int getNumOfSlots() { // i.e. for limit the number of slots for each parking
    return slotCounter;
  }

  public int getId() {
    return id;
  }
}
