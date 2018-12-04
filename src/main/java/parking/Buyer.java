package parking;

import java.util.*;

public interface Buyer {
  void rentParkingSlot(int spotID, int slotID);

  void unrentParkingSlot(int spotID, int slotID);

  List<RentSlot> getAllAvailableSlots();

  List<RentSlot> getRequstedSlots(Address a);
}
