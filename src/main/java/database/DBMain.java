package database;

import java.sql.*;
import parking.*;
import java.util.*;

public class DBMain {
  static final String createParkingSpotsTable = "CREATE TABLE ParkingSpots (\n"
      + "id INT NOT NULL AUTO_INCREMENT,\n"
      + "price INT NOT NULL,\n"
      + "city VARCHAR(20) NOT NULL,\n"
      + "street VARCHAR(20) NOT NULL,\n"
      + "building INT NOT NULL,\n"
      + "date DATE NOT NULL,\n"
      + "owner INT NOT NULL,\n"
      + "buyer INT,\n"
      + "PRIMARY KEY(id));";
  
  static final String destroyParkingSpotsTable = "DROP TABLE ParkingSpots;";

  public static void main(final String[] args) {
    
    try {
      Address a = new Address("C","S",5);    
      //ParkingDataBase.addParkingSpot(new ParkingSpot(3,50,-10,100,a,"2015-01-19"));
      //ParkingDataBase.unRentParkingSpot(new ParkingSpot(-5,50,20,100,a,"2018-05-17"),200);
      List<ParkingSpot> p = ParkingDataBase.searchParkingSpots(null,a);
      System.out.println(p.size());
      System.out.println("Good");
    }
    catch(SQLException e) {
      System.out.println(e);
    }
    System.out.println("Done");
  }

  
  public static void printAllSpots() {
    QueryResults q = null;
    try {
      q = SQLUtils.runQuery("SELECT * FROM ParkingSpots;");
      for (final ResultSet ¢ = q.getResults(); ¢.next();)
        System.out.println("ID: " + ¢.getInt("id") + "\tCity: " + ¢.getString("city") + "\tStreet: " + ¢.getString("street") + "\tBuilding: "
            + ¢.getInt("building") + "\tOwner: " + ¢.getInt("owner") + "\tBuyer: " + ¢.getInt("buyer") + "\tprice: " + ¢.getInt("price")
            + "\tstart time: " + ¢.getString("startTime") + "\tend time: " + ¢.getString("endTime"));
    } catch (final SQLException ¢) {
      System.out.println(¢);
    } finally {
      if (q != null)
        q.close();
    }
  }
}
