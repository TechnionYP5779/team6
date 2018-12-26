package database;

import java.sql.*;

/** @fluent.ly.Package database
 * @fluent.ly.Since 17 בדצמ׳ 2018
 * @fluent.ly.Author Nitzan
 * @fluent.ly.ClassDesc This class packages the results of a query with the
 *                      connection still open. To get the results simply use the
 *                      getResults() method. After finishing with the results
 *                      close() should be called (preferably in a finally
 *                      block). */
public class QueryResults {
  private final Connection c;
  private final Statement s;
  private final ResultSet rs;

  public QueryResults(final Connection c, final Statement s, final ResultSet rs) {
    this.c = c;
    this.s = s;
    this.rs = rs;
  }

  /** @return The ResultSet of an SQL query. */
  public ResultSet getResults() {
    return rs;
  }

  /** Closes the Connection, Statement and ResultSet associated with the instance,
   * afterwards its ResultSet is no longer usable. */
  public void close() {
    SQLUtils.closeAll(c, s, rs);
  }
}
