package database;

import java.sql.*;
import java.util.*;

import parking.*;


public class ParkingDataBase {
  
  public static void addParkingSpot(ParkingSpot s) throws SQLException {
    String buyer;
    if(s.getBuyerID()<1)
      buyer = "NULL";
    else
      buyer = "'"+s.getBuyerID()+"'";
    SQLUtils.runCommand("INSERT INTO parkingspots (price,city,street,building,date,owner,buyer)\n"
                      + "VALUES (" + s.getPrice() + ", "
                                   + "'" + s.getAddress().getCity() + "', "
                                   + "'" + s.getAddress().getStreet() + "', "
                                   + s.getAddress().getBuilding() + ", "
                                   + "DATE '" + s.getDate() + "', "
                                   + s.getSellerID() + ", "
                                   + buyer + ");");
  }

  public static void removeParkingSpot(ParkingSpot s) throws SQLException {
    if(s.getId()>0)
      SQLUtils.runCommand("DELETE FROM parkingspots WHERE id = " + s.getId() + ";");
    else
      SQLUtils.runCommand("DELETE FROM parkingspots WHERE "
                        + "city = '" + s.getAddress().getCity() + "' AND "
                        + "street = '" + s.getAddress().getStreet() + "' AND "
                        + "building = " + s.getAddress().getBuilding() + " AND "
                        + "date = DATE '" + s.getDate() + "';");
  }

  public static void rentParkingSpot(ParkingSpot s, int buyerID) throws SQLException {
    if(s.getId()>0)
      SQLUtils.runCommand("UPDATE parkingspots SET buyer = " + buyerID + " WHERE id = " + s.getId() + " AND buyer IS NULL;");
    else
      SQLUtils.runCommand("UPDATE parkingspots SET buyer = " + buyerID + " WHERE "
                        + "city = '" + s.getAddress().getCity() + "' AND "
                        + "street = '" + s.getAddress().getStreet() + "' AND "
                        + "building = " + s.getAddress().getBuilding() + " AND "
                        + "date = DATE '" + s.getDate() + "' AND "
                        + "buyer IS NULL;");
  }

  public static void unRentParkingSpot(ParkingSpot p, int buyerID) throws SQLException {
    if(p.getId()>0)
      SQLUtils.runCommand("UPDATE parkingspots SET buyer = NULL WHERE id = " + p.getId() + " AND buyer = " + buyerID + ";");
    else
      SQLUtils.runCommand("UPDATE parkingspots SET buyer = NULL WHERE "
                        + "city = '" + p.getAddress().getCity() + "' AND "
                        + "street = '" + p.getAddress().getStreet() + "' AND "
                        + "building = " + p.getAddress().getBuilding() + " AND "
                        + "date = DATE '" + p.getDate() + "' AND "
                        + "buyer = " + buyerID + ";");
  }

  public static List<ParkingSpot> searchParkingSpots(String date, Address a) throws SQLException {
    String query = "SELECT * FROM parkingspots";
    if(date != null || a != null) {
      query += " WHERE ";
      if(date != null) {
        query += ("date = DATE '" + date + "'");
        if(a != null)
          query += " AND ";
      }
      if(a != null)
        query += ("city = '" + a.getCity() + "' AND street = '" + a.getStreet()+"'");
    }
    query += ";";
    
    QueryResults q = SQLUtils.runQuery(query);
    @SuppressWarnings("resource") ResultSet rs = q.getResults();
    List<ParkingSpot> $ = new ArrayList<>();
    while(rs.next()) {
      Address newAddress = new Address(rs.getString("city"),rs.getString("street"),rs.getInt("building"));
      $.add(new ParkingSpot(rs.getInt("id"), rs.getInt("owner"), rs.getInt("buyer"), rs.getInt("price"), newAddress, rs.getDate("date") + ""));
    }
    q.close();
    rs.close();
    return $;
  }
}
