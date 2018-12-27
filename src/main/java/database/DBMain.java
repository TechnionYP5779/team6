package database;

import java.sql.*;
import java.util.*;

import parking.*;

public class DBMain {
  public static void main(final String[] args) {
    try {
      final List<ParkingSpot> l = ParkingDataBase.getAllAvailableSpotsToday();
      for (final ParkingSpot ¢ : l)
        System.out.println(¢);
      System.out.println(ParkingDataBase.countAvailableSpotsToday());
    } catch (final SQLException ¢) {
      System.out.println(¢);
    }
    System.out.println("Done");
  }
}
