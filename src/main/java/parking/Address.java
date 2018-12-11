package parking;
/**
 * the class that represents an address of parking spot
 * @fluent.ly.Package parking
 * @fluent.ly.Since Dec 8, 2018
 * @fluent.ly.Author Or, Nitzan
 */
public class Address {
  private String city;
  private String street;
  private int building;

  /**
   * 
   * @param city the city that the parking spot located in
   * @param street the street that the parking spot located in
   * @param building the building that the parking spot located in
   */
  Address(String city, String street, int building) {
    this.city = city;
    this.street = street;
    this.building = building;
  }

  /**
   * 
   * @return the city that the parking spot located in
   */
  public String getCity() {
    return city;
  }

  /**
   * 
   * @return the street that the parking spot located in
   */
  public String getStreet() {
    return street;
  }

  /**
   * 
   * @return the building that the parking spot located in
   */
  public int getBuilding() {
    return building;
  }

}
