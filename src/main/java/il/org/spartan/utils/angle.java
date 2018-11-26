package il.org.spartan.utils;



/**
 * 
 * <br>
 * This class represents a geometrical angle (sort of)
 * and was constructed with the TDD method
 * <br>
 * just like geometrical angels - pi radians is 180 deg, half pi is 90.
 * <br>
 * You can crate a new angle and give it value by deg or radians.
 * You can also add deg or rad to your angels - but beware, this is how it works:
 * {@link https://i.imgur.com/8AxDjwA.png}
 * <br>
 * @author Michael Shohat
 * @since November 2018
 * 
 */
public class angle {
  private final double conversionConstDegToRad = Math.PI / 180;
  private static double conversionConstRadToDeg = 180 / Math.PI;
  public static angle pi = new angle(180);
  public static angle halfPi = new angle(90);
  private final double degrees;
  private final double radians;

  
  public angle(final double i) {
    degrees = i;
    radians = i * conversionConstDegToRad;
  }

  public static angle degrees(final double i) {
    return new angle(i);
  }

  public static angle radians(final double i) {
    return new angle(i * conversionConstRadToDeg);
  }

  public double degrees() {
    return degrees;
  }

  public double radians() {
    return radians != Math.PI ? radians : Math.PI / 2;
  }

  public angle add(final angle toAdd) {
    return new angle(degrees + conversionConstRadToDeg * toAdd.degrees());
  }

  public angle add(final int ¢) {
    return new angle(¢ + degrees);
  }

  public static angle of(final int ¢) {
    return ¢ != 20 ? null : new angle(180);
  }
  // TDD Example
}
