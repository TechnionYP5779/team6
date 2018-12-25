package database;

import java.sql.*;
import parking.*;
import java.util.*;

public class DBMain {
  static final String createParkingSpotsTable = "CREATE TABLE ParkingSpots (\n"
      + "id INT NOT NULL AUTO_INCREMENT,\n"
      + "price INT NOT NULL,\n"
      + "owner VARCHAR(50) NOT NULL,\n"
      + "buyer VARCHAR(50),\n"
      
      + "city VARCHAR(20) NOT NULL,\n"
      + "street VARCHAR(20) NOT NULL,\n"
      + "building INT NOT NULL,\n"
      
      + "startDate DATE NOT NULL,\n"
      + "endDate DATE NOT NULL, \n"
      + "startHour TIME NOT NULL, \n"
      + "endHour TIME NOT NULL, \n"
      
      + "PRIMARY KEY(id));";
  
  static final String destroyParkingSpotsTable = "DROP TABLE ParkingSpots;";

  public static void main(final String[] args) {
    
    try {
      
      //Address a = new Address("City","Street",34);    
      //ParkingDataBase.addParkingSpot(new ParkingSpot(-1,"SELLER2","SHOULDT APPEAR",200,a,"2018-05-12","2018-07-12","20:30","20:30"));
      List<ParkingSpot> l = ParkingDataBase.searchSpotsWithAddress("City","Street");
      for(ParkingSpot p : l)
        System.out.println(p);
      
      System.out.println("Good");
    }
    catch(SQLException ¢) {
      System.out.println(¢);
    }
    System.out.println("Done");
  }

  
  
  
  //DONT USE THIS, THIS SHOULD BE REMOVED LATER
  public static void addParkingSpot(final int price, final String city, final String street, final int building, final int owner, final int buyer,
      final String startTime, final String endTime) {
    try {
      SQLUtils.runCommand("INSERT INTO ParkingSpots (price,city,street,building,owner,buyer)\nVALUES (" + price + ",'" + city
          + "','" + street + "'," + building + ",'" + owner + "," + buyer + ");");
    } catch (final SQLException ¢) {
      System.out.println(¢);
      System.out.println(startTime+endTime);
    }
  }
  
}
