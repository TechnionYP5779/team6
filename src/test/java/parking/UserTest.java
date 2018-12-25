
//package parking;
//
//import static fluent.ly.azzert.*;
//
//import java.util.*;
//
//import org.junit.*;
//
//import fluent.ly.*;
//
///** @fluent.ly.Package parking
// * @fluent.ly.Since Dec 11, 2018
// * @fluent.ly.Author Or
// * @fluent.ly.ClassDesc TODO
// * @see User */
//@SuppressWarnings({ "static-method", "unused" }) public class UserTest {
//  @Test public void addingAndRemovingParkingSpotsTest() {
//    // create a user named Yossi and add him some parking spots
//    User yossi = new User("Yossi", "Cohen", "050-123-4567");
//    Address a1 = new Address("Tel-Aviv", "King George", 5), a2 = new Address("Tel-Aviv", "King George", 5),
//        a3 = new Address("Petah-Tikwa", "Hivner", 25), a4 = new Address("Raanana", "Kazan", 30);
//    List<Address> yossiAdd = new ArrayList<>();// list of addresses of parking spots
//    yossiAdd.add(a1);
//    yossiAdd.add(a2);
//    yossiAdd.add(a3);
//    yossiAdd.add(a4);
//    yossi.addParkingSpot(a1);
//    yossi.addParkingSpot(a2);
//    yossi.addParkingSpot(a3);
//    yossi.addParkingSpot(a4);
//    // create a user named Tamar and add her some parking spots
//    User tamar = new User("Tamar", "Ohayon", "050-123-4568");
//    Address a5 = new Address("Tel-Aviv", "King George", 10), a6 = new Address("Petah-Tikwa", "Hivner", 13);
//    List<Address> tamarAdd = new ArrayList<>();// list of addresses of parking spots
//    tamarAdd.add(a5);
//    tamarAdd.add(a6);
//    tamar.addParkingSpot(a5);
//    tamar.addParkingSpot(a6);
//    // check that details of Yossi's parking spots are correct
//    List<ParkingSpot> setPYossi = yossi.getOwnedParkingSpots();
//    azzert.that(setPYossi.size(), is(4));
//    for (int ¢ = 0; ¢ < yossiAdd.size(); ++¢) {
//      azzert.that(setPYossi.get(¢).getAddress(), is(yossiAdd.get(¢)));
//      azzert.that(setPYossi.get(¢).getOwner(), is(yossi));
//      azzert.that(setPYossi.get(¢).getNumOfSlots(), is(0));
//    }
//    // check that details of Tamar's parking spots are correct
//    List<ParkingSpot> setPTamar = tamar.getOwnedParkingSpots();
//    azzert.that(setPTamar.size(), is(2));
//    for (int ¢ = 0; ¢ < tamarAdd.size(); ++¢) {
//      azzert.that(setPTamar.get(¢).getAddress(), is(tamarAdd.get(¢)));
//      azzert.that(setPTamar.get(¢).getOwner(), is(tamar));
//      azzert.that(setPTamar.get(¢).getNumOfSlots(), is(0));
//    }
//    // remove a parking spots, and check it realy removed
//    yossi.removeParkingSpot(setPYossi.get(0).getId());
//    boolean check = false;
//    try {
//      yossi.removeParkingSpot(setPYossi.get(0).getId());
//    } catch (IllegalArgumentException e) {
//      check = true;
//    }
//    assert check;
//    // some more removal of parking spots
//    setPYossi = yossi.getOwnedParkingSpots();
//    azzert.that(setPYossi.size(), is(3));
//    yossi.removeParkingSpot(setPYossi.get(1).getId());
//    setPYossi = yossi.getOwnedParkingSpots();
//    azzert.that(setPYossi.size(), is(2));
//    // check Tamar's parking spots didn't change
//    setPTamar = tamar.getOwnedParkingSpots();
//    azzert.that(setPTamar.size(), is(2));
//    // some exceptions checks
//    check = false;
//    try {
//      yossi.addParkingSpot(null);
//    } catch (NullPointerException e) {
//      check = true;
//    }
//    assert check;
//    check = false;
//    try {
//      yossi.removeParkingSpot(-1);
//    } catch (IllegalArgumentException e) {
//      check = true;
//    }
//    assert check;
//  }
//
//  @Test public void addingAndRemovingRentSlotsTest() {
//    // create a user named Yossi and add him some parking spots
//    User yossi = new User("Yossi", "Cohen", "050-123-4567");
//    Address a1 = new Address("Tel-Aviv", "King George", 5), a2 = new Address("Tel-Aviv", "King George", 5),
//        a3 = new Address("Petah-Tikwa", "Hivner", 25), a4 = new Address("Raanana", "Kazan", 30);
//    List<Address> yossiAdd = new ArrayList<>();// list of addresses of parking spots
//    yossiAdd.add(a1);
//    yossiAdd.add(a2);
//    yossiAdd.add(a3);
//    yossiAdd.add(a4);
//    yossi.addParkingSpot(a1);
//    yossi.addParkingSpot(a2);
//    yossi.addParkingSpot(a3);
//    yossi.addParkingSpot(a4);
//    // get 2 parking spots of Yossi
//    List<ParkingSpot> setP = yossi.getOwnedParkingSpots();
//    ParkingSpot pOfYossi1 = setP.get(0), pOfYossi2 = setP.get(1);
//    // add a rent slot to p1 of Yossi, and check it added
//    yossi.addRentSlot(pOfYossi1, new Time(Time.WeekDay.Sunday, new Time.DayTime(10, 53), new Time.DayTime(13, 30)), 23.5);
//    boolean check = false;
//    try {
//      yossi.addRentSlot(pOfYossi1, new Time(Time.WeekDay.Sunday, new Time.DayTime(10, 53), new Time.DayTime(13, 30)), 23.5);
//    } catch (IllegalArgumentException e) {
//      check = true;
//    }
//    assert check;
//    // add some more rent slots to p1 of Yossi
//    yossi.addRentSlot(pOfYossi1, new Time(Time.WeekDay.Monday, new Time.DayTime(10, 53), new Time.DayTime(13, 30)), 23.5);
//    yossi.addRentSlot(pOfYossi1, new Time(Time.WeekDay.Monday, new Time.DayTime(14, 53), new Time.DayTime(20, 30)), 30);
//    yossi.addRentSlot(pOfYossi1, new Time(Time.WeekDay.Saturday, new Time.DayTime(14, 53), new Time.DayTime(16, 30)), 30);
//    check = false;
//    try {
//      yossi.addRentSlot(pOfYossi1, new Time(Time.WeekDay.Saturday, new Time.DayTime(14, 53), new Time.DayTime(16, 30)), 30);
//    } catch (IllegalArgumentException e) {
//      check = true;
//    }
//    assert check;
//    azzert.that(pOfYossi1.getNumOfSlots(), is(4));
//    azzert.that(pOfYossi2.getNumOfSlots(), is(0));
//    // add some rent slots to p2 of Yossi
//    yossi.addRentSlot(pOfYossi2, new Time(Time.WeekDay.Monday, new Time.DayTime(10, 53), new Time.DayTime(13, 30)), 23.5);
//    yossi.addRentSlot(pOfYossi2, new Time(Time.WeekDay.Monday, new Time.DayTime(14, 53), new Time.DayTime(20, 30)), 30);
//    yossi.addRentSlot(pOfYossi2, new Time(Time.WeekDay.Saturday, new Time.DayTime(14, 53), new Time.DayTime(16, 30)), 30);
//    azzert.that(pOfYossi2.getNumOfSlots(), is(3));
//    List<RentSlot> yossiFreeRentSlotsOfP = yossi.getAllFreeSlotsBySpotID(pOfYossi2.getId());
//    azzert.that(yossiFreeRentSlotsOfP.size(), is(3));
//    yossi.removeRentSlot(pOfYossi2.getId(), yossiFreeRentSlotsOfP.get(0).getId());
//    azzert.that(pOfYossi2.getNumOfSlots(), is(2));
//    azzert.that(yossi.getAllFreeRentSlots().size(), is(6));
//  }
//
//  @Test public void letAndUnletTest() {
//    // create a user named Yossi and add him some parking spots
//    User yossi = new User("Yossi", "Cohen", "050-123-4567");
//    Address a1 = new Address("Tel-Aviv", "King George", 5), a2 = new Address("Tel-Aviv", "King George", 5),
//        a3 = new Address("Petah-Tikwa", "Hivner", 25), a4 = new Address("Raanana", "Kazan", 30);
//    List<Address> yossiAdd = new ArrayList<>();// list of addresses of parking spots
//    yossiAdd.add(a1);
//    yossiAdd.add(a2);
//    yossiAdd.add(a3);
//    yossiAdd.add(a4);
//    yossi.addParkingSpot(a1);
//    yossi.addParkingSpot(a2);
//    yossi.addParkingSpot(a3);
//    yossi.addParkingSpot(a4);
//    // add some rent slots to a parking of Yossi
//    ParkingSpot pOfYossi1 = yossi.getOwnedParkingSpots().get(0);
//    yossi.addRentSlot(pOfYossi1, new Time(Time.WeekDay.Sunday, new Time.DayTime(10, 53), new Time.DayTime(13, 30)), 23.5);
//    yossi.addRentSlot(pOfYossi1, new Time(Time.WeekDay.Monday, new Time.DayTime(10, 53), new Time.DayTime(13, 30)), 23.5);
//    yossi.addRentSlot(pOfYossi1, new Time(Time.WeekDay.Monday, new Time.DayTime(14, 53), new Time.DayTime(20, 30)), 30);
//    yossi.addRentSlot(pOfYossi1, new Time(Time.WeekDay.Saturday, new Time.DayTime(14, 53), new Time.DayTime(16, 30)), 30);
//    List<RentSlot> freeRS = yossi.getAllFreeRentSlots(), usedRS = yossi.getAllUsedRentSlots();
//    azzert.that(freeRS.size(), is(4));
//    azzert.that(usedRS.size(), is(0));
//    // let a rent slot to a buyer named Tamar and check it was rent
//    Buyer tamar = new User("Tamar", "Ohayon", "050-123-4568");
//    RentSlot rs1 = freeRS.get(0);
//    yossi.letParkingSlot(tamar, rs1.getParkingSpot().getId(), rs1.getId());
//    azzert.that(tamar, is(freeRS.get(0).getBuyer()));
//    freeRS = yossi.getAllFreeRentSlots();
//    usedRS = yossi.getAllUsedRentSlots();
//    azzert.that(freeRS.size(), is(3));
//    azzert.that(usedRS.size(), is(1));
//    yossi.unletParkingSlot(rs1.getParkingSpot().getId(), rs1.getId());
//    freeRS = yossi.getAllFreeRentSlots();
//    usedRS = yossi.getAllUsedRentSlots();
//    azzert.that(freeRS.size(), is(4));
//    azzert.that(usedRS.size(), is(0));
//    // some exceptions checks
//    // let checks
//    boolean check = false;
//    try {
//      yossi.letParkingSlot(tamar, -1, freeRS.get(0).getId());
//    } catch (IllegalArgumentException e) {
//      check = true;
//    }
//    assert check;
//    check = false;
//    try {
//      yossi.letParkingSlot(tamar, pOfYossi1.getId(), -1);
//    } catch (IllegalArgumentException e) {
//      check = true;
//    }
//    assert check;
//    check = false;
//    try {
//      ((User) tamar).letParkingSlot(yossi, pOfYossi1.getId(), freeRS.get(0).getId());
//    } catch (IllegalArgumentException e) {
//      check = true;
//    }
//    assert check;
//    int id = freeRS.get(0).getId();
//    yossi.removeRentSlot(pOfYossi1.getId(), id);
//    check = false;
//    try {
//      yossi.letParkingSlot(tamar, pOfYossi1.getId(), id);
//    } catch (IllegalArgumentException e) {
//      check = true;
//    }
//    assert check;
//    id = freeRS.get(1).getId();
//    yossi.letParkingSlot(tamar, pOfYossi1.getId(), id);
//    check = false;
//    try {
//      yossi.letParkingSlot(tamar, pOfYossi1.getId(), id);
//    } catch (IllegalArgumentException e) {
//      check = true;
//    }
//    assert check;
//    // unlet checks
//    check = false;
//    try {
//      yossi.unletParkingSlot(-1, id);
//    } catch (IllegalArgumentException e) {
//      check = true;
//    }
//    assert check;
//    check = false;
//    try {
//      yossi.unletParkingSlot(pOfYossi1.getId(), -1);
//    } catch (IllegalArgumentException e) {
//      check = true;
//    }
//    assert check;
//    check = false;
//    try {
//      ((User) tamar).unletParkingSlot(pOfYossi1.getId(), id);
//    } catch (IllegalArgumentException e) {
//      check = true;
//    }
//    assert check;
//    yossi.removeRentSlot(pOfYossi1.getId(), id);
//    check = false;
//    try {
//      yossi.unletParkingSlot(pOfYossi1.getId(), id);
//    } catch (IllegalArgumentException e) {
//      check = true;
//    }
//    assert check;
//    id = freeRS.get(2).getId();
//    check = false;
//    try {
//      yossi.unletParkingSlot(pOfYossi1.getId(), id);
//    } catch (IllegalArgumentException e) {
//      check = true;
//    }
//    assert check;
//  }
//
//  @Test public void updatePriceOfRentSlot() {
//    // create a user named Yossi and add him some parking spots
//    User yossi = new User("Yossi", "Cohen", "050-123-4567");
//    Address a1 = new Address("Tel-Aviv", "King George", 5), a2 = new Address("Tel-Aviv", "King George", 5),
//        a3 = new Address("Petah-Tikwa", "Hivner", 25), a4 = new Address("Raanana", "Kazan", 30);
//    List<Address> yossiAdd = new ArrayList<>();// list of addresses of parking spots
//    yossiAdd.add(a1);
//    yossiAdd.add(a2);
//    yossiAdd.add(a3);
//    yossiAdd.add(a4);
//    yossi.addParkingSpot(a1);
//    yossi.addParkingSpot(a2);
//    yossi.addParkingSpot(a3);
//    yossi.addParkingSpot(a4);
//    // add some renting slots to p1 and p2
//    List<ParkingSpot> setP = yossi.getOwnedParkingSpots();
//    ParkingSpot pOfYossi1 = setP.get(0), pOfYossi2 = setP.get(1);
//    yossi.addRentSlot(pOfYossi1, new Time(Time.WeekDay.Sunday, new Time.DayTime(10, 53), new Time.DayTime(13, 30)), 23.5);
//    yossi.addRentSlot(pOfYossi1, new Time(Time.WeekDay.Monday, new Time.DayTime(10, 53), new Time.DayTime(13, 30)), 23.5);
//    yossi.addRentSlot(pOfYossi1, new Time(Time.WeekDay.Monday, new Time.DayTime(14, 53), new Time.DayTime(20, 30)), 30);
//    yossi.addRentSlot(pOfYossi1, new Time(Time.WeekDay.Saturday, new Time.DayTime(14, 53), new Time.DayTime(16, 30)), 30);
//    azzert.that(pOfYossi1.getNumOfSlots(), is(4));
//    yossi.addRentSlot(pOfYossi2, new Time(Time.WeekDay.Monday, new Time.DayTime(10, 53), new Time.DayTime(13, 30)), 23.5);
//    yossi.addRentSlot(pOfYossi2, new Time(Time.WeekDay.Monday, new Time.DayTime(14, 53), new Time.DayTime(20, 30)), 30);
//    yossi.addRentSlot(pOfYossi2, new Time(Time.WeekDay.Saturday, new Time.DayTime(14, 53), new Time.DayTime(16, 30)), 30);
//    azzert.that(pOfYossi2.getNumOfSlots(), is(3));
//    // check prices of rent slots (assumed order is saved due to LinkedHashMap
//    // property)
//    List<RentSlot> freeRentSlots = yossi.getAllFreeSlotsBySpotID(pOfYossi1.getId());
//    azzert.that(freeRentSlots.size(), is(4));
//    azzert.that(freeRentSlots.get(0).getPrice(), is(23.5));
//    azzert.that(freeRentSlots.get(1).getPrice(), is(23.5));
//    azzert.that(freeRentSlots.get(2).getPrice(), is(30.0));
//    azzert.that(freeRentSlots.get(3).getPrice(), is(30.0));
//    // update price of parking spot, and updates all rent slots fit
//    yossi.updateParkingSpotPrice(pOfYossi1.getId(), 10);
//    freeRentSlots = yossi.getAllFreeSlotsBySpotID(pOfYossi1.getId());
//    azzert.that(freeRentSlots.get(0).getPrice(), is(33.5));
//    azzert.that(freeRentSlots.get(1).getPrice(), is(33.5));
//    azzert.that(freeRentSlots.get(2).getPrice(), is(40.0));
//    azzert.that(freeRentSlots.get(3).getPrice(), is(40.0));
//    //// update price of parking spot, and updates all rent slots fit
//    yossi.updateParkingSpotPrice(pOfYossi1.getId(), -20);
//    freeRentSlots = yossi.getAllFreeSlotsBySpotID(pOfYossi1.getId());
//    azzert.that(freeRentSlots.get(0).getPrice(), is(13.5));
//    azzert.that(freeRentSlots.get(1).getPrice(), is(13.5));
//    azzert.that(freeRentSlots.get(2).getPrice(), is(20.0));
//    azzert.that(freeRentSlots.get(3).getPrice(), is(20.0));
//    freeRentSlots = yossi.getAllFreeSlotsBySpotID(pOfYossi2.getId());
//    azzert.that(pOfYossi2.getNumOfSlots(), is(3));
//    azzert.that(freeRentSlots.get(0).getPrice(), is(23.5));
//    azzert.that(freeRentSlots.get(1).getPrice(), is(30.0));
//    azzert.that(freeRentSlots.get(2).getPrice(), is(30.0));
//    // update price of individual rent slots and check that
//    yossi.updateRentSlotPrice(pOfYossi2.getId(), freeRentSlots.get(0).getId(), 35);
//    yossi.updateRentSlotPrice(pOfYossi2.getId(), freeRentSlots.get(2).getId(), 40);
//    azzert.that(freeRentSlots.get(0).getPrice(), is(35.0));
//    azzert.that(freeRentSlots.get(1).getPrice(), is(30.0));
//    azzert.that(freeRentSlots.get(2).getPrice(), is(40.0));
//    // some exceptions check
//    boolean check = false;
//    try {
//      yossi.updateParkingSpotPrice(-1, 10);
//    } catch (IllegalArgumentException e) {
//      check = true;
//    }
//    assert check;
//    User tamar = new User("Tamar", "Ohayon", "050-123-4568");
//    check = false;
//    try {
//      tamar.updateParkingSpotPrice(pOfYossi1.getId(), 10);
//    } catch (IllegalArgumentException e) {
//      check = true;
//    }
//    assert check;
//    check = false;
//    try {
//      tamar.updateRentSlotPrice(-1, freeRentSlots.get(0).getId(), 10);
//    } catch (IllegalArgumentException e) {
//      check = true;
//    }
//    assert check;
//    check = false;
//    try {
//      tamar.updateRentSlotPrice(pOfYossi2.getId(), -1, 10);
//    } catch (IllegalArgumentException e) {
//      check = true;
//    }
//    assert check;
//    check = false;
//    try {
//      tamar.updateRentSlotPrice(pOfYossi2.getId(), freeRentSlots.get(0).getId(), -1);
//    } catch (IllegalArgumentException e) {
//      check = true;
//    }
//    assert check;
//  }
//
//  @Test public void getParkingAndSlotsTest() {
//    // create a user named Yossi and add him some parking spots
//    User yossi = new User("Yossi", "Cohen", "050-123-4567");
//    Address a1 = new Address("Tel-Aviv", "King George", 5), a2 = new Address("Tel-Aviv", "King George", 5),
//        a3 = new Address("Petah-Tikwa", "Hivner", 25), a4 = new Address("Raanana", "Kazan", 30);
//    List<Address> yossiAdd = new ArrayList<>();// list of addresses of parking spots
//    yossiAdd.add(a1);
//    yossiAdd.add(a2);
//    yossiAdd.add(a3);
//    yossiAdd.add(a4);
//    yossi.addParkingSpot(a1);
//    yossi.addParkingSpot(a2);
//    yossi.addParkingSpot(a3);
//    yossi.addParkingSpot(a4);
//    List<ParkingSpot> yossiP = yossi.getOwnedParkingSpots();
//    ParkingSpot p0 = yossiP.get(0), p1 = yossiP.get(1);
//    azzert.that(yossiP.size(), is(4));
//    azzert.that(yossi.getAllRentSlots().size(), is(0));
//    azzert.that(yossi.getAllFreeRentSlots().size(), is(0));
//    azzert.that(yossi.getAllUsedRentSlots().size(), is(0));
//    azzert.that(yossi.getAllSlotsBySpotID(p1.getId()).size(), is(0));
//    azzert.that(yossi.getAllFreeSlotsBySpotID(p1.getId()).size(), is(0));
//    azzert.that(yossi.getAllUsedSlotsBySpotID(p1.getId()).size(), is(0));
//    yossi.addRentSlot(p0, new Time(Time.WeekDay.Sunday, new Time.DayTime(10, 53), new Time.DayTime(13, 30)), 23.5);
//    yossi.addRentSlot(p0, new Time(Time.WeekDay.Monday, new Time.DayTime(10, 53), new Time.DayTime(13, 30)), 23.5);
//    yossi.addRentSlot(p0, new Time(Time.WeekDay.Monday, new Time.DayTime(14, 53), new Time.DayTime(20, 30)), 30);
//    yossi.addRentSlot(p0, new Time(Time.WeekDay.Saturday, new Time.DayTime(14, 53), new Time.DayTime(16, 30)), 30);
//    yossi.addRentSlot(p1, new Time(Time.WeekDay.Sunday, new Time.DayTime(10, 53), new Time.DayTime(13, 30)), 23.5);
//    yossi.addRentSlot(p1, new Time(Time.WeekDay.Monday, new Time.DayTime(10, 53), new Time.DayTime(13, 30)), 23.5);
//    yossi.addRentSlot(p1, new Time(Time.WeekDay.Monday, new Time.DayTime(14, 53), new Time.DayTime(20, 30)), 30);
//    yossi.addRentSlot(p1, new Time(Time.WeekDay.Saturday, new Time.DayTime(14, 53), new Time.DayTime(16, 30)), 30);
//    yossiP = yossi.getOwnedParkingSpots();
//    p0 = yossiP.get(0);
//    p1 = yossiP.get(1);
//    azzert.that(yossiP.size(), is(4));
//    azzert.that(yossi.getAllRentSlots().size(), is(8));
//    azzert.that(yossi.getAllFreeRentSlots().size(), is(8));
//    azzert.that(yossi.getAllUsedRentSlots().size(), is(0));
//    azzert.that(yossi.getAllSlotsBySpotID(p1.getId()).size(), is(4));
//    azzert.that(yossi.getAllFreeSlotsBySpotID(p1.getId()).size(), is(4));
//    azzert.that(yossi.getAllUsedSlotsBySpotID(p1.getId()).size(), is(0));
//    Buyer tamar = new User("Tamar", "Ohayon", "050-123-4568");
//    RentSlot rs1 = yossi.getAllFreeSlotsBySpotID(p1.getId()).get(1);
//    yossi.letParkingSlot(tamar, rs1.getParkingSpot().getId(), yossi.getAllFreeSlotsBySpotID(p1.getId()).get(0).getId());
//    yossi.letParkingSlot(tamar, rs1.getParkingSpot().getId(), rs1.getId());
//    azzert.that(yossi.getAllRentSlots().size(), is(8));
//    azzert.that(yossi.getAllFreeRentSlots().size(), is(6));
//    azzert.that(yossi.getAllUsedRentSlots().size(), is(2));
//    azzert.that(yossi.getAllSlotsBySpotID(p1.getId()).size(), is(4));
//    azzert.that(yossi.getAllFreeSlotsBySpotID(p1.getId()).size(), is(2));
//    azzert.that(yossi.getAllUsedSlotsBySpotID(p1.getId()).size(), is(2));
//    azzert.that(yossi.getAllSlotsBySpotID(p0.getId()).size(), is(4));
//    azzert.that(yossi.getAllFreeSlotsBySpotID(p0.getId()).size(), is(4));
//    azzert.that(yossi.getAllUsedSlotsBySpotID(p0.getId()).size(), is(0));
//    yossi.unletParkingSlot(p1.getId(), rs1.getId());
//    azzert.that(yossi.getAllRentSlots().size(), is(8));
//    azzert.that(yossi.getAllFreeRentSlots().size(), is(7));
//    azzert.that(yossi.getAllUsedRentSlots().size(), is(1));
//    azzert.that(yossi.getAllSlotsBySpotID(p1.getId()).size(), is(4));
//    azzert.that(yossi.getAllFreeSlotsBySpotID(p1.getId()).size(), is(3));
//    azzert.that(yossi.getAllUsedSlotsBySpotID(p1.getId()).size(), is(1));
//    azzert.that(yossi.getAllSlotsBySpotID(p0.getId()).size(), is(4));
//    azzert.that(yossi.getAllFreeSlotsBySpotID(p0.getId()).size(), is(4));
//    azzert.that(yossi.getAllUsedSlotsBySpotID(p0.getId()).size(), is(0));
//    yossi.removeParkingSpot(p0.getId());
//    azzert.that(yossi.getOwnedParkingSpots().size(), is(3));
//    azzert.that(yossi.getAllRentSlots().size(), is(4));
//    azzert.that(yossi.getAllFreeRentSlots().size(), is(3));
//    azzert.that(yossi.getAllUsedRentSlots().size(), is(1));
//    azzert.that(yossi.getAllSlotsBySpotID(p1.getId()).size(), is(4));
//    azzert.that(yossi.getAllFreeSlotsBySpotID(p1.getId()).size(), is(3));
//    azzert.that(yossi.getAllUsedSlotsBySpotID(p1.getId()).size(), is(1));
//    boolean check = false;
//    try {
//      yossi.getAllSlotsBySpotID(p0.getId());
//    } catch (IllegalArgumentException e) {
//      check = true;
//    }
//    assert check;
//    check = false;
//    try {
//      yossi.getAllFreeSlotsBySpotID(p0.getId());
//    } catch (IllegalArgumentException e) {
//      check = true;
//    }
//    assert check;
//    check = false;
//    try {
//      yossi.getAllUsedSlotsBySpotID(p0.getId());
//    } catch (IllegalArgumentException e) {
//      check = true;
//    }
//    assert check;
//  }
//}

