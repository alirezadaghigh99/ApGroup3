package Model.Transport;

public class Helicopter extends Transportation{
    private int capacity = 100 ;
    private int speed = 5 ;
    private static Helicopter helicopter = new Helicopter();
    private int stored = 0 ;

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
