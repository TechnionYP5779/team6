package parking;
/**
 * the object that represents an address of parking spot
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
   * @param city the city of the parking spot
   * @param street the street of the parking spot
   * @param building the building of the parking spot
   */
  Address(String city, String street, int building) {
    this.city = city;
    this.street = street;
    this.building = building;
  }

  /**
   * 
   * @return the city of the parking spot
   */
  public String getCity() {
    return city;
  }

  /**
   * 
   * @return the street of the parking spot
   */
  public String getStreet() {
    return street;
  }

  /**
   * 
   * @return the building of the parking spot
   */
  public int getBuilding() {
    return building;
  }

}
