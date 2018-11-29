package il.org.spartan.utils;

import java.util.*;

import fluent.ly.*;

/** <br>
 * This class represents a Point and was constructed with the TDD method. <br>
 * A Point is constructed with two parameters which represent the location of
 * the Point: x and y, both double values. <br>
 * @author Idan Hadad
 * @since November 2018 */
public class Point {
  double x;
  double y;

  /** constructor
   * @param x : x location value of point
   * @param y : y location value of point
   * @return A Point instance with specified x and y parameters. */
  public Point(final double x, final double y) {
    this.x = x;
    this.y = y;
  }

  /** default constructor
   * @return A Point instance with x=0 , y=0 */
  public Point() {
    this.y = this.x = 0;
  }

  /** copy constructor
   * @param a : a Point object to copy
   * @return A Point instance with the same x and y values as a. */
  public Point(final Point a) {
    // TODO Auto-generated constructor stub
    this.x = a.x;
    this.y = a.y;
  }

  /** equals override.
   * @param a : a Point object to compare to
   * @return true if both Points have the same x and y values, false otherwise */
  @Override public boolean equals(final Object a) {
    return a == this || a instanceof Point && this.x == ((Point) a).x && this.y == ((Point) a).y;
  }

  /** hashcode override.
   * @return true if both Points have the same x and y values, false otherwise */
  @Override public int hashCode() {
    return Objects.hash(box.boxThis(x), box.boxThis(y));
  }
}
