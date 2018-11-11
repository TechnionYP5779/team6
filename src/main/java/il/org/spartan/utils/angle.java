package il.org.spartan.utils;

public class angle {

  
  private  int degrees;

  public angle(int i) {
    degrees = i;
  }

  public static  angle degrees(int i) {
    return new angle(i);
  }

  public int degrees() {
    return degrees;
  }


 
  
  //TDD Example
}
