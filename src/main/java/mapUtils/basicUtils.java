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
  /** @param a address
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

  /** @param lat lat coordinates of an address
   * @param lng lng coordinates of an address
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

  /**
   * 
   * @param source the address which the distance is calculated from
   * @param destination the address which the distance is calculated to
   * @return air distance between the two addresses in meters.
   * @throws ApiException
   * @throws InterruptedException
   * @throws IOException
   */
  @SuppressWarnings("boxing") public static double calculateDistanceByAddress(Address source, Address destination) throws ApiException, InterruptedException, IOException {
    Pair<Double, Double> sourceCoordinates = geocodingAddress(source);
    Pair<Double, Double> destinationCoordinates = geocodingAddress(destination);
    return calculateDistanceByCoordinates(sourceCoordinates.first, sourceCoordinates.second, destinationCoordinates.first,
        destinationCoordinates.second);
  }

  //this function gets coordinates and return the distance between the coordinates
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
//    Address source = new Address("Petah Tikwa", "Salomon", 3);
//    Address destination = new Address("Petah Tikwa", "Tidhar", 6);
//    System.out.print(calculateDistanceByAddress(source, destination));
//  }
}
