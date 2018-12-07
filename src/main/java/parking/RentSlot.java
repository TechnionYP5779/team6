package parking;

public class RentSlot {
  private int id;
  private ParkingSpot p;
  private Time t;
  private double price;
  private Buyer b;
  private static int uniqueId;

  public RentSlot(Seller s, ParkingSpot p, Time t, double price) {
    if(s == null || p == null || t == null)
      throw new NullPointerException();
    if(!p.getOwner().equals(s))
      throw new IllegalArgumentException();
    this.id = uniqueId++;
    this.p = p;
    this.t = t;
    this.price = price;
    this.b = null;
    p.addSlotOfParking();
  }

  public int getId() {
    return id;
  }

  public ParkingSpot getParkingSpot() {
    return p;
  }
  
  public Time getTime() {
    return t;
  }
  
  public double getPrice() {
    return price;
  }
  
  public void setPrice(double price) {
    this.price = price;
  }
  
  public Buyer getBuyer() {
    return b;
  }
}
