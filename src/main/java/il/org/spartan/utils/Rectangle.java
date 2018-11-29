package il.org.spartan.utils;

import java.security.*;

/** <br>
 * This class represents a Rectangle and was constructed with the TDD method.
 * <br>
 * A Rectangle is constructed with two {@link Point}s which represent two
 * vertices in the Rectangle: top-left, and bottom-right. <br>
 * The class's methods retrieves Area, Perimeter, Length and Width, all
 * calculated from the given Points.
 * @author Idan Hadad
 * @since November 2018 */
public class Rectangle {
  public final Point topLeft;
  public final Point bottomRight;
  public final Point bottomLeft;
  public final Point topRight;
  public final double length;
  public final double width;

  /** constructor
   * @param a : a Point which represent either top-left or bottom-right vertex.
   * @param b : a Point which represent either top-left or bottom-right vertex.
   * @return A Rectangle instance with specified vertices and two more (top-right
   *         and bottom-left) based on the specified vertices.
   * @throws InvalidParameterException if both Points represent the same
   *                                   location. */
  public Rectangle(final Point a, final Point b) throws InvalidParameterException {
    if (a.equals(b))
      throw new InvalidParameterException();
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
    width = topRight.y - bottomRight.y == length ? topRight.x - topLeft.x : topRight.y - bottomRight.y;
  }

  /** @return The Rectangle's area value. */
  public double getArea() {
    // TODO Auto-generated method stub
    return (topRight.y - bottomRight.y) * (bottomRight.x - bottomLeft.x);
  }

  /** @return The Rectangle's perimeter value. */
  public double getPerimeter() {
    // TODO Auto-generated method stub
    return 2 * (topRight.y + bottomRight.x - bottomLeft.x - bottomRight.y);
  }

  /** The length is defined as the longer side of the Rectangle.
   * @return The Rectangle's length value. */
  public double getLength() {
    // TODO Auto-generated method stub
    return length;
  }

  /** The width is defined as the shorter side of the Rectangle.
   * @return The Rectangle's width value. */
  public double getWidth() {
    // TODO Auto-generated method stub
    return width;
  }
}
