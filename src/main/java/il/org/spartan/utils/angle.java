package il.org.spartan.utils;

public class angle {

  
  private  double degrees;

  public angle(double i) {
    degrees = i;
  }

  public static  angle degrees(double i) {
    return new angle(i);
  }

  public double degrees() {
    return degrees;
  }


 
  
  //TDD Example
}
