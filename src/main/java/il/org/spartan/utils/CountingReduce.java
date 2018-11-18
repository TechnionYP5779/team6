package il.org.spartan.utils;

import fluent.ly.*;

/** Reducer that concatenate strings
 * @author Yossi Gil
 * @since 2017-03-19 */
public class CountingReduce extends Reduce<Integer> {
  @Override public final Integer reduce(final Integer i1, final Integer i2) {
    if(i1==null || i2==null)
      return null;
    return Box.box(Unbox.unbox(i1) + Unbox.unbox(i2));
  }

  @Override public final Integer reduce() {
    return Box.box(0);
  }
}
