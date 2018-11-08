package fluent.ly;

/** TODO Yossi Gil: document class
 * @author Yossi Gil
 * @since 2017-04-16 */
public interface forget {
  /* Ignore an exception means allow the program to continue to run as it never
   * thrown */
  @SuppressWarnings("unused") static void all(final Object _1, final Object... _2) {
    /* this method takes number of exception and ignore all of them */ }

  @SuppressWarnings("unused") static void it(final boolean __) {
    /* this method takes an boolean and ignore the exception */ }

  @SuppressWarnings("unused") static void it(final double __) {
    /* this method takes an double and ignore the exception */ }

  @SuppressWarnings("unused") static void it(final long __) {
    /* this method takes an long and ignore the exception */ }

  @SuppressWarnings("unused") static void it(final Object __) {
    /* this method takes an exception an ignore it */ }
}
