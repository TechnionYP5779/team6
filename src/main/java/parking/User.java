package parking;

import java.util.*;

import fluent.ly.*;

/**
 * a class that represents a user in the Parking project
 * @fluent.ly.Package parking
 * @fluent.ly.Since Dec 8, 2018
 * @fluent.ly.Author Or
 */

public class User implements Seller, Buyer {
  // user info will be in user package
  private String name;// meanwhile, for making unique users
  private String lastName;
  private String phone;
  // seller info
  private Map<Integer, ParkingSpot> ownedParkingSpots; // parking spots this user owns
  private Map<Integer, Map<Integer, RentSlot>> freeRentSlots; // slots of parking ready for renting
  private Map<Integer, Map<Integer, RentSlot>> usedRentSlots; // slots of parking which already rented to someone

  // buyer info
  
  
  /**
   * initialize a user, including name, last name, phone, 
   * and initialization of the data structure of the user
   * @param name name of the user
   * @param lastName last name of the user
   * @param phone phone of the user, represented by a string
   */
  User(String name, String lastName, String phone) {
    this.name = name;
    this.lastName = lastName;
    this.phone = phone;
    ownedParkingSpots = new LinkedHashMap<>();
    freeRentSlots = new LinkedHashMap<>();
    usedRentSlots = new LinkedHashMap<>();
  }

  /**
   * 
   * @see parking.Seller#letParkingSlot(int, int)
   * @fluent.ly.Changed
   * @throws IllegalArgumentException on spotID < 0 or slotID < 0
   * @throws IllegalArgumentException if spotID is not associated with parking spot
   * @throws IllegalArgumentException if rent slot not available to renting
   */
  @Override public void letParkingSlot(Buyer b, int spotID, int slotID) {
    if (spotID < 0 || slotID < 0)
      throw new IllegalArgumentException();
    if(!checkParkingBelongsToUser(spotID))
      throw new IllegalArgumentException(); //TODO: specify later
    Map<Integer, RentSlot> usedRentSlotsOfPSpot = usedRentSlots.get(box.it(spotID));
    if(usedRentSlotsOfPSpot.containsKey(box.it(slotID)))
      throw new IllegalArgumentException(); //TODO: specify later
    Map<Integer, RentSlot> freeRentSlotsOfPSpot = freeRentSlots.get(box.it(spotID));
    if(!freeRentSlotsOfPSpot.containsKey(box.it(slotID)))
      throw new IllegalArgumentException(); //TODO: specify later
    RentSlot rs = freeRentSlotsOfPSpot.remove(box.it(slotID));
    rs.setBuyer(b);
    usedRentSlotsOfPSpot.put(box.it(slotID), rs);
  }

  /**
   * 
   * @see parking.Seller#unletParkingSlot(int, int)
   * @fluent.ly.Changed
   * @throws IllegalArgumentException if spotID < 0 or slotID < 0
   * @throws IllegalArgumentException if spotID is not associated with parking spot
   * @throws IllegalArgumentException if rent slot is not rented
   */
  @Override public void unletParkingSlot(int spotID, int slotID) {
    if (spotID < 0 || slotID < 0)
      throw new IllegalArgumentException();
    if(!checkParkingBelongsToUser(spotID))
      throw new IllegalArgumentException(); //TODO: specify later
    Map<Integer, RentSlot> freeRentSlotsOfPSpot = freeRentSlots.get(box.it(spotID));
    if(freeRentSlotsOfPSpot.containsKey(box.it(slotID)))
      throw new IllegalArgumentException(); //TODO: specify later
    Map<Integer, RentSlot> usedRentSlotsOfPSpot = usedRentSlots.get(box.it(spotID));
    if(!usedRentSlotsOfPSpot.containsKey(box.it(slotID)))
      throw new IllegalArgumentException(); //TODO: specify later
    RentSlot rs = usedRentSlotsOfPSpot.remove(box.it(slotID));
    rs.setBuyer(null);
    freeRentSlotsOfPSpot.put(box.it(slotID), rs);
  }

  /**
   * 
   * @see parking.Buyer#getAllAvailableSlots()
   * @fluent.ly.Changed
   */
  @Override public List<RentSlot> getAllAvailableSlots() {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * 
   * @see parking.Seller#addParkingSpot(parking.Address)
   * @fluent.ly.Changed
   * @throws NullPointerException is Address given is null
   */
  @Override public void addParkingSpot(Address a) {
    // tests of validity of address and parkingSpot in class ParkingSpot
    ParkingSpot p = new ParkingSpot(a);
    p.setOwner(this);
    ownedParkingSpots.put(box.it(p.getId()), p);
    freeRentSlots.put(box.it(p.getId()), new LinkedHashMap<>());
    usedRentSlots.put(box.it(p.getId()), new LinkedHashMap<>());
  }

  /**
   * 
   * @see parking.Seller#removeParkingSpot(int)
   * @fluent.ly.Changed
   * @throws IllegalArgumentException if spotID < 0
   * @throws IllegalArgumentException if spotID is not associated with parking spot
   */
  @Override public void removeParkingSpot(int spotID) {
    if (spotID < 0)
      throw new IllegalArgumentException();
    if (!checkParkingBelongsToUser(spotID))
      throw new IllegalArgumentException();// TODO: specify the exception
    ownedParkingSpots.remove(box.it(spotID));
    freeRentSlots.remove(box.it(spotID));
    for (RentSlot urs : usedRentSlots.get(box.it(spotID)).values())
      urs.getBuyer().notifyRentSlotRemoved(urs);
    usedRentSlots.remove(box.it(spotID));
  }

  /**
   * 
   * @see parking.Seller#addRentSlot(parking.ParkingSpot, parking.Time, double)
   * @fluent.ly.Changed
   * @throws NullPointerException if parking spot or time given are null
   * @throws IllegalArgumentException if spotID is not associated with parking spot
   * @throws IllegalArgumentException if time is conflicted with another rent slot of same parking spot
   */
  @Override public void addRentSlot(ParkingSpot s, Time t, double price) {
    if (s == null || t == null)
      throw new NullPointerException();
    if (price < 0)
      throw new IllegalArgumentException();
    if (!checkParkingBelongsToUser(s.getId()))
      throw new IllegalArgumentException(); // TODO: specify later
    Map<Integer, RentSlot> freeRentSlotsOfS = freeRentSlots.get(box.it(s.getId()));
    for (RentSlot rs : freeRentSlotsOfS.values())
      if (t.isConflicting(rs.getTime()))
        throw new IllegalArgumentException(); // TODO: specify error later
    for (RentSlot rs : usedRentSlots.get(box.it(s.getId())).values())
      if (t.isConflicting(rs.getTime()))
        throw new IllegalArgumentException(); // TODO: specify error later
    RentSlot newRs = new RentSlot(this, s, t, price);
    freeRentSlotsOfS.put(box.it(newRs.getId()), newRs);
  }

  /**
   * 
   * @see parking.Seller#removeRentSlot(int, int)
   * @fluent.ly.Changed
   * @throws IllegalArgumentException if spotID < 0 or slotID < 0
   * @throws IllegalArgumentException if spotID is not associated with parking spot
   */
  @Override public void removeRentSlot(int spotID, int slotID) {
    if (spotID < 0 || slotID < 0)
      throw new IllegalArgumentException();
    if (!checkParkingBelongsToUser(spotID))
      throw new IllegalArgumentException(); // TODO: specify later
    Map<Integer, RentSlot> freeRentSlotsOfPSpot = freeRentSlots.get(box.it(spotID));
    if(freeRentSlotsOfPSpot.containsKey(box.it(slotID))) {
      freeRentSlotsOfPSpot.get(box.it(slotID)).closeRentSlot();
      freeRentSlotsOfPSpot.remove(box.it(slotID));
      return;
    }
    Map<Integer, RentSlot> usedRentSlotsOfPSpot = usedRentSlots.get(box.it(spotID));
    if(usedRentSlotsOfPSpot.containsKey(box.it(slotID))) {
      RentSlot rs = usedRentSlotsOfPSpot.get(box.it(slotID));
      rs.getBuyer().notifyRentSlotRemoved(rs);
      rs.closeRentSlot();
      usedRentSlotsOfPSpot.remove(box.it(slotID));
    }
    else
      throw new IllegalArgumentException(); //TODO: specify later
  }

  /**
   * 
   * @see parking.Seller#updateParkingSpotPrice(int, double)
   * @fluent.ly.Changed
   * @throws IllegalArgumentException if spotID < 0
   * @throws IllegalArgumentException if spotID is not associated with parking spot
   */
  @Override public void updateParkingSpotPrice(int spotID, double change) {
    if (spotID < 0)
      throw new IllegalArgumentException();
    if (!checkParkingBelongsToUser(spotID))
      throw new IllegalArgumentException(); // TODO: specify later
    for (RentSlot rs : freeRentSlots.get(box.it(spotID)).values())
      rs.setPrice(rs.getPrice() + change);
    for (RentSlot rs : usedRentSlots.get(box.it(spotID)).values()) {
      rs.getBuyer().notifyNewPrice(rs.getPrice() + change, rs);
      rs.setPrice(rs.getPrice() + change);
    }
  }

  /**
   * 
   * @see parking.Seller#updateRentSlotPrice(int, int, double)
   * @fluent.ly.Changed
   * @throws IllegalArgumentException if spotID is not associated with parking spot
   */
  @Override public void updateRentSlotPrice(int spotID, int slotID, double price) {
    if (spotID < 0 || slotID < 0 || price < 0)
      throw new IllegalArgumentException();
    if (!checkParkingBelongsToUser(spotID))
      throw new IllegalArgumentException(); // TODO: specify later
    RentSlot rs = freeRentSlots.get(box.it(spotID)).get(box.it(slotID));
    if (rs != null) {
      rs.setPrice(price);
      return;
    }
    rs = usedRentSlots.get(box.it(spotID)).get(box.it(slotID));
    if (rs == null)
      return; // TODO: display message rentSlotNotExist
    rs.getBuyer().notifyNewPrice(price, rs);
    rs.setPrice(price);
  }

  /**
   * 
   * @see parking.Seller#getOwnedParkingSpots()
   * @fluent.ly.Changed
   */
  @Override public List<ParkingSpot> getOwnedParkingSpots() {
    return new ArrayList<>(ownedParkingSpots.values());
  }

  /**
   * 
   * @see parking.Seller#getAllSlotsBySpotID(int)
   * @fluent.ly.Changed
   * @throws IllegalArgumentException if spotID is not associated with parking spot
   */
  @Override public List<RentSlot> getAllSlotsBySpotID(int spotID) {
    if(!checkParkingBelongsToUser(spotID))
      throw new IllegalArgumentException(); //TODO: specify exception
    return User.union(freeRentSlots.get(box.it(spotID)).values(), usedRentSlots.get(box.it(spotID)).values());
  }
  
  /**
   * 
   * @see parking.Seller#getAllFreeSlotsBySpotID(int)
   * @fluent.ly.Changed
   * @throws IllegalArgumentException if spotID is not associated with parking spot
   */
  @Override public List<RentSlot> getAllFreeSlotsBySpotID(int spotID) {
    if(!checkParkingBelongsToUser(spotID))
      throw new IllegalArgumentException(); //TODO: specify exception
    return new ArrayList<>(freeRentSlots.get(box.it(spotID)).values());
  }
  
  /**
   * 
   * @see parking.Seller#getAllUsedSlotsBySpotID(int)
   * @fluent.ly.Changed
   * @throws IllegalArgumentException if spotID is not associated with parking spot
   */
  @Override public List<RentSlot> getAllUsedSlotsBySpotID(int spotID) {
    if(!checkParkingBelongsToUser(spotID))
      throw new IllegalArgumentException(); //TODO: specify exception
    return new ArrayList<>(usedRentSlots.get(box.it(spotID)).values());
  }

  /**
   * 
   * @see parking.Seller#getAllRentSlots()
   * @fluent.ly.Changed
   */
  @Override public List<RentSlot> getAllRentSlots() {
    Set<RentSlot> $ = new HashSet<>();
    for(Map<Integer, RentSlot> f : freeRentSlots.values()) 
      $.addAll(f.values());
    for(Map<Integer, RentSlot> f : usedRentSlots.values()) 
      $.addAll(f.values());
    return new ArrayList<>($);
  }
  
  /**
   * 
   * @see parking.Seller#getAllFreeRentSlots()
   * @fluent.ly.Changed
   */
  @Override public List<RentSlot> getAllFreeRentSlots() {
    Set<RentSlot> $ = new HashSet<>();
    for(Map<Integer, RentSlot> f : freeRentSlots.values()) 
      $.addAll(f.values());
    return new ArrayList<>($);
  }
  
  /**
   * 
   * @see parking.Seller#getAllUsedRentSlots()
   * @fluent.ly.Changed
   */
  @Override public List<RentSlot> getAllUsedRentSlots() {
    Set<RentSlot> $ = new HashSet<>();
    for(Map<Integer, RentSlot> f : usedRentSlots.values()) 
      $.addAll(f.values());
    return new ArrayList<>($);
  }

  /**
   * 
   * @see parking.Buyer#notifyNewPrice(double, parking.RentSlot)
   * @fluent.ly.Changed
   */
  @Override public void notifyNewPrice(double price, RentSlot s) {
    // TODO Auto-generated method stub
  }

  /**
   * 
   * @see parking.Buyer#notifyRentSlotRemoved(parking.RentSlot)
   * @fluent.ly.Changed
   */
  @Override public void notifyRentSlotRemoved(RentSlot s) {
    // TODO Auto-generated method stub
  }

  /**
   * 
   * @param spotID the identifier of a parking spot
   * @return True if parking spot belongs to this user
   *         False otherwise
   */
  private boolean checkParkingBelongsToUser(int spotID) {
    return ownedParkingSpots.containsKey(box.it(spotID));
  }
  
  /**
   * 
   * @param <T> the type of the collections
   * @param list1
   * @param list2
   * @return union of those 2 lists
   */
  private static <T> List<T> union(Collection<T> list1, Collection<T> list2) {
    Set<T> set = new HashSet<>();

    set.addAll(list1);
    set.addAll(list2);

    return new ArrayList<>(set);
  }

  /**
   * 
   * @see parking.Buyer#rentParkingSlot(parking.Seller, int, int)
   * @fluent.ly.Changed
   */
  @Override public void rentParkingSlot(Seller s, int spotID, int slotID) {
    s.letParkingSlot(this, spotID, slotID);
  }

  /**
   * 
   * @see parking.Buyer#unrentParkingSlot(parking.Seller, int, int)
   * @fluent.ly.Changed
   */
  @Override public void unrentParkingSlot(Seller s, int spotID, int slotID) {
    s.unletParkingSlot(spotID, slotID);
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
}
