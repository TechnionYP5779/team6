package mapUtils;

import java.io.*;

import com.google.gson.*;
import com.google.maps.*;
import com.google.maps.errors.*;
import com.google.maps.model.*;

import fluent.ly.*;
import il.org.spartan.utils.*;
import parking.*;

/**
 * 
 * @fluent.ly.Package mapUtils
 * @fluent.ly.Since Dec 25, 2018
 * @fluent.ly.Author Or
 * @fluent.ly.ClassDesc TODO
 */

public class basicUtils {
  /**
   * 
   * @param a address
   * @return the coordinates of the address
   * @throws ApiException
   * @throws InterruptedException
   * @throws IOException
   */
  public static Pair<Double, Double> geocodingAddress(Address a) throws ApiException, InterruptedException, IOException {
    GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyDQSACUeONioHKwbzWqEmL35YqRAbgnjeQ").build();
    GeocodingResult[] results = GeocodingApi.geocode(context, String.valueOf(a.getStreet() + " " + a.getBuilding()) + ", " + a.getCity()).await();
     final double lat = Double.parseDouble(new GsonBuilder().setPrettyPrinting().create().toJson(box.it(results[0].geometry.location.lat)));
     final double lng = Double.parseDouble(new GsonBuilder().setPrettyPrinting().create().toJson(box.it(results[0].geometry.location.lng)));
     return new Pair<>(box.it(lat), box.it(lng));
  }
  
  /**
   * 
   * @param lat lat coordinates of an address
   * @param lng lng coordinates of an address
   * @return the address of the coordinates
   * @throws ApiException
   * @throws InterruptedException
   * @throws IOException
   */
  public static Address reverseGeocodingAddress(double lat, double lng) throws ApiException, InterruptedException, IOException {
    GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyDQSACUeONioHKwbzWqEmL35YqRAbgnjeQ").build();
    GeocodingResult[] results = GeocodingApi.reverseGeocode(context, new LatLng(lat, lng)).await();
    
    String buildingString = new GsonBuilder().setPrettyPrinting().create().toJson(results[0].addressComponents[0].longName);
    int building = Integer.parseInt(buildingString.substring(1, buildingString.length()-1));
    
    String street = new GsonBuilder().setPrettyPrinting().create().toJson(results[0].addressComponents[1].longName);
    int lastIndex = street.lastIndexOf("Street");
    street = street.substring(1,lastIndex-1);
    
    String city = new GsonBuilder().setPrettyPrinting().create().toJson(results[0].addressComponents[2].longName);
    city = city.substring(1,lastIndex-2);
    
    return new Address(city, street, building);
  }
}


