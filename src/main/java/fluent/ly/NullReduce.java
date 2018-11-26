package fluent.ly;

import org.jetbrains.annotations.*;

/** Provides null value for {@link #reduce()}
 * @param <T>
 * @since 2017 */
public abstract class NullReduce<@Nullable T> extends Reduce<T> {
  @Override public final T reduce() {
    return null;
  }
}