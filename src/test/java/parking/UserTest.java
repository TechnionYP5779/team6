package parking;

import static fluent.ly.azzert.*;

import java.util.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings({"static-method", "unused"}) public class UserTest {
  @Test public void addingAndRemovingParkingSpotsTest() {
    Address a1 = new Address("Tel-Aviv", "King George", 5);
    Address a2 = new Address("Tel-Aviv", "King George", 5);
    Address a3 = new Address("Petah-Tikwa", "Hivner", 25);
    Address a4 = new Address("Raanana", "Kazan", 30);
    List<Address> yossiAdd = new ArrayList<>();
    yossiAdd.add(a1);
    yossiAdd.add(a2);
    yossiAdd.add(a3);
    yossiAdd.add(a4);
    User yossi = new User("Yossi", "Cohen", "050-123-4567");
    Address a5 = new Address("Tel-Aviv", "King George", 10);
    Address a6 = new Address("Petah-Tikwa", "Hivner", 13);
    List<Address> tamarAdd = new ArrayList<>();
    tamarAdd.add(a5);
    tamarAdd.add(a6);
    User tamar = new User("Tamar", "Ohayon", "050-123-4568");
    yossi.addParkingSpot(a1);
    yossi.addParkingSpot(a2);
    yossi.addParkingSpot(a3);
    yossi.addParkingSpot(a4);
    tamar.addParkingSpot(a5);
    tamar.addParkingSpot(a6);
    List<ParkingSpot> setPYossi = yossi.getOwnedParkingSpots();
    azzert.that(setPYossi.size(), is(4));
    for (int ¢ = 0; ¢ < yossiAdd.size(); ++¢) {
      azzert.that(setPYossi.get(¢).getAddress(), is(yossiAdd.get(¢)));
      azzert.that(setPYossi.get(¢).getOwner(), is(yossi));
      azzert.that(setPYossi.get(¢).getNumOfSlots(), is(0));
    }
    List<ParkingSpot> setPTamar = tamar.getOwnedParkingSpots();
    azzert.that(setPTamar.size(), is(2));
    for (int ¢ = 0; ¢ < tamarAdd.size(); ++¢) {
      azzert.that(setPTamar.get(¢).getAddress(), is(tamarAdd.get(¢)));
      azzert.that(setPTamar.get(¢).getOwner(), is(tamar));
      azzert.that(setPTamar.get(¢).getNumOfSlots(), is(0));
    }
    yossi.removeParkingSpot(setPYossi.get(0).getId());
    boolean check = false;
    try {
      yossi.removeParkingSpot(setPYossi.get(0).getId());
    } catch (IllegalArgumentException e) {
      check = true;
    }
    assert check;
    setPYossi = yossi.getOwnedParkingSpots();
    azzert.that(setPYossi.size(), is(3));
    yossi.removeParkingSpot(setPYossi.get(1).getId());
    setPYossi = yossi.getOwnedParkingSpots();
    azzert.that(setPYossi.size(), is(2));
    
    setPTamar = tamar.getOwnedParkingSpots();
    azzert.that(setPTamar.size(), is(2));
  }

  @Test public void addingAndRemovingRentSlotsTest() {
    Address a1 = new Address("Tel-Aviv", "King George", 5);
    Address a2 = new Address("Tel-Aviv", "King George", 5);
    Address a3 = new Address("Petah-Tikwa", "Hivner", 25);
    Address a4 = new Address("Raanana", "Kazan", 30);
    List<Address> yossiAdd = new ArrayList<>();
    yossiAdd.add(a1);
    yossiAdd.add(a2);
    yossiAdd.add(a3);
    yossiAdd.add(a4);
    
    User yossi = new User("Yossi", "Cohen", "050-123-4567");
    
    yossi.addParkingSpot(a1);
    yossi.addParkingSpot(a2);
    yossi.addParkingSpot(a3);
    yossi.addParkingSpot(a4);
    
    List<ParkingSpot> setP = yossi.getOwnedParkingSpots();  
    
    ParkingSpot pOfYossi1 = setP.get(0);
    ParkingSpot pOfYossi2 = setP.get(1);
    
    yossi.addRentSlot(pOfYossi1, new Time(Time.WeekDay.Sunday, new Time.DayTime(10, 53), new Time.DayTime(13, 30)), 23.5);
    
    boolean check = false;
    try{
      yossi.addRentSlot(pOfYossi1, new Time(Time.WeekDay.Sunday, new Time.DayTime(10, 53), new Time.DayTime(13, 30)), 23.5);
    }
    catch(IllegalArgumentException e) {
      check = true;
    }
    assert check;
    
    yossi.addRentSlot(pOfYossi1, new Time(Time.WeekDay.Monday, new Time.DayTime(10, 53), new Time.DayTime(13, 30)), 23.5);
    yossi.addRentSlot(pOfYossi1, new Time(Time.WeekDay.Monday, new Time.DayTime(14, 53), new Time.DayTime(20, 30)), 30);
    yossi.addRentSlot(pOfYossi1, new Time(Time.WeekDay.Saturday, new Time.DayTime(14, 53), new Time.DayTime(16, 30)), 30);
    check = false;
    try{
      yossi.addRentSlot(pOfYossi1, new Time(Time.WeekDay.Saturday, new Time.DayTime(14, 53), new Time.DayTime(16, 30)), 30);
    }
    catch(IllegalArgumentException e) {
      check = true;
    }
    assert check;
    
    azzert.that(pOfYossi1.getNumOfSlots(), is(4));
    azzert.that(pOfYossi2.getNumOfSlots(), is(0));
    
    yossi.addRentSlot(pOfYossi2, new Time(Time.WeekDay.Monday, new Time.DayTime(10, 53), new Time.DayTime(13, 30)), 23.5);
    yossi.addRentSlot(pOfYossi2, new Time(Time.WeekDay.Monday, new Time.DayTime(14, 53), new Time.DayTime(20, 30)), 30);
    yossi.addRentSlot(pOfYossi2, new Time(Time.WeekDay.Saturday, new Time.DayTime(14, 53), new Time.DayTime(16, 30)), 30);
    
    azzert.that(pOfYossi2.getNumOfSlots(), is(3));
    
    List<RentSlot> yossiFreeRentSlotsOfP = yossi.getAllFreeSlotsBySpotID(pOfYossi2.getId());
    azzert.that(yossiFreeRentSlotsOfP.size(), is(3));
    
    yossi.removeRentSlot(pOfYossi2.getId(), yossiFreeRentSlotsOfP.get(0).getId());
    
    azzert.that(pOfYossi2.getNumOfSlots(), is(2));
    
    azzert.that(yossi.getAllFreeRentSlots().size(), is(6));
  }

  @Test public void letAndUnletTest() {
    Address a1 = new Address("Tel-Aviv", "King George", 5);
    Address a2 = new Address("Tel-Aviv", "King George", 5);
    Address a3 = new Address("Petah-Tikwa", "Hivner", 25);
    Address a4 = new Address("Raanana", "Kazan", 30);
    List<Address> yossiAdd = new ArrayList<>();
    yossiAdd.add(a1);
    yossiAdd.add(a2);
    yossiAdd.add(a3);
    yossiAdd.add(a4);
    
    User yossi = new User("Yossi", "Cohen", "050-123-4567");
    
    yossi.addParkingSpot(a1);
    yossi.addParkingSpot(a2);
    yossi.addParkingSpot(a3);
    yossi.addParkingSpot(a4);
    
    ParkingSpot pOfYossi1 = yossi.getOwnedParkingSpots().get(0);
    
    yossi.addRentSlot(pOfYossi1, new Time(Time.WeekDay.Sunday, new Time.DayTime(10, 53), new Time.DayTime(13, 30)), 23.5);    
    yossi.addRentSlot(pOfYossi1, new Time(Time.WeekDay.Monday, new Time.DayTime(10, 53), new Time.DayTime(13, 30)), 23.5);
    yossi.addRentSlot(pOfYossi1, new Time(Time.WeekDay.Monday, new Time.DayTime(14, 53), new Time.DayTime(20, 30)), 30);
    yossi.addRentSlot(pOfYossi1, new Time(Time.WeekDay.Saturday, new Time.DayTime(14, 53), new Time.DayTime(16, 30)), 30);

    
    List<RentSlot> freeRS = yossi.getAllFreeRentSlots();
    List<RentSlot> usedRS = yossi.getAllUsedRentSlots();
    azzert.that(freeRS.size(), is(4));
    azzert.that(usedRS.size(), is(0));
    yossi.letParkingSlot(freeRS.get(0).getParkingSpot().getId(), freeRS.get(0).getId());
    
    freeRS = yossi.getAllFreeRentSlots();
    usedRS = yossi.getAllUsedRentSlots();
    
    azzert.that(freeRS.size(), is(3));
    azzert.that(usedRS.size(), is(1));
  }
  
  @Test public void updatePriceOfRentSlot() {
    Address a1 = new Address("Tel-Aviv", "King George", 5);
    Address a2 = new Address("Tel-Aviv", "King George", 5);
    Address a3 = new Address("Petah-Tikwa", "Hivner", 25);
    Address a4 = new Address("Raanana", "Kazan", 30);
    List<Address> yossiAdd = new ArrayList<>();
    yossiAdd.add(a1);
    yossiAdd.add(a2);
    yossiAdd.add(a3);
    yossiAdd.add(a4);
    
    User yossi = new User("Yossi", "Cohen", "050-123-4567");
    
    yossi.addParkingSpot(a1);
    yossi.addParkingSpot(a2);
    yossi.addParkingSpot(a3);
    yossi.addParkingSpot(a4);
    
    List<ParkingSpot> setP = yossi.getOwnedParkingSpots();  
    
    ParkingSpot pOfYossi1 = setP.get(0);
    ParkingSpot pOfYossi2 = setP.get(1);
    
    yossi.addRentSlot(pOfYossi1, new Time(Time.WeekDay.Sunday, new Time.DayTime(10, 53), new Time.DayTime(13, 30)), 23.5);    
    yossi.addRentSlot(pOfYossi1, new Time(Time.WeekDay.Monday, new Time.DayTime(10, 53), new Time.DayTime(13, 30)), 23.5);
    yossi.addRentSlot(pOfYossi1, new Time(Time.WeekDay.Monday, new Time.DayTime(14, 53), new Time.DayTime(20, 30)), 30);
    yossi.addRentSlot(pOfYossi1, new Time(Time.WeekDay.Saturday, new Time.DayTime(14, 53), new Time.DayTime(16, 30)), 30);
   
    azzert.that(pOfYossi1.getNumOfSlots(), is(4));
    
    yossi.addRentSlot(pOfYossi2, new Time(Time.WeekDay.Monday, new Time.DayTime(10, 53), new Time.DayTime(13, 30)), 23.5);
    yossi.addRentSlot(pOfYossi2, new Time(Time.WeekDay.Monday, new Time.DayTime(14, 53), new Time.DayTime(20, 30)), 30);
    yossi.addRentSlot(pOfYossi2, new Time(Time.WeekDay.Saturday, new Time.DayTime(14, 53), new Time.DayTime(16, 30)), 30);
    
    azzert.that(pOfYossi2.getNumOfSlots(), is(3));
    
    List<RentSlot> freeRentSlots = yossi.getAllFreeSlotsBySpotID(pOfYossi1.getId());
    azzert.that(freeRentSlots.size(), is(4));
    azzert.that(freeRentSlots.get(0).getPrice(), is(23.5));
    azzert.that(freeRentSlots.get(1).getPrice(), is(23.5));
    azzert.that(freeRentSlots.get(2).getPrice(), is(30.0));
    azzert.that(freeRentSlots.get(3).getPrice(), is(30.0));
    
    yossi.updateParkingSpotPrice(pOfYossi1.getId(), 10);
    freeRentSlots = yossi.getAllFreeSlotsBySpotID(pOfYossi1.getId());
    azzert.that(freeRentSlots.get(0).getPrice(), is(33.5));
    azzert.that(freeRentSlots.get(1).getPrice(), is(33.5));
    azzert.that(freeRentSlots.get(2).getPrice(), is(40.0));
    azzert.that(freeRentSlots.get(3).getPrice(), is(40.0));
    
    yossi.updateParkingSpotPrice(pOfYossi1.getId(), -20);
    freeRentSlots = yossi.getAllFreeSlotsBySpotID(pOfYossi1.getId());
    azzert.that(freeRentSlots.get(0).getPrice(), is(13.5));
    azzert.that(freeRentSlots.get(1).getPrice(), is(13.5));
    azzert.that(freeRentSlots.get(2).getPrice(), is(20.0));
    azzert.that(freeRentSlots.get(3).getPrice(), is(20.0));
    
    freeRentSlots = yossi.getAllFreeSlotsBySpotID(pOfYossi2.getId());
    azzert.that(pOfYossi2.getNumOfSlots(), is(3));
    azzert.that(freeRentSlots.get(0).getPrice(), is(23.5));
    azzert.that(freeRentSlots.get(1).getPrice(), is(30.0));
    azzert.that(freeRentSlots.get(2).getPrice(), is(30.0));
    
    yossi.updateRentSlotPrice(pOfYossi2.getId(), freeRentSlots.get(0).getId(), 35);
    yossi.updateRentSlotPrice(pOfYossi2.getId(), freeRentSlots.get(2).getId(), 40);
    
    azzert.that(freeRentSlots.get(0).getPrice(), is(35.0));
    azzert.that(freeRentSlots.get(1).getPrice(), is(30.0));
    azzert.that(freeRentSlots.get(2).getPrice(), is(40.0));
  }

  
}
