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
    String $ = String.valueOf(hour);
    for(int ¢ = 1; ¢ < startHourComponent.length; ++¢)
      $ += ":" + startHourComponent[¢];
    return $; 
  }
  
  public static void addParkingSpot(JSONObject jObj) {
    String city = jObj.getString("city"), street = jObj.getString("street");
    int building = Integer.parseInt(jObj.getString("spot_num"));
    String endTime = jObj.getString("end_time");
    
    String[] startComponent = jObj.getString("start_time").split("T");
    String startDate = startComponent[0], startHour = addTwoHours(startComponent[1].substring(0, 9));
    String[] endComponent = endTime.split("T");
    String endDate = endComponent[0], endHour = addTwoHours(endComponent[1].substring(0, 9));
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
    String buyerId = jObj.getString("buyerId");
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
 
  
  public static JSONArray getAllParkingSpots() {
    List<ParkingSpot> $ = null;
    try {
      $ = ParkingDataBase.getAllParkingSpots();
    } catch (SQLException ¢) {
      // TODO Auto-generated catch block
      ¢.printStackTrace();
    }
    return convertParkingSpotsToJSONArray($);
  }
  
  public static JSONArray getAllParkingSpotsByUser(JSONObject jObj) {
    List<ParkingSpot> $ = null;
    try {
      $ = ParkingDataBase.getAllParkingSpotsByUser(jObj.getString("userId"));
    } catch (SQLException ¢) {
      // TODO Auto-generated catch block
      ¢.printStackTrace();
    }
    return convertParkingSpotsToJSONArray($);
  }
  
  public static JSONArray getAllAvailableParkingSpots() {
    List<ParkingSpot> $ = null;
    try {
      $ = ParkingDataBase.getAllAvailableParkingSpots();
    } catch (SQLException ¢) {
      // TODO Auto-generated catch block
      ¢.printStackTrace();
    }
    return convertParkingSpotsToJSONArray($);
  }
  
  public static JSONArray getParkingSpotsByDate(JSONObject jObj) {
    //don't use it yet, need to be fixed 
    String date = jObj.getString("date");
    List<ParkingSpot> $ = null;
    try {
      $ = ParkingDataBase.searchSpotsWithDate(date);
    } catch (SQLException ¢) {
      // TODO Auto-generated catch block
      ¢.printStackTrace();
    }
    return convertParkingSpotsToJSONArray($);
  }
  
  public static JSONArray getParkingSpotsByAddress(JSONObject jObj) {
    String city = jObj.getString("city"), street = jObj.getString("street"); 
    List<ParkingSpot> $ = null;
    try {
      $ = ParkingDataBase.searchSpotsWithAddress(city, street);
    } catch (SQLException ¢) {
      // TODO Auto-generated catch block
      ¢.printStackTrace();
    }
    return convertParkingSpotsToJSONArray($);
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
  
  private static JSONArray convertParkingSpotsToJSONArray(List<ParkingSpot> pList) {
    JSONArray $ = new JSONArray();
    for(ParkingSpot ps : pList) {
      JSONObject jsonObjParkingSpot = new JSONObject();
      jsonObjParkingSpot.put("city", ps.getAddress().getCity());
      jsonObjParkingSpot.put("street", ps.getAddress().getStreet());
      jsonObjParkingSpot.put("building", ps.getAddress().getBuilding());
      jsonObjParkingSpot.put("start_time", ps.getStartTime());
      jsonObjParkingSpot.put("end_time", ps.getEndTime());
      jsonObjParkingSpot.put("price", ps.getPrice());
      jsonObjParkingSpot.put("userId", ps.getSellerID());
      jsonObjParkingSpot.put("buyerId", ps.getBuyerID());
      jsonObjParkingSpot.put("latitude", ps.getLatitude());
      jsonObjParkingSpot.put("longitude", ps.getLongitude());
      jsonObjParkingSpot.put("id", ps.getId());

      $.put(jsonObjParkingSpot);
    }
    return $;
  }
  /*
  private static boolean checkTimeLegit(String startTime, String endTime) {
    int sTHour = Integer.parseInt(startTime.substring(0, 2)), sTMin = Integer.parseInt(startTime.substring(3, 5)),
        eTHour = Integer.parseInt(endTime.substring(0, 2)), eTMin = Integer.parseInt(endTime.substring(3, 5));
    return !(eTMin < 0 | sTMin < 0 | eTHour < 0 | sTHour < 0) && !(eTMin >= 60 | sTMin >= 60 | eTHour >= 24 | sTHour >= 24);
  }
  */
  
}
