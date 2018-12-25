package database;

import java.sql.*;
import java.util.*;

import parking.*;

/**
 * @fluent.ly.Package database
 * @fluent.ly.Since 25 בדצמ׳ 2018
 * @fluent.ly.Author Nitzan
 * @fluent.ly.ClassDesc Class responsible for sending the database queries relating to parking spots.
 */
public class ParkingDataBase {
  
  /**
   * This method adds a spot to the db. Make sure dates are in 'yyyy-mm-dd' format, and hours are in the 'hh:mm' format.
   * The buyer field is ignored and a null value is added in its place.
   * @param ¢ The parking spot to be added to the DB.
   * @throws SQLException
   */
  public static void addParkingSpot(ParkingSpot ¢) throws SQLException {
    SQLUtils.runCommand("INSERT INTO parkingspots (price,owner,buyer,city,street,building,startDate,endDate,startHour,endHour) "
                      + "VALUES (" + ¢.getPrice() + ", "
                                   + "'" + ¢.getSellerID() + "', "
                                   + "NULL, "
                                   + "'" + ¢.getAddress().getCity() + "', "
                                   + "'" + ¢.getAddress().getStreet() + "', "
                                   + ¢.getAddress().getBuilding() + ", "
                                   + "DATE '" + ¢.getStartDate() + "', "
                                   + "DATE '" + ¢.getEndDate() + "', "
                                   + "TIME '" + ¢.getStartHour() + ":00', "
                                   + "TIME '" + ¢.getEndHour() + ":00')"
        );
  }

  /**
   * Removes a spot from the DB according to its ID.
   * @param spotID the ID of the spot to be removed.
   * @throws SQLException
   */
  public static void removeParkingSpot(int spotID) throws SQLException {
    SQLUtils.runCommand("DELETE FROM parkingspots WHERE id = " + spotID + ";");
  }

  /**
   * Rents a specific spot to a specific buyer. Will not do anything if the spot is already rented.
   * @param spotID the ID of the spot to be rented.
   * @param buyerID the ID of the buyer renting the spot.
   * @throws SQLException
   */
  public static void rentParkingSpot(int spotID, String buyerID) throws SQLException {
    SQLUtils.runCommand("UPDATE parkingspots SET buyer = '" + buyerID + "' WHERE id = " + spotID + " AND buyer IS NULL;");
  }

  /**
   * Frees a parking spot, making it available to be rented again (effectively removing the buyer from the spot entry).
   * @param spotID the ID of the spot to be freed.
   * @throws SQLException
   */
  public static void unRentParkingSpot(int spotID) throws SQLException {
    SQLUtils.runCommand("UPDATE parkingspots SET buyer = NULL WHERE id = " + spotID + ";");
  }

  /**
   * Returns all parking spots in the database.
   * @return a list of all the spots in the database.
   * @throws SQLException
   */
  public static List<ParkingSpot> getAllParkingSpots() throws SQLException {
    SQLException exception = null;
    QueryResults q = null;
    List<ParkingSpot> $ = new ArrayList<>();
    try {
      q = SQLUtils.runQuery("SELECT * FROM parkingspots;");
      @SuppressWarnings("resource") ResultSet rs = q.getResults();
      while(rs.next()) {
        Address a = new Address(rs.getString("city"),rs.getString("street"),rs.getInt("building"));
        $.add(new ParkingSpot(rs.getInt("id"), rs.getString("owner"), rs.getString("buyer"), rs.getInt("price"), a, rs.getDate("startDate") + "",
            rs.getDate("endDate") + "", rs.getTime("startHour") + "", rs.getTime("endHour") + ""));
      }
    }
    catch(SQLException ¢) {
      exception = ¢;
    }
    finally {
      if(q != null)
        q.close();
    }
    if(exception != null)
      throw exception;
    return $;
  }
  
  /**
   * Returns all available spots whose range of dates includes the given date.
   * @param date the date to be searched for, must be in 'yyyy-mm-dd' format.
   * @return a list of all the spots meeting the condition.
   * @throws SQLException
   */
  public static List<ParkingSpot> searchSpotsWithDate (String date) throws SQLException {
    SQLException exception = null;
    QueryResults q = null;
    List<ParkingSpot> $ = new ArrayList<>();
    try {
      String SQLdate = "DATE '" + date + "'";
      q = SQLUtils.runQuery("SELECT * FROM parkingspots WHERE " + SQLdate + " >= startDate AND " + SQLdate + " <= endDate AND buyer IS NULL;");
      @SuppressWarnings("resource") ResultSet rs = q.getResults();
      while(rs.next()) {
        Address a = new Address(rs.getString("city"),rs.getString("street"),rs.getInt("building"));
        $.add(new ParkingSpot(rs.getInt("id"), rs.getString("owner"), rs.getString("buyer"), rs.getInt("price"), a, rs.getDate("startDate") + "",
            rs.getDate("endDate") + "", rs.getTime("startHour") + "", rs.getTime("endHour") + ""));
      }
    }
    catch(SQLException ¢) {
      exception = ¢;
    }
    finally {
      if(q != null)
        q.close();
    }
    if(exception != null)
      throw exception;
    return $;
  }
  
  /**
   * Returns all available spots in the given city and street.
   * @param city
   * @param street
   * @return a list of all the spots meeting the condition.
   * @throws SQLException
   */
  public static List<ParkingSpot> searchSpotsWithAddress(String city, String street) throws SQLException {
    SQLException exception = null;
    QueryResults q = null;
    List<ParkingSpot> $ = new ArrayList<>();
    try {
      q = SQLUtils.runQuery("SELECT * FROM parkingspots WHERE city = '"+city+"' AND street = '"+street+"' AND buyer IS NULL;");
      @SuppressWarnings("resource") ResultSet rs = q.getResults();
      while(rs.next()) {
        Address a = new Address(rs.getString("city"),rs.getString("street"),rs.getInt("building"));
        $.add(new ParkingSpot(rs.getInt("id"), rs.getString("owner"), rs.getString("buyer"), rs.getInt("price"), a, rs.getDate("startDate") + "",
            rs.getDate("endDate") + "", rs.getTime("startHour") + "", rs.getTime("endHour") + ""));
      }
    }
    catch(SQLException ¢) {
      exception = ¢;
    }
    finally {
      if(q != null)
        q.close();
    }
    if(exception != null)
      throw exception;
    return $;
  }
}
