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
    String city = jObj.getString("city"), street = jObj.getString("street");
    //int building = Integer.parseInt(jObj.getString("building"));
    int building = 1;
    String startTime = jObj.getString("start_time"), endTime = jObj.getString("end_time");
    if(!checkTimeLegit(startTime, endTime))
      throw new IllegalArgumentException();
    int price = Integer.parseInt(jObj.getString("price")), ownerID = 1;
    ParkingSpot p = new ParkingSpot(ownerID, new Address(city, street, building),startTime, endTime, price);
    try {
      ParkingDataBase.addParkingSpot(p);
    } catch (SQLException ¢) {
      // TODO Auto-generated catch block
      ¢.printStackTrace();
    }
  }
  
  public static void removeParkingSpot(JSONObject jObj) {
    String city = jObj.getString("city"), street = jObj.getString("street");
    //int building = Integer.parseInt(jObj.getString("building"));
    int building = 1;
    String startTime = jObj.getString("start_time"), endTime = jObj.getString("end_time");
    if(!checkTimeLegit(startTime, endTime))
      throw new IllegalArgumentException();
    int price = Integer.parseInt(jObj.getString("price")), ownerID = 1;
    ParkingSpot p = new ParkingSpot(ownerID, new Address(city, street, building),startTime, endTime, price);
    try {
      ParkingDataBase.removeParkingSpot(p);
    } catch (SQLException ¢) {
      // TODO Auto-generated catch block
      ¢.printStackTrace();
    }
  }
  
  public static void rentParkingSpot(JSONObject jObj) {
    String city = jObj.getString("city"), street = jObj.getString("street");
    //int building = Integer.parseInt(jObj.getString("building"));
    int building = 1;
    String startTime = jObj.getString("start_time"), endTime = jObj.getString("end_time");
    if(!checkTimeLegit(startTime, endTime))
      throw new IllegalArgumentException();
    int price = Integer.parseInt(jObj.getString("price")), ownerID = 1, buyerID = 1;
    ParkingSpot p = new ParkingSpot(ownerID, new Address(city, street, building),startTime, endTime, price);
    try {
      ParkingDataBase.rentParkingSpot(p, buyerID);
    } catch (SQLException ¢) {
      // TODO Auto-generated catch block
      ¢.printStackTrace();
    }
  }
  
  public static void unrentParkingSpot(JSONObject jObj) {
    String city = jObj.getString("city"), street = jObj.getString("street");
    //int building = Integer.parseInt(jObj.getString("building"));
    int building = 1;
    String startTime = jObj.getString("start_time"), endTime = jObj.getString("end_time");
    if(!checkTimeLegit(startTime, endTime))
      throw new IllegalArgumentException();
    int price = Integer.parseInt(jObj.getString("price")), ownerID = 1, buyerID = 1;
    ParkingSpot p = new ParkingSpot(ownerID, new Address(city, street, building),startTime, endTime, price);
    try {
      ParkingDataBase.unrentParkingSpot(p, buyerID);
    } catch (SQLException ¢) {
      // TODO Auto-generated catch block
      ¢.printStackTrace();
    }
  }
 
  
  public static JSONObject getAllParkingSpots(JSONObject jObj) {
    List<ParkingSpot> pList = null;
    try {
      pList = ParkingDataBase.searchParkingSpots(null, null);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    return convertParkingSpotsToJSON(pList);
  }
  
  public static JSONObject getParkingSpotsByDate(JSONObject jObj) {
    String date = jObj.getString("date");
    List<ParkingSpot> pList = null;
    try {
      pList = ParkingDataBase.searchParkingSpots(date, null);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return convertParkingSpotsToJSON(pList);
  }
  
  public static JSONObject searchParkingSpots(JSONObject jObj) {
String startTime = jObj.getString("start_time"), endTime = jObj.getString("end_time"), locX = jObj.getString("locX"), locY = jObj.getString("locY"),
    date = jObj.getString("date");
    if(!checkTimeLegit(startTime, endTime))
      throw new IllegalArgumentException();
    List<ParkingSpot> pList = null;
//    try {
//      pList = ParkingDataBase.searchParkingSpots(date, locX, locY, startTime, endTime);
//    } catch (SQLException e) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    }
    return convertParkingSpotsToJSON(pList);
  }
  
  private static JSONObject convertParkingSpotsToJSON(List<ParkingSpot> pList) {
    //String jsonDataString = "{\"lat\":\"value\",\"lon\":\"value\"}";
    JSONObject $ = new JSONObject();
    
    int i = 0;
    for(ParkingSpot ¢ : pList)
      $.put("ParkingSpot" + String.valueOf(i) + ": ", ¢ + "");
    return $;
  }
  
  private static boolean checkTimeLegit(String startTime, String endTime) {
    int sTHour = Integer.parseInt(startTime.substring(0, 2)), sTMin = Integer.parseInt(startTime.substring(3, 5)),
        eTHour = Integer.parseInt(endTime.substring(0, 2)), eTMin = Integer.parseInt(endTime.substring(3, 5));
    return !(eTMin < 0 | sTMin < 0 | eTHour < 0 | sTHour < 0) && !(eTMin >= 60 | sTMin >= 60 | eTHour >= 24 | sTHour >= 24);
  }
  
  
}
