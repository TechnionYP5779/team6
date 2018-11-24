package fluent.ly;

import java.util.*;

import org.jetbrains.annotations.*;

/** A utility class, offering a collection of function to unbox arrays and
 * collection of the boxed versions of the primitive types. The input of each
 * unboxing function is a {@link Collection} or an array of one the following
 * eight reference types
 * <ol>
 * <li>{@link Boolean}
 * <li>{@link Byte}
 * <li>{@link Character}
 * <li>{@link Double}
 * <li>{@link Float}
 * <li>{@link Integer}
 * <li>{@link Long}
 * <li>{@link Short}
 * </ol>
 * The returned value is an array of the equivalent primitive type.
 * <p>
 * Note that unboxing of a single value of a reference type is easy using a
 * function such as {@link Long#longValue()}
 * @author Yossi Gil.
 * @see box */
@SuppressWarnings("null") public enum unbox {
  // A namespace: no values to this <code><b>enum</b></code>
  ;
  public static double @NotNull [] it(final @NotNull Double[] ¢) {
    return unboxThis(¢);
  }

  public static float @NotNull [] it(final Float[] ¢) {
    return unboxThis(¢);
  }

  public static int it(final @NotNull Integer ¢) {
    return ¢.intValue();
  }

  public static int @NotNull [] it(final @NotNull Integer[] ¢) {
    return unboxThis(¢);
  }

  public static int @NotNull [] it(final @NotNull List<Integer> ¢) {
    return it(¢.toArray(new Integer[¢.size()]));
  }

  public static boolean unboxThis(final @NotNull Boolean ¢) {
    return ¢.booleanValue();
  }

  /** unbox an array of {@link Boolean}s into an array of
   * <code><b>boolean</b></code>s.
   * @param bs an array of {@link Boolean}s
   * @return an equivalent array of <code><b>boolean</b></code>s. */
  public static boolean @NotNull [] unboxThis(final @NotNull Boolean[] bs) {
    final boolean @NotNull [] $ = new boolean[bs.length];
    for (int ¢ = 0; ¢ < bs.length; ++¢)
      $[¢] = bs[¢].booleanValue();
    return $;
  }

  public static byte unboxThis(final @NotNull Byte ¢) {
    return ¢.byteValue();
  }

  /** unbox an array of {@link Byte}s into an array of <code><b>byte</b></code> s.
   * @param bs an array of {@link Byte}s
   * @return an equivalent array of <code><b>byte</b></code>s. */
  public static byte @NotNull [] unboxThis(final @NotNull Byte[] bs) {
    final byte @NotNull [] $ = new byte[bs.length];
    for (int ¢ = 0; ¢ < bs.length; ++¢)
      $[¢] = bs[¢].byteValue();
    return $;
  }

  public static char unboxThis(final @NotNull Character ¢) {
    return ¢.charValue();
  }

  /** unbox an array of {@link Character}s into an array of
   * <code><b>char</b></code>s.
   * @param cs an array of {@link Character}s
   * @return an equivalent array of <code><b>char</b></code>s. */
  public static char @NotNull [] unboxThis(final @NotNull Character[] cs) {
    final char @NotNull [] $ = new char[cs.length];
    for (int ¢ = 0; ¢ < cs.length; ++¢)
      $[¢] = cs[¢].charValue();
    return $;
  }

  /** unbox a {@link Collection} of {@link Short}s into an array of
   * <code><b>short</b></code>s.
   * @param ss a {@link Collection} of {@link Integer}s
   * @return an equivalent array of <code><b>short</b></code>s. */
  public static short @NotNull [] unboxThis(final @NotNull Collection<Short> ss) {
    final short @NotNull [] $ = new short[ss.size()];
    int i = 0;
    for (final @NotNull Short v : ss)
      $[i++] = v.shortValue();
    return $;
  }

  public static double unboxThis(final @NotNull Double ¢) {
    return ¢.doubleValue();
  }

  /** unbox an array of {@link Double}s into an array of
   * <code><b>double</b></code>s.
   * @param ds an array of {@link Double}s
   * @return an equivalent array of <code><b>double</b></code>s. */
  public static double @NotNull [] unboxThis(final @NotNull Double[] ds) {
    final double @NotNull [] $ = new double[ds.length];
    for (int ¢ = 0; ¢ < ds.length; ++¢)
      $[¢] = ds[¢].floatValue();
    return $;
  }

  public static float unboxThis(final @NotNull Float ¢) {
    return ¢.floatValue();
  }

  /** unbox an array of {@link Float}s into an array of <code><b>float</b></code>
   * s.
   * @param fs an array of {@link Float}s
   * @return an equivalent array of <code><b>float</b></code>s. */
  public static float @NotNull [] unboxThis(final Float[] fs) {
    final float @NotNull [] $ = new float[fs.length];
    for (int ¢ = 0; ¢ < fs.length; ++¢)
      $[¢] = fs[¢].floatValue();
    return $;
  }

  public static int unboxThis(final @NotNull Integer ¢) {
    return ¢.intValue();
  }

  /** unbox an array of {@link Integer}s into an array of <code><b>int</b></code>
   * s.
   * @param is an array of {@link Integer}s
   * @return an equivalent array of <code><b>int</b></code>s. */
  public static int @NotNull [] unboxThis(final @NotNull Integer[] is) {
    final int @NotNull [] $ = new int[is.length];
    for (int ¢ = 0; ¢ < is.length; ++¢)
      $[¢] = is[¢].intValue();
    return $;
  }

  public static long unboxThis(final @NotNull Long ¢) {
    return ¢.longValue();
  }

  /** unbox an array of {@link Long}s into an array of <code><b>long</b></code> s.
   * @param ls an array of {@link Long}s
   * @return an equivalent array of <code><b>long</b></code>s. */
  public static long @NotNull [] unboxThis(final @NotNull Long[] ls) {
    final long @NotNull [] $ = new long[ls.length];
    for (int ¢ = 0; ¢ < ls.length; ++¢)
      $[¢] = ls[¢].longValue();
    return $;
  }

  public static short unboxThis(final @NotNull Short ¢) {
    return ¢.shortValue();
  }

  /** unbox an array of {@link Short}s into an array of <code><b>short</b></code>
   * s.
   * @param ss an array of {@link Integer}s
   * @return an equivalent array of <code><b>short</b></code>s. */
  public static short @NotNull [] unboxThis(final @NotNull Short[] ss) {
    final short @NotNull [] $ = new short[ss.length];
    for (int ¢ = 0; ¢ < ss.length; ++¢)
      $[¢] = ss[¢].shortValue();
    return $;
  }
}
