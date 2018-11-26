package fluent.ly;

/** Reducer that concatenate strings
 * @author Yossi Gil
 * @since 2017-03-19 */
public class CountingReduce extends Reduce<Integer> {
  @Override public final Integer reduce(final Integer i1, final Integer i2) {
    return i1 == null || i2 == null ? null : box.boxThis(unbox.unboxThis(i1) + unbox.unboxThis(i2));
  }

  @Override public final Integer reduce() {
    return box.boxThis(0);
  }
}
