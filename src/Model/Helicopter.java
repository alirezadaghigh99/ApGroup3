package Model;

import sun.plugin2.liveconnect.JSExceptions;

public class Helicopter extends Transportation implements Upgradable{
    private int capacity = 100 ;
    private int speed = 5 ;
    private static Helicopter helicopter = new Helicopter();
    private int stored = 0 ;
    private int upgradeCost = 100 ;
    private int level = 1 ;
    private int maxLevel = 4 ; // Alaki meqdaar dadim

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

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

    public void upgrade() throws Exception {
        int money = 100 ;
        if(money < upgradeCost)
            throw new Exception("Money is not enough!!");
        if(this.level == maxLevel)
            throw new Exception("Level exceeded!!");
        setLevel(getLevel() + 1 ) ;
        setSpeed(getSpeed() + 5 ) ;
        setCapacity(getCapacity() + 50 ) ;
        money -= upgradeCost ;


    }
}
