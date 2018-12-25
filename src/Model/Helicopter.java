package Model;

public class Helicopter extends Transportation{
    private int capacity ;
    private int speed ;
    private static Helicopter helicopter = new Helicopter();

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
