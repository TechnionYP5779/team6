package parking;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;
import parking.Time.*;

/** Unit tests for class Time and it's subclass DayTime.
 * @Package: parking
 * @Since: 1 בדצמ׳ 2018
 * @Author: Nitzan
 * @see Time */
@SuppressWarnings("static-method") public class TimeTest {
  @Test public void testDayTimeRestrictions() {
    Time.DayTime $;
    try {
      $ = new Time.DayTime(-1, 30);
    } catch (final IllegalArgumentException ¢) {
      azzert.that(¢.getClass(), is(new IllegalArgumentException().getClass()));
    }
    try {
      $ = new Time.DayTime(20, -1);
    } catch (final IllegalArgumentException ¢) {
      azzert.that(¢.getClass(), is(new IllegalArgumentException().getClass()));
    }
    try {
      $ = new Time.DayTime(24, 30);
    } catch (final IllegalArgumentException ¢) {
      azzert.that(¢.getClass(), is(new IllegalArgumentException().getClass()));
    }
    try {
      $ = new Time.DayTime(20, 60);
    } catch (final IllegalArgumentException ¢) {
      azzert.that(¢.getClass(), is(new IllegalArgumentException().getClass()));
    }
    $ = new Time.DayTime(20, 40);
    azzert.that($.getHour(), is(20));
    azzert.that($.getMinute(), is(40));
  }

  @Test public void testCompare() {
    azzert.that(new Time.DayTime(2, 30).compareTo(new Time.DayTime(3, 30)), is(-1));
    azzert.that(new Time.DayTime(4, 30).compareTo(new Time.DayTime(3, 30)), is(1));
    azzert.that(new Time.DayTime(2, 30).compareTo(new Time.DayTime(2, 40)), is(-1));
    azzert.that(new Time.DayTime(2, 50).compareTo(new Time.DayTime(2, 40)), is(1));
    azzert.that(new Time.DayTime(2, 30).compareTo(new Time.DayTime(2, 30)), is(0));
  }

  @Test @SuppressWarnings("unlikely-arg-type") public void testDayTimeEquals() {
    final Time.DayTime $ = new Time.DayTime(1, 30);
    assert $.equals(new Time.DayTime(1, 30));
    assert !$.equals(new Time.DayTime(1, 50));
    assert $.equals($);
    assert !$.equals(box.boxThis(80085));
    azzert.that($.hashCode(), is(130));
  }

  @Test public void testRelativityMethods() {
    assert new Time.DayTime(2, 30).isEarlierThan(new Time.DayTime(2, 40));
    assert !new Time.DayTime(2, 50).isEarlierThan(new Time.DayTime(2, 40));
    assert !new Time.DayTime(2, 30).isEarlierThan(new Time.DayTime(2, 30));
    assert new Time.DayTime(2, 30).isLaterThan(new Time.DayTime(2, 20));
    assert !new Time.DayTime(2, 30).isLaterThan(new Time.DayTime(2, 40));
    assert !new Time.DayTime(2, 30).isLaterThan(new Time.DayTime(2, 30));
  }

  @Test public void testDiffInMinutes() {
    azzert.that(new Time.DayTime(5, 30).diffInMinutes(new Time.DayTime(5, 20)), is(10));
    azzert.that(new Time.DayTime(5, 30).diffInMinutes(new Time.DayTime(5, 40)), is(-10));
    azzert.that(new Time.DayTime(7, 30).diffInMinutes(new Time.DayTime(5, 30)), is(120));
    azzert.that(new Time.DayTime(7, 30).diffInMinutes(new Time.DayTime(10, 30)), is(-180));
    azzert.that(new Time.DayTime(5, 30).diffInMinutes(new Time.DayTime(4, 50)), is(40));
    azzert.that(new Time.DayTime(7, 30).diffInMinutes(new Time.DayTime(8, 50)), is(-80));
  }

  @Test public void testTimeRestrictions() {
    Time $;
    try {
      $ = new Time(WeekDay.Sunday, new Time.DayTime(5, 10), new Time.DayTime(5, 5));
    } catch (final IllegalArgumentException ¢) {
      azzert.that(¢.getClass(), is(new IllegalArgumentException().getClass()));
    }
    try {
      $ = new Time(WeekDay.Monday, new Time.DayTime(1, 1), new Time.DayTime(1, 1));
    } catch (final IllegalArgumentException ¢) {
      azzert.that(¢.getClass(), is(new IllegalArgumentException().getClass()));
    }
    $ = new Time(WeekDay.Tuesday, new Time.DayTime(2, 0), new Time.DayTime(4, 0));
    azzert.that($.lengthInMinutes(), is(120));
    azzert.that($.getDay(), is(WeekDay.Tuesday));
    azzert.that($.getFromHour(), is(new Time.DayTime(2, 0)));
    azzert.that($.getToHour(), is(new Time.DayTime(4, 0)));
  }

  @Test public void testConficting() {
    final Time $ = new Time(WeekDay.Friday, new Time.DayTime(6, 0), new Time.DayTime(8, 20));
    assert !$.isConflicting(new Time(WeekDay.Sunday, new Time.DayTime(6, 0), new Time.DayTime(8, 20)));
    assert $.isConflicting(new Time(WeekDay.Friday, new Time.DayTime(7, 0), new Time.DayTime(9, 20)));
    assert $.isConflicting(new Time(WeekDay.Friday, new Time.DayTime(5, 0), new Time.DayTime(8, 0)));
    assert $.isConflicting(new Time(WeekDay.Friday, new Time.DayTime(5, 0), new Time.DayTime(5, 40)));
    assert $.isConflicting(new Time(WeekDay.Friday, new Time.DayTime(8, 50), new Time.DayTime(9, 10)));
    assert !$.isConflicting(new Time(WeekDay.Friday, new Time.DayTime(2, 50), new Time.DayTime(4, 10)));
    assert !$.isConflicting(new Time(WeekDay.Friday, new Time.DayTime(9, 50), new Time.DayTime(10, 10)));
    assert !$.isConflicting(new Time(WeekDay.Friday, new Time.DayTime(9, 20), new Time.DayTime(10, 10)));
    assert !$.isConflicting(new Time(WeekDay.Friday, new Time.DayTime(4, 0), new Time.DayTime(5, 0)));
    assert $.isConflicting(new Time(WeekDay.Friday, new Time.DayTime(6, 0), new Time.DayTime(8, 20)));
    assert $.isConflicting(new Time(WeekDay.Friday, new Time.DayTime(4, 0), new Time.DayTime(8, 20)));
    assert $.isConflicting(new Time(WeekDay.Friday, new Time.DayTime(6, 0), new Time.DayTime(10, 20)));
    assert $.isConflicting(new Time(WeekDay.Friday, new Time.DayTime(7, 0), new Time.DayTime(8, 0)));
    assert $.isConflicting(new Time(WeekDay.Friday, new Time.DayTime(2, 0), new Time.DayTime(10, 20)));
  }
}
