package database;

import java.sql.*;

/** @fluent.ly.Package database
 * @fluent.ly.Since 17 בדצמ׳ 2018
 * @fluent.ly.Author Nitzan
 * @fluent.ly.ClassDesc A utility class for SQL. Mainly used to reduce boiler
 *                      plate code. */
public class SQLUtils {
  static String URL = "jdbc:mysql://den1.mysql6.gear.host/";
  static String USER = "parkingdatabase";
  static String PASS = "team6!";

  /** @return Returns a connection to the default SQL server.
   * @throws SQLException */
  public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(URL, USER, PASS);
  }

  /** Overrides default connection with the given url,user and password. Note: the
   * given server should have a database called "parkingdatabase"
   * @param url
   * @param user
   * @param pass */
  public static void overrideDefaultConnection(final String url, final String user, final String pass) {
    URL = url;
    USER = user;
    PASS = pass;
  }

  @SuppressWarnings("unused") public static void closeAll(final Connection c, final Statement s, final ResultSet rs) {
    try {
      if (s != null)
        s.close();
    } catch (final Exception ¢) {
      // Nothing to do here.
    }
    try {
      if (c != null)
        c.close();
    } catch (final Exception ¢) {
      // Nothing to do here.
    }
    try {
      if (rs != null)
        rs.close();
    } catch (final Exception ¢) {
      // Nothing to do here.
    }
  }

  /** Executes the given command on the default server.
   * @param command
   * @throws SQLException */
  public static void runCommand(final String command) throws SQLException {
    Connection conn = null;
    Statement stmt = null;
    SQLException e = null;
    try {
      conn = getConnection();
      stmt = conn.createStatement();
      stmt.execute("USE parkingdatabase;");
      stmt.execute(command);
    } catch (final SQLException ¢) {
      e = ¢;
    } finally {
      closeAll(conn, stmt, null);
    }
    if (e != null)
      throw e;
  }

  /** Executes the query on the default server. The output QueryResults should be
   * closed after it is done.
   * @param query
   * @return An object containing the results and the associated connection.
   * @throws SQLException */
  @SuppressWarnings("resource") public static QueryResults runQuery(final String query) throws SQLException {
    final Connection $ = getConnection();
    final Statement s = $.createStatement();
    s.execute("USE parkingdatabase;");
    return new QueryResults($, s, s.executeQuery(query));
  }

  // For my local connection
  static final String LOCAL_URL = "jdbc:mysql://localhost/parking?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
  static final String LOCAL_USER = "root";
  static final String LOCAL_PASS = "0532826092";
}
