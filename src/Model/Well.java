package Model;

public class Well extends Building{
    private int capacity ;
    private int storage ;
    private static Well well  = new Well();
    private Well() {
    }

    public static Well getWell() {
        return well;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public void pickUpWater(int litre){

    }

    public void addWater(int litre){

    }


}
