package database;

import java.sql.*;

public class DBMain {
  
  static final String createParkingSpotsTable =  
      "CREATE TABLE ParkingSpots (\n" +
          "id INT NOT NULL AUTO_INCREMENT,\n" +
          "price INT NOT NULL,\n" +
          "city VARCHAR(20) NOT NULL,\n" +
          "street VARCHAR(20) NOT NULL,\n" +
          "building INT NOT NULL,\n" +
          "owner INT NOT NULL,\n" +
          "buyer INT,\n" +
          "PRIMARY KEY(id));";
  
  static final String destroyParkingSpotsTable = "DROP TABLE ParkingSpots;";
  
  public static void main(String[] args) {
    //addParkingSpot(10,"Tel Aviv","Street",10,50,40);
    printAllSpots();
    System.out.println("Done");
  }
  
  public static void addParkingSpot(int price, String city, String street, int building, int owner, int buyer) {
    try {
      SQLUtils.runCommand(
          "INSERT INTO ParkingSpots (price,city,street,building,owner,buyer)\n" +
          "VALUES ("+price+",'"+city+"','"+street+"',"+building+","+owner+","+buyer+");"
          );
    }
    catch(SQLException ¢) {
      System.out.println(¢);
    }
  }
  
  public static void printAllSpots() {
    QueryResults q = null;
    try {
      q = SQLUtils.runQuery("SELECT * FROM ParkingSpots;");
      @SuppressWarnings("resource") ResultSet r = q.getResults();
      while(r.next())
        System.out.println(
            "ID: "+r.getInt("id")+"\t"+
            "City: "+r.getString("city")+"\t"+
            "Street: "+r.getString("street")+"\t"+
            "Building: "+r.getInt("building")+"\t"+
            "Owner: "+r.getInt("owner")+"\t"+
            "Buyer: "+r.getInt("buyer")
        );
    }
    catch(SQLException ¢) {
      System.out.println(¢);
    }
    finally {
      if(q!=null)
        q.close();
    }
  }
  
  
}
