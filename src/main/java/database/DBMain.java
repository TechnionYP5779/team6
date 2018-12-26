package database;

import java.sql.*;
import java.util.*;

import parking.*;

public class DBMain {
  static final String createParkingSpotsTable = "CREATE TABLE ParkingSpots (\nid INT NOT NULL AUTO_INCREMENT,\nprice INT NOT NULL,\n"
      + "owner VARCHAR(50) NOT NULL,\nbuyer VARCHAR(50),\ncity VARCHAR(20) NOT NULL,\nstreet VARCHAR(20) NOT NULL,\n"
      + "building INT NOT NULL,\nstartDate DATE NOT NULL,\nendDate DATE NOT NULL, \nstartHour TIME NOT NULL, \n"
      + "endHour TIME NOT NULL, \nPRIMARY KEY(id));";
  static final String destroyParkingSpotsTable = "DROP TABLE ParkingSpots;";

  public static void main(final String[] args) {
    try {
      // Address a = new Address("hadera","hahida",20);
      // ParkingDataBase.addParkingSpot(new
      // ParkingSpot(-1,"SELLER2","SHOULDTAPPEAR",200,a,"2018-05-12","2018-07-12","20:30","20:30"));
      /* SQLUtils.
       * runCommand("INSERT INTO parkingspots (price,owner,buyer,city,street,building,startDate,endDate,startHour,endHour) "
       * + "VALUES (" + "40" + ", " + "'" +"kuku" + "', " + "NULL, " + "'" + "hadera"
       * + "', " + "'" + "hahida" + "', " + "20" + ", " + "DATE '" + "2019-05-12" +
       * "', " + "DATE '" + "2019-07-12" + "', " + "TIME '" + "20:30" + ":00', " +
       * "TIME '" + "20:30" + ":00')"); */
      // final List<ParkingSpot> l = ParkingDataBase.searchSpotsWithAddress("City",
      // "Street");
      final List<ParkingSpot> l = ParkingDataBase.getAllParkingSpots();
      for (final ParkingSpot ¢ : l)
        System.out.println(¢);
      System.out.println("Good");
    } catch (final SQLException ¢) {
      System.out.println(¢);
    }
    System.out.println("Done");
  }

  // DONT USE THIS, THIS SHOULD BE REMOVED LATER
  public static void addParkingSpot(final int price, final String city, final String street, final int building, final int owner, final int buyer,
      final String startTime, final String endTime) {
    try {
      SQLUtils.runCommand("INSERT INTO ParkingSpots (price,city,street,building,owner,buyer)\nVALUES (" + price + ",'" + city + "','" + street + "',"
          + building + ",'" + owner + "," + buyer + ");");
    } catch (final SQLException ¢) {
      System.out.println(¢);
      System.out.println(startTime + endTime);
    }
  }
}
