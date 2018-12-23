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
  
  public static void addParkingSpot(JSONObject jObj) throws SQLException {
    String city = jObj.getString("city"), street = jObj.getString("street");
    //int building = Integer.parseInt(jObj.getString("building"));
    int building = 1;
    String startTime = jObj.getString("start_time"), endTime = jObj.getString("end_time");
    if(!checkTimeLegit(startTime, endTime))
      throw new IllegalArgumentException();
    ParkingDataBase
        .addParkingSpot(new ParkingSpot(1, new Address(city, street, building), startTime, endTime, Integer.parseInt(jObj.getString("price"))));
  }
  
  public static void removeParkingSpot(JSONObject jObj) throws SQLException {
    String city = jObj.getString("city"), street = jObj.getString("street");
    //int building = Integer.parseInt(jObj.getString("building"));
    int building = 1;
    String startTime = jObj.getString("start_time"), endTime = jObj.getString("end_time");
    if(!checkTimeLegit(startTime, endTime))
      throw new IllegalArgumentException();
    ParkingDataBase
        .removeParkingSpot(new ParkingSpot(1, new Address(city, street, building), startTime, endTime, Integer.parseInt(jObj.getString("price"))));
  }
  
  public static void rentParkingSpot(JSONObject jObj) throws SQLException {
    String city = jObj.getString("city"), street = jObj.getString("street");
    //int building = Integer.parseInt(jObj.getString("building"));
    int building = 1;
    String startTime = jObj.getString("start_time"), endTime = jObj.getString("end_time");
    if(!checkTimeLegit(startTime, endTime))
      throw new IllegalArgumentException();
    ParkingDataBase
        .rentParkingSpot(new ParkingSpot(1, new Address(city, street, building), startTime, endTime, Integer.parseInt(jObj.getString("price"))), 1);

  }
  
  public static void unrentParkingSpot(JSONObject jObj) throws SQLException {
    String city = jObj.getString("city"), street = jObj.getString("street");
    //int building = Integer.parseInt(jObj.getString("building"));
    int building = 1;
    String startTime = jObj.getString("start_time"), endTime = jObj.getString("end_time");
    if(!checkTimeLegit(startTime, endTime))
      throw new IllegalArgumentException();
    ParkingDataBase.unrentParkingSpot(
        new ParkingSpot(1, new Address(city, street, building), startTime, endTime, Integer.parseInt(jObj.getString("price"))), 1);
  }
  
  public static JSONObject searchParkingSpots(JSONObject jObj) throws SQLException {
String $ = jObj.getString("start_time"), endTime = jObj.getString("end_time"), locX = jObj.getString("locX"), locY = jObj.getString("locY"),
    date = jObj.getString("date");
    if(!checkTimeLegit($, endTime))
      throw new IllegalArgumentException();
    return convertParkingSpotsToJSON(ParkingDataBase.searchParkingSpots(date, locX, locY, $, endTime));
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
