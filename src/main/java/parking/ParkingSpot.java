package parking;

/** the object that represent a parking spot
 * @fluent.ly.Package parking
 * @fluent.ly.Since Dec 8, 2018
 * @fluent.ly.Author Or, Nitzan */
public class ParkingSpot {
  
  //ONLY THESE ARE RELEVANT CURRENTLY
  private final int id;
  private Address address;
  private String sellerID;
  private String buyerID;
  private String startDate;
  private String endDate;
  private String startHour;
  private String endHour;
  private int price;
  //
  
  public ParkingSpot(int id, String seller, String buyer, int price, Address a, String startDate, String endDate, String startHour, String endHour){
    this.id = id;
    this.sellerID = seller;
    this.buyerID = buyer;
    this.price = price;
    this.address = a;
    this.startDate = startDate;
    this.endDate = endDate;
    this.startHour = startHour;
    this.endHour = endHour;
  }
  
  @Override 
  public String toString() {
    String buyer = buyerID == null ? "-" : buyerID;
    return ("id: " + id + "\t seller: " + sellerID + "\t buyer: " + buyer + "\t price: " + price 
        + "\t city: " + address.getCity() +"\t street: "+ address.getStreet() + "\t building: " + address.getBuilding()
        + "\t startDate: " + startDate + "\t endDate: " + endDate + "\t startHour: " + startHour + "\t endHour: " + endHour);
  }
  
  
  private Seller owner;
  private int slotCounter; // number of rent slots associated with this parking spot
  private static int uniqueId;

  /** initialize the parking spot with an address check validity of the address
   * check parking spot is not already belongs to a seller
   * @param a the address of the parking spot
   * @throws NullPointerException if the address is null */
  ParkingSpot(final Address a) {
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
  public void setOwner(final Seller owner) {
    this.owner = owner;
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
    return startHour;
  }

  public void setStartHour(String startHour) {
    this.startHour = startHour;
  }

  public String getEndHour() {
    return endHour;
  }

  public void setEndHour(String endHour) {
    this.endHour = endHour;
  }
}
