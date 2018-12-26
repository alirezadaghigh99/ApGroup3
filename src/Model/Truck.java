package Model;

public class Truck extends Transportation{
    private int capacity = 50 ;
    private int speed  = 2 ;
    private int stored = 0;


    public int getStored() {
        return stored;
    }


    public void setStored(int stored) {
        this.stored = stored;
    }
    public boolean isFullTruck()
    {
        if (animalsInTransportation.size() + productsInTransportation.size() >= capacity)
            return true ;
        else
            return false ;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    private static Truck truck = new Truck();

    private Truck() {
    }

    public static Truck getTruck() {
        return truck;
    }
}
