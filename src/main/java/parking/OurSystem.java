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

  // a helper function to adjust time to Israel time (+2)
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

  /** add parking spot to the system
   * @param jObj - should include:
   *             <p>
   *             city -> the city of the parking spot <br>
   *             street -> the street of the parking spot <br>
   *             spot_num -> the building number of the parking spot <br>
   *             start_time -> the start time of renting the parking spot in
   *             format: DateTHour <br>
   *             end_time -> the end time of renting the parking spot in format:
   *             DateTHour <br>
   *             price -> the price per hour for renting the like that: dateTtime
   *             parking spot <br>
   *             userId -> the userId of the owner of the parking spot
   * @throws IllegalArgumentException in most cases of invalid addresses. Invalid
   *                                  street number, for instance, will be count
   *                                  as valid.
   * @see {@link mapUtils.basicUtils#checkValidityOfAddress} for more information
   *      about this exception. */
  public static void addParkingSpot(final JSONObject jObj) {
    final String city = jObj.getString("city"), street = jObj.getString("street");
    final int building = Integer.parseInt(jObj.getString("spot_num"));
    final String[] startComponent = jObj.getString("start_time").split("T");
    final String startDate = startComponent[0], startHour = addTwoHours(startComponent[1].substring(0, 9));
    final String[] endComponent = jObj.getString("end_time").split("T");
    final String endDate = endComponent[0], endHour = addTwoHours(endComponent[1].substring(0, 9));
    final int price = Integer.parseInt(jObj.getString("price"));
    final String ownerID = jObj.getString("userId");
    final Address a = new Address(city, street, building);
    try {
      if (!basicUtils.checkValidityOfAddress(a))
        throw new IllegalArgumentException("Invalid Address");
    } catch (ApiException | InterruptedException | IOException ¢) {
      // TODO Auto-generated catch block
      ¢.printStackTrace();
    }
    final ParkingSpot p = new ParkingSpot(0, ownerID, null, price, a, startHour, endHour, startDate, endDate);
    try {
      ParkingDataBase.addParkingSpot(p);
    } catch (final SQLException ¢) {
      // TODO Auto-generated catch block
      ¢.printStackTrace();
    }
  }

  /** remove parking spot from the system
   * @param jObj - should include:
   *             <p>
   *             parkingSpotId -> the id of the sparking spot to be removed */
  public static void removeParkingSpot(final JSONObject jObj) {
    final int parkingSpotId = Integer.parseInt(jObj.getString("id"));
    try {
      ParkingDataBase.removeParkingSpot(parkingSpotId);
    } catch (final SQLException ¢) {
      // TODO Auto-generated catch block
      ¢.printStackTrace();
    }
  }

  /** rent available parking spot that exist in the system. you cannot rent
   * specific time, but the whole blank of time of the parking spot as the seller
   * wanted
   * @param jObj - should include:
   *             <p>
   *             buyerId -> the id of the buyer of the parking spot <br>
   *             parkingSpotId -> the id of the parking spot the buyer want to
   *             rent */
  public static void rentParkingSpot(final JSONObject jObj) {
    final String buyerId = jObj.getString("buyerId");
    final int parkingSpotId = Integer.parseInt(jObj.getString("id"));
    try {
      ParkingDataBase.rentParkingSpot(parkingSpotId, buyerId);
    } catch (final SQLException ¢) {
      // TODO Auto-generated catch block
      ¢.printStackTrace();
    }
  }

  /** unrent rented parking spot
   * @param jObj - should include:
   *             <p>
   *             parkingSpotId -> the id of the parking spot to be unrented */
  public static void unrentParkingSpot(final JSONObject jObj) {
    final int parkingSpotId = Integer.parseInt(jObj.getString("id"));
    try {
      ParkingDataBase.unRentParkingSpot(parkingSpotId);
    } catch (final SQLException ¢) {
      // TODO Auto-generated catch block
      ¢.printStackTrace();
    }
  }

  /** @return all the parking spots as JSONArray of JsonObjects that each one
   *         contains the following information of the parking spot:
   *         <p>
   *         city -> the city of the parking spot <br>
   *         street -> the street of the parking spot <br>
   *         building -> the building number of the parking spot <br>
   *         start_time -> the start time of renting the parking spot, in format:
   *         DateTHour <br>
   *         end_time -> the end time of renting the parking spot, in format:
   *         DateTHour <br>
   *         price -> the price per hour of renting the parking spot <br>
   *         userId -> the id of the owner of the parking spot <br>
   *         buyerId -> the id of the buyer of the parking spot, if there is any
   *         <br>
   *         latitude -> the latitude of the coordinates location of the parking
   *         spot <br>
   *         longitude -> the longitude of the coordinates location of the parking
   *         spot <br>
   *         id -> the identifier of the parking spot */
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

  public static JSONArray getParkingSpotsByParameters(final JSONObject jObj) {
    final String locationOption = jObj.getString("locationOption");
    final String maxDistance = jObj.getString("maxDistance");
    final String maxPrice = jObj.getString("maxPrice");
    final String address = jObj.getString("address");
    boolean addressPar = locationOption.equals("Address");
    boolean distancePar = !maxDistance.equals("-1");
    boolean pricePar = !maxPrice.equals("-1");
    Address a = null;
    double distance = 0;
    double price = 0;
    if (distancePar) {
      distance = Double.parseDouble(maxDistance);
    }
    if (pricePar) {
      price = Double.parseDouble(maxPrice);
    }
    if (addressPar) {
      try {
        a = basicUtils.transferStringToAddress(address);
      } catch (ApiException | InterruptedException | IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    } else {
      String[] coordinates = address.split(":");
      try {
        a = basicUtils.reverseGeocodingAddress(Double.parseDouble(coordinates[0]), Double.parseDouble(coordinates[1]));
      } catch (NumberFormatException | ApiException | InterruptedException | IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    List<ParkingSpot> allAvailableParkingSpots = null;
    final List<ParkingSpot> $ = new ArrayList<>();
    try {
      allAvailableParkingSpots = ParkingDataBase.getAllAvailableParkingSpots();
    } catch (final SQLException ¢) {
      // TODO Auto-generated catch block
      ¢.printStackTrace();
    }
    if (allAvailableParkingSpots == null)
      return new JSONArray();
    for (final ParkingSpot p : allAvailableParkingSpots) {
      try {
        if (price <= p.getPrice()) {
          if (distancePar) {
            if (basicUtils.calculateDistanceByAddress(a, p.getAddress()) <= distance)
              $.add(p);
          } else {
            $.add(p);
          }
        }
      } catch (ApiException | InterruptedException | IOException ¢) {
        ¢.printStackTrace();
      }
    }
    
    return convertParkingSpotsToJSONArray($);
  }

  /** @param jObj - should include:
   *             <p>
   *             userId -> the id of the user which his parking spots will be
   *             returned (available and none available)
   * @return the parking spots of the user as JSONArray of JSONObjects that each
   *         one contains parking spot's information in the following format:
   *         <p>
   *         city -> the city of the parking spot <br>
   *         street -> the street of the parking spot <br>
   *         building -> the building number of the parking spot <br>
   *         start_time -> the start time of renting the parking spot, in format:
   *         DateTHour <br>
   *         end_time -> the end time of renting the parking spot, in format:
   *         DateTHour <br>
   *         price -> the price per hour of renting the parking spot <br>
   *         userId -> the id of the owner of the parking spot <br>
   *         buyerId -> the id of the buyer of the parking spot, if there is any
   *         <br>
   *         latitude -> the latitude of the coordinates location of the parking
   *         spot <br>
   *         longitude -> the longitude of the coordinates location of the parking
   *         spot <br>
   *         id -> the identifier of the parking spot */
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

  public static JSONArray getAllParkingSpotsByBuyer(final JSONObject jObj) {
    List<ParkingSpot> $ = null;
    try {
      $ = ParkingDataBase.getAllParkingSpotsByUser(jObj.getString("buyerId"));
    } catch (final SQLException ¢) {
      // TODO Auto-generated catch block
      ¢.printStackTrace();
    }
    return convertParkingSpotsToJSONArray($);
  }

  /** @return all the available parking spots as JSONArray of JSONObjects that
   *         each one contains parking spots information in the following format:
   *         <p>
   *         city -> the city of the parking spot <br>
   *         street -> the street of the parking spot <br>
   *         building -> the building number of the parking spot <br>
   *         start_time -> the start time of renting the parking spot, in format:
   *         DateTHour <br>
   *         end_time -> the end time of renting the parking spot, in format:
   *         DateTHour <br>
   *         price -> the price per hour of renting the parking spot <br>
   *         userId -> the id of the owner of the parking spot <br>
   *         buyerId -> the id of the buyer of the parking spot, if there is any
   *         <br>
   *         latitude -> the latitude of the coordinates location of the parking
   *         spot <br>
   *         longitude -> the longitude of the coordinates location of the parking
   *         spot <br>
   *         id -> the identifier of the parking spot */
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

  /** @param jObj - should include:
   *             <p>
   *             date -> the date the user want to rent a parking spot.
   * @return all the available parking spots that fit to the date as JSONArray of
   *         JSONObjects that each one contains parking spots information in the
   *         following format:
   *         <p>
   *         city -> the city of the parking spot <br>
   *         street -> the street of the parking spot <br>
   *         building -> the building number of the parking spot <br>
   *         start_time -> the start time of renting the parking spot, in format:
   *         DateTHour <br>
   *         end_time -> the end time of renting the parking spot, in format:
   *         DateTHour <br>
   *         price -> the price per hour of renting the parking spot <br>
   *         userId -> the id of the owner of the parking spot <br>
   *         buyerId -> the id of the buyer of the parking spot, if there is any
   *         <br>
   *         latitude -> the latitude of the coordinates location of the parking
   *         spot <br>
   *         longitude -> the longitude of the coordinates location of the parking
   *         spot <br>
   *         id -> the identifier of the parking spot */
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

  /** @param jObj - should include:
   *             <p>
   *             city -> the city the user want to rent a parking spot at <br>
   *             street -> the street the user want to rent a parking spot at
   * @return all the available parking spots that fit to the street and city as
   *         JSONArray of JSONObjects that each one contains parking spots
   *         information in the following format:
   *         <p>
   *         city -> the city of the parking spot <br>
   *         street -> the street of the parking spot <br>
   *         building -> the building number of the parking spot <br>
   *         start_time -> the start time of renting the parking spot, in format:
   *         DateTHour <br>
   *         end_time -> the end time of renting the parking spot, in format:
   *         DateTHour <br>
   *         price -> the price per hour of renting the parking spot <br>
   *         userId -> the id of the owner of the parking spot <br>
   *         buyerId -> the id of the buyer of the parking spot, if there is any
   *         <br>
   *         latitude -> the latitude of the coordinates location of the parking
   *         spot <br>
   *         longitude -> the longitude of the coordinates location of the parking
   *         spot <br>
   *         id -> the identifier of the parking spot */
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

  /** @param jObj - should include:
   *             <p>
   *             distance -> the radius from the wanted location that the user
   *             want parking spots from <br>
   *             city -> the city of the wanted location <br>
   *             street -> the street of the wanted location <br>
   *             spot_num -> the building of the wanted location
   * @return all the available parking spots that fit to the air-distance from the
   *         wanted location as JSONArray of JSONObjects that each one contains
   *         parking spots information in the following format:
   *         <p>
   *         city -> the city of the parking spot <br>
   *         street -> the street of the parking spot <br>
   *         building -> the building number of the parking spot <br>
   *         start_time -> the start time of renting the parking spot, in format:
   *         DateTHour <br>
   *         end_time -> the end time of renting the parking spot, in format:
   *         DateTHour <br>
   *         price -> the price per hour of renting the parking spot <br>
   *         userId -> the id of the owner of the parking spot <br>
   *         buyerId -> the id of the buyer of the parking spot, if there is any
   *         <br>
   *         latitude -> the latitude of the coordinates location of the parking
   *         spot <br>
   *         longitude -> the longitude of the coordinates location of the parking
   *         spot <br>
   *         id -> the identifier of the parking spot */
  public static JSONArray getParkingSpotsByDistance(final JSONObject jObj) {
    final double distance = Double.parseDouble(jObj.getString("distance"));
    final String city = jObj.getString("city"), street = jObj.getString("street");
    final int building = Integer.parseInt(jObj.getString("spot_num"));
    final Address sourceAddress = new Address(city, street, building);
    List<ParkingSpot> allAvailableParkingSpots = null;
    final List<ParkingSpot> $ = new ArrayList<>();
    try {
      allAvailableParkingSpots = ParkingDataBase.getAllAvailableParkingSpots();
    } catch (final SQLException ¢) {
      // TODO Auto-generated catch block
      ¢.printStackTrace();
    }
    if (allAvailableParkingSpots == null)
      return new JSONArray();
    for (final ParkingSpot p : allAvailableParkingSpots)
      try {
        if (basicUtils.calculateDistanceByAddress(sourceAddress, p.getAddress()) <= distance)
          $.add(p);
      } catch (ApiException | InterruptedException | IOException ¢) {
        ¢.printStackTrace();
      }
    return convertParkingSpotsToJSONArray($);
  }

  /** @return all the parking spots that available today as JSONArray of
   *         JSONObjects that each one contains parking spots information in the
   *         following format:
   *         <p>
   *         city -> the city of the parking spot <br>
   *         street -> the street of the parking spot <br>
   *         building -> the building number of the parking spot <br>
   *         start_time -> the start time of renting the parking spot, in format:
   *         DateTHour <br>
   *         end_time -> the end time of renting the parking spot, in format:
   *         DateTHour <br>
   *         price -> the price per hour of renting the parking spot <br>
   *         userId -> the id of the owner of the parking spot <br>
   *         buyerId -> the id of the buyer of the parking spot, if there is any
   *         <br>
   *         latitude -> the latitude of the coordinates location of the parking
   *         spot <br>
   *         longitude -> the longitude of the coordinates location of the parking
   *         spot <br>
   *         id -> the identifier of the parking spot */
  public static JSONArray getAllAvailableSpotsToday() {
    List<ParkingSpot> $ = null;
    try {
      $ = ParkingDataBase.getAllAvailableSpotsToday();
    } catch (final SQLException ¢) {
      // TODO Auto-generated catch block
      ¢.printStackTrace();
    }
    return convertParkingSpotsToJSONArray($);
  }

  /** @return the number of all parking spots in the system */
  public static int countAllParkingSpots() {
    int $ = 0;
    try {
      $ = ParkingDataBase.countAllParkingSpots();
    } catch (final SQLException ¢) {
      // TODO Auto-generated catch block
      ¢.printStackTrace();
    }
    return $;
  }

  /** @return the number of all available parking spots in the system */
  public static int countAvailableParkingSpots() {
    int $ = 0;
    try {
      $ = ParkingDataBase.countAvailableParkingSpots();
    } catch (final SQLException ¢) {
      // TODO Auto-generated catch block
      ¢.printStackTrace();
    }
    return $;
  }

  /** @return the number of all parking spots in the system that available
   *         today */
  public static int countAvailableSpotsToday() {
    int $ = 0;
    try {
      $ = ParkingDataBase.countAvailableSpotsToday();
    } catch (final SQLException ¢) {
      // TODO Auto-generated catch block
      ¢.printStackTrace();
    }
    return $;
  }

  // convert parking spots list to a JSONArray of JSONObject which each one
  // contains parking spot information
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
