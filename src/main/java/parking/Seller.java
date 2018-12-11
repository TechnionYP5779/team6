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
   * @param a address of the parking spot
   */
  void addParkingSpot(Address a);

  /**
   * Add a rent slot, means slot of time that a buyer can rent the parking spot for the fit price
   * @param s a parking spot
   * @param t the time which this parking spot can be rented in
   * @param price the price of the rent slot
   */
  void addRentSlot(ParkingSpot s, Time t, double price);

  /**
   * Remove a parking spot of a seller.
   * Will handle all the rent slots associated with this parking spot,
   * and will notify the buyers of these slots, if exist.
   * @param spotID the id of the parking spot
   */
  void removeParkingSpot(int spotID);

  /**
   * Remove a rent slot that belongs to the seller.
   * Will notify the buyer of this slot, if exist.
   * @param spotID the id of the parking associated with the slot that will be removed
   * @param slotID the id of the rent slot
   */
  void removeRentSlot(int spotID, int slotID);

  /**
   * Updates all rent slots prices associated to the parking spot
   * Will notify the buyers of these slots, if exist.
   * @param spotID the id of the parking spot which its slots's price need update
   * @param change the amount that will be added to all rent slots belong to the parking spot
   */
  void updateParkingSpotPrice(int spotID, double change);
  
  /**
   * updates a rent slot price.
   * Will notify the buyer of this slot, if exist.
   * @param spotID the id of the parking associated with the slot which its price needs update
   * @param slotID the id of the rent slot
   * @param price the new price of the rent slot
   */
  void updateRentSlotPrice(int spotID, int slotID, double price);

  /**
   * 
   * @return list of parking spots which belong to the seller, arranged in order of income parking spots. 
   */
  List<ParkingSpot> getOwnedParkingSpots();

  /**
   * 
   * @param spotID the id of the parking spot it slots will be returned
   * @return list of the slots associated with the parking spot. No order guaranteed.
   */
  List<RentSlot> getAllSlotsBySpotID(int spotID);

  /**
   * 
   * @return list of all rent slots of this seller. No order guaranteed
   */
  List<RentSlot> getAllRentSlots();

  /**
   * 
   * @param spotID the id of the parking spot it non-rented slots will be returned
   * @return list of all non-rented slots associated with the parking spot. No order guaranteed.
   */
  List<RentSlot> getAllFreeSlotsBySpotID(int spotID);

  /**
   * 
   * @param spotID the id of the parking spot it rented slots will be returned
   * @return list of rented slots associated with the parking spot. No order guaranteed.
   */
  List<RentSlot> getAllUsedSlotsBySpotID(int spotID);

  /**
   * let parking spot to a buyer, and update the fit lists accordingly
   * @param spotID the spot id which the rent slot associated with
   * @param slotID the slot id of the rent slot
   */
  void letParkingSlot(Buyer b, int spotID, int slotID);

  /**
   * unlet parking spot from a buyer, and update the fit lists accordingly
   * @param spotID the spot id which the rent slot associated with
   * @param slotID the slot id of the rented slot
   */
  void unletParkingSlot(int spotID, int slotID);

  /**
   * 
   * @return list of all unrented slots belong to this seller. Arranged in order of income parking spots, no second order guaranteed on rent slots. 
   */
  List<RentSlot> getAllFreeRentSlots();

  /**
   * 
   * @return list of all rented slots belong to this seller. Arranged in order of income parking spots, no second order guaranteed on rent slots.
   */
  List<RentSlot> getAllUsedRentSlots();
}
