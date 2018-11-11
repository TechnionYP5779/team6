package il.org.spartan.utils;

public class angle {
  private  double conversionConstDegToRad = Math.PI/180;
  private static  double conversionConstRadToDeg = 180/Math.PI;
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
    return radians;
  }


 
  
  //TDD Example
}
