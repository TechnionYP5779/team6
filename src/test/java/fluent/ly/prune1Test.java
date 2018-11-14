package fluent.ly;

import static org.junit.Assert.assertEquals;

import static fluent.ly.azzert.assertEquals;
import static fluent.ly.prune.*;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

@SuppressWarnings({ "null", "static-method" }) public class prune1Test {
  @Nullable final String[] alternatingArray = new @Nullable String[] { null, "A", null, null, "B", null, null, null, "C", null };
  @NotNull final String[] nonNullArray = { "1", "2", "4" };
  @NotNull private final List<String> sparseCollection = as.list(null, null, null, null, null, "A", null, null, null, "B", null, "C", null, null,
      null, null, null);

  @Test public void nullsNotNullArrayLength() {
    assertEquals(nonNullArray.length, nulls(nonNullArray).length);
  }

  @Test public void nullsNullArrayItems() {
    assertEquals("1", nulls(nonNullArray)[0]);
    assertEquals("2", nulls(nonNullArray)[1]);
    assertEquals("4", nulls(nonNullArray)[2]);
  }

  @Test public void nullsPruneArrayAltenatingItems() {
    assertEquals("A", nulls(alternatingArray)[0]);
    assertEquals("B", nulls(alternatingArray)[1]);
    assertEquals("C", nulls(alternatingArray)[2]);
  }

  @Test public void nullsPruneArrayAltenatingLength() {
    assertEquals(3, nulls(alternatingArray).length);
  }

  @Test public void nullsPruneSparseCollectionContents() {
    final String[] a = nulls(sparseCollection).toArray(new String[3]);
    assertEquals("A", a[0]);
    assertEquals("B", a[1]);
    assertEquals("C", a[2]);
    assertEquals(3, a.length);
  }

  @Test public void nullsPruneSparseCollectionLength() {
    assertEquals(3, nulls(sparseCollection).size());
  }

  @Test public void nullsPrunNotNull() {
    assert nulls(sparseCollection) != null;
  }

  // @Test public void shrinkArray() {
  // assertEquals(0, shrink(new Object[10]).length);
  // }
  //
  // @Test public void shrinkEmptyArray() {
  // assertEquals(0, shrink(new Object[0]).length);
  // }
  @Test public void whitesEmptyArray() {
    assertEquals(0, prune.whites().length);
  }

  @Test public void whitesEmptyList() {
    assertEquals(0, prune.whites().length);
  }
}
