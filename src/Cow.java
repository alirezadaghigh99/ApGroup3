public class Cow extends ProducerAnimal {
    private int timeToNextHungry;
    private Milk milk = new Milk();
    public void bfsWalk()
    {

    }
    public void randomWalk()
    {

    }

    public int getTimeToNextHungry() {
        return timeToNextHungry;
    }

    public void setTimeToNextHungry(int timeToNextHungry) {
        this.timeToNextHungry = timeToNextHungry;
    }
}
