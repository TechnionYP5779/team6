package parking;

import static fluent.ly.azzert.*;

import java.util.*;

import org.junit.*;

import fluent.ly.*;

/** @fluent.ly.Package parking
 * @fluent.ly.Since Dec 8, 2018
 * @fluent.ly.Author Or
 * @see RentSlot */
@SuppressWarnings({ "static-method", "unused" }) public class RentSlotTest {
  @Test public void rebtSlotFuncsTest() {
    Address a1 = new Address("Tel-Aviv", "King George", 5), a2 = new Address("Tel-Aviv", "King George", 5),
        a3 = new Address("Petah-Tikwa", "Hivner", 25), a4 = new Address("Raanana", "Kazan", 30);
    // save that addresses in a list
    List<Address> yossiAdd = new ArrayList<>();
    yossiAdd.add(a1);
    yossiAdd.add(a2);
    yossiAdd.add(a3);
    yossiAdd.add(a4);
    // create a new user named Yossi
    User yossi = new User("Yossi", "Cohen", "050-123-4567");
    // add some parking spots with the addresses above
    yossi.addParkingSpot(a1);
    yossi.addParkingSpot(a2);
    yossi.addParkingSpot(a3);
    yossi.addParkingSpot(a4);
    // setP p = list of the parking spots belong to Yossi. order is saved
    List<ParkingSpot> setP = yossi.getOwnedParkingSpots();
    ParkingSpot pOfYossi1 = setP.get(0), pOfYossi2 = setP.get(1);
    // add rent slot to the first parking spot of Yossi.No buyer to this rent slot
    yossi.addRentSlot(pOfYossi1, new Time(Time.WeekDay.Sunday, new Time.DayTime(10, 53), new Time.DayTime(13, 30)), 23.5);
    assert yossi.getAllFreeRentSlots().get(0).getBuyer() == null;
    // try adding rent slot that its time conflict with the rent slot just added
    boolean check = false;
    try {
      yossi.addRentSlot(pOfYossi1, new Time(Time.WeekDay.Sunday, new Time.DayTime(10, 53), new Time.DayTime(13, 30)), 23.5);
    } catch (IllegalArgumentException e) {
      check = true;
    }
    assert check;
    // add some rent slots to the first parking
    yossi.addRentSlot(pOfYossi1, new Time(Time.WeekDay.Monday, new Time.DayTime(10, 53), new Time.DayTime(13, 30)), 23.5);
    yossi.addRentSlot(pOfYossi1, new Time(Time.WeekDay.Monday, new Time.DayTime(14, 53), new Time.DayTime(20, 30)), 30);
    yossi.addRentSlot(pOfYossi1, new Time(Time.WeekDay.Saturday, new Time.DayTime(14, 53), new Time.DayTime(16, 30)), 30);
    //// try adding rent slot that its time conflict with the rent slot just added
    check = false;
    try {
      yossi.addRentSlot(pOfYossi1, new Time(Time.WeekDay.Saturday, new Time.DayTime(14, 53), new Time.DayTime(16, 30)), 30);
    } catch (IllegalArgumentException e) {
      check = true;
    }
    assert check;
    // each parking spot saved the number of slots associated to it, check this
    azzert.that(pOfYossi1.getNumOfSlots(), is(4));
    azzert.that(pOfYossi2.getNumOfSlots(), is(0));
    // add some rent slots to the second parking spot of Yossi
    yossi.addRentSlot(pOfYossi2, new Time(Time.WeekDay.Monday, new Time.DayTime(10, 53), new Time.DayTime(13, 30)), 23.5);
    yossi.addRentSlot(pOfYossi2, new Time(Time.WeekDay.Monday, new Time.DayTime(14, 53), new Time.DayTime(20, 30)), 30);
    yossi.addRentSlot(pOfYossi2, new Time(Time.WeekDay.Saturday, new Time.DayTime(14, 53), new Time.DayTime(16, 30)), 30);
    // check the number of slots in the parking spot updated correctly
    azzert.that(pOfYossi2.getNumOfSlots(), is(3));
    // get a list of all rent slots of parking 2 that has no buyer
    List<RentSlot> yossiFreeRentSlotsOfP = yossi.getAllFreeSlotsBySpotID(pOfYossi2.getId());
    azzert.that(yossiFreeRentSlotsOfP.size(), is(3));
    // some checks on that slots details
    azzert.that(pOfYossi2, is(yossiFreeRentSlotsOfP.get(0).getParkingSpot()));
    azzert.that(pOfYossi2, is(yossiFreeRentSlotsOfP.get(1).getParkingSpot()));
    azzert.that(pOfYossi2, is(yossiFreeRentSlotsOfP.get(2).getParkingSpot()));
    azzert.that(23.5, is(yossiFreeRentSlotsOfP.get(0).getPrice()));
    azzert.that(30, is(yossiFreeRentSlotsOfP.get(1).getPrice()));
    azzert.that(30, is(yossiFreeRentSlotsOfP.get(2).getPrice()));
    // change price of parking slot and check it
    yossiFreeRentSlotsOfP.get(0).setPrice(30);
    azzert.that(30, is(yossiFreeRentSlotsOfP.get(0).getPrice()));
    // assign buyer to parking slot and check it
    Buyer tamar = new User("Tamar", "Ohayon", "050-123-4568");
    yossiFreeRentSlotsOfP.get(0).setBuyer(tamar);
    azzert.that(tamar, is(yossiFreeRentSlotsOfP.get(0).getBuyer()));
    // remove parking slot and check that it was removed correctly
    yossi.removeRentSlot(pOfYossi2.getId(), yossiFreeRentSlotsOfP.get(0).getId());
    azzert.that(pOfYossi2.getNumOfSlots(), is(2));
    azzert.that(yossi.getAllFreeRentSlots().size(), is(6));
    // some null checks
    check = false;
    try {
      new RentSlot(null, pOfYossi1, new Time(Time.WeekDay.Monday, new Time.DayTime(10, 53), new Time.DayTime(13, 30)), 30.0);
    } catch (NullPointerException e) {
      check = true;
    }
    assert check;
    check = false;
    try {
      new RentSlot(yossi, null, new Time(Time.WeekDay.Monday, new Time.DayTime(10, 53), new Time.DayTime(13, 30)), 30.0);
    } catch (NullPointerException e) {
      check = true;
    }
    assert check;
    check = false;
    try {
      new RentSlot(yossi, pOfYossi1, null, 30.0);
    } catch (NullPointerException e) {
      check = true;
    }
    assert check;
    // check that only owner of parking spot can add a rent slot of the parking spot
    check = false;
    try {
      new RentSlot((User) tamar, pOfYossi1, new Time(Time.WeekDay.Monday, new Time.DayTime(10, 53), new Time.DayTime(13, 30)), 30.0);
    } catch (IllegalArgumentException e) {
      check = true;
    }
    assert check;
  }
}
