package parking;

import java.util.*;

/** @Package: parking
 * @Since: 28 בנוב׳ 2018
 * @Author: user */
public interface Seller {
  void addParkingSpot(Address a);

  void addRentSlot(ParkingSpot s, Time t, double price);

  void removeParkingSpot(int spotID);

  void removeRentSlot(int spotID, int slotID);

  void updateParkingSpotPrice(int slotID, double price);

  // Will be internal function
  // ParkingSpot getParkingSpotByID(int spotID);
  List<ParkingSpot> getOwnedParkingSpots();

  List<RentSlot> getAllSlotsBySpotID(int spotID);

  List<RentSlot> getAllRentSlots();
}
