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

    public DayTime(final int hour, final int minute) {
      if (minute < 0 || minute > 59 || hour < 0 || hour > 23)
        throw new IllegalArgumentException();
      this.minute = minute;
      this.hour = hour;
    }

    public int getHour() {
      return hour;
    }

    public int getMinute() {
      return minute;
    }

    int compareTo(final DayTime ¢) {
      return this.hour < ¢.hour ? -1 : this.hour > ¢.hour ? 1 : this.minute < ¢.minute ? -1 : this.minute > ¢.minute ? 1 : 0;
    }

    boolean isEarlierThan(final DayTime ¢) {
      return this.compareTo(¢) == -1;
    }

    boolean isLaterThan(final DayTime ¢) {
      return this.compareTo(¢) == 1;
    }

    int diffInMinutes(final DayTime ¢) {
      return this.getMinute() + minutesPerHour * (this.getHour() - ¢.getHour()) - ¢.getMinute();
    }

    @Override public boolean equals(final Object ¢) {
      if (¢ == this)
        return true;
      return ¢ instanceof DayTime && compareTo((DayTime) ¢) == 0;
    }

    @Override public int hashCode() {
      return minute + 100 * hour;
    }
  }
  // End of class DayTime

  public enum WeekDay {
    Sunday, Monday, Tuesday, Wednesday, Thursay, Friday, Saturday
  }

  public Time(final WeekDay day, final DayTime from, final DayTime to) {
    if (!from.isEarlierThan(to))
      throw new IllegalArgumentException();
    this.day = day;
    this.fromHour = from;
    this.toHour = to;
  }

  public WeekDay getDay() {
    return day;
  }

  public DayTime getFromHour() {
    return fromHour;
  }

  public DayTime getToHour() {
    return toHour;
  }

  public boolean isConflicting(final Time ¢) {
    if (¢.getDay() != this.getDay())
      return false;
    if (this.getFromHour().isEarlierThan(¢.getFromHour()) && ¢.getFromHour().isEarlierThan(this.getToHour())
        || ¢.getFromHour().isEarlierThan(this.getFromHour()) && this.getFromHour().isEarlierThan(¢.getToHour()))
      return true;
    int diff = Math.abs(¢.getToHour().diffInMinutes(this.getFromHour()));
    if (diff < minDistance)
      return true;
    diff = Math.abs(this.getToHour().diffInMinutes(¢.getFromHour()));
    return diff < minDistance;
  }

  public int lengthInMinutes() {
    return toHour.diffInMinutes(fromHour);
  }
}
