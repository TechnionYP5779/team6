package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class RectangleTest {
  @Test @SuppressWarnings("null") public void RectangleTDDTest() {
    azzert.that(new Rectangle(new Point(6.0, 7.0), new Point(12.0, 3.0)).bottomLeft.x,
        is(new Rectangle(new Point(6.0, 7.0), new Point(12.0, 3.0)).topLeft.x));
    azzert.that(new Rectangle(new Point(6.0, 7.0), new Point(12.0, 3.0)).bottomLeft.y,
        is(new Rectangle(new Point(6.0, 7.0), new Point(12.0, 3.0)).bottomRight.y));
    azzert.that(new Rectangle(new Point(6.0, 7.0), new Point(12.0, 3.0)).topRight.x,
        is(new Rectangle(new Point(6.0, 7.0), new Point(12.0, 3.0)).bottomRight.x));
    azzert.that(new Rectangle(new Point(6.0, 7.0), new Point(12.0, 3.0)).topRight.y,
        is(new Rectangle(new Point(6.0, 7.0), new Point(12.0, 3.0)).topLeft.y));
    azzert.that(new Rectangle(new Point(6.0, 7.0), new Point(12.0, 3.0)).getArea(), is(24.0));
    azzert.that(new Rectangle(new Point(6.0, 7.0), new Point(12.0, 3.0)).getPerimeter(), is(20.0));
    azzert.that(new Rectangle(new Point(12.0, 3.0), new Point(6.0, 7.0)).bottomLeft.x,
        is(new Rectangle(new Point(6.0, 7.0), new Point(12.0, 3.0)).topLeft.x));
    azzert.that(new Rectangle(new Point(12.0, 3.0), new Point(6.0, 7.0)).bottomLeft.y,
        is(new Rectangle(new Point(6.0, 7.0), new Point(12.0, 3.0)).bottomRight.y));
    azzert.that(new Rectangle(new Point(12.0, 3.0), new Point(6.0, 7.0)).topRight.x,
        is(new Rectangle(new Point(6.0, 7.0), new Point(12.0, 3.0)).bottomRight.x));
    azzert.that(new Rectangle(new Point(12.0, 3.0), new Point(6.0, 7.0)).topRight.y,
        is(new Rectangle(new Point(6.0, 7.0), new Point(12.0, 3.0)).topLeft.y));
    azzert.that(new Rectangle(new Point(12.0, 3.0), new Point(6.0, 7.0)).getArea(), is(24.0));
    azzert.that(new Rectangle(new Point(12.0, 3.0), new Point(6.0, 7.0)).getPerimeter(), is(20.0));
    azzert.that(new Rectangle(new Point(12.0, 3.0), new Point(6.0, 7.0)).bottomRight, is(new Point(12.0, 3.0)));
    azzert.that(new Rectangle(new Point(12.0, 3.0), new Point(6.0, 7.0)).topRight, is(new Point(12.0, 7.0)));
    azzert.that(new Rectangle(new Point(12.0, 3.0), new Point(6.0, 7.0)).bottomLeft, is(new Point(6.0, 3.0)));
    azzert.that(new Rectangle(new Point(12.0, 3.0), new Point(6.0, 7.0)).topLeft, is(new Point(6.0, 7.0)));
    azzert.that(new Rectangle(new Point(6.0, 7.0), new Point(12.0, 3.0)).bottomRight, is(new Point(12.0, 3.0)));
    azzert.that(new Rectangle(new Point(6.0, 7.0), new Point(12.0, 3.0)).topRight, is(new Point(12.0, 7.0)));
    azzert.that(new Rectangle(new Point(6.0, 7.0), new Point(12.0, 3.0)).bottomLeft, is(new Point(6.0, 3.0)));
    azzert.that(new Rectangle(new Point(6.0, 7.0), new Point(12.0, 3.0)).topLeft, is(new Point(6.0, 7.0)));
    azzert.that(new Rectangle(new Point(6.0, 7.0), new Point(12.0, 3.0)).length, is(6.0));
    azzert.that(new Rectangle(new Point(6.0, 7.0), new Point(12.0, 3.0)).width, is(4.0));
    azzert.that(new Rectangle(new Point(12.0, 3.0), new Point(6.0, 7.0)).length, is(6.0));
    azzert.that(new Rectangle(new Point(12.0, 3.0), new Point(6.0, 7.0)).width, is(4.0));
    azzert.that(new Rectangle(new Point(12.0, 3.0), new Point(11.0, 7.0)).length, is(4.0));
    azzert.that(new Rectangle(new Point(12.0, 3.0), new Point(11.0, 7.0)).width, is(1.0));
    azzert.that(new Rectangle(new Point(11.0, 7.0), new Point(12.0, 3.0)).length, is(4.0));
    azzert.that(new Rectangle(new Point(11.0, 7.0), new Point(12.0, 3.0)).width, is(1.0));
    azzert.that(new Rectangle(new Point(12.0, 3.0), new Point(11.0, 7.0)).getLength(), is(4.0));
    azzert.that(new Rectangle(new Point(12.0, 3.0), new Point(11.0, 7.0)).getWidth(), is(1.0));
    azzert.that(new Rectangle(new Point(11.0, 7.0), new Point(12.0, 3.0)).getLength(), is(4.0));
    azzert.that(new Rectangle(new Point(11.0, 7.0), new Point(12.0, 3.0)).getWidth(), is(1.0));
    final Rectangle a = new Rectangle(new Point(12.0, 3.0), new Point(6.0, 7.0));
    azzert.that(a.bottomLeft, is(a.bottomLeft));
    azzert.that(a.bottomLeft, not(box.it(5.0)));
    azzert.that(a.bottomLeft, not(new Point(6.0, 6.0)));
    azzert.that(a.bottomLeft, not(new Point(5.0, 6.0)));
    azzert.that(a.bottomLeft, not(new Point(5.0, 7.0)));
  }
}
