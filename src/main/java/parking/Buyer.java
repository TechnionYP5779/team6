package parking;

import java.util.*;

/**
 * this interface includes basic functions of a buyer
 * @fluent.ly.Package parking
 * @fluent.ly.Since Dec 8, 2018
 * @fluent.ly.Author Or, Nitzan
 */

public interface Buyer {
  /**
   * Buyer rents a slot from the seller.
   * Will notify the seller in this renting.
   * @param s the seller who rents the slot
   * @param spotID the id of the parking spot associated with the slot
   * @param slotID the id of the slot
   */
  void rentParkingSlot(Seller s, int spotID, int slotID);

  /**
   * Buyer unrents a slot from the seller.
   * Will notify the seller in this unrenting.
   * @param s the seller who rents the slot
   * @param spotID the id of the parking spot associated with the slot
   * @param slotID the id of the slot
   */
  void unrentParkingSlot(Seller s, int spotID, int slotID);

  /**
   * 
   * @return all available slots of all users
   */
  List<RentSlot> getAllAvailableSlots();

  //List<RentSlot> getRequstedSlots(Address a);

  /**
   * notify the buyer of the new price of the slot
   * @param price new price
   * @param s the slot its price updated
   */
  void notifyNewPrice(double price, RentSlot s);

  /**
   * notify the buyer that the slot have been removed
   * @param s the slot which was removed
   */
  void notifyRentSlotRemoved(RentSlot s);
}
