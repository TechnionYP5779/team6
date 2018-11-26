package fluent.ly;

import static il.org.spartan.Utils.*;

import static fluent.ly.azzert.*;
import static fluent.ly.separate.*;

import java.util.*;
import java.util.function.*;

import org.jetbrains.annotations.*;
import org.junit.*;


import il.org.spartan.*;
/**
* For tested enum please see {@link fluent.ly.separate} .
*/
@SuppressWarnings({ "null", "static-method" }) public class separateTest {
  @NotNull public static final String SPACE = " ";
  private static final Function<String, String> quote = λ -> "'" + λ + "'";

  @Test public final void asArrayBetweenChar() {
    azzert.that(separate.these(as.array("Hello", "World")).by(','), is("Hello,World"));
  }

  @Test public final void byArrayString() {
    azzert.that(separate.these(new String[] { "Hello", "World" }).by(", "), is("Hello, World"));
  }

  @Test public final void byArrayStringUsingLiterals() {
    azzert.that(separate.these(as.array("Hello", "World")).by(", "), is("Hello, World"));
  }

  @Test public final void byBooleanArrayChar() {
    azzert.that(separate.these(new boolean[] { true, false }).by(':'), is("true:false"));
  }

  @Test public final void byBooleanArrayString() {
    azzert.that(separate.these(new boolean[] { true, false }).by("; "), is("true; false"));
  }

  @Test public final void byByteArrayChar() {
    azzert.that(separate.these(new byte[] { 3, -5 }).by(':'), is("3:-5"));
  }

  @Test public final void byByteArrayString() {
    azzert.that(separate.these(new byte[] { -1, 2 }).by("; "), is("-1; 2"));
  }

  @Test public final void byCharArrayChar() {
    azzert.that(separate.these(new char[] { '3', 'x' }).by(':'), is("3:x"));
  }

  @Test public final void byCharArrayString() {
    azzert.that(separate.these(new char[] { 'a', 'x' }).by("; "), is("a; x"));
  }

  @Test public final void byCommasTypical() {
    azzert.that(separate.these("A", "B", "C").byCommas(), is("A,B,C"));
  }

  @Test public final void byDoubleArrayChar() {
    azzert.that(separate.these(new double[] { 3.3, 4.2 }).by(':'), is("3.3:4.2"));
  }

  @Test public final void byDoubleArrayString() {
    azzert.that(separate.these(new double[] { -1.0, 2.0 }).by("; "), is("-1.0; 2.0"));
  }

  @Test public final void byFloatArrayChar() {
    azzert.that(separate.these(new float[] { 3.3F, 4.2F }).by(':'), is("3.3:4.2"));
  }

  @Test public final void byFloatArrayString() {
    azzert.that(separate.these(new float[] { -1F, 2F }).by("; "), is("-1.0; 2.0"));
  }

  @Test public final void byFOfTIterableOfTChar() {
    azzert.that(separate.these(apply(λ -> "<" + λ + ">").to("A", "B")).by(' '), is("<A> <B>"));
  }

  @Test public final void byFOfTIterableOfTString() {
    azzert.that(separate.these(new Utils.Applicator<>(quote).to(as.list("Hello", "World"))).by(", "), is("'Hello', 'World'"));
  }

  @Test public final void byFOfTTArrayChar() {
    final @NotNull Utils.Applicator<Object, String> f = new Utils.Applicator<>(λ -> "'" + λ + "'");
    assert f != null : "Function literals should never by null.";
    final @NotNull Collection<String> c = as.list("Hello", "World");
    azzert.that(c.size(), is(2));
    final @NotNull Iterable<String> ts = f.to(c);
    azzert.that(count.of(ts), is(2));
    azzert.that(separate.these(ts).by(' '), is("'Hello' 'World'"));
  }

  @Test public final void byFOfTTArrayString() {
    azzert.that(separate.these(apply(quote).to("Hello", "World")).by(", "), is("'Hello', 'World'"));
  }

  @Test public final void byIntArrayChar() {
    azzert.that(separate.these(new int[] { 3, 4 }).by(':'), is("3:4"));
  }

  @Test public final void byIntArrayString() {
    azzert.that(separate.these(new int @NotNull [] { -1, 2 }).by("; "), is("-1; 2"));
  }

  @Test public final void byIterableOfChar() {
    azzert.that(separate.these(as.array("Hello", "World")).by(','), is("Hello,World"));
  }

  @Test public final void byIterableOfString() {
    azzert.that(separate.these(as.list("Hello", "World")).by(", "), is("Hello, World"));
  }

  @Test public final void byLongArrayChar() {
    azzert.that(separate.these(new long[] { 3, 4 }).by(':'), is("3:4"));
  }

  @Test public final void byLongArrayString() {
    azzert.that(separate.these(new long[] { -1L, 2L }).by("; "), is("-1; 2"));
  }

  @Test public final void byMapOfKeyValueStringString() {
    final @NotNull Map<String, Integer> map = new TreeMap<>();
    map.put("One", box.it(1));
    map.put("Two", box.it(2));
    map.put("Three", box.it(3));
    map.put("Four", box.it(4));
    azzert.that(separate.these(map).by(", "), is("Four->4, One->1, Three->3, Two->2"));
  }

  @Test public final void byShortArrayChar() {
    azzert.that(separate.these(new short[] { 3, 4 }).by(':'), is("3:4"));
  }

  @Test public final void byShortArrayString() {
    azzert.that(separate.these(new short[] { (short) -1, (short) 2 }).by(": "), is("-1: 2"));
  }

  @Test public final void bySpacesEmptyl() {
    azzert.that(separate.these().bySpaces(), is(""));
  }

  @Test public final void bySpacesLengthLessThan2() {
    assert separate.these().bySpaces().length() < 2;
  }

  @Test public final void bySpacesLengthLessThan3() {
    assert separate.these().bySpaces().length() < 3;
  }

  @Test public final void bySpacesTypical() {
    azzert.that(separate.these("A", "B", "C").bySpaces(), is("A B C"));
  }

  @Test public final void byTArrayChar() {
    azzert.that(separate.these(new String[] { "Hello", "World" }).by(','), is("Hello,World"));
  }

  @Test public final void nlIterableOfString() {
    azzert.that(separate.these(as.list("Hello", "World")).byNLs(), is("Hello\nWorld"));
  }

  @Test public final void nlStringArray() {
    azzert.that(separate.these("Hello", "World").byNLs(), is("Hello\nWorld"));
  }

  @Test public final void separateByNoItemslPruneWhitesSpaceSeparated() {
    final @NotNull separate.SeparationSubject these = separate.these();
    assert these != null : null;
    final Iterable<?> os = these.os;
    assert os != null : null;
    assert is.empty(os);
    final @NotNull String[] ss = as.strings(os);
    assert ss != null : null;
    azzert.zero(ss.length);
    azzert.zero(prune.whites(ss).length);
    // azzert.that(separate.SeparationSubject.separateBy(noWhites, " "), is(""));
    // //SeparationSubject.separateBy is private = cant test that here
  }

  @Test public final void separateByNoItemslSpaceSeparated() {
    azzert.that(separate.SeparationSubject.separateBy(separate.these().os, " "), is(""));
  }

  @Test public void separateBySpaceEmpty() {
    azzert.that(bySpaces(), is(""));
  }

  @Test public void separateBySpaceEmptyIterator() {
    azzert.that(separateBySpaces(fluent.ly.empty.list()), is(""));
  }

  @Test public void separateBySpaceMultipleIterator() {
    azzert.that(separateBySpaces(as.list(new String[] { "X", "Y", "Z" })), is("X Y Z"));
  }

  @Test public void separateBySpaceOnIteator() {
    azzert.that(separateBySpaces(as.list(new String[] { "Hello", "World " })), is("Hello World "));
  }

  @Test public void separateBySpaceOnSingletonIteator() {
    azzert.that(separateBySpaces(iterable.singleton("Hello")), is("Hello"));
  }

  @Test public void separateBySpaceSimple() {
    azzert.that(bySpaces("A"), is("A"));
  }

  @Test public void separateBySpaceSingletonIterator() {
    azzert.that(separateBySpaces(iterable.singleton("X")), is("X"));
  }

  @Test public void separateBySpaceTwoStrings() {
    azzert.that(bySpaces("A", "B"), is("A B"));
  }

  @Test public final void spaceIsSpace() {
    azzert.that(SPACE, is(" "));
  }

  @Test public final void theseArraySize0() {
    azzert.that(count.of(separate.these(as.array()).os), is(0));
  }

  @Test public final void theseArraySize1() {
    azzert.that(count.of(separate.these(as.array("Rosebud")).os), is(1));
  }

  @Test public final void theseArraySize2() {
    azzert.that(count.of(separate.these(as.array("Hello", "World")).os), is(2));
  }

  @Test public final void theseArraySize3() {
    azzert.that(count.of(separate.these(as.array("A", "B", "C")).os), is(3));
  }

  @Test public final void theseFromOneItem() {
    azzert.that(count.of(separate.these(as.list("Rosebud")).os), is(1));
  }

  @Test public final void theseFromThreeItems() {
    azzert.that(count.of(separate.these(as.list("A", "B", "C")).os), is(3));
  }

  @Test public final void theseFromTwoItems() {
    azzert.that(count.of(separate.these(as.list("Hello", "World")).os), is(2));
  }

  @Test public final void theseFromZeroItems() {
    azzert.that(count.of(separate.these(as.list((Double) null)).os), is(0));
  }

  @Test public final void theseOfNoItemsl() {
    assert is.empty(separate.these(new String[] {}).os);
  }

  @Test public final void theseOfNoItemslSpaceSeparated() {
    azzert.that(separate.these(new String[] {}).bySpaces(), is(""));
  }
}
