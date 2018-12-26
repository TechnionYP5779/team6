package parking;

import java.io.*;
import java.sql.*;
import java.util.*;

import org.json.*;

import com.google.maps.errors.*;

import database.*;
import mapUtils.*;

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

  private static String addTwoHours(final String startHour) {
    final String[] startHourComponent = startHour.split(":");
    int hour = Integer.parseInt(startHourComponent[0]) + 2;
    if (hour > 23)
      hour -= 24;
    String $ = String.valueOf(hour);
    for (int ¢ = 1; ¢ < startHourComponent.length; ++¢)
      $ += ":" + startHourComponent[¢];
    return $;
  }

  public static void addParkingSpot(final JSONObject jObj) {
    final String city = jObj.getString("city"), street = jObj.getString("street");
    final int building = Integer.parseInt(jObj.getString("spot_num"));
    final String endTime = jObj.getString("end_time");
    final String[] startComponent = jObj.getString("start_time").split("T");
    final String startDate = startComponent[0], startHour = addTwoHours(startComponent[1].substring(0, 9));
    final String[] endComponent = endTime.split("T");
    final String endDate = endComponent[0], endHour = addTwoHours(endComponent[1].substring(0, 9));
    final int price = Integer.parseInt(jObj.getString("price"));
    final String ownerID = jObj.getString("userId");
    final ParkingSpot p = new ParkingSpot(0, ownerID, null, price, new Address(city, street, building), startHour, endHour, startDate, endDate);
    try {
      ParkingDataBase.addParkingSpot(p);
    } catch (final SQLException ¢) {
      // TODO Auto-generated catch block
      ¢.printStackTrace();
    }
  }

  public static void removeParkingSpot(final JSONObject jObj) {
    final int parkingSpotId = Integer.parseInt(jObj.getString("parkingSpotId"));
    try {
      ParkingDataBase.removeParkingSpot(parkingSpotId);
    } catch (final SQLException ¢) {
      // TODO Auto-generated catch block
      ¢.printStackTrace();
    }
  }

  public static void rentParkingSpot(final JSONObject jObj) {
    final String buyerId = jObj.getString("buyerId");
    final int parkingSpotId = Integer.parseInt(jObj.getString("parkingSpotId"));
    try {
      ParkingDataBase.rentParkingSpot(parkingSpotId, buyerId);
    } catch (final SQLException ¢) {
      // TODO Auto-generated catch block
      ¢.printStackTrace();
    }
  }

  public static void unrentParkingSpot(final JSONObject jObj) {
    final int parkingSpotId = Integer.parseInt(jObj.getString("parkingSpotId"));
    try {
      ParkingDataBase.unRentParkingSpot(parkingSpotId);
    } catch (final SQLException ¢) {
      // TODO Auto-generated catch block
      ¢.printStackTrace();
    }
  }

  public static JSONArray getAllParkingSpots() {
    List<ParkingSpot> $ = null;
    try {
      $ = ParkingDataBase.getAllParkingSpots();
    } catch (final SQLException ¢) {
      // TODO Auto-generated catch block
      ¢.printStackTrace();
    }
    return convertParkingSpotsToJSONArray($);
  }

  public static JSONArray getAllParkingSpotsByUser(final JSONObject jObj) {
    List<ParkingSpot> $ = null;
    try {
      $ = ParkingDataBase.getAllParkingSpotsByUser(jObj.getString("userId"));
    } catch (final SQLException ¢) {
      // TODO Auto-generated catch block
      ¢.printStackTrace();
    }
    return convertParkingSpotsToJSONArray($);
  }

  public static JSONArray getAllAvailableParkingSpots() {
    List<ParkingSpot> $ = null;
    try {
      $ = ParkingDataBase.getAllAvailableParkingSpots();
    } catch (final SQLException ¢) {
      // TODO Auto-generated catch block
      ¢.printStackTrace();
    }
    return convertParkingSpotsToJSONArray($);
  }

  public static JSONArray getParkingSpotsByDate(final JSONObject jObj) {
    // don't use it yet, need to be fixed
    final String date = jObj.getString("date");
    List<ParkingSpot> $ = null;
    try {
      $ = ParkingDataBase.searchSpotsWithDate(date);
    } catch (final SQLException ¢) {
      // TODO Auto-generated catch block
      ¢.printStackTrace();
    }
    return convertParkingSpotsToJSONArray($);
  }

  public static JSONArray getParkingSpotsByAddress(final JSONObject jObj) {
    final String city = jObj.getString("city"), street = jObj.getString("street");
    List<ParkingSpot> $ = null;
    try {
      $ = ParkingDataBase.searchSpotsWithAddress(city, street);
    } catch (final SQLException ¢) {
      // TODO Auto-generated catch block
      ¢.printStackTrace();
    }
    return convertParkingSpotsToJSONArray($);
  }
  
  public static JSONArray getParkingSpotsByDistance(final JSONObject jObj) {
    final double distance = Double.parseDouble(jObj.getString("distance"));
    final String city = jObj.getString("city"), street = jObj.getString("street");
    final int building = Integer.parseInt(jObj.getString("building"));
    Address sourceAddress = new Address(city, street, building);
    List<ParkingSpot> allAvailableParkingSpots = null;
    List<ParkingSpot> $ = new ArrayList<>();
    try {
      allAvailableParkingSpots = ParkingDataBase.getAllAvailableParkingSpots();
    } catch (final SQLException ¢) {
      // TODO Auto-generated catch block
      ¢.printStackTrace();
    }
    if (allAvailableParkingSpots == null) return new JSONArray();
    for (ParkingSpot p : allAvailableParkingSpots) {
      try {
        if (basicUtils.calculateDistanceByAddress(sourceAddress, p.getAddress()) <= distance) {
          $.add(p);
        }
      } catch (ApiException | InterruptedException | IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    return convertParkingSpotsToJSONArray($);
  }

  // public static JSONObject searchParkingSpots(JSONObject jObj) {
  // String startTime = jObj.getString("start_time"), endTime =
  // jObj.getString("end_time"), locX = jObj.getString("locX"), locY =
  // jObj.getString("locY"),
  // date = jObj.getString("date");
  // if(!checkTimeLegit(startTime, endTime))
  // throw new IllegalArgumentException();
  // List<ParkingSpot> $ = null;
  // try {
  // $ = ParkingDataBase.getAllParkingSpots();
  // } catch (SQLException ¢) {
  // // TODO Auto-generated catch block
  // ¢.printStackTrace();
  // }
  // return convertParkingSpotsToJSON($);
  // }
  private static JSONArray convertParkingSpotsToJSONArray(final List<ParkingSpot> pList) {
    final JSONArray $ = new JSONArray();
    for (final ParkingSpot ps : pList) {
      final JSONObject jsonObjParkingSpot = new JSONObject();
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
  /* private static boolean checkTimeLegit(String startTime, String endTime) { int
   * sTHour = Integer.parseInt(startTime.substring(0, 2)), sTMin =
   * Integer.parseInt(startTime.substring(3, 5)), eTHour =
   * Integer.parseInt(endTime.substring(0, 2)), eTMin =
   * Integer.parseInt(endTime.substring(3, 5)); return !(eTMin < 0 | sTMin < 0 |
   * eTHour < 0 | sTHour < 0) && !(eTMin >= 60 | sTMin >= 60 | eTHour >= 24 |
   * sTHour >= 24); } */
}
