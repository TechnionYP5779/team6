package database;

import java.sql.*;

public class DBMain {
  static final String createParkingSpotsTable = "CREATE TABLE ParkingSpots (\n"
      + "id INT NOT NULL AUTO_INCREMENT,\n"
      + "price INT NOT NULL,\n"
      + "city VARCHAR(20) NOT NULL,\n"
      + "street VARCHAR(20) NOT NULL,\n"
      + "building INT NOT NULL,\n"
      + "date DATE NOT NULL,\n"
      + "owner INT NOT NULL,\n"
      + "buyer INT,\n"
      + "PRIMARY KEY(id));";
  
  static final String destroyParkingSpotsTable = "DROP TABLE ParkingSpots;";

  public static void main(final String[] args) {
    try {
      SQLUtils.runCommand(destroyParkingSpotsTable);
      SQLUtils.runCommand(createParkingSpotsTable);
      System.out.println("Good");
    }
    catch(SQLException e) {
      System.out.println(e);
    }
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
