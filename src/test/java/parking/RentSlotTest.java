package parking;

import static fluent.ly.azzert.*;

import java.util.*;

import org.junit.*;

import fluent.ly.*;
/**
 * 
 * @fluent.ly.Package parking
 * @fluent.ly.Since Dec 8, 2018
 * @fluent.ly.Author Or
 */
@SuppressWarnings({"static-method", "unused"}) public class RentSlotTest {  
   @Test public void rebtSlotFuncsTest () {
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
}

