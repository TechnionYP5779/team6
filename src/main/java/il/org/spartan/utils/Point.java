package il.org.spartan.utils;

public class Point {
  int x;
  int y;
  public Point(int x, int y) {
    super();
    this.x = x;
    this.y = y;
  }
  public Point() {
    super();
    this.x = 0;
    this.y = 0;
  }
  public Point(Point a) {
    // TODO Auto-generated constructor stub
    this.x = a.x;
    this.y=a.y;
  }
  
  @Override public boolean equals(Object a) {
    if (this == a) return true;
    if (!(a instanceof Point)) return false;
    Point na = (Point)a;
    return (this.x==na.x && this.y == na.y);
  }
  
}
