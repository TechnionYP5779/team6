package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;
public class RectangleTest {
  @Test @SuppressWarnings({ "static-method", "null" }) public void RectangleTDDTest() {
    azzert.that(new Rectangle(new Point(6,7),new Point(12,3)).bottomLeft.x, is((new Rectangle(new Point(6,7),new Point(12,3)).topLeft.x)));
    azzert.that(new Rectangle(new Point(6,7),new Point(12,3)).bottomLeft.y, is(new Rectangle(new Point(6,7),new Point(12,3)).bottomRight.y));
    azzert.that(new Rectangle(new Point(6,7),new Point(12,3)).topRight.x, is(new Rectangle(new Point(6,7),new Point(12,3)).bottomRight.x));
    azzert.that(new Rectangle(new Point(6,7),new Point(12,3)).topRight.y, is(new Rectangle(new Point(6,7),new Point(12,3)).topLeft.y));
    azzert.that(new Rectangle(new Point(6,7),new Point(12,3)).getArea(), is(24));
    azzert.that(new Rectangle(new Point(6,7),new Point(12,3)).getPerimeter(), is(20));
    azzert.that(new Rectangle(new Point(12,3),new Point(6,7)).bottomLeft.x, is((new Rectangle(new Point(6,7),new Point(12,3)).topLeft.x)));
    azzert.that(new Rectangle(new Point(12,3),new Point(6,7)).bottomLeft.y, is(new Rectangle(new Point(6,7),new Point(12,3)).bottomRight.y));
    azzert.that(new Rectangle(new Point(12,3),new Point(6,7)).topRight.x, is(new Rectangle(new Point(6,7),new Point(12,3)).bottomRight.x));
    azzert.that(new Rectangle(new Point(12,3),new Point(6,7)).topRight.y, is(new Rectangle(new Point(6,7),new Point(12,3)).topLeft.y));
    azzert.that(new Rectangle(new Point(12,3),new Point(6,7)).getArea(), is(24));
    azzert.that(new Rectangle(new Point(12,3),new Point(6,7)).getPerimeter(), is(20));

    azzert.that(new Rectangle(new Point(12,3),new Point(6,7)).bottomRight,  is(new Point(12,3)));
    azzert.that(new Rectangle(new Point(12,3),new Point(6,7)).topRight,  is(new Point(12,7)));
    azzert.that(new Rectangle(new Point(12,3),new Point(6,7)).bottomLeft,  is(new Point(6,3)));
    azzert.that(new Rectangle(new Point(12,3),new Point(6,7)).topLeft,  is(new Point(6,7)));
    
    azzert.that(new Rectangle(new Point(6,7),new Point(12,3)).bottomRight,  is(new Point(12,3)));
    azzert.that(new Rectangle(new Point(6,7),new Point(12,3)).topRight,  is(new Point(12,7)));
    azzert.that(new Rectangle(new Point(6,7),new Point(12,3)).bottomLeft,  is(new Point(6,3)));
    azzert.that(new Rectangle(new Point(6,7),new Point(12,3)).topLeft,  is(new Point(6,7)));
    
    azzert.that(new Rectangle(new Point(6,7),new Point(12,3)).length, is(6));
    azzert.that(new Rectangle(new Point(6,7),new Point(12,3)).width, is(4));
    azzert.that(new Rectangle(new Point(12,3),new Point(6,7)).length, is(6));
    azzert.that(new Rectangle(new Point(12,3),new Point(6,7)).width, is(4));
    
    azzert.that(new Rectangle(new Point(12,3),new Point(11,7)).length, is(4));
    azzert.that(new Rectangle(new Point(12,3),new Point(11,7)).width, is(1));
    azzert.that(new Rectangle(new Point(11,7),new Point(12,3)).length, is(4));
    azzert.that(new Rectangle(new Point(11,7),new Point(12,3)).width, is(1));
    
    azzert.that(new Rectangle(new Point(12,3),new Point(11,7)).getLength(), is(4));
    azzert.that(new Rectangle(new Point(12,3),new Point(11,7)).getWidth(), is(1));
    azzert.that(new Rectangle(new Point(11,7),new Point(12,3)).getLength(), is(4));
    azzert.that(new Rectangle(new Point(11,7),new Point(12,3)).getWidth(), is(1));
    
    
    Rectangle a= new Rectangle(new Point(12,3),new Point(6,7));
    azzert.that(a.bottomLeft,is(a.bottomLeft));
    azzert.assertNotEquals(a.bottomLeft,5);
    azzert.assertNotEquals(a.bottomLeft,new Point(6,6));
    azzert.assertNotEquals(a.bottomLeft,new Point(5,6));
    azzert.assertNotEquals(a.bottomLeft,new Point(5,7));
    
    
  }
}
