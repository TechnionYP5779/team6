package mapUtils;

/**
 * Thrown to indicate that a method has been passed an illegal or
 * inappropriate address. The exception <b>may <tt> have (<b>not necessary<tt>) more info about which argument wrong, which can be accessed via:
 * <p> isCityOk
 * <br> isStreetOk
 * <br> isBuildingOk
 * <p> To get access to the address data, if exist:
 * <p> getCityName
 * <br> getStreetName
 * <br>getBuildingNumber
 * 
 * @fluent.ly.Package mapUtils
 * @fluent.ly.Since Dec 27, 2018
 * @fluent.ly.Author Or
 * @fluent.ly.ClassDesc TODO
 */

public class InvalidAddressException extends IllegalArgumentException {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private boolean cityValid;
  private boolean streetValid;
  private boolean buildingValid;
  
  private String cityName;
  private String streetName;
  private int buildingNum;
  
  /**
   * @return True
   * <br> False - The city is not valid
   */
  public boolean isCityOk() {return this.cityValid;}
  
  /**
   * @return True
   * <br> False - The street is not valid
   */
  public boolean isStreetOk() {return this.streetValid;}
  
  /**
   * @return True
   * <br> False - The building is not valid
   */
  public boolean isBuildingOk() {return this.buildingValid;}
  
  /**
   * 
   * @return The name of the city belongs to address, if there is any. null otherwise
   */
  public String getCityName() {return this.cityName;}
  
  /**
   * 
   * @return The name of the street belongs to address, if there is any. null otherwise.
   */
  public String getStreetName() {return this.streetName;}
  
  /**
   * 
   * @return The number of the building belongs to address, if there is any. 0 otherwise
   */
  public int getBuildingNumber() {return this.buildingNum;}
  
  
  public InvalidAddressException(String message) {
    super(message);
  }
  
  public InvalidAddressException(String message, Throwable cause) {
    super(message, cause);
  }
  
  public InvalidAddressException() {
    super();
  }
  
  public InvalidAddressException(Throwable cause) {
    super(cause);
  }
  
  /**
   * Constructs an <code>IllegalArgumentException</code> with more details about which parameter is wrong
   * @param cityValid - validity of city
   * @param streetValid - validity of street
   * @param buildingValid - validity of building
   */
  public InvalidAddressException(boolean cityValid, boolean streetValid, boolean buildingValid, String cityName, String streetName, int buildingNum) {
    super();
    this.cityValid = cityValid;
    this.streetValid = streetValid;
    this.buildingValid = buildingValid;
    this.cityName = cityName;
    this.streetName = streetName;
    this.buildingNum = buildingNum;
   }
  
  public InvalidAddressException(String cityName, String streetName, int buildingNum) {
    super();
    this.cityValid = false;
    this.streetValid = false;
    this.buildingValid = false;
    this.cityName = cityName;
    this.streetName = streetName;
    this.buildingNum = buildingNum;
   }
}
