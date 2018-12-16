package Model;

public class Well extends Building  implements  Upgradable{
    private int capacity = 50 ;
    private int storage = 50 ;
    private int level ;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

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
        well.setStorage(well.getStorage()-litre);
    }
    public void addWater()
    {
        if (well.getCapacity() != well.getStorage()) {
            well.setStorage(well.getCapacity());
        }
    }



    @Override
    public void upgrade() {
        level = level + 1 ;
        capacity = capacity + 10 ;
    }
}
