package parking;

import org.json.*;

import database.*;

import java.sql.*;
import java.util.*;


/** @fluent.ly.Package parking
 * @fluent.ly.Since Dec 18, 2018
 * @fluent.ly.Author Or
 * @fluent.ly.ClassDesc TODO */
public class OurSystem {
  private static OurSystem system = new OurSystem();

  /* A private Constructor prevents any other class from instantiating. */
  private OurSystem() {
  }

  /* Static 'instance' method */
  public static OurSystem getInstance() {
    return system;
  }
  
  public static void addParkingSpot(JSONObject jObj) {
    String city = jObj.getString("city");
    String street = jObj.getString("street");
    //int building = Integer.parseInt(jObj.getString("building"));
    int building = 1;
    String startTime = jObj.getString("start_time");
    String endTime = jObj.getString("end_time");
    if(!checkTimeLegit(startTime, endTime))
      throw new IllegalArgumentException();
    int price = Integer.parseInt(jObj.getString("price"));
    // int ownerID = Integer.parseInt(jObj.getString("ownerID"));    
    int ownerID = 1;
    ParkingSpot p = new ParkingSpot(ownerID, new Address(city, street, building),startTime, endTime, price);
    try {
      ParkingDataBase.addParkingSpot(p);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  public static void removeParkingSpot(JSONObject jObj) {
    String city = jObj.getString("city");
    String street = jObj.getString("street");
    //int building = Integer.parseInt(jObj.getString("building"));
    int building = 1;
    String startTime = jObj.getString("start_time");
    String endTime = jObj.getString("end_time");
    if(!checkTimeLegit(startTime, endTime))
      throw new IllegalArgumentException();
    int price = Integer.parseInt(jObj.getString("price"));
    // int ownerID = Integer.parseInt(jObj.getString("ownerID"));    
    int ownerID = 1;
    ParkingSpot p = new ParkingSpot(ownerID, new Address(city, street, building),startTime, endTime, price);
    try {
      ParkingDataBase.removeParkingSpot(p);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  public static void rentParkingSpot(JSONObject jObj) {
    String city = jObj.getString("city");
    String street = jObj.getString("street");
    //int building = Integer.parseInt(jObj.getString("building"));
    int building = 1;
    String startTime = jObj.getString("start_time");
    String endTime = jObj.getString("end_time");
    if(!checkTimeLegit(startTime, endTime))
      throw new IllegalArgumentException();
    int price = Integer.parseInt(jObj.getString("price"));
    //int ownerID = Integer.parseInt(jObj.getString("ownerID"));
    //int buyerID = Integer.parseInt(jObj.getString("buyerID"));
    int ownerID = 1;
    int buyerID = 1;
    ParkingSpot p = new ParkingSpot(ownerID, new Address(city, street, building),startTime, endTime, price);
    try {
      ParkingDataBase.rentParkingSpot(p, buyerID);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  public static void unrentParkingSpot(JSONObject jObj) {
    String city = jObj.getString("city");
    String street = jObj.getString("street");
    //int building = Integer.parseInt(jObj.getString("building"));
    int building = 1;
    String startTime = jObj.getString("start_time");
    String endTime = jObj.getString("end_time");
    if(!checkTimeLegit(startTime, endTime))
      throw new IllegalArgumentException();
    int price = Integer.parseInt(jObj.getString("price"));
    //int ownerID = Integer.parseInt(jObj.getString("ownerID"));
    //int buyerID = Integer.parseInt(jObj.getString("buyerID"));
    int ownerID = 1;
    int buyerID = 1;
    ParkingSpot p = new ParkingSpot(ownerID, new Address(city, street, building),startTime, endTime, price);
    try {
      ParkingDataBase.unrentParkingSpot(p, buyerID);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  public static JSONObject searchParkingSpots(JSONObject jObj) {
/*    String city = jObj.getString("city");
    String street = jObj.getString("street");
    int building = Integer.parseInt(jObj.getString("building"));*/
    String startTime = jObj.getString("start_time");
    String endTime = jObj.getString("end_time");
    String locX = jObj.getString("locX");
    String locY = jObj.getString("locY");
    String date = jObj.getString("date");
    if(!checkTimeLegit(startTime, endTime))
      throw new IllegalArgumentException();
    List<ParkingSpot> pList = null;
    try {
      pList = ParkingDataBase.searchParkingSpots(date, locX, locY, startTime, endTime);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    return convertParkingSpotsToJSON(pList);
  }
  
  private static JSONObject convertParkingSpotsToJSON(List<ParkingSpot> pList) {
    //String jsonDataString = "{\"lat\":\"value\",\"lon\":\"value\"}";
    JSONObject $ = new JSONObject();
    
    int i = 0;
    for(ParkingSpot p : pList) {
      $.put("ParkingSpot" + String.valueOf(i) + ": ", p + "");
    }
    return $;
  }
  
  private static boolean checkTimeLegit(String startTime, String endTime) {
    int sTHour = Integer.parseInt(startTime.substring(0, 2));
    int sTMin = Integer.parseInt(startTime.substring(3, 5));
    int eTHour = Integer.parseInt(endTime.substring(0, 2));
    int eTMin = Integer.parseInt(endTime.substring(3, 5));
    if(eTMin < 0 | sTMin < 0 | eTHour < 0 | sTHour < 0)
      return false;
    if(eTMin >= 60 | sTMin >= 60 | eTHour >= 24 | sTHour >= 24)
      return false;
    return true;
  }
  
  
}
