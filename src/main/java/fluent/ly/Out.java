package fluent.ly;

import java.util.*;

import org.jetbrains.annotations.*;

public class Out {
  static final int MAX_FIRST = 20;
  static final int MAX_LAST = 10;

  public static void out(final @NotNull String ¢) {
    System.out.print(¢);
  }

  public static void out(final @NotNull String name, final boolean b) {
    System.out.printf("%s = %b\n", name, Box.box(b));
  }

  public static void out(final @NotNull String name, final @Nullable Collection<Object> os) {
    assert name != null;
    if (os == null || os.isEmpty()) {
      System.out.printf("No %s\n", name);
      return;
    }
    if (os.size() == 1) {
      System.out.printf("Only 1 %s: %s\n", name, os.iterator().next());
      return;
    }
    System.out.printf("Total of %d %s:\n", Box.box(os.size()), name);
    int n = 0;
    for (final Object ¢ : os) {
      if (++n > MAX_FIRST && n <= os.size() - MAX_LAST) {
        System.out.print("\t...\n");
        return;
      }
      System.out.printf("\t%2d) %s\n", Box.box(n), ¢);
    }
  }

  public static void out(final @NotNull String name, final int i) {
    System.out.printf("%s = %d\n", name, Box.box(i));
  }

  public static void out(final @NotNull String name, final @Nullable Object a) {
    System.out.printf((a == null ? "No" : "%s =") + " %s\n", name, a);
  }

  public static void out(final @NotNull String name, final Object[] os) {
    assert name != null;
    if (os == null || os.length <= 0)
      System.out.printf("No %s\n", name);
    else if (os.length == 1)
      System.out.printf("Only one %s: %s\n", name, os[0]);
    else
      System.out.printf("Total of %d %s:\n\t%s\n", Box.box(os.length), name, separate.these(os).by("\n\t"));
  }
}
