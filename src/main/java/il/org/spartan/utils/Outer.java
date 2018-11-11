package il.org.spartan.utils;

import org.jetbrains.annotations.*;

import il.org.spartan.*;

/** TODO Yossi Gil: document class
 * @author Yossi Gil
 * @since 2017-03-21 */
public class Outer<Inner> implements Cloneable {
  public Inner inner;

  public Outer(final Inner inner) {
    this.inner = inner;
    if (inner == null || inner == this)
      throw new IllegalArgumentException();
  }

  @Override public boolean equals(final Object ¢) {
    if (¢ == this)
      return true;
    if (¢ == null || getClass() != ¢.getClass())
      return false;
    @SuppressWarnings("unchecked") final Outer<Inner> $ = (Outer<Inner>) ¢;
    return equals($);
  }

  @SuppressWarnings("null") protected boolean equals(final Outer<Inner> other) {
    if (inner == null) {
      if (other.inner != null)
        return false;
    } else if (!inner.equals(other.inner))
      return false;
    return true;
  }

  @Override @NotNull @SuppressWarnings("unchecked") public Outer<Inner> clone() throws CloneNotSupportedException {
    return (Outer<Inner>) Utils.cantBeNull(super.clone());
  }

  public Inner get() {
    return inner;
  }

  @Override public int hashCode() {
    return 31 + Utils.hash(inner);
  }

  public void set(final Inner ¢) throws IllegalArgumentException {
    if (¢ == null)
      throw new IllegalArgumentException();
    this.inner = ¢;
  }

  @Override public String toString() {
    return Utils.cantBeNull(inner + "");
  }
}
