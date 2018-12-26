package database;

import java.sql.*;
import java.util.*;
import parking.ParkingSpot;

public class DBMain {
  public static void main(final String[] args) {
    try {
      List<ParkingSpot> l = ParkingDataBase.getAllAvailableSpotsToday();
      for(ParkingSpot p : l)
        System.out.println(p);
      System.out.println(ParkingDataBase.countAvailableSpotsToday());
    }
    catch(SQLException ¢) {
      System.out.println(¢);
    }
    System.out.println("Done");
  }
}
