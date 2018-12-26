// package parking;
//
// import static fluent.ly.azzert.*;
//
// import java.util.*;
//
// import org.junit.*;
//
// import fluent.ly.*;
//
//// Unit tests for class ParkingSpot
//
/// **
// * @fluent.ly.Package parking
// * @fluent.ly.Since Dec 11, 2018
// * @fluent.ly.Author Or
// * @fluent.ly.ClassDesc TODO
// * @see ParkingSpot
// */
// @SuppressWarnings({"static-method", "unused"}) public class ParkingSpotTest {
// @Test public void basicParkingSpotFuncsTest () {
// //create a new parking spot and add it to a new user named Yossi
// Address a1 = new Address("Tel-Aviv", "King George", 5);
// ParkingSpot p1 = new ParkingSpot(a1);
// User yossi = new User("Yossi", "Cohen", "050-123-4567");
// p1.setOwner(yossi);
//
// //create a new parking spot and add it to a new user named Tamar
// Address a2 = new Address("Tel-Aviv", "King George", 10);
// ParkingSpot p2 = new ParkingSpot(a2);
// User tamar = new User("Tamar", "Ohayon", "050-123-4568");
// p2.setOwner(tamar);
//
// //some checks of the parking spots
// azzert.that(p1.getOwner(), is(yossi));
// azzert.that(p1.getAddress(), is(a1));
// azzert.that(p1.getNumOfSlots(), is(0));
//
// azzert.that(p2.getOwner(), is(tamar));
// azzert.that(p2.getAddress(), is(a2));
// azzert.that(p2.getNumOfSlots(), is(0));
// }
//
// @Test public void advancedParkingSpotFuncsTest () {
// Address a1 = new Address("Tel-Aviv", "King George", 5), a2 = new
// Address("Tel-Aviv", "King George", 5),
// a3 = new Address("Petah-Tikwa", "Hivner", 25), a4 = new Address("Raanana",
// "Kazan", 30);
// List<Address> yossiAdd = new ArrayList<>();
// yossiAdd.add(a1);
// yossiAdd.add(a2);
// yossiAdd.add(a3);
// yossiAdd.add(a4);
//
// //create a user named Yossi and add him parking spots
// User yossi = new User("Yossi", "Cohen", "050-123-4567");
// yossi.addParkingSpot(a1);
// yossi.addParkingSpot(a2);
// yossi.addParkingSpot(a3);
// yossi.addParkingSpot(a4);
//
// Address a5 = new Address("Tel-Aviv", "King George", 10), a6 = new
// Address("Petah-Tikwa", "Hivner", 13);
// List<Address> tamarAdd = new ArrayList<>();
// tamarAdd.add(a5);
// tamarAdd.add(a6);
//
// //create a user named Tamar and add her parking spots
// User tamar = new User("Tamar", "Ohayon", "050-123-4568");
//
// tamar.addParkingSpot(a5);
// tamar.addParkingSpot(a6);
//
// //setP - an ordered list of the parking spots of Yossi
// List<ParkingSpot> setP = yossi.getOwnedParkingSpots();
// azzert.that(setP.size(), is(4));
// for(int ¢ = 0; ¢ < yossiAdd.size(); ++¢) {
// azzert.that(setP.get(¢).getAddress(), is(yossiAdd.get(¢)));
// azzert.that(setP.get(¢).getOwner(), is(yossi));
// azzert.that(setP.get(¢).getNumOfSlots(), is(0));
// }
//
// //setP - an ordered list of the parking spots of Tamar
// setP = tamar.getOwnedParkingSpots();
// for(int ¢ = 0; ¢ < tamarAdd.size(); ++¢) {
// azzert.that(setP.get(¢).getAddress(), is(tamarAdd.get(¢)));
// azzert.that(setP.get(¢).getOwner(), is(tamar));
// azzert.that(setP.get(¢).getNumOfSlots(), is(0));
// }
//
// //Yossi tries to add a rent slot to the parking of Tamar and gets an error
// ParkingSpot pOfTamar = setP.get(0);
//
// boolean check = false;
// try{
// yossi.addRentSlot(pOfTamar, new Time(Time.WeekDay.Sunday, new
// Time.DayTime(10, 53), new Time.DayTime(13, 30)), 23.5);
// }
// catch(IllegalArgumentException ¢) {
// check = true;
// }
// assert check;
//
// //Tamar adds a rent slot to her parking
// try{
// tamar.addRentSlot(pOfTamar, new Time(Time.WeekDay.Sunday, new
// Time.DayTime(10, 53), new Time.DayTime(13, 30)), 23.5);
// }
// catch(IllegalArgumentException ¢) {
// check = false;
// }
// assert check;
//
// azzert.that(pOfTamar.getNumOfSlots(), is(1));
//
//// List<RentSlot> tamarFreeRentSlotsOfP =
// tamar.getAllFreeSlotsBySpotID(pOfTamar.getId());
//// azzert.that(tamarFreeRentSlotsOfP.size(), is(1));
////
//// tamar.removeRentSlot(pOfTamar.getId(),
// tamarFreeRentSlotsOfP.get(0).getId());
////
//// azzert.that(pOfTamar.getNumOfSlots(), is(0));
// }
// }
