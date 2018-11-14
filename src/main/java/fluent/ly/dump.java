package fluent.ly;

import java.lang.management.*;
import java.lang.reflect.*;
import java.util.*;

import org.jetbrains.annotations.*;

import il.org.spartan.*;

/** A class to print all properties of an arbitrary object which can be
 * retrieved by getters methods (i.e., getXXX()) methods and boolean inspection
 * methods (i.e., isXXX()), as can be determined by reflection information.
 * @author Yossi Gil
 * @since 24/07/2007 */
@SuppressWarnings("null") public class dump {
  /** Dump a class object
   * @param ¢ JD */
  public static void go(final @NotNull Class<?> ¢) {
    Out.out("\n\n--IDENTIFICATION--\n");
    Out.out("Simple Name", ¢.getSimpleName());
    Out.out("Canonical Name", ¢.getCanonicalName());
    Out.out("Name", ¢.getName());
    Out.out("toString", ¢ + "");
    Out.out("super class", ¢.getSuperclass());
    Out.out("generic super class", ¢.getGenericSuperclass());
    Out.out("class", ¢.getClass());
    Out.out("component type", ¢.getComponentType());
    // out("protection domain", c.getProtectionDomain());
    Out.out("class loader", ¢.getClassLoader());
    Out.out("--MODIFIERS--\n");
    final int flags = ¢.getModifiers();
    Out.out("Package", ¢.getPackage());
    Out.out("Modifiers (decimal form)", flags);
    Out.out("Modifiers (binary form)", ReflectionAnalyzer.toBinary(flags));
    Out.out("IsSynthetic", ¢.isSynthetic());
    Out.out("IsPrimitive", ¢.isPrimitive());
    Out.out("IsFinal", Modifier.isFinal(flags));
    Out.out("IsAbstract", Modifier.isAbstract(flags));
    Out.out("IsStatic", Modifier.isStatic(flags));
    Out.out("IsStrictfp", Modifier.isStrict(flags));
    Out.out("--Visibility--\n");
    Out.out("IsPublic", Modifier.isPublic(flags));
    Out.out("IsPrivate", Modifier.isPrivate(flags));
    Out.out("IsProtected", Modifier.isProtected(flags));
    Out.out("--MEMBERS\n");
    Out.out("fields", ¢.getFields());
    Out.out("methods", ¢.getMethods());
    Out.out("constructors", ¢.getConstructors());
    Out.out("declared fields", ¢.getDeclaredFields());
    Out.out("declared methods", ¢.getDeclaredMethods());
    Out.out("declared constructors", ¢.getDeclaredConstructors());
    Out.out("--CLASS SIGNATURE--\n");
    Out.out("interfaces", ¢.getInterfaces());
    Out.out("annotations", ¢.getAnnotations());
    Out.out("type parameters", ¢.getTypeParameters());
    Out.out("declared annotations", ¢.getDeclaredAnnotations());
    Out.out("generic interfaces", ¢.getGenericInterfaces());
    Out.out("--CONTAINERS--\n");
    Out.out("declared classes", ¢.getDeclaredClasses());
    Out.out("declaring class", ¢.getDeclaringClass());
    Out.out("enclosing class", ¢.getEnclosingClass());
    Out.out("enclosing constructor", ¢.getEnclosingConstructor());
    Out.out("enclosing method", ¢.getEnclosingMethod());
    Out.out("--CLASS MEMBERS--\n");
    Out.out("public classes", ¢.getClasses());
    Out.out("declared classes", ¢.getDeclaredClasses());
    Out.out("declared annotations", ¢.getDeclaredAnnotations());
    Out.out("---------------------------\n");
  }

  public static <T> void go(final @NotNull List<T> ts, final @NotNull String... ss) {
    Out.out("Exploring list");
    for (final @NotNull String ¢ : ss)
      Out.out(¢);
    for (final T ¢ : ts)
      dump.go(¢);
  }

  public static void go(final Object os[], final @NotNull String... ss) {
    for (final @NotNull String ¢ : ss)
      Out.out(¢);
    Out.out("elements", os);
  }

  public static void go(final @Nullable Object o, final @NotNull String... ss) {
    for (final @NotNull String ¢ : ss)
      Out.out(¢);
    if (o == null) {
      Out.out("NULL");
      return;
    }
    final Class<?> c = o.getClass();
    Out.out("\n\n--BEGIN " + c.getSimpleName() + " object: " + o + "\n");
    Out.out("Class canonical name", c.getCanonicalName());
    Out.out("Class name", c.getName());
    for (final @NotNull Method m : c.getMethods()) {
      if (m.getParameterTypes().length != 0)
        continue;
      String name = m.getName();
      if ("getClass".equals(name) || "toString".equals(name))
        continue;
      if (name.matches("^get[A-Z].*$"))
        name = name.replaceFirst("^get", "");
      else if (name.matches("^is[A-Z].*$"))
        name = name.replaceFirst("^is", "");
      else if ("size".equals(name))
        name = "size";
      else if (!name.matches("^to[A-Z].*$"))
        continue;
      try {
        final Object $ = m.invoke(o);
        if ($ == null) {
          Out.out(name, "null");
          continue;
        }
        if ($ instanceof Object[])
          Out.out(name, (Object[]) $);
        Out.out(name, !($ instanceof Collection) ? $ : (Collection<?>) $);
      } catch (final Throwable ¢) {
        // For some reason, a reflection call to method
        // getContent() in URL objects throws this exception.
        // We do not have much to do in this and other similar cases.
        Out.out(name, m.getName() + " THROWS " + ¢);
      }
    }
    Out.out("--END OBJECT--\n\n");
    System.out.flush();
  }

  public static void main(final @NotNull String[] args) {
    // Explore.go(Package.class);
    final ClassLoadingMXBean a = ManagementFactory.getClassLoadingMXBean();
    System.out.println(a.getLoadedClassCount());
    System.out.println(a.getTotalLoadedClassCount());
    System.out.println(a.getUnloadedClassCount());
    dump.go(ManagementFactory.getClassLoadingMXBean());
    final CompilationMXBean b = ManagementFactory.getCompilationMXBean();
    System.out.println(b.getTotalCompilationTime());
    System.out.println(b.getName());
    System.out.println(b.isCompilationTimeMonitoringSupported());
    System.exit(1);
    dump.go(ManagementFactory.getGarbageCollectorMXBeans());
    dump.go(ManagementFactory.getMemoryManagerMXBeans());
    dump.go(ManagementFactory.getMemoryPoolMXBeans());
    dump.go(ManagementFactory.getOperatingSystemMXBean());
    dump.go(ManagementFactory.getPlatformMBeanServer());
    dump.go(ManagementFactory.getRuntimeMXBean());
    dump.go(ManagementFactory.getThreadMXBean());
  }
}
