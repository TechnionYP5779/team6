package mapUtils;

import java.io.*;

import com.google.gson.*;
import com.google.maps.*;
import com.google.maps.errors.*;
import com.google.maps.model.*;

import fluent.ly.*;
import il.org.spartan.utils.*;
import parking.*;

/** @fluent.ly.Package mapUtils
 * @fluent.ly.Since Dec 25, 2018
 * @fluent.ly.Author Or
 * @fluent.ly.ClassDesc TODO */
public class basicUtils {
  /** @param a - address
   * @return the coordinates of the address as a Pair
   * @throws ApiException
   * @throws InterruptedException
   * @throws IOException */
  public static Pair<Double, Double> geocodingAddress(final Address ¢) throws ApiException, InterruptedException, IOException {
    final GeocodingResult[] $ = GeocodingApi.geocode(new GeoApiContext.Builder().apiKey("AIzaSyDQSACUeONioHKwbzWqEmL35YqRAbgnjeQ").build(),
        String.valueOf(¢.getStreet() + " " + ¢.getBuilding()) + ", " + ¢.getCity()).await();
    return new Pair<>(box.it(Double.parseDouble(new GsonBuilder().setPrettyPrinting().create().toJson(box.it($[0].geometry.location.lat)))),
        box.it(Double.parseDouble(new GsonBuilder().setPrettyPrinting().create().toJson(box.it($[0].geometry.location.lng)))));
  }

  /** @param lat - latitude coordinates of an address
   * @param lng - longitude coordinates of an address
   * @return the address of the coordinates
   * @throws ApiException
   * @throws InterruptedException
   * @throws IOException */
  public static Address reverseGeocodingAddress(final double lat, final double lng) throws ApiException, InterruptedException, IOException {
    final GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyDQSACUeONioHKwbzWqEmL35YqRAbgnjeQ").build();
    final GeocodingResult[] results = GeocodingApi.reverseGeocode(context, new LatLng(lat, lng)).await();
    final String buildingString = new GsonBuilder().setPrettyPrinting().create().toJson(results[0].addressComponents[0].longName);
    final int $ = Integer.parseInt(buildingString.substring(1, buildingString.length() - 1));
    String street = new GsonBuilder().setPrettyPrinting().create().toJson(results[0].addressComponents[1].longName);
    final int lastIndex = street.lastIndexOf("Street");
    street = street.substring(1, lastIndex - 1);
    return new Address(new GsonBuilder().setPrettyPrinting().create().toJson(results[0].addressComponents[2].longName).substring(1, lastIndex - 2),
        street, $);
  }

  public static Address transferStringToAddress (String s) throws ApiException, InterruptedException, IOException {
    final GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyDQSACUeONioHKwbzWqEmL35YqRAbgnjeQ").build();
    final GeocodingResult[] $ = GeocodingApi.geocode(new GeoApiContext.Builder().apiKey("AIzaSyDQSACUeONioHKwbzWqEmL35YqRAbgnjeQ").build(), s).await();
    
    String city = "";
    String street = "";
    int building = 0;
    for (AddressComponent ac : $[0].addressComponents) {
      switch(ac.types[0]) {
        case STREET_ADDRESS: city += ac.longName;
          break;
        case ROUTE: street += ac.longName;
          break;
        case LOCALITY: building = Integer.parseInt(ac.longName);
          break;
        default:
      }
    }
    return new Address(city, street, building);
  }
  
  /** check the validity of address and return the result.
   * <p>
   * <b>IMPORTANT NOTES: <br>
   * 1. Some invalid addresses will be returned as valid. For example, wrong
   * street number will pass this validation. <br>
   * 2. The function depends strongly on the implementation of the Google Api.
   * Will not work on other implementation than this specific one.
   * @param a - address
   * @return True - if address is valid or only the building number is invalid
   *         <br>
   *         False - otherwise
   * @throws InvalidAddressException
   * @throws ApiException
   * @throws InterruptedException
   * @throws IOException */
  public static void checkValidityOfAddress(Address a) throws ApiException, InterruptedException, IOException, InvalidAddressException {
    final GeocodingResult[] $ = GeocodingApi.geocode(new GeoApiContext.Builder().apiKey("AIzaSyDQSACUeONioHKwbzWqEmL35YqRAbgnjeQ").build(),
        String.valueOf(a.getStreet() + " " + a.getBuilding()) + ", " + a.getCity()).await();
    if ($ == null || $.length == 0)
        throw new InvalidAddressException(a.getCity(), a.getStreet(), a.getBuilding());
    boolean checkStreet = false, checkCity = false, checkBuilding = false;
    for(AddressComponent ac : $[0].addressComponents) {
      if(ac.types[0].equals(AddressComponentType.STREET_NUMBER)) checkBuilding = true;
      else if(ac.types[0].equals(AddressComponentType.ROUTE)) checkStreet = true;
      else if(ac.types[0].equals(AddressComponentType.LOCALITY)) checkCity = true;
    }
    if (!checkCity || !checkStreet || !checkBuilding)
      throw new InvalidAddressException(checkCity, checkStreet, checkBuilding, a.getCity(), a.getStreet(), a.getBuilding());
  }
  

  /** @param source  - the address which the distance is calculated from
   * @param destination - the address which the distance is calculated to
   * @return air distance between the two addresses in meters.
   * @throws ApiException
   * @throws InterruptedException
   * @throws IOException */
  @SuppressWarnings("boxing") public static double calculateDistanceByAddress(Address source, Address destination)
      throws ApiException, InterruptedException, IOException {
    Pair<Double, Double> sourceCoordinates = geocodingAddress(source);
    Pair<Double, Double> destinationCoordinates = geocodingAddress(destination);
    return calculateDistanceByCoordinates(sourceCoordinates.first, sourceCoordinates.second, destinationCoordinates.first,
        destinationCoordinates.second);
  }

  // this function gets coordinates and return the distance between the
  // coordinates
  private static double calculateDistanceByCoordinates(double sourceLat, double sourceLng, double destinationLat, double destinationLng) {
    final int R = 6371; // Radius of the earth
    double latDistance = Math.toRadians(destinationLat - sourceLat);
    double lngDistance = Math.toRadians(destinationLng - sourceLng);
    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
        + Math.cos(Math.toRadians(sourceLat)) * Math.cos(Math.toRadians(destinationLat)) * Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);
    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    double distance = R * c * 1000; // convert to meters
    return Math.sqrt(Math.pow(distance, 2));
  }

//  public static void main(final String[] args) throws ApiException, InterruptedException, IOException {
//    Address ¢ = new Address("Petah Tikwa", "vsdvd", 5);
//    try {
//      checkValidityOfAddress(¢);
//      System.out.println("OK");
//    } catch(InvalidAddressException e) {
//      System.out.println("City " + e.getCityName() + " is " + e.isCityOk());
//      System.out.println("Street " + e.getStreetName() +" is " + e.isStreetOk());
//      System.out.println("Building " + e.getBuildingNumber() + " is " + e.isBuildingOk());
//    }
//    
//    System.out.println("OK");
    
//    System.out.println(calculateDistanceByAddress(new Address("אריאל", "דרך הציונות", 2) ,¢));
//    System.out.println(geocodingAddress(¢));
//    final GeocodingResult[] $ = GeocodingApi.geocode(new GeoApiContext.Builder().apiKey("AIzaSyDQSACUeONioHKwbzWqEmL35YqRAbgnjeQ").build(),
//        String.valueOf(¢.getStreet() + " " + ¢.getBuilding()) + ", " + ¢.getCity()).await();
    
//    for(AddressComponent ac : $[0].addressComponents)
//      System.out.println(ac.types[0]);
//    
//    
    // System.out.print(checkValidityOfAddress(¢));
    // System.out.print(checkValidityOfAddress(¢));
    // final GeocodingResult[] $ = GeocodingApi.geocode(new
    // GeoApiContext.Builder().apiKey("AIzaSyDQSACUeONioHKwbzWqEmL35YqRAbgnjeQ").build(),
    // String.valueOf(¢.getStreet() + " " + ¢.getBuilding()) + ", " +
    // ¢.getCity()).await();
    // System.out.print(new
    // GsonBuilder().setPrettyPrinting().create().toJson($[0].addressComponents));
    // Address destination = new Address("Petah Tikwa", "Herzel", 3);
    // System.out.print(calculateDistanceByAddress(source, destination));
//  }
}
