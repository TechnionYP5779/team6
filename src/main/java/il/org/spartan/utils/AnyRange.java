package il.org.spartan.utils;

import static fluent.ly.forget.*;

import org.jetbrains.annotations.*;

/** <br>
 * This class contains in her three different class of specific type to
 * range.<br>
 * One for above bounded range, one for below bounded range and one for finite
 * range.<br>
 * In addition, this class return some known ranges like natural , negative odd
 * and positive odd ranges.<br>
 * @author Elizabeth Yeshaayahu
 * @since November 2018 */
public class AnyRange {
  /** <br>
   * This class is the type of elements AnyRange and the other three specific
   * range throw
   * @author Elizabeth Yeshaayahu
   * @since November 2018 */
  @SuppressWarnings("serial") public static class AnyRangeException extends Exception {
    //
  }

  /** <br>
   * This class describes an above bounded range.<br>
   * It offers methods like changing the upper bound , getting the step of the
   * range , etc.<br>
   * @author Elizabeth Yeshaayahu
   * @since November 2018 */
  public static class BoundedAboveRange {
    int to;
    int step;

    /** constructor
     * @param to_   : upper bound
     * @param step_ : step of the range
     * @throws AnyRangeException if to_ is positive */
    BoundedAboveRange(final int to_, final int step_) throws AnyRangeException {
      if (step_ > 0)
        throw new AnyRangeException();
      to = to_;
      step = step_;
    }

    /** @param to_ : new upper bound updates the upper bound */
    public void to(final int to_) {
      to = to_;
    }

    /** @return upper bound */
    public int getTo() {
      return to;
    }

    /** @return upper step */
    public int getStep() {
      return step;
    }

    /** @param step_ : new step updates the step
     * @throws AnyRangeException if to_ is positive */
    public void step(final int step_) throws AnyRangeException {
      if (step_ > 0)
        throw new AnyRangeException();
      step = step_;
    }

    /** 
     * @param from : lower bound
     * @return new finite range with the old upper bound and step and with the new
     *         lower bound
     * @throws AnyRangeException if to if bigger then from */
    public FiniteRange from(final int from) throws AnyRangeException {
      if (to < from)
        throw new AnyRangeException();
      return new FiniteRange(from, to, -step);
    }

    /** @return the upper bound and the step like this [upper bound,step] */
    @Override public String toString() {
      return String.format("[%d, %d]", fluent.ly.box.it(to), fluent.ly.box.it(step));
    }

    /** @return the sum of the upper bound and the step if it negative otherwise the
     *         negated of the sum */
    @Override public int hashCode() {
      return to + step <= 0 ? to + step : -(to + step);
    }

    /** @param ¢ : object
     * @return true if ¢'s type is BoundedAboveRange and upper bounds and steps are
     *         identical */
    @Override public boolean equals(final Object ¢) {
      return ¢ instanceof BoundedAboveRange && to == ((BoundedAboveRange) ¢).to && step == ((BoundedAboveRange) ¢).step;
    }

    /** @param ¢ : from type BoundedAboveRange
     * @return object from type BoundedAboveRange with the highest upper bound and
     *         with the smaller step */
    @NotNull public BoundedAboveRange merge(final @NotNull BoundedAboveRange ¢) throws AnyRangeException {
      return new BoundedAboveRange(to > ¢.to ? to : ¢.to, step < ¢.step ? step : ¢.step);
    }

    /** @param ¢ : from type BoundedAboveRange
     * @return true if current upper bound is smaller or identical to the upper
     *         bound of the parameter */
    public boolean includedIn(final @NotNull BoundedAboveRange ¢) {
      return to <= ¢.to;
    }

    /** @return true because every two above bounded ranges overlap */
    @SuppressWarnings("static-method") public boolean overlapping(final @NotNull BoundedAboveRange ¢) {
      ______unused(¢);
      return true;
    }
  }

  /** <br>
   * This class describes a below bounded range.<br>
   * It offers methods like changing the below bound , getting the step of the
   * range , etc.<br>
   * @author Elizabeth Yeshaayahu
   * @since November 2018 */
  public static class BoundedBelowRange {
    int from;
    int step;

    /** constructor
     * @param from_ : lower bound
     * @param step_ : step of the range
     * @throws AnyRangeException to is negative */
    BoundedBelowRange(final int from_, final int step_) throws AnyRangeException {
      if (step_ < 0)
        throw new AnyRangeException();
      from = from_;
      step = step_;
    }

    /** @param from_ : new lower bound updates the from */
    public void from(final int from_) {
      from = from_;
    }

    /** @return the lower bound */
    public int getFrom() {
      return from;
    }

    /** @return step */
    public int getStep() {
      return step;
    }

    /** @param to_ : upper bound
     * @throws AnyRangeException to is to_ is lower then from
     * @return new finite range with the old lower bound and step and with the new
     *         upper bound */
    public FiniteRange to(final int to_) throws AnyRangeException {
      if (to_ < from)
        throw new AnyRangeException();
      return new FiniteRange(from, to_, step);
    }

    /** @param step_ : new step updates the step
     * @throws AnyRangeException if to_ is negative */
    public void step(final int step_) throws AnyRangeException {
      if (step_ < 0)
        throw new AnyRangeException();
      step = step_;
    }

    /** @return the lower bound and the step like this [lower bound,step] */
    @Override public String toString() {
      return String.format("[%d, %d]", fluent.ly.box.it(from), fluent.ly.box.it(step));
    }

    /** @return the sum of the lower bound and the step if it positive otherwise the
     *         negated of the sum */
    @Override public int hashCode() {
      return from + step >= 0 ? from + step : -(from + step);
    }

    /** @param ¢ : object
     * @return true if ¢'s type is BoundedBelowRange and lower bounds and steps are
     *         identical */
    @Override public boolean equals(final Object ¢) {
      return ¢ instanceof BoundedBelowRange && from == ((BoundedBelowRange) ¢).from && step == ((BoundedBelowRange) ¢).step;
    }

    /** @param ¢ : from type BoundedBelowRange
     * @return object from type BoundedBelowRange with the smaller lower bound and
     *         with the smaller step */
    @NotNull public BoundedBelowRange merge(final @NotNull BoundedBelowRange ¢) throws AnyRangeException {
      return new BoundedBelowRange(from < ¢.from ? from : ¢.from, step < ¢.step ? step : ¢.step);
    }

    /** @param ¢ : from type BoundedBelowRange
     * @return true if current lower bound is bigger or identical to the upper bound
     *         of the parameter */
    public boolean includedIn(final @NotNull BoundedBelowRange ¢) {
      return from >= ¢.from;
    }

    /** @return true because every two below bounded ranges overlap */
    @SuppressWarnings("static-method") public boolean overlapping(final @NotNull BoundedBelowRange ¢) {
      ______unused(¢);
      return true;
    }
  }

  /** <br>
   * This class describes a finite range.<br>
   * It offers methods like getting the step of the range , etc.<br>
   * @author Elizabeth Yeshaayahu
   * @since November 2018 */
  public static class FiniteRange {
    int from;
    int to;
    int step;

    /** constructor
     * @param from_ : lower bound
     * @param to_   : upper bound
     * @param step_ : step of the range
     * @throws AnyRangeException to is negative or from_ is bigger then to_ */
    FiniteRange(final int from_, final int to_, final int step_) throws AnyRangeException {
      if (from_ > to_ || step_ < 0)
        throw new AnyRangeException();
      from = from_;
      to = to_;
      step = step_;
    }

    /** @param from_arg : lower bound
     * @return new finite range with the old upper bound and step and with the new
     *         lower bound
     * @throws AnyRangeException if to if bigger then from */
    public FiniteRange from(final int from_arg) throws AnyRangeException {
      if (to < from_arg)
        throw new AnyRangeException();
      return new FiniteRange(from_arg, to, -step);
    }

    /** @param to_ : upper bound
     * @throws AnyRangeException to is to_ is lower then from
     * @return new finite range with the old lower bound and step and with the new
     *         upper bound */
    public FiniteRange to(final int to_) throws AnyRangeException {
      if (to_ < from)
        throw new AnyRangeException();
      return new FiniteRange(from, to_, step);
    }

    /** @return lower bound */
    public int getFrom() {
      return from;
    }

    /** @return step */
    public int getStep() {
      return step;
    }

    /** @return upper bound */
    public int getTo() {
      return to;
    }

    /** @param ¢ : object
     * @return true if ¢'s type is FiniteRange and bounds and steps are identical */
    @Override public boolean equals(final Object ¢) {
      return ¢ instanceof FiniteRange && from == ((FiniteRange) ¢).from && to == ((FiniteRange) ¢).to && step == ((FiniteRange) ¢).step;
    }

    /** @return (from + 0.5 * (to + from) * (to + from + 1) as hashcode */
    @Override public int hashCode() {
      // Cantor pairing function
      return (int) (from + 0.5 * (to + from) * (to + from + 1));
    }

    /** @return true if the current upper bound is smaller the the upper bound of
     *         the parameter and if the lower bound is bigger then the lower bound
     *         of the parameter otherwise false */
    public boolean includedIn(final @NotNull FiniteRange ¢) {
      return from >= ¢.from && to <= ¢.to;
    }

    /** @param ¢ : from type FiniteRange
     * @return object from type FiniteRange with the smaller lower bound and bigger
     *         upper bound and with the smaller step */
    @NotNull public FiniteRange merge(final @NotNull FiniteRange ¢) throws AnyRangeException {
      return new FiniteRange(from < ¢.from ? from : ¢.from, to > ¢.to ? to : ¢.to, step < ¢.step ? step : ¢.step);
    }

    /** @return true if the current upper bound is smaller the the upper bound of
     *         the parameter or if the lower bound is bigger then the lower bound of
     *         the parameter otherwise false */
    public boolean overlapping(final @NotNull FiniteRange ¢) {
      return from >= ¢.from || to <= ¢.to;
    }

    /** @return the upper bound minus lower bound */
    public int size() {
      return to - from;
    }

    /** @return the lower bound and the upper bound like this [lower bound,upper
     *         bound] */
    @Override public String toString() {
      return String.format("[%d, %d]", fluent.ly.box.it(from), fluent.ly.box.it(to));
    }

    /** @param step_ : new step updates the step
     * @throws AnyRangeException if to_ is negative */
    public void step(final int step_) throws AnyRangeException {
      if (step < 0)
        throw new AnyRangeException();
      step = step_;
    }
  }

  /** @param from : lower bound
   * @return BoundedBelowRange with from as lower bound and 0 as step */
  public static BoundedBelowRange from(final int from) throws AnyRangeException {
    return new BoundedBelowRange(from, 0);
  }

  /** @param to : upper bound
   * @return BoundedAboveRange with to as upper bound and 0 as step */
  public static BoundedAboveRange to(final int to) throws AnyRangeException {
    return new BoundedAboveRange(to, 0);
  }

  /** @return BoundedBelowRange with 1 as lower bound and 1 as step */
  public static BoundedBelowRange naturals() throws AnyRangeException {
    return new BoundedBelowRange(1, 1);
  }

  /** @return BoundedAboveRange with -1 as upper bound and -2 as step */
  public static BoundedAboveRange Negativeodds() throws AnyRangeException {
    return new BoundedAboveRange(-1, -2);
  }

  /** @return BoundedBelowRange with 1 as lower bound and 2 as step */
  public static BoundedBelowRange Positiveodds() throws AnyRangeException {
    return new BoundedBelowRange(1, 2);
  }
}
