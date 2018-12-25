package Model;

public class Helicopter extends Transportation{
    private int capacity ;
    private int speed ;
    private static Helicopter helicopter = new Helicopter();
    private int stored ;

    public int getStored() {
        return stored;
    }

    public void setStored(int stored) {
        this.stored = stored;
    }
    public boolean ifFullHelicopter()
    {
        if (animalsInTransportation.size() + productsInTransportation.size()>=capacity)
            return true ;
        else return false ;
    }

    private Helicopter() {
    }

    public static Helicopter getHelicopter() {
        return helicopter;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
