package database;

import java.sql.*;

public class DBMain {
  static final String createParkingSpotsTable = "CREATE TABLE ParkingSpots (\nid INT NOT NULL AUTO_INCREMENT,\nprice INT NOT NULL,\n"
      + "city VARCHAR(20) NOT NULL,\nstreet VARCHAR(20) NOT NULL,\nbuilding INT NOT NULL,\nstartTime VARCHAR(10) NOT NULL,\n"
      + "endTime VARCHAR(10) NOT NULL,\nowner INT NOT NULL,\nbuyer INT,\nPRIMARY KEY(id));";
  static final String destroyParkingSpotsTable = "DROP TABLE ParkingSpots;";

  public static void main(final String[] args) {
    // addParkingSpot(10,"Tel Aviv","Street",10,50,40);
    printAllSpots();
    System.out.println("Done");
  }

  public static void addParkingSpot(final int price, final String city, final String street, final int building, final int owner, final int buyer,
      final String startTime, final String endTime) {
    try {
      SQLUtils.runCommand("INSERT INTO ParkingSpots (price,city,street,building,startTime,endTime,owner,buyer)\nVALUES (" + price + ",'" + city
          + "','" + street + "'," + building + ",'" + startTime + "','" + endTime + "'," + owner + "," + buyer + ");");
    } catch (final SQLException ¢) {
      System.out.println(¢);
    }
  }

  public static void printAllSpots() {
    QueryResults q = null;
    try {
      q = SQLUtils.runQuery("SELECT * FROM ParkingSpots;");
      for (final ResultSet ¢ = q.getResults(); ¢.next();)
        System.out.println("ID: " + ¢.getInt("id") + "\tCity: " + ¢.getString("city") + "\tStreet: " + ¢.getString("street") + "\tBuilding: "
            + ¢.getInt("building") + "\tOwner: " + ¢.getInt("owner") + "\tBuyer: " + ¢.getInt("buyer") + "\tprice: " + ¢.getInt("price")
            + "\tstart time: " + ¢.getString("startTime") + "\tend time: " + ¢.getString("endTime"));
    } catch (final SQLException ¢) {
      System.out.println(¢);
    } finally {
      if (q != null)
        q.close();
    }
  }
}
