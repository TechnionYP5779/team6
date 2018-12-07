package parking;

import java.util.*;

import fluent.ly.*;

public class User implements Seller, Buyer {
  // user info will be in user package
  // seller info
  private Map<Integer, Map<Integer, RentSlot>> freeRentSlots; // slots of parking ready for renting
  private Map<Integer, Map<Integer, RentSlot>> usedRentSlots; // slots of parking which already rented to someone

  // buyer info
  User() {
    freeRentSlots = new HashMap<>();
    usedRentSlots = new HashMap<>();
  }

  @Override public void rentParkingSlot(int spotID, int slotID) {
    if (spotID < 0 || slotID < 0)
      throw new IllegalArgumentException();
  }

  @Override public void unrentParkingSlot(int spotID, int slotID) {
    // TODO Auto-generated method stub
  }

  @Override public List<RentSlot> getAllAvailableSlots() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override public List<RentSlot> getRequstedSlots(Address a) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override public void addParkingSpot(Address a) {
    // tests of validity of address and parkingSpot in class ParkingSpot
    ParkingSpot p = new ParkingSpot(a);
    p.setOwner(this);
    freeRentSlots.put(box.it(p.getId()), new HashMap<>());
    usedRentSlots.put(box.it(p.getId()), new HashMap<>());
  }

  @Override public void removeParkingSpot(int spotID) {
    if (spotID < 0)
      throw new IllegalArgumentException();
    if (!checkParkingBelongsToUser(spotID))
      throw new IllegalArgumentException();// TODO: specify the exception
    freeRentSlots.remove(box.it(spotID));
    for (RentSlot urs : usedRentSlots.get(box.it(spotID)).values())
      urs.getBuyer().notifyRentSlotRemoved(urs);
    usedRentSlots.remove(box.it(spotID));
  }

  @Override public void addRentSlot(ParkingSpot s, Time t, double price) {
    if (s == null || t == null)
      throw new NullPointerException();
    if (price < 0)
      throw new IllegalArgumentException();
    if (!checkParkingBelongsToUser(s.getId()))
      throw new IllegalArgumentException(); // TODO: specify later
    RentSlot newRs = new RentSlot(this, s, t, price); // will check this is the owner of parkingSpot
    Map<Integer, RentSlot> freeRentSlotsOfS = freeRentSlots.get(box.it(s.getId()));
    for (RentSlot rs : freeRentSlotsOfS.values())
      if (t.isConflicting(rs.getTime()))
        throw new IllegalArgumentException(); // TODO: specify error later
    for (RentSlot rs : usedRentSlots.get(box.it(s.getId())).values())
      if (t.isConflicting(rs.getTime()))
        throw new IllegalArgumentException(); // TODO: specify error later
    freeRentSlotsOfS.put(box.it(newRs.getId()), newRs);
  }

  @Override public void removeRentSlot(int spotID, int slotID) {
    if (spotID < 0 || slotID < 0)
      throw new IllegalArgumentException();
  }

  @Override public void updateParkingSpotPrice(int spotID, double price) {
    if (spotID < 0 || price < 0)
      throw new IllegalArgumentException();
    if (!checkParkingBelongsToUser(spotID))
      throw new IllegalArgumentException(); // TODO: specify later
    for (RentSlot rs : freeRentSlots.get(box.it(spotID)).values())
      rs.setPrice(price);
    for (RentSlot rs : usedRentSlots.get(box.it(spotID)).values()) {
      rs.getBuyer().notifyNewPrice(price, rs);
      rs.setPrice(price);
    }
  }

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

  @Override public List<ParkingSpot> getOwnedParkingSpots() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override public List<RentSlot> getAllSlotsBySpotID(int spotID) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override public List<RentSlot> getAllRentSlots() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override public void notifyNewPrice(double price, RentSlot s) {
    // TODO Auto-generated method stub
  }

  @Override public void notifyRentSlotRemoved(RentSlot s) {
    // TODO Auto-generated method stub
  }

  private boolean checkParkingBelongsToUser(int spotID) {
    return freeRentSlots.containsKey(box.it(spotID));
  }
}
