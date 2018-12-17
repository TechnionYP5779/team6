package parking;

import java.util.*;

import fluent.ly.*;

/** a class that represents a user in the Parking project
 * @fluent.ly.Package parking
 * @fluent.ly.Since Dec 8, 2018
 * @fluent.ly.Author Or */
public class User implements Seller, Buyer {
  // user info will be in user package
  private String name;// meanwhile, for making unique users
  private String lastName;
  private String phone;
  // seller info
  private final Map<Integer, ParkingSpot> ownedParkingSpots; // parking spots this user owns
  private final Map<Integer, Map<Integer, RentSlot>> freeRentSlots; // slots of parking ready for renting
  private final Map<Integer, Map<Integer, RentSlot>> usedRentSlots; // slots of parking which already rented to someone
  // buyer info

  /** initialize a user, including name, last name, phone, and initialization of
   * the data structure of the user
   * @param name     name of the user
   * @param lastName last name of the user
   * @param phone    phone of the user, represented by a string */
  User(final String name, final String lastName, final String phone) {
    this.name = name;
    this.lastName = lastName;
    this.phone = phone;
    ownedParkingSpots = new LinkedHashMap<>();
    freeRentSlots = new LinkedHashMap<>();
    usedRentSlots = new LinkedHashMap<>();
  }

  /** @see parking.Seller#letParkingSlot(int, int)
   * @fluent.ly.Changed
   * @throws IllegalArgumentException on spotID < 0 or slotID < 0
   * @throws IllegalArgumentException if spotID is not associated with parking
   *                                  spot
   * @throws IllegalArgumentException if rent slot not available to renting */
  @Override public void letParkingSlot(final Buyer b, final int spotID, final int slotID) {
    if (spotID < 0 || slotID < 0 || !checkParkingBelongsToUser(spotID))
      throw new IllegalArgumentException();
    final Map<Integer, RentSlot> usedRentSlotsOfPSpot = usedRentSlots.get(box.it(spotID));
    if (usedRentSlotsOfPSpot.containsKey(box.it(slotID)))
      throw new IllegalArgumentException();
    final Map<Integer, RentSlot> freeRentSlotsOfPSpot = freeRentSlots.get(box.it(spotID));
    if (!freeRentSlotsOfPSpot.containsKey(box.it(slotID)))
      throw new IllegalArgumentException();
    final RentSlot rs = freeRentSlotsOfPSpot.remove(box.it(slotID));
    rs.setBuyer(b);
    usedRentSlotsOfPSpot.put(box.it(slotID), rs);
  }

  /** @see parking.Seller#unletParkingSlot(int, int)
   * @fluent.ly.Changed
   * @throws IllegalArgumentException if spotID < 0 or slotID < 0
   * @throws IllegalArgumentException if spotID is not associated with parking
   *                                  spot
   * @throws IllegalArgumentException if rent slot is not rented */
  @Override public void unletParkingSlot(final int spotID, final int slotID) {
    if (spotID < 0 || slotID < 0 || !checkParkingBelongsToUser(spotID))
      throw new IllegalArgumentException();
    final Map<Integer, RentSlot> freeRentSlotsOfPSpot = freeRentSlots.get(box.it(spotID));
    if (freeRentSlotsOfPSpot.containsKey(box.it(slotID)))
      throw new IllegalArgumentException();
    final Map<Integer, RentSlot> usedRentSlotsOfPSpot = usedRentSlots.get(box.it(spotID));
    if (!usedRentSlotsOfPSpot.containsKey(box.it(slotID)))
      throw new IllegalArgumentException();
    final RentSlot rs = usedRentSlotsOfPSpot.remove(box.it(slotID));
    rs.setBuyer(null);
    freeRentSlotsOfPSpot.put(box.it(slotID), rs);
  }

  /** @see parking.Buyer#getAllAvailableSlots()
   * @fluent.ly.Changed */
  @Override public List<RentSlot> getAllAvailableSlots() {
    // TODO Auto-generated method stub
    return null;
  }

  /** @see parking.Seller#addParkingSpot(parking.Address)
   * @fluent.ly.Changed
   * @throws NullPointerException is Address given is null */
  @Override public void addParkingSpot(final Address a) {
    // tests of validity of address and parkingSpot in class ParkingSpot
    final ParkingSpot p = new ParkingSpot(a);
    p.setOwner(this);
    ownedParkingSpots.put(box.it(p.getId()), p);
    freeRentSlots.put(box.it(p.getId()), new LinkedHashMap<>());
    usedRentSlots.put(box.it(p.getId()), new LinkedHashMap<>());
  }

  /** @see parking.Seller#removeParkingSpot(int)
   * @fluent.ly.Changed
   * @throws IllegalArgumentException if spotID < 0
   * @throws IllegalArgumentException if spotID is not associated with parking
   *                                  spot */
  @Override public void removeParkingSpot(final int spotID) {
    if (spotID < 0 || !checkParkingBelongsToUser(spotID))
      throw new IllegalArgumentException();
    ownedParkingSpots.remove(box.it(spotID));
    freeRentSlots.remove(box.it(spotID));
    for (final RentSlot urs : usedRentSlots.get(box.it(spotID)).values())
      urs.getBuyer().notifyRentSlotRemoved(urs);
    usedRentSlots.remove(box.it(spotID));
  }

  /** @see parking.Seller#addRentSlot(parking.ParkingSpot, parking.Time, double)
   * @fluent.ly.Changed
   * @throws NullPointerException     if parking spot or time given are null
   * @throws IllegalArgumentException if spotID is not associated with parking
   *                                  spot
   * @throws IllegalArgumentException if time is conflicted with another rent slot
   *                                  of same parking spot */
  @Override public void addRentSlot(final ParkingSpot s, final Time t, final double price) {
    if (s == null || t == null)
      throw new NullPointerException();
    if (price < 0 || !checkParkingBelongsToUser(s.getId()))
      throw new IllegalArgumentException();
    final Map<Integer, RentSlot> freeRentSlotsOfS = freeRentSlots.get(box.it(s.getId()));
    for (final RentSlot ¢ : freeRentSlotsOfS.values())
      if (t.isConflicting(¢.getTime()))
        throw new IllegalArgumentException();
    for (final RentSlot ¢ : usedRentSlots.get(box.it(s.getId())).values())
      if (t.isConflicting(¢.getTime()))
        throw new IllegalArgumentException();
    final RentSlot newRs = new RentSlot(this, s, t, price);
    freeRentSlotsOfS.put(box.it(newRs.getId()), newRs);
  }

  /** @see parking.Seller#removeRentSlot(int, int)
   * @fluent.ly.Changed
   * @throws IllegalArgumentException if spotID < 0 or slotID < 0
   * @throws IllegalArgumentException if spotID is not associated with parking
   *                                  spot */
  @Override public void removeRentSlot(final int spotID, final int slotID) {
    if (spotID < 0 || slotID < 0 || !checkParkingBelongsToUser(spotID))
      throw new IllegalArgumentException();
    final Map<Integer, RentSlot> freeRentSlotsOfPSpot = freeRentSlots.get(box.it(spotID));
    if (freeRentSlotsOfPSpot.containsKey(box.it(slotID))) {
      freeRentSlotsOfPSpot.get(box.it(slotID)).closeRentSlot();
      freeRentSlotsOfPSpot.remove(box.it(slotID));
      return;
    }
    final Map<Integer, RentSlot> usedRentSlotsOfPSpot = usedRentSlots.get(box.it(spotID));
    if (!usedRentSlotsOfPSpot.containsKey(box.it(slotID)))
      throw new IllegalArgumentException();
    final RentSlot rs = usedRentSlotsOfPSpot.get(box.it(slotID));
    rs.getBuyer().notifyRentSlotRemoved(rs);
    rs.closeRentSlot();
    usedRentSlotsOfPSpot.remove(box.it(slotID));
  }

  /** @see parking.Seller#updateParkingSpotPrice(int, double)
   * @fluent.ly.Changed
   * @throws IllegalArgumentException if spotID < 0
   * @throws IllegalArgumentException if spotID is not associated with parking
   *                                  spot */
  @Override public void updateParkingSpotPrice(final int spotID, final double change) {
    if (spotID < 0 || !checkParkingBelongsToUser(spotID))
      throw new IllegalArgumentException();
    for (final RentSlot ¢ : freeRentSlots.get(box.it(spotID)).values())
      ¢.setPrice(¢.getPrice() + change);
    for (final RentSlot ¢ : usedRentSlots.get(box.it(spotID)).values()) {
      ¢.getBuyer().notifyNewPrice(¢.getPrice() + change, ¢);
      ¢.setPrice(¢.getPrice() + change);
    }
  }

  /** @see parking.Seller#updateRentSlotPrice(int, int, double)
   * @fluent.ly.Changed
   * @throws IllegalArgumentException if spotID is not associated with parking
   *                                  spot */
  @Override public void updateRentSlotPrice(final int spotID, final int slotID, final double price) {
    if (spotID < 0 || slotID < 0 || price < 0 || !checkParkingBelongsToUser(spotID))
      throw new IllegalArgumentException();
    RentSlot rs = freeRentSlots.get(box.it(spotID)).get(box.it(slotID));
    if (rs != null) {
      rs.setPrice(price);
      return;
    }
    rs = usedRentSlots.get(box.it(spotID)).get(box.it(slotID));
    if (rs == null)
      return;
    rs.getBuyer().notifyNewPrice(price, rs);
    rs.setPrice(price);
  }

  /** @see parking.Seller#getOwnedParkingSpots()
   * @fluent.ly.Changed */
  @Override public List<ParkingSpot> getOwnedParkingSpots() {
    return new ArrayList<>(ownedParkingSpots.values());
  }

  /** @see parking.Seller#getAllSlotsBySpotID(int)
   * @fluent.ly.Changed
   * @throws IllegalArgumentException if spotID is not associated with parking
   *                                  spot */
  @Override public List<RentSlot> getAllSlotsBySpotID(final int spotID) {
    if (!checkParkingBelongsToUser(spotID))
      throw new IllegalArgumentException(); // TODO: specify exception
    return User.union(freeRentSlots.get(box.it(spotID)).values(), usedRentSlots.get(box.it(spotID)).values());
  }

  /** @see parking.Seller#getAllFreeSlotsBySpotID(int)
   * @fluent.ly.Changed
   * @throws IllegalArgumentException if spotID is not associated with parking
   *                                  spot */
  @Override public List<RentSlot> getAllFreeSlotsBySpotID(final int spotID) {
    if (!checkParkingBelongsToUser(spotID))
      throw new IllegalArgumentException(); // TODO: specify exception
    return new ArrayList<>(freeRentSlots.get(box.it(spotID)).values());
  }

  /** @see parking.Seller#getAllUsedSlotsBySpotID(int)
   * @fluent.ly.Changed
   * @throws IllegalArgumentException if spotID is not associated with parking
   *                                  spot */
  @Override public List<RentSlot> getAllUsedSlotsBySpotID(final int spotID) {
    if (!checkParkingBelongsToUser(spotID))
      throw new IllegalArgumentException(); // TODO: specify exception
    return new ArrayList<>(usedRentSlots.get(box.it(spotID)).values());
  }

  /** @see parking.Seller#getAllRentSlots()
   * @fluent.ly.Changed */
  @Override public List<RentSlot> getAllRentSlots() {
    final Set<RentSlot> $ = new HashSet<>();
    for (final Map<Integer, RentSlot> f : freeRentSlots.values())
      $.addAll(f.values());
    for (final Map<Integer, RentSlot> f : usedRentSlots.values())
      $.addAll(f.values());
    return new ArrayList<>($);
  }

  /** @see parking.Seller#getAllFreeRentSlots()
   * @fluent.ly.Changed */
  @Override public List<RentSlot> getAllFreeRentSlots() {
    final Set<RentSlot> $ = new HashSet<>();
    for (final Map<Integer, RentSlot> f : freeRentSlots.values())
      $.addAll(f.values());
    return new ArrayList<>($);
  }

  /** @see parking.Seller#getAllUsedRentSlots()
   * @fluent.ly.Changed */
  @Override public List<RentSlot> getAllUsedRentSlots() {
    final Set<RentSlot> $ = new HashSet<>();
    for (final Map<Integer, RentSlot> f : usedRentSlots.values())
      $.addAll(f.values());
    return new ArrayList<>($);
  }

  /** @see parking.Buyer#notifyNewPrice(double, parking.RentSlot)
   * @fluent.ly.Changed */
  @Override public void notifyNewPrice(final double price, final RentSlot __) {
    // TODO Auto-generated method stub
  }

  /** @see parking.Buyer#notifyRentSlotRemoved(parking.RentSlot)
   * @fluent.ly.Changed */
  @Override public void notifyRentSlotRemoved(final RentSlot __) {
    // TODO Auto-generated method stub
  }

  /** @param spotID the identifier of a parking spot
   * @return True if parking spot belongs to this user False otherwise */
  private boolean checkParkingBelongsToUser(final int spotID) {
    return ownedParkingSpots.containsKey(box.it(spotID));
  }

  /** @param   <T> the type of the collections
   * @param list1
   * @param list2
   * @return union of those 2 lists */
  private static <T> List<T> union(final Collection<T> list1, final Collection<T> list2) {
    final Set<T> $ = new HashSet<>(list1);
    $.addAll(list2);
    return new ArrayList<>($);
  }

  /** @see parking.Buyer#rentParkingSlot(parking.Seller, int, int)
   * @fluent.ly.Changed */
  @Override public void rentParkingSlot(final Seller s, final int spotID, final int slotID) {
    s.letParkingSlot(this, spotID, slotID);
  }

  /** @see parking.Buyer#unrentParkingSlot(parking.Seller, int, int)
   * @fluent.ly.Changed */
  @Override public void unrentParkingSlot(final Seller s, final int spotID, final int slotID) {
    s.unletParkingSlot(spotID, slotID);
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(final String lastName) {
    this.lastName = lastName;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(final String phone) {
    this.phone = phone;
  }
}
