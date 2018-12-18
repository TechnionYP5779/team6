package parking;

/** Class representing an interval of time in a week. Includes day of the week
 * and the range of hours and minutes.
 * @Package: parking
 * @Since: 1 בדצמ׳ 2018
 * @Author: user */
public class Time {
  private final WeekDay day;
  private final DayTime fromHour;
  private final DayTime toHour;
  private static final int minDistance = 60;

  /** Class used to store a time in the day, only contains hour and minute
   * components. Immutable.
   * @Package: parking
   * @Since: 29 בנוב׳ 2018
   * @Author: Nitzan */
  public static class DayTime {
    private final int minute;
    private final int hour;
    private static final int minutesPerHour = 60;

    /** @param hour an integer representing an hour in a 24 hour day. Range
     *               accepted: 0 - 23.
     * @param minute an integer representing a minute in an hour. Range accepted: 0
     *               - 59.
     * @exception If an integer outside the ranges is provided an
     *               IllegalArgumentException is thrown. */
    public DayTime(final int hour, final int minute) {
      if (minute < 0 || minute > 59 || hour < 0 || hour > 23)
        throw new IllegalArgumentException();
      this.minute = minute;
      this.hour = hour;
    }

    /** @return the hour component of the time. */
    public int getHour() {
      return hour;
    }

    /** @return the minute component of the time. */
    public int getMinute() {
      return minute;
    }

    /** @param ¢ another DayTime instance to be compared to this instance.
     * @return an integer according to which is earlier in the day. 1 if this
     *         instance is later. 0 if they are both at the same time. -1 if this
     *         instance is earlier. */
    int compareTo(final DayTime ¢) {
      return this.hour < ¢.hour ? -1 : this.hour > ¢.hour ? 1 : this.minute < ¢.minute ? -1 : this.minute > ¢.minute ? 1 : 0;
    }

    /** @param ¢ another DayTime instance to be compared to this instance.
     * @return whether this instance is earlier than and not equal to the
     *         parameter. */
    boolean isEarlierThan(final DayTime ¢) {
      return this.compareTo(¢) == -1;
    }

    /** @param ¢ another DayTime instance to be compared to this instance.
     * @return whether this instance is later than and not equal to the
     *         parameter. */
    boolean isLaterThan(final DayTime ¢) {
      return this.compareTo(¢) == 1;
    }

    /** @param ¢ another DayTime instance.
     * @return the difference in minutes between the DayTimes. Is negative if this
     *         instance is later than the parameter. */
    int diffInMinutes(final DayTime ¢) {
      return this.getMinute() + minutesPerHour * (this.getHour() - ¢.getHour()) - ¢.getMinute();
    }

    /** @see java.lang.Object#equals(java.lang.Object) */
    @Override public boolean equals(final Object ¢) {
      return ¢ == this || ¢ instanceof DayTime && compareTo((DayTime) ¢) == 0;
    }

    /** @see java.lang.Object#hashCode() */
    @Override public int hashCode() {
      return minute + 100 * hour;
    }
  }
  // End of class DayTime

  /** @fluent.ly.Package parking
   * @fluent.ly.Since 29 בנוב׳ 2018
   * @fluent.ly.Author Nitzan
   * @fluent.ly.ClassDesc Enum for each day of the week, doesn't include any
   *                      logic. */
  public enum WeekDay {
    Sunday, Monday, Tuesday, Wednesday, Thursay, Friday, Saturday
  }

  /** @param day The day the hour range takes place in.
   * @param from The time in the day the range begins.
   * @param to   The time in the day the range ends.
   * @exception If the parameter 'from' is not earlier than the parameter 'to', an
   *               IllegalArgumentException is thrown. */
  public Time(final WeekDay day, final DayTime from, final DayTime to) {
    if (!from.isEarlierThan(to))
      throw new IllegalArgumentException();
    this.day = day;
    this.fromHour = from;
    this.toHour = to;
  }

  /** @return The day in the week the time range takes place in. */
  public WeekDay getDay() {
    return day;
  }

  /** @return The time in the day the range begins. */
  public DayTime getFromHour() {
    return fromHour;
  }

  /** @return The time in the day the range ends. */
  public DayTime getToHour() {
    return toHour;
  }

  /** @param $ A time in the day to be checked.
   * @return True if the parameter is in the time range of this instance
   *         regardless if range, including the edges. False, otherwise. */
  boolean includesInRange(final DayTime $) {
    return $.isLaterThan(fromHour) && $.isEarlierThan(toHour) || $.compareTo(fromHour) == 0 || $.compareTo(toHour) == 0;
  }

  /** @param ¢ Another Time range to be compared to.
   * @return true if there is a conflict between the ranges. A conflict occurs if
   *         the ranges are overlapping or they are less than 60 minutes apart and
   *         they are both on the same day. */
  public boolean isConflicting(final Time ¢) {
    if (¢.getDay() != this.getDay())
      return false;
    if (this.includesInRange(¢.fromHour) || this.includesInRange(¢.toHour) || ¢.includesInRange(fromHour) || ¢.includesInRange(toHour))
      return true;
    int diff = Math.abs(¢.getToHour().diffInMinutes(this.getFromHour()));
    if (diff < minDistance)
      return true;
    diff = Math.abs(this.getToHour().diffInMinutes(¢.getFromHour()));
    return diff < minDistance;
  }

  /** @return The length in minutes of the time range. */
  public int lengthInMinutes() {
    return toHour.diffInMinutes(fromHour);
  }
}
