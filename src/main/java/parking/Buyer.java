package parking;

/** this interface includes basic functions of a buyer
 * @fluent.ly.Package parking
 * @fluent.ly.Since Dec 8, 2018
 * @fluent.ly.Author Or, Nitzan */
public interface Buyer {
  /** Buyer rents a slot from the seller.
   * @param s      the seller who rents the slot
   * @param spotID the id of the parking spot associated with the slot
   * @param slotID the id of the rent slot */
  void rentParkingSlot(Seller s, int spotID, int slotID);

  /** Buyer unrents a slot from the seller.
   * @param s      the seller who rents the slot
   * @param spotID the id of the parking spot associated with the slot
   * @param slotID the id of the rent slot */
  void unrentParkingSlot(Seller s, int spotID, int slotID);
  /** @return all available rent slots of all users */
  // List<RentSlot> getAllAvailableSlots();
  // // List<RentSlot> getRequstedSlots(Address a);
  // /** notify the buyer of the new price of a slot
  // * @param price new price
  // * @param s the rent slot its price updated */
  // void notifyNewPrice(double price, RentSlot s);
  //
  // /** notify the buyer that a rent slot have been removed
  // * @param s the rent slot which was removed */
  // void notifyRentSlotRemoved(RentSlot s);
}
