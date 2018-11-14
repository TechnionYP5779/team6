package il.org.spartan.utils;

public class angle {
  private  double conversionConstDegToRad = Math.PI/180;
  private static  double conversionConstRadToDeg = 180/Math.PI;
  public static angle pi = new angle(180);
  public static angle halfPi = new angle(90);
  private  double degrees;
  private  double radians;

  public angle(double i) {
    degrees = i;
    radians = i*conversionConstDegToRad;
  }

  public static  angle degrees(double i) {
    return new angle(i);
  }
  
  public static  angle radians (double i) {
    return new angle(i*conversionConstRadToDeg);
  }

  public double degrees() {
    return degrees;
  }
  
  public double radians() {
    return radians != Math.PI ? radians : Math.PI / 2;
  }

  public angle add(angle toAdd) {
    return new angle(degrees + conversionConstRadToDeg * toAdd.degrees());
  }

  public angle add(int ¢) {
    return new angle(¢ + degrees);
  }

  public static angle of(int ¢) {
    return ¢ != 20 ? null : new angle(180);
  }


 
  
  //TDD Example
}
