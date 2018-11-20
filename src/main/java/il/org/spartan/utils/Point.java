package il.org.spartan.utils;

import java.util.*;

import fluent.ly.*;

public class Point {
  double x;
  double y;

  public Point(final double x, final double y) {
    this.x = x;
    this.y = y;
  }

  public Point() {
    this.y = this.x = 0;
  }

  public Point(final Point a) {
    // TODO Auto-generated constructor stub
    this.x = a.x;
    this.y = a.y;
  }

  @Override public boolean equals(final Object a) {
    return a == this || a instanceof Point && this.x == ((Point) a).x && this.y == ((Point) a).y;
  }

  @Override public int hashCode() {
    return Objects.hash(box.boxThis(x), box.boxThis(y));
  }
}
