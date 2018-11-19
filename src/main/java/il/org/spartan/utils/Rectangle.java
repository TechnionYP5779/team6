package il.org.spartan.utils;


public class Rectangle {

  public final Point topLeft;
  public final Point bottomRight;
  public final Point bottomLeft;
  public final Point topRight;
  public final int length;
  public final int width;

  public Rectangle(Point a, Point b) {
   if (a.x <= b.x) {
     topLeft = new Point(a);
     bottomRight = new Point(b);
   }
   else {
     topLeft = new Point(b);
     bottomRight = new Point(a);
   }
   topRight=new Point();
   bottomLeft=new Point();
   topRight.x=bottomRight.x;
   topRight.y=topLeft.y;
   bottomLeft.x=topLeft.x;
   bottomLeft.y=bottomRight.y;
   
   length = (topRight.y - bottomRight.y) >= (topRight.x - topLeft.x) ? (topRight.y - bottomRight.y) :(topRight.x - topLeft.x);
   width = (topRight.y - bottomRight.y) == length ? (topRight.x - topLeft.x) : (topRight.y - bottomRight.y);
  }

  public int getArea() {
    // TODO Auto-generated method stub
    return ((bottomRight.x-bottomLeft.x) * (topRight.y - bottomRight.y));
  }

  public int getPerimeter() {
    // TODO Auto-generated method stub
    return (((bottomRight.x-bottomLeft.x) + (topRight.y - bottomRight.y))*2);
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
