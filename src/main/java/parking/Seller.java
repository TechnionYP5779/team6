package parking;

import java.util.*;

/**
 * This interface includes basic functions of a seller
 * @fluent.ly.Package parking
 * @fluent.ly.Since Dec 8, 2018
 * @fluent.ly.Author Or, Nitzan
 */
public interface Seller {
  
  /**
   * Add parking spot to this seller 
   * @param a address of the parking spot that will be added
   */
  void addParkingSpot(Address a);

  /**
   * Add a rent slot, means slot of time that a buyer can rent the parking spot for the fit price
   * @param s a parking spot
   * @param t the time which this parking spot will be rented in
   * @param price the price of the time slot that will be added
   */
  void addRentSlot(ParkingSpot s, Time t, double price);

  /**
   * Remove a parking spot of a seller.
   * Will handle all the rent slots associated with this parking spot,
   * and will notify the buyers of these slots, if exist.
   * @param spotID the id of the parking to be removed
   */
  void removeParkingSpot(int spotID);

  /**
   * Remove a rent slot that belongs to the seller.
   * Will notify the buyer of this slot, if exist.
   * @param spotID the id of the parking associated with the slot that will be removed
   * @param slotID the id of the slot that will be removed
   */
  void removeRentSlot(int spotID, int slotID);

  /**
   * Updates all parking prices, according to the change the seller wants.
   * Will notify the buyers of the buyers of these slots, if exist.
   * @param spotID the id of the parking spot which its slots's price need update
   * @param change the amount that will be added to all rent slots belong to the parking spot
   */
  void updateParkingSpotPrice(int spotID, double change);
  
  /**
   * 
   * @param spotID the id of the parking associated with the slot which its price needs update
   * @param slotID the id of the slot which its price needs update
   * @param price the new price of the slot
   */
  void updateRentSlotPrice(int spotID, int slotID, double price);

  /**
   * 
   * @return list of parking spots which belong to the seller
   */
  List<ParkingSpot> getOwnedParkingSpots();

  /**
   * 
   * @param spotID the id of the parking spot it slots will be returned
   * @return the slots associated with the parking spot
   */
  List<RentSlot> getAllSlotsBySpotID(int spotID);

  /**
   * 
   * @return list of all rent slots of this seller
   */
  List<RentSlot> getAllRentSlots();

  /**
   * 
   * @param spotID the id of the parking spot it non-rented slots will be returned
   * @return list of non-rented slots associated with the parking spot
   */
  List<RentSlot> getAllFreeSlotsBySpotID(int spotID);

  /**
   * 
   * @param spotID the id of the parking spot it rented slots will be returned
   * @return list of rented slots associated with the parking spot
   */
  List<RentSlot> getAllUsedSlotsBySpotID(int spotID);

  /**
   * let parking spot to a buyer, and update the fit lists accordingly
   * @param spotID the spot id which the rent slot associated with
   * @param slotID the slot id of the rent slot
   */
  void letParkingSlot(int spotID, int slotID);

  /**
   * unlet parking spot from a buyer, and update the fit lists accordingly
   * @param spotID the spot id which the rent slot associated with
   * @param slotID the slot id of the rented slot
   */
  void unletParkingSlot(int spotID, int slotID);

  /**
   * 
   * @return list of all unrented slots belong to this seller
   */
  List<RentSlot> getAllFreeRentSlots();

  /**
   * 
   * @return list of all rented slots belong to this seller
   */
  List<RentSlot> getAllUsedRentSlots();
}
