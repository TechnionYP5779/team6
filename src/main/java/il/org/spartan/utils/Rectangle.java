package il.org.spartan.utils;

public class Rectangle {
  public final Point topLeft;
  public final Point bottomRight;
  public final Point bottomLeft;
  public final Point topRight;
  public final int length;
  public final int width;

  public Rectangle(Point a, Point b) {
    if (a.x > b.x) {
      topLeft = new Point(b);
      bottomRight = new Point(a);
    } else {
      topLeft = new Point(a);
      bottomRight = new Point(b);
    }
    topRight = new Point();
    bottomLeft = new Point();
    topRight.x = bottomRight.x;
    topRight.y = topLeft.y;
    bottomLeft.x = topLeft.x;
    bottomLeft.y = bottomRight.y;
    length = topLeft.x + topRight.y < topRight.x + bottomRight.y ? topRight.x - topLeft.x : topRight.y - bottomRight.y;
    width = (topRight.y - bottomRight.y) == length ? (topRight.x - topLeft.x) : (topRight.y - bottomRight.y);
  }

  public int getArea() {
    // TODO Auto-generated method stub
    return ((topRight.y - bottomRight.y) * (bottomRight.x - bottomLeft.x));
  }

  public int getPerimeter() {
    // TODO Auto-generated method stub
    return (2 * (topRight.y + bottomRight.x - bottomLeft.x - bottomRight.y));
  }

  public int getLength() {
    // TODO Auto-generated method stub
    return length;
  }

  public int getWidth() {
    // TODO Auto-generated method stub
    return width;
  }
}
