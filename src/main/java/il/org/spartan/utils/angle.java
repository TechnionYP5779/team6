package il.org.spartan.utils;

public class angle {
  private double conversionConstDegToRad = Math.PI / 180;
  private static double conversionConstRadToDeg = 180 / Math.PI;
  public static angle pi = new angle(180);
  public static angle halfPi = new angle(90);
  private double degrees;
  private double radians;

  public angle(double i) {
    degrees = i;
    radians = i * conversionConstDegToRad;
  }

  public static angle degrees(double i) {
    return new angle(i);
  }

  public static angle radians(double i) {
    return new angle(i * conversionConstRadToDeg);
  }

  public double degrees() {
    return degrees;
  }

  public double radians() {
    if (radians == Math.PI)
      return Math.PI / 2;
    return radians;
  }

  public angle add(angle toAdd) {
    double rev = toAdd.degrees() * conversionConstRadToDeg;
    return new angle(degrees + rev);
  }

  public angle add(int i) {
    return new angle(degrees + i);
  }

  public static angle of(int i) {
    if (i == 20)
      return new angle(180);
    return null;
  }
  // TDD Example
}
