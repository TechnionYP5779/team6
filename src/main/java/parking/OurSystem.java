package parking;

import org.json.*;

import database.*;




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
    DBMain.addParkingSpot(jObj.getInt("price"), jObj.getString("city"), jObj.getString("street"),
        0, 1, 0, jObj.getString("start_time"), jObj.getString("end_time"));
    
    /*Seller s = new User("Shlomi", "Sella", "050-123-4567");
    s.addRentSlot(s.addParkingSpot(new Address(city, street, building)),
        new Time(Time.WeekDay.Sunday, new Time.DayTime(sTHour, sTMin), new Time.DayTime(eTHour, eTMin)), price);*/
  }
  
  
}
