package il.org.spartan.utils;

import static il.org.spartan.Utils.*;

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
    return (Outer<Inner>) cantBeNull(super.clone());
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
    return cantBeNull(inner + "");
  }

  public static class Wrapper<@Nullable T> {
    @Nullable protected T inner;

    public Wrapper() {
      this(null);
    }

    public Wrapper(final @Nullable T inner) {
      this.inner = inner;
    }

    @Override @NotNull @SuppressWarnings("unchecked") public Wrapper<T> clone() throws CloneNotSupportedException {
      return (Wrapper<T>) cantBeNull(super.clone());
    }

    @Override @SuppressWarnings("unchecked") public final boolean equals(final @Nullable Object ¢) {
      return super.equals(¢) || ¢ != null && getClass() == ¢.getClass() && equals((Wrapper<T>) ¢);
    }

    public boolean equals(final Wrapper<T> ¢) {
      return inner == null ? ¢.inner == null : equalsAux(¢.inner);
    }

    private boolean equalsAux(final T ¢) {
      return inner != null && inner.equals(¢);
    }

    public T get() {
      return inner;
    }

    @Override @SuppressWarnings("null") public int hashCode() {
      return inner == null ? 0 : inner.hashCode();
    }

    public void set(final T inner) {
      this.inner = inner;
    }

    @Override @NotNull public String toString() {
      return inner == null ? "null" : cantBeNull(inner + "");
    }
  }
}
