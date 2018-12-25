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
  
  private static String addTwoHours (String startHour) {
    String[] startHourComponent = startHour.split(":");
    int hour = Integer.parseInt(startHourComponent[0]) + 2;
    if (hour > 23)
      hour -= 24;
    String newStartHour = String.valueOf(hour);
    for(int i = 1; i < startHourComponent.length; ++i) {
      newStartHour += ":" + startHourComponent[i];
    }
    return newStartHour; 
  }
  
  public static void addParkingSpot(JSONObject jObj) {
    String city = jObj.getString("city"), street = jObj.getString("street");
    int building = Integer.parseInt(jObj.getString("building"));
    String startTime = jObj.getString("start_time"), endTime = jObj.getString("end_time");
    
    String[] startComponent = startTime.split("T");
    String startDate = startComponent[0];
    String startHour = addTwoHours(startComponent[1].substring(0,9));
    
    String[] endComponent = endTime.split("T");
    String endDate = endComponent[0];
    String endHour = addTwoHours(endComponent[1].substring(0,9));

    int price = Integer.parseInt(jObj.getString("price"));
    String ownerID = jObj.getString("userId");
    ParkingSpot p = new ParkingSpot(0, ownerID, null, price, new Address(city, street, building),startHour, endHour, startDate, endDate);
    try {
      ParkingDataBase.addParkingSpot(p);
    } catch (SQLException ¢) {
      // TODO Auto-generated catch block
      ¢.printStackTrace();
    }
  }
  
  public static void removeParkingSpot(JSONObject jObj) {
    int parkingSpotId = Integer.parseInt(jObj.getString("parkingSpotId"));
    try {
      ParkingDataBase.removeParkingSpot(parkingSpotId);
    } catch (SQLException ¢) {
      // TODO Auto-generated catch block
      ¢.printStackTrace();
    }
  }
  
  public static void rentParkingSpot(JSONObject jObj) {
    String buyerId = jObj.getString("userId");
    int parkingSpotId = Integer.parseInt(jObj.getString("parkingSpotId"));
    try {
      ParkingDataBase.rentParkingSpot(parkingSpotId, buyerId);
    } catch (SQLException ¢) {
      // TODO Auto-generated catch block
      ¢.printStackTrace();
    }
  }
  
  public static void unrentParkingSpot(JSONObject jObj) {
    int parkingSpotId = Integer.parseInt(jObj.getString("parkingSpotId"));
    try {
      ParkingDataBase.unRentParkingSpot(parkingSpotId);
    } catch (SQLException ¢) {
      // TODO Auto-generated catch block
      ¢.printStackTrace();
    }
  }
 
  
  public static JSONObject getAllParkingSpots(JSONObject jObj) {
    List<ParkingSpot> pList = null;
    try {
      pList = ParkingDataBase.getAllParkingSpots();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return convertParkingSpotsToJSON(pList);
  }
  
  public static JSONObject getAllAvailableParkingSpots(JSONObject jObj) {
    List<ParkingSpot> pList = null;
    try {
      pList = ParkingDataBase.getAllAvailableParkingSpots();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return convertParkingSpotsToJSON(pList);
  }
  
  public static JSONObject getParkingSpotsByDate(JSONObject jObj) {
    //don't use it yet, need to be fixed 
    String date = jObj.getString("date");
    List<ParkingSpot> pList = null;
    try {
      pList = ParkingDataBase.searchSpotsWithDate(date);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return convertParkingSpotsToJSON(pList);
  }
  
  public static JSONObject getParkingSpotsByAddress(JSONObject jObj) {
    String city = jObj.getString("city"), street = jObj.getString("street"); 
    List<ParkingSpot> pList = null;
    try {
      pList = ParkingDataBase.searchSpotsWithAddress(city, street);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return convertParkingSpotsToJSON(pList);
  }
  
//  public static JSONObject searchParkingSpots(JSONObject jObj) {
//String startTime = jObj.getString("start_time"), endTime = jObj.getString("end_time"), locX = jObj.getString("locX"), locY = jObj.getString("locY"),
//    date = jObj.getString("date");
//    if(!checkTimeLegit(startTime, endTime))
//      throw new IllegalArgumentException();
//    List<ParkingSpot> $ = null;
//    try {
//      $ = ParkingDataBase.getAllParkingSpots();
//    } catch (SQLException ¢) {
//      // TODO Auto-generated catch block
//      ¢.printStackTrace();
//    }
//    return convertParkingSpotsToJSON($);
//  }
  
  private static JSONObject convertParkingSpotsToJSON(List<ParkingSpot> pList) {
    //String jsonDataString = "{\"lat\":\"value\",\"lon\":\"value\"}";
    JSONObject $ = new JSONObject();
    
    for(ParkingSpot ¢ : pList) {
//      JSONObject jsonObjParkingSpot = new JSONObject();
      $.put(String.valueOf(¢.getId()), ¢ + "");
    }
    return $;
  }
  
  private static boolean checkTimeLegit(String startTime, String endTime) {
    int sTHour = Integer.parseInt(startTime.substring(0, 2)), sTMin = Integer.parseInt(startTime.substring(3, 5)),
        eTHour = Integer.parseInt(endTime.substring(0, 2)), eTMin = Integer.parseInt(endTime.substring(3, 5));
    return !(eTMin < 0 | sTMin < 0 | eTHour < 0 | sTHour < 0) && !(eTMin >= 60 | sTMin >= 60 | eTHour >= 24 | sTHour >= 24);
  }
  
  
}
