package database;

import java.sql.*;
import java.util.*;

import parking.*;


public class ParkingDataBase {
  
  public static void addParkingSpot(ParkingSpot s) throws SQLException {
    SQLUtils.runCommand("INSERT INTO parkingspots (price,owner,buyer,city,street,building,startDate,endDate,startHour,endHour) "
                      + "VALUES (" + s.getPrice() + ", "
                                   + "'" + s.getSellerID() + "', "
                                   + "NULL, "
                                   + "'" + s.getAddress().getCity() + "', "
                                   + "'" + s.getAddress().getStreet() + "', "
                                   + s.getAddress().getBuilding() + ", "
                                   + "DATE '" + s.getStartDate() + "', "
                                   + "DATE '" + s.getEndDate() + "', "
                                   + "TIME '" + s.getStartHour() + ":00', "
                                   + "TIME '" + s.getEndHour() + ":00')"
        );
  }

  public static void removeParkingSpot(int spotID) throws SQLException {
    SQLUtils.runCommand("DELETE FROM parkingspots WHERE id = " + spotID + ";");
  }

  public static void rentParkingSpot(int spotID, String buyerID) throws SQLException {
    SQLUtils.runCommand("UPDATE parkingspots SET buyer = '" + buyerID + "' WHERE id = " + spotID + " AND buyer IS NULL;");
  }

  public static void unRentParkingSpot(int spotID) throws SQLException {
    SQLUtils.runCommand("UPDATE parkingspots SET buyer = NULL WHERE id = " + spotID + ";");
  }

  public static List<ParkingSpot> getAllParkingSpots() throws SQLException {
    return null;
  }
  
  public static List<ParkingSpot> searchSpotsWithDate (String date){
    return null;
  }
  
  public static List<ParkingSpot> searchSpotsWithAddress(String city, String street) throws SQLException {
    SQLException exception = null;
    QueryResults q = null;
    List<ParkingSpot> results = new ArrayList<>();
    try {
      q = SQLUtils.runQuery("SELECT * FROM parkingspots WHERE city = '"+city+"' AND street = '"+street+"';");
      @SuppressWarnings("resource") ResultSet rs = q.getResults();
      while(rs.next()) {
        Address a = new Address(rs.getString("city"),rs.getString("street"),rs.getInt("building"));
        ParkingSpot p = new ParkingSpot(rs.getInt("id"),rs.getString("owner"),rs.getString("buyer"),rs.getInt("price"),a,
            rs.getDate("startDate")+"",rs.getDate("endDate")+"",rs.getTime("startHour")+"",rs.getTime("endHour")+"");
        results.add(p);
      }
    }
    catch(SQLException e) {
      exception = e;
    }
    finally {
      if(q != null)
        q.close();
    }
    if(exception != null)
      throw exception;
    return results;
  }
}
